package br.com.itix.chathub.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;

@Path("contact")
public class ContactController {
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public String sendHi() {
		return (new Gson()).toJson( "Hello world !!!" );
	}
}


