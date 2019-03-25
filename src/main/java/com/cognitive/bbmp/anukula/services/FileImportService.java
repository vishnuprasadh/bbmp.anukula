package com.cognitive.bbmp.anukula.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognitive.bbmp.anukula.configuration.MongoConfiguration;
import com.cognitive.bbmp.anukula.domain.FileFormat;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/processCSVFile")
public class FileImportService {

	@Autowired
	MongoConfiguration config ;

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<?> updateFile(@RequestBody FileFormat file)
	{
		if (file.getType()!=null && file.getFileName()!=null)
		{	
			String currentTime = new Timestamp(new java.util.Date().getTime()).toString();
			
			file.setLastModified(currentTime );
			if (file.getDateCreated()==null) file.setDateCreated(currentTime);
			
			file.setStatus("New");
			
			Query query = new Query();
			query.addCriteria(Criteria.where("_Id").is(file.get_id()));
			
			Update upd = new Update();
			upd.set("type", file.getType());
			upd.set("fileName", file.getFileName());
			upd.set("status", file.getStatus());
			upd.set("updatedBy", file.getUpdatedBy());
			upd.set("dateCreated", file.getDateCreated());
			upd.set("dateModified", file.getDateCreated());
			
			MongoOperations ops = config.mongoTemplate();
			UpdateResult result = ops.upsert(query, upd, "fileProcess");
					
			return new ResponseEntity<>(result.getMatchedCount(),HttpStatus.OK);
		}
		else
		{
			MongoOperations ops = config.mongoTemplate();
			FileFormat result = ops.save(file,"fileProcess");
			return new ResponseEntity<>(result.get_id(),HttpStatus.OK);
		}
	}
	
	
	/*
	 * This can be used to update status of a file with either Processed or New or In Progress.
	 * If the status is not provided, then status is assumed as Processed i.e. completed.
	 */
	@RequestMapping(value="/updateStatus/{id}/status/{status}",method=RequestMethod.PUT)
	public ResponseEntity<?> updateFileStatus(@PathVariable(name="id") String id, @PathVariable(name="status") String status)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("_Id").is(id));
		
		Update upd = new Update();
		
		if (status !=null)
		{
			upd.set("status", status);
		}
		else
		{
			upd.set("status", "Processed");
		}
		upd.set("dateModified",  new Timestamp(new java.util.Date().getTime()).toString());
		
		MongoOperations ops = config.mongoTemplate();
		UpdateResult result = ops.upsert(query, upd, "fileProcess");
		
		return new ResponseEntity<>(result.getMatchedCount(),HttpStatus.OK);
	
	}
	
	@RequestMapping(value={"/get","/get/{status}"},method=RequestMethod.GET)
	public ResponseEntity<?> getFilesList(@PathVariable(name="status")  String status )
	{
		Query query = new Query();
		if (status !=null)
			query.addCriteria(Criteria.where("status").is(status));
		
		//config = new MongoConfiguration();
		MongoOperations ops = config.mongoTemplate();
		
		List<FileFormat> fileList = ops.findAll(FileFormat.class, "fileProcess");
		
		return new ResponseEntity<List<FileFormat>>(fileList,HttpStatus.OK);
	}
	
	
}
