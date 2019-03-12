/*package com.cognitive.bbmp.anukula.configuration;

import java.util.List;
import java.util.stream.Stream;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.EntityWriteResult;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.data.cassandra.core.UpdateOptions;
import org.springframework.data.cassandra.core.WriteResult;
import org.springframework.data.cassandra.core.ExecutableDeleteOperation.ExecutableDelete;
import org.springframework.data.cassandra.core.ExecutableInsertOperation.ExecutableInsert;
import org.springframework.data.cassandra.core.ExecutableSelectOperation.ExecutableSelect;
import org.springframework.data.cassandra.core.ExecutableUpdateOperation.ExecutableUpdate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.cql.CqlOperations;
import org.springframework.data.cassandra.core.cql.QueryOptions;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.data.cassandra.core.query.Update;
import org.springframework.data.cassandra.repository.support.SimpleCassandraRepository;
import org.springframework.data.domain.Slice;

import com.datastax.driver.core.Statement;

//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

	@Autowired
	private Environment env;
	
	@Override
	public String getKeyspaceName()
	{
		return  env.getProperty("${keyspacename}");
		
	}
	
	
	@Bean
	public CassandraClusterFactoryBean clusterBean() {
		CassandraClusterFactoryBean cbean =
				new CassandraClusterFactoryBean();
		cbean.setContactPoints(env.getProperty("${contactpoints}"));
		cbean.setPort(Integer.parseInt(env.getProperty("${cassandraport}")));
		return cbean;
	}
	
	
	@Bean
	public CassandraSessionFactoryBean sessionBean() {
		CassandraSessionFactoryBean sbean = new CassandraSessionFactoryBean();
		sbean.setCluster(clusterBean().getObject());
		
		
		return sbean;
	}
	
	@Bean
	public CassandraMappingContext cassandraMapping()
	{
		CassandraMappingContext context= new BasicCassandraMappingContext();
		context.setUserTypeResolver(new SimpleUserTypeResolver(clusterBean().getObject(),
				env.getProperty("${keyspacename}") ));
	
		return context;
	}
	
	
}*/
