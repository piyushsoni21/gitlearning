package com.aerohive.association;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/helloWorldOperations") 
public class HelloWorldController {
	
	private HelloWorld helloWorld;	
	private static int id = 0;
	private List<HelloWorld> hwList = new ArrayList<HelloWorld>();

	@GET
	@Path("/addMessage")
	public void addMessage(@QueryParam("message") String message){
		helloWorld = new HelloWorld();
		helloWorld.setMessage(message);
		helloWorld.setId(id++);
		hwList.add(helloWorld);
	}
	
	
	@GET
	@Path("/getMessage")
	@Produces("application/json")
	public String getMessage(){
		return "hello";
	}


	public HelloWorld getHelloWorld() {
		return helloWorld;
	}


	public void setHelloWorld(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}	
}
