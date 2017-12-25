package com.petshop.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.petshop.models.ResourceLink;
import com.petshop.models.ShopData;

public class ShopDataLayer {
	
	private String connstring = "jdbc:mysql://localhost:3306/marsweather?useSSL=false";
	private String user = "root";
	private String password = "abcd1234";
	
	//return all machines from database
	public ArrayList<ShopData> GetAllShops() {
		
		//define an arraylist of ShopData type to store the results
		ArrayList<ShopData> shops = new ArrayList<ShopData>();
		try (
			// get sql connections
			Connection conn = DriverManager.getConnection(connstring, user, password);
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM pet_grooming_app.pet_store");
		) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				shops.add(new ShopData(rs.getDouble("ID_Pet_Store"), rs.getLong("Approved"), rs.getString("StoreName"), rs.getString("OwnerFirstName"),
									   rs.getString("OwnerLastName"), rs.getString("BizRegNumber"), rs.getString("StoreWebsite"), rs.getString("StoreEmail"),
									   rs.getString("LoginEmail"), rs.getString("LoginPassword"),rs.getString("AddressStreet"),rs.getString("AddressUnitNumber"),
									   rs.getString("AddressPostalCode"), rs.getTimestamp("OpStartTime"),rs.getTimestamp("OpEndTime"),rs.getString("ContactNumber"),new ResourceLink()));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return shops;
	}

	public double AddShop(ShopData newShop) {
		// TODO Auto-generated method stub
		 double petshopId = 0;
		try (
				// get sql connections
				Connection conn = DriverManager.getConnection(connstring, user, password);
				PreparedStatement statement = conn.prepareStatement("INSERT INTO pet_grooming_app.pet_store (StoreName, OwnerFirstName, OwnerLastName, BizRegNumber, "
						+ "StoreWebsite, StoreEmail, LoginEmail, LoginPassword, AddressStreet,AddressUnitNumber, AddressPostalCode, OpStartTime, OpEndTime, "
						+ "ContactNumber) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
			) {
				statement.setString(1, newShop.StoreName);
				statement.setString(2, newShop.OwnerFirstName);
				statement.setString(3, newShop.OwnerLastName);
				statement.setString(4, newShop.BizRegNum);
				statement.setString(5, newShop.StoreName);
				statement.setString(6, newShop.StoreEmail);
				statement.setString(7, newShop.LoginEmail);
				statement.setString(8, newShop.LoginPasswd);
				statement.setString(9, newShop.AddressStreet);
				statement.setString(10, newShop.AddressUnitNum);
				statement.setString(11, newShop.PostalCode);
				statement.setTimestamp(12, newShop.Operate_StartTime);
				statement.setTimestamp(13, newShop.Operate_EndTime);
				statement.setString(14, newShop.Contact_Num);
				
								
				int affectedRows = statement.executeUpdate();
				if (affectedRows == 0) {
		            throw new SQLException("Creating New Pet Shop, no rows affected.");
		        }
				
				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		            	petshopId = generatedKeys.getInt(1);
		            }
		            else {
		                throw new SQLException("Creating New Pet Shop failed, no ID obtained.");
		            }
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return petshopId;
		
	}
	
}
