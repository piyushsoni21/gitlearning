package com.aerohive.association;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.aerohive.association.domain.DeviceStatus;
import com.aerohive.association.handler.AssociationRequestHandler;

@Component("haController")
@Path("/")
public class HaController {

	
/*	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}*/

	@Autowired
	private AssociationRequestHandler associationService;
	
	@GET
	//@RequestMapping(value="/association/{identifier}")
	@Path("/association/{identifier}")
	@Produces(MediaType.APPLICATION_JSON)
	public String readJson(@PathParam("identifier") String identifier) throws IOException {

		DeviceStatus ds= associationService.getDeviceDetails(identifier);
		System.out.println("Object component :"+ds);
		BufferedReader in = null;
		String outputString = "";
		// JSONObject jsonResult = null;
		HaResponse haResponse = new HaResponse();

		//DeviceStatus deviceUtils=hmService.getDeviceDetails(identifier);
		try {
			//BeanUtils.copyProperties(deviceUtils, haResponse);

			in = new BufferedReader(new InputStreamReader(
					JsonReader.class.getResourceAsStream("haResponse.txt")));
			String c;
			while ((c = in.readLine()) != null) {
				outputString = outputString + c;
			}
			/*ObjectMapper mapper = new ObjectMapper();
			mapper = mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			haResponse = mapper.readValue(outputString, HaResponse.class);*/
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (in != null) {
				in.close();
			}
		}

		return "Piyush";
	}
	@POST
	@Path("/association")
	@Produces("application/json")
	public Response  writeJson(@RequestBody String jsonString) throws IOException {

		HaRequest haRequest = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper = mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		haRequest = mapper.readValue(jsonString, HaRequest.class);
		//hmService.addDeviceDetails(haRequest);
		return Response.status(200).entity("ok").build();
	}

}
