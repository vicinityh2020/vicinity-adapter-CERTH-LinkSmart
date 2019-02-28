package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import adapter.services.WorkflowClass.Variable;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class WorkflowClass2{
      //variables
   private Variable oid = new Variable("oid","", "String");
   private Variable pid = new Variable("oid","", "String");
   private Get_IoT_PropertyResponse Get_IoT_Property_response = new Get_IoT_PropertyResponse();


      public static class Get_IoT_PropertyRequest {


         public Get_IoT_PropertyRequest(){
         }


      }

   public static class Get_IoT_PropertyResponse {
      private UnitOfMeasurement UnitOfMeasurement = new UnitOfMeasurement();
      private String Name;
      private ArrayList <IoTStateObservation> IoTStateObservation = new ArrayList<IoTStateObservation>();
      private String DataType;
      private String About;


      Get_IoT_PropertyResponse(){
      }

      Get_IoT_PropertyResponse(UnitOfMeasurement UnitOfMeasurement, String Name, ArrayList <IoTStateObservation> IoTStateObservation, String DataType, String About){
         this.UnitOfMeasurement = UnitOfMeasurement;
         this.Name = Name;
         this.IoTStateObservation = IoTStateObservation;
         this.DataType = DataType;
         this.About = About;
      }


      public void setUnitOfMeasurement(UnitOfMeasurement UnitOfMeasurement) {
         this.UnitOfMeasurement = UnitOfMeasurement;
      }
      @XmlElement
      public UnitOfMeasurement getUnitOfMeasurement() {
         return UnitOfMeasurement;
      }
      public void setName(String Name) {
         this.Name = Name;
      }
      @XmlElement
      public String getName() {
         return Name;
      }
      public void setIoTStateObservation(ArrayList<IoTStateObservation> IoTStateObservation) {
         this.IoTStateObservation = IoTStateObservation;
      }
      @XmlElement
      public ArrayList<IoTStateObservation> getIoTStateObservation() {
         return IoTStateObservation;
      }
      public void setDataType(String DataType) {
         this.DataType = DataType;
      }
      @XmlElement
      public String getDataType() {
         return DataType;
      }
      public void setAbout(String About) {
         this.About = About;
      }
      @XmlElement
      public String getAbout() {
         return About;
      }
}

   public static class UnitOfMeasurement {
      private String TypeId;


      UnitOfMeasurement(){
      }

      UnitOfMeasurement(String TypeId){
         this.TypeId = TypeId;
      }


      public void setTypeId(String TypeId) {
         this.TypeId = TypeId;
      }
      @XmlElement
      public String getTypeId() {
         return TypeId;
      }
}

   public static class IoTStateObservation {
      private String PhenomenonTime;
      private String ResultTime;
      private String Value;


      IoTStateObservation(){
      }

      IoTStateObservation(String PhenomenonTime, String ResultTime, String Value){
         this.PhenomenonTime = PhenomenonTime;
         this.ResultTime = ResultTime;
         this.Value = Value;
      }


      public void setPhenomenonTime(String PhenomenonTime) {
         this.PhenomenonTime = PhenomenonTime;
      }
      @XmlElement
      public String getPhenomenonTime() {
         return PhenomenonTime;
      }
      public void setResultTime(String ResultTime) {
         this.ResultTime = ResultTime;
      }
      @XmlElement
      public String getResultTime() {
         return ResultTime;
      }
      public void setValue(String Value) {
         this.Value = Value;
      }
      @XmlElement
      public String getValue() {
         return Value;
      }
}


//      public static class Get_IoT_PropertyResponse {
//         private ArrayList <Properties> Properties = new ArrayList<Properties>();
//         private String About ;
//         private String Name ;
//
//
//      public void setProperties(ArrayList<Properties> Properties) {
//         this.Properties = Properties;
//      }
//      @XmlElement
//      public ArrayList<Properties> getProperties() {
//         return Properties;
//      }
//      public void setAbout(String About) {
//         this.About = About;
//      }
//      @XmlElement
//      public String getAbout() {
//         return About;
//      }
//      public void setName(String Name) {
//         this.Name = Name;
//      }
//      @XmlElement
//      public String getName() {
//         return Name;
//      }
//      }
   @XmlRootElement(name = "Response")
   public static class GetPropResponse{

      private String value;
      private String timestamp;


      public GetPropResponse(String value, String timestamp) {
         this.value = value;
         this.timestamp = timestamp;
}
      
      public void setValue(String value) {
         this.value = value;
      }
      @XmlElement
      public String getValue() {
         return value;
      }
      public void setTimestamp(String timestamp) {
         this.timestamp = timestamp;
      }
      @XmlElement
      public String getTimestamp() {
         return timestamp;
      }
   }

   protected String callEndNode()  throws Exception{
      return null;
   }
   protected String callStartNode()  throws Exception{
      return "callGet_IoT_Property";
   }
   protected String callGet_IoT_Property()  throws Exception{
      //call service: Get_IoT_Property
      String entity = "";
      ArrayList<Variable> inputs = new ArrayList<Variable>();
      ArrayList<Variable> requestHeaderList = new  ArrayList<Variable>();
      String wsUrl ="http://160.40.51.136/StorageManager/REST/iotentities/{oid}/properties/{pid}";
      wsUrl = wsUrl.replace("{oid}", oid.value);
      wsUrl = wsUrl.replace("{pid}", pid.value);
      String crudVerb="GET";
      boolean hasAuth= false;
      String auth="";
      String result=CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth, requestHeaderList);
      GsonBuilder gsonBuilder = new GsonBuilder();
      Gson gson = gsonBuilder.create();
      Get_IoT_Property_response = gson.fromJson(result, Get_IoT_PropertyResponse.class);
      return "callEndNode";
   }
   public String call(String name)throws Exception{
      if(name.equals("callEndNode"))
         return callEndNode();
      if(name.equals("callStartNode"))
         return callStartNode();
      if(name.equals("callGet_IoT_Property"))
         return callGet_IoT_Property();
      return null;
   }
   public GetPropResponse parseResponse(String oid,String pid) throws Exception{
      //assign inputs of services to variables
      //assign uri parameters of services to variables
      if (oid == null) {
         this.oid.value ="";
      } else {
         this.oid.value = oid;
      }
      if (pid == null) {
          this.pid.value ="";
       } else {
          this.pid.value = pid;
       }
      //assign other variables
      //call services iterately
      String _nextCall = "callGet_IoT_Property";
      while(_nextCall!=null){
         //update matchedIO variable values
         _nextCall = call(_nextCall);

         }
      
//      String propertyValue = "";
//      String propertyTimestamp = "";
//      for (Properties prop : Get_IoT_Property_response.getProperties()){
//    	  if (prop.getName().equals(pid)){
//    		  propertyValue = prop.getIoTStateObservation().get(0).getValue();
//    		  propertyTimestamp = prop.getIoTStateObservation().get(0).getResultTime();
//    	  }
//      }
      
      //create class instance to be returned
      GetPropResponse response = new GetPropResponse(Get_IoT_Property_response.getIoTStateObservation().get(0).getValue(), Get_IoT_Property_response.getIoTStateObservation().get(0).getResultTime());
      return response;
   }
}