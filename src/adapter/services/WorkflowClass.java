package adapter.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class WorkflowClass {
	// variables
	private LinksmartAdapterResponse LinksmartAdapter_response = new LinksmartAdapterResponse();
	private Map<String, String> deviceTypes = new HashMap<String, String>();
	private Map<String, String> deviceProperties = new HashMap<String, String>();

	public static class IoTEntity {
		private String Name;
		private ArrayList<Properties> Properties = new ArrayList<Properties>();
		private String About;
		private ArrayList<String> TypeOf;

		IoTEntity() {
		}

		IoTEntity(String Name, ArrayList<Properties> Properties, String About) {
			this.Name = Name;
			this.Properties = Properties;
			this.About = About;
		}

		public void setName(String Name) {
			this.Name = Name;
		}

		@XmlElement
		public String getName() {
			return Name;
		}

		public void setProperties(ArrayList<Properties> Properties) {
			this.Properties = Properties;
		}

		@XmlElement
		public ArrayList<Properties> getProperties() {
			return Properties;
		}

		public void setAbout(String About) {
			this.About = About;
		}

		@XmlElement
		public String getAbout() {
			return About;
		}

		public ArrayList<String> getTypeOf() {
			return TypeOf;
		}

		public void setTypeOf(ArrayList<String> typeOf) {
			TypeOf = typeOf;
		}
	}

	public static class Properties {
		private String DataType;
		private ArrayList<IoTStateObservation> IoTStateObservation = new ArrayList<IoTStateObservation>();
		private String About;
		private UnitOfMeasurement UnitOfMeasurement = new UnitOfMeasurement();
		private String Name;

		Properties() {
		}

		Properties(String DataType, ArrayList<IoTStateObservation> IoTStateObservation, String About,
				UnitOfMeasurement UnitOfMeasurement, String Name) {
			this.DataType = DataType;
			this.IoTStateObservation = IoTStateObservation;
			this.About = About;
			this.UnitOfMeasurement = UnitOfMeasurement;
			this.Name = Name;
		}

		public void setDataType(String DataType) {
			this.DataType = DataType;
		}

		@XmlElement
		public String getDataType() {
			return DataType;
		}

		public void setIoTStateObservation(ArrayList<IoTStateObservation> IoTStateObservation) {
			this.IoTStateObservation = IoTStateObservation;
		}

		@XmlElement
		public ArrayList<IoTStateObservation> getIoTStateObservation() {
			return IoTStateObservation;
		}

		public void setAbout(String About) {
			this.About = About;
		}

		@XmlElement
		public String getAbout() {
			return About;
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
	}

	public static class IoTStateObservation {
		private String Value;
		private String ResultTime;
		private String PhenomenonTime;

		IoTStateObservation() {
		}

		IoTStateObservation(String Value, String ResultTime, String PhenomenonTime) {
			this.Value = Value;
			this.ResultTime = ResultTime;
			this.PhenomenonTime = PhenomenonTime;
		}

		public void setValue(String Value) {
			this.Value = Value;
		}

		@XmlElement
		public String getValue() {
			return Value;
		}

		public void setResultTime(String ResultTime) {
			this.ResultTime = ResultTime;
		}

		@XmlElement
		public String getResultTime() {
			return ResultTime;
		}

		public void setPhenomenonTime(String PhenomenonTime) {
			this.PhenomenonTime = PhenomenonTime;
		}

		@XmlElement
		public String getPhenomenonTime() {
			return PhenomenonTime;
		}
	}

	public static class UnitOfMeasurement {
		private String TypeId;

		UnitOfMeasurement() {
		}

		UnitOfMeasurement(String TypeId) {
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

	public static class LinksmartAdapterResponse {
		private ArrayList<IoTEntity> IoTEntity = new ArrayList<IoTEntity>();

		public void setIoTEntity(ArrayList<IoTEntity> IoTEntity) {
			this.IoTEntity = IoTEntity;
		}

		@XmlElement
		public ArrayList<IoTEntity> getIoTEntity() {
			return IoTEntity;
		}
	}

	public static class Action {

		private String aid;
		private String affects;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();
		private Input input;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Action() {
		}

		/**
		 * 
		 * @param input
		 * @param affects
		 * @param links
		 * @param aid
		 */
		Action(String aid, String affects, ArrayList<Link> read_links, ArrayList<Link> write_links, Input input) {
			super();
			this.aid = aid;
			this.affects = affects;
			this.read_links = read_links;
			this.write_links = read_links;
			this.input = input;
		}

		@XmlElement
		public String getAid() {
			return aid;
		}

		public void setAid(String aid) {
			this.aid = aid;
		}

		@XmlElement
		public String getAffects() {
			return affects;
		}

		public void setAffects(String affects) {
			this.affects = affects;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

		@XmlElement
		public Input getInput() {
			return input;
		}

		public void setInput(Input input) {
			this.input = input;
		}

	}

	public static class Input {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Input() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Input(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Link {

		private String href;
		private String mediaType;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Link() {
		}

		/**
		 * 
		 * @param href
		 * @param mediaType
		 */
		Link(String href, String mediaType) {
			super();
			this.href = href;
			this.mediaType = mediaType;
		}

		@XmlElement
		public String getHref() {
			return href;
		}

		public void setHref(String href) {
			this.href = href;
		}

		@XmlElement
		public String getMediaType() {
			return mediaType;
		}

		public void setMediaType(String mediaType) {
			this.mediaType = mediaType;
		}

	}

	public static class Output {

		private String units;
		private String datatype;

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Output() {
		}

		/**
		 * 
		 * @param datatype
		 * @param units
		 */
		Output(String units, String datatype) {
			super();
			this.units = units;
			this.datatype = datatype;
		}

		@XmlElement
		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}

		@XmlElement
		public String getDatatype() {
			return datatype;
		}

		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}

	}

	public static class Property {

		private String pid;
		private String monitors;
		private Output output;
		private Boolean writable;
		private ArrayList<Link> read_links = new ArrayList<Link>();
		private ArrayList<Link> write_links = new ArrayList<Link>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		Property() {
		}

		/**
		 * 
		 * @param monitors
		 * @param writable
		 * @param links
		 * @param pid
		 * @param output
		 */
		Property(String pid, String monitors, Output output, Boolean writable, ArrayList<Link> read_links,
				ArrayList<Link> write_links) {
			super();
			this.pid = pid;
			this.monitors = monitors;
			this.output = output;
			this.writable = writable;
			this.read_links = read_links;
			this.write_links = write_links;
		}

		@XmlElement
		public String getPid() {
			return pid;
		}

		public void setPid(String pid) {
			this.pid = pid;
		}

		@XmlElement
		public String getMonitors() {
			return monitors;
		}

		public void setMonitors(String monitors) {
			this.monitors = monitors;
		}

		@XmlElement
		public Output getOutput() {
			return output;
		}

		public void setOutput(Output output) {
			this.output = output;
		}

		@XmlElement
		public Boolean getWritable() {
			return writable;
		}

		public void setWritable(Boolean writable) {
			this.writable = writable;
		}

		@XmlElement
		public ArrayList<Link> getread_links() {
			return read_links;
		}

		public void setread_links(ArrayList<Link> read_links) {
			this.read_links = read_links;
		}

		@XmlElement
		public ArrayList<Link> getwrite_links() {
			return write_links;
		}

		public void setwrite_links(ArrayList<Link> write_links) {
			this.write_links = write_links;
		}

	}

	@XmlRootElement(name = "Response")
	public static class GetObjectsResponse {

		private String type;
		private String oid;
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		/**
		 * No args constructor for use in serialization
		 * 
		 */
		public GetObjectsResponse() {
		}

		/**
		 * 
		 * @param oid
		 * @param properties
		 * @param type
		 * @param actions
		 */
		public GetObjectsResponse(String type, String oid, ArrayList<Property> properties, ArrayList<Action> actions) {
			super();
			this.type = type;
			this.oid = oid;
			this.properties = properties;
			this.actions = actions;
		}

		@XmlElement
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@XmlElement
		public String getOid() {
			return oid;
		}

		public void setOid(String oid) {
			this.oid = oid;
		}

		@XmlElement
		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		@XmlElement
		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	public static class Variable {
		public String name;
		public String value;
		public String type;
		public ArrayList<Variable> subtypes = new ArrayList<Variable>();
		public ArrayList<Variable> arrayElements = new ArrayList<Variable>();

		Variable(String name, String value, String type) {
			this.name = name;
			this.value = value;
			this.type = type;
		}

		Variable(Variable prototype) {
			this.name = prototype.name;
			this.value = prototype.value;
			this.type = prototype.type;
			for (Variable sub : prototype.subtypes) {
				Variable arg = new Variable(sub);
				subtypes.add(arg);
			}
			for (Variable el : prototype.arrayElements) {
				Variable arg = new Variable(el);
				arrayElements.add(arg);
			}
		}

		public Variable getSubtype(String name) {
			for (Variable sub : subtypes) {
				if (sub.name.equals(name.replaceAll("[^A-Za-z]", ""))) {
					return sub;
				}
			}
			return null;
		}
	}

	public class PropertiesActions {
		private ArrayList<Property> properties = new ArrayList<Property>();
		private ArrayList<Action> actions = new ArrayList<Action>();

		PropertiesActions() {

		}

		PropertiesActions(ArrayList<Property> properties, ArrayList<Action> actions) {
			this.properties = properties;
			this.actions = actions;

		}

		public ArrayList<Property> getProperties() {
			return properties;
		}

		public void setProperties(ArrayList<Property> properties) {
			this.properties = properties;
		}

		public ArrayList<Action> getActions() {
			return actions;
		}

		public void setActions(ArrayList<Action> actions) {
			this.actions = actions;
		}

	}

	protected String callLinksmartAdapter() throws Exception {
		// call service: LinksmartAdapter
		String entity = "";
		ArrayList<Variable> inputs = new ArrayList<Variable>();
		ArrayList<Variable> requestHeaderList = new ArrayList<Variable>();
		String wsUrl = "http://160.40.51.136/StorageManager/REST/iotentities";
		String crudVerb = "GET";
		boolean hasAuth = false;
		String auth = "";
		String result = CallRESTfulService.callService(wsUrl, crudVerb, inputs, entity, hasAuth, auth,
				requestHeaderList);
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		LinksmartAdapter_response = gson.fromJson(result, LinksmartAdapterResponse.class);
		return "callEndNode";
	}

	protected String callEndNode() throws Exception {
		return null;
	}

	public String call(String name) throws Exception {
		if (name.equals("callLinksmartAdapter"))
			return callLinksmartAdapter();
		if (name.equals("callEndNode"))
			return callEndNode();
		return null;
	}

	public ArrayList<GetObjectsResponse> parseResponse() throws Exception {

		// temporary values
		deviceTypes.put("PowerSwitch", "PowerMeter");
		deviceTypes.put("HumiditySensor", "HumiditySensor");
		deviceTypes.put("Thermometer", "Thermometer");
		deviceTypes.put("BrightnessSensor", "LuminanceMeter");
		deviceTypes.put("CO2Sensor", "CO2Sensor");
		deviceTypes.put("PowerMeter", "PowerMeter");

		// temporary values
		deviceProperties.put("PowerConsumption", "MeanPowerConsumption");
		deviceProperties.put("DeviceStatus", "Mode");
		deviceProperties.put("SwitchStatus", "Mode");
		deviceProperties.put("Humidity", "RelativeHumidity");
		deviceProperties.put("Temperature", "AmbientTemperature");
		deviceProperties.put("Brightness", "Luminance");
		deviceProperties.put("CO2Level", "CO2Concentration");

		String _nextCall = "callLinksmartAdapter";
		while (_nextCall != null) {
			// update matchedIO variable values
			_nextCall = call(_nextCall);

		}

		// create class instance to be returned
		ArrayList<GetObjectsResponse> response = new ArrayList<GetObjectsResponse>();
		if (LinksmartAdapter_response != null){
		for (IoTEntity iotentity : LinksmartAdapter_response.getIoTEntity()) {
			if (!iotentity.getTypeOf().get(0).isEmpty()
					&& deviceTypes.containsKey(iotentity.getTypeOf().get(0).split(":")[1])) {
				response.add(generateObject(iotentity));
			}
		}
		} else {
			response.add(new GetObjectsResponse());
			response.get(0).setType("error");
		}
		return response;
	}

	public GetObjectsResponse generateObject(IoTEntity iotentity) {
		GetObjectsResponse vicinityObject = new GetObjectsResponse();
		String oid = iotentity.getAbout();
		String type = deviceTypes.get(iotentity.getTypeOf().get(0).split(":")[1]);
		PropertiesActions p_a = parse(iotentity.getProperties());
		vicinityObject = new GetObjectsResponse(type, oid, p_a.getProperties(), p_a.getActions());
		return vicinityObject;
	}

	public PropertiesActions parse(ArrayList<Properties> properties) {
		ArrayList<String> ssnProperty = new ArrayList<String>();
		ArrayList<String> units = new ArrayList<String>();
		ArrayList<String> datatypes = new ArrayList<String>();
		PropertiesActions object = new PropertiesActions();
		for (Properties prop : properties) {
			ssnProperty.add(prop.getAbout());
			if (prop.getUnitOfMeasurement() != null) {
				units.add(prop.getUnitOfMeasurement().getTypeId());
			} else {
				units.add("");
			}
			datatypes.add(prop.getDataType());
		}

		// translate ssnProperty to vicinity ssnProperty
		for (int i = 0; i < ssnProperty.size(); i++) {
			String trimmed_prop = ssnProperty.get(i).trim();
			String simple_prop = trimmed_prop;
			if (trimmed_prop.contains(":")) {
				simple_prop = trimmed_prop.split(":")[1];
			}
			// create Links
			ArrayList<Link> write_links = new ArrayList<Link>();
			// get
			String read_link_href = "/objects/{oid}/properties/" + trimmed_prop;
			ArrayList<Link> read_links = new ArrayList<Link>();
			read_links.add(new Link(read_link_href, "application/json"));

			// create a wot:Property
			boolean writable = false;
			if (deviceProperties.containsKey(simple_prop)) {
				Property property = new Property(trimmed_prop, deviceProperties.get(simple_prop),
						new Output(units.get(i), datatypes.get(i)), writable, read_links, write_links);
				object.getProperties().add(property);
			}
		}
		return object;
	}
}