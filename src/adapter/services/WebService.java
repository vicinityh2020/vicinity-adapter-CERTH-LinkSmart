package adapter.services;
import adapter.services.WorkflowClass;
import adapter.services.WorkflowClass.GetObjectsResponse;
import adapter.services.WorkflowClass2.GetPropResponse;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/objects")
 public class WebService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<GetObjectsResponse> generateResponse() throws Exception {
        WorkflowClass newClass = new WorkflowClass();
        ArrayList<GetObjectsResponse> response = newClass.parseResponse();
        return response;
    }
    
    @GET
    @Path("/{oid}/properties/{pid}")
    @Produces(MediaType.APPLICATION_JSON)
    public GetPropResponse generateResponse(@PathParam("oid") String oid, @PathParam("pid") String pid) throws Exception {
        WorkflowClass2 newClass = new WorkflowClass2();
        GetPropResponse response = newClass.parseResponse(oid, pid);
        return response;
    }
}
