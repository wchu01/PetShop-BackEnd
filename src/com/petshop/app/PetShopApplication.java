package com.petshop.app;

import org.glassfish.jersey.server.ResourceConfig;

import com.petshop.api.JacksonFeature;

public class PetShopApplication extends ResourceConfig {
	public PetShopApplication (){
		packages("com.petshop.api");
		register(JacksonFeature.class);
		
	}
	
}
