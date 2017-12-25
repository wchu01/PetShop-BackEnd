package com.petshop.api;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import com.MARS_Explorer.models.WeatherMachine;
import com.petshop.data.ShopDataLayer;
import com.petshop.models.ShopData;


@Path ("v1/shops")
public class PetShopService {
	
	private ShopDataLayer data_Shop = new ShopDataLayer();
	
	
	// ### List all shops [GET]
	@PermitAll
	@GET
	@Produces({ "application/xml; qs=0.9", "application/json; qs=1" })
	public Response GetShops() {

		ArrayList<ShopData> shopList = data_Shop.GetAllShops();

		for (ShopData shop : shopList) {
			shop.Uri.Href = "/PetShop/v1/machines/" + shop.Id_Pet_Store;
			shop.Uri.Method = "GET";
			shop.Uri.Rel = "Shop Details";
		}

		GenericEntity<ArrayList<ShopData>> entity = new GenericEntity<ArrayList<ShopData>>(shopList) {};


		return Response.ok(entity).build();
	
	}//### End of List all shops [GET]
	
	// ### Create New MARS Explorer Machine [POST]
	@PermitAll
	@POST
	@Consumes({"application/json"})
	public Response AddShop(ShopData newShop) {
				
		double id = this.data_Shop.AddShop(newShop);
				
		return Response.status(200).type("text/plain").entity("Shop ID : " +  id + " added" ).build();
	}// ###  End of Create New MARS Explorer Machine [POST]
	
}
