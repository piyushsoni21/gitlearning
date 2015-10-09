package com.aerohive.association;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.springframework.web.bind.annotation.RequestBody;

@Path("/process")
public class JsonReader {

	@GET
	@Path("/pollRequest")
	@Produces("application/json")
	public String readJson() throws IOException {
		BufferedReader in = null;
		StringBuilder outputString = new StringBuilder();
		// JSONObject jsonResult = null;
		try {
			in = new BufferedReader(new InputStreamReader(
					JsonReader.class.getResourceAsStream("jsonInput.txt")));
			String c;
			while ((c = in.readLine()) != null) {
				outputString.append(c);
			}
			/*ObjectMapper mapper = new ObjectMapper();
			// mapper.setVisibility(JsonMethod.FIELD, Visibility.ANY);
			mapper = mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
			cliCommmand = mapper.readValue(outputString, CliCommand.class);*/
			/*
			 * String mappedString = mapper.writeValueAsString(cliCommmand);
			 * 
			 * jsonResult = new JSONObject(mappedString);
			 * System.out.println(jsonResult);
			 */
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return outputString.toString();
	}

	@POST
	@Path("/pollRequest")
	@Produces("application/json")
	public Status writeJson(@RequestBody String jsonString)  {
		/*
		 * JsonFactory jfactory = new JsonFactory(); JsonParser jsonParser =
		 * jfactory.createJsonParser(jsonString); while (jsonParser.nextToken()
		 * != JsonToken.END_OBJECT) {
		 * System.out.println(jsonParser.getCurrentName() + ":"
		 * +jsonParser.getText()); } System.out.println(jsonString);
		 */
		CliCommand cliCommmand = null;
		ObjectMapper mapper = new ObjectMapper();
		mapper = mapper.configure(Feature.FAIL_ON_EMPTY_BEANS, false);
		try {
			cliCommmand = mapper.readValue(jsonString, CliCommand.class);
		} catch (JsonParseException e) {
			return Status.BAD_REQUEST;
		} catch (JsonMappingException e) {
			return Status.BAD_REQUEST;
		} catch (IOException e) {
			return Status.BAD_REQUEST;
		}
		return Status.OK;
	}

}
