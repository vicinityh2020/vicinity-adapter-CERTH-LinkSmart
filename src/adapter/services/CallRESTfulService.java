package adapter.services;

import adapter.services.WorkflowClass.Variable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
public class CallRESTfulService {
    public static String callService(String wsUrl, String crudVerb, ArrayList<Variable> inputs, String entity, boolean hasAuth, String auth, ArrayList<Variable> requestHeaderList){
        String result = "";
        String inputList = "";
        if (!inputs.isEmpty()) {
            for (Variable input : inputs) {
                if (input.value !=null && !input.value.isEmpty()) {
                    if (!inputList.isEmpty())
                        inputList += "&";
                    inputList += input.name + "=" + input.value;
                }
            }
        }

        // instead of using URLEncoder
        inputList = inputList.replaceAll("\\{", "%7B");
        inputList = inputList.replaceAll("\\}", "%7D");
        inputList = inputList.replaceAll("\\[", "%5B");
        inputList = inputList.replaceAll("\\]", "%5D");
        inputList = inputList.replaceAll("\\:", "%3A");

        String inputListGet = "";
        if (!inputList.isEmpty()) {
            inputListGet = "?" + inputList;
        }
        if (crudVerb.equalsIgnoreCase("get") || crudVerb.equalsIgnoreCase("post") || crudVerb.equalsIgnoreCase("delete") || crudVerb.equalsIgnoreCase("put")) {
            HttpURLConnection conn = null;
            try {
                URL url = new URL((wsUrl + inputListGet).replaceAll(" ","%20"));
                System.out.println("Calling " + url.toString());
                conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setReadTimeout(5000);
                conn.setRequestMethod(crudVerb);
                conn.setRequestProperty("Accept", "application/json");                
                if (hasAuth) {
                    Base64 b = new Base64();
                    String encoding = b.encodeAsString(new String(auth).getBytes());
                    conn.setRequestProperty("Authorization", "Basic " + encoding);
                }
                if (requestHeaderList != null) {
                    for (Variable header : requestHeaderList) {
                        conn.setRequestProperty(header.name, header.value);
                    }
                }
                if (crudVerb.equalsIgnoreCase("post") || crudVerb.equalsIgnoreCase("put")) {
                        conn.setRequestProperty("Content-Type", "application/json");
                        conn.setDoInput(true);
                        conn.setDoOutput(true);
                        DataOutputStream os = new DataOutputStream(conn.getOutputStream());
                        os.writeBytes(entity); 
                }
                int code = conn.getResponseCode();
                if (code != 200 && code != 201 && code != 301) {
                    throw new RuntimeException("Failed : HTTP error code : " + code);
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                String output;
                System.out.println("Output from Server ....\n");
                while ((output = br.readLine()) != null) {
                    result += output;
                    System.out.println(output);
                }
                br.close();
            } catch (java.net.SocketTimeoutException e) {
            	e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        } else {
            System.out.println("Operation " + crudVerb + " is not a valid CRUD operation");
        }
        if (result.startsWith("[")){
            result = "{\"Property\":" + result + "}";
        }
        return result;
    }
}
