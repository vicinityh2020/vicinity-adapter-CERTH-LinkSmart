# 1. Infrastructure overview
This is a Vicinity Adapter for CERTH-ITI Building Infrastructure.It adapts LinkSmart IoT Platform, which is used for CERTH-ITI Building devices, to Vicinity.

# 2. Configuration and deployment
## Build using Maven

In the root folder of the project:

`mvn clean install`

## Deploy on Tomcat 8.5

Copy the LinkSmartAdapter-0.0.1-SNAPSHOT.war file from ./target directory of the project to /webapps directory located on Tomcat server and start Tomcat server
or 
use Manager web application http://host-IP:port/manager/html for deployment (you need manager-gui role to be allowed to access it).


# 3. Functionality and API

## Endpoints
*	GET /objects: Retrieve all devices Thing Descriptions(TDs) for registration to VICINITY.
*	GET /objects/{oid}/properties/{pid} : Get the latest value of a property of a device e.g. get temperature
