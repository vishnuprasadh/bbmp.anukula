# bbmp.anukula
An API library used to capture road information, street, drain &amp; other issues of a specific Ward in India. As a start, its an effort to caputre Bellandur ward.

## Basic Ward Issues & Issue History API
The following URL has a sample payload for request and response for various API used for Issue upload, edit and updating of statuses.

1. [Ward Issue API Sample](https://documenter.getpostman.com/view/1662159/S11RLvpd)
  - Add or Update new Ward Issue as a Single Item - http://bbmpanukula.herokuapp.com/issues/update
  - Bulk Insert or Update Ward Issue - http://bbmpanukula.herokuapp.com/issues/bulkupdate
  - Get wardIssues by Ward - http://bbmpanukula.herokuapp.com/issues/ward/BELL 
  - Get wardIssues by ward and Status - http://bbmpanukula.herokuapp.com/issues/ward/BELL/status/New
  
  
2. [Issue History or Action taken API Sample](https://documenter.getpostman.com/view/1662159/S11RLvpd)
  - Add or Update action taken or site visit on a wardIssue using IssueHistory - http://bbmpanukula.herokuapp.com/issues/update/history
  - Get history of site visits and ation taken on a issue - http://bbmpanukula.herokuapp.com/issues/history/123
  
## Roads API
TBD

## RoadState API
TBD

## Drains API
TBD

## Footpath API
TBD

## StreetLights API
TBD

## Culverts API
TBD

