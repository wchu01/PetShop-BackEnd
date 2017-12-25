package com.petshop.models;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlElement;

import com.MARS_Explorer.models.ResourceLink;

public class ShopData {

	
	@XmlElement 
	public double Id_Pet_Store;
	@XmlElement 
	public long Approved;
	@XmlElement 
	public String StoreName;
	@XmlElement 
	public String OwnerFirstName;
	@XmlElement 
	public String OwnerLastName;
	@XmlElement 
	public String BizRegNum;
	@XmlElement 
	public String StoreWebsite;
	@XmlElement 
	public String StoreEmail;
	@XmlElement 
	public String LoginEmail;
	@XmlElement 
	public String LoginPasswd;
	@XmlElement 
	public String AddressStreet;
	@XmlElement 
	public String AddressUnitNum;
	@XmlElement 
	public String PostalCode;
	@XmlElement
	public Timestamp Operate_StartTime;
	@XmlElement
	public Timestamp Operate_EndTime;
	@XmlElement
	public String Contact_Num;
	
	public ResourceLink Uri;
	
	//default constructor 
	public ShopData(){
		this.Uri = new ResourceLink();
	}
	
	//for GET (All Shops)
	public ShopData(double id_pet_store, long approved, String storename, String ownerfirstname,
					String ownerlastname, String bizregnum, String storewebsite, String storeemail,
					String loginemail, String loginpasswd, String addressstreet, String addressunitnum,
					String PostalCode, Timestamp op_starttime, Timestamp op_endtime, String contact_num, ResourceLink uri){
		
		this.Id_Pet_Store = id_pet_store;
		this.Approved = approved;
		this.StoreName = storename;
		this.OwnerFirstName = ownerfirstname;
		this.OwnerLastName = ownerlastname;
		this.BizRegNum = bizregnum;
		this.StoreWebsite = storewebsite;
		this.StoreEmail = storeemail;
		this.LoginEmail = loginemail;
		this.LoginPasswd = loginpasswd;
		this.AddressStreet = addressstreet;
		this.AddressUnitNum = addressunitnum;
		this.PostalCode = PostalCode;
		this.Operate_StartTime = op_starttime;
		this.Operate_EndTime = op_endtime;
		this.Contact_Num = contact_num;
		this.Uri = uri;
	}
	
	public ShopData(String storename, String ownerfirstname, String ownerlastname, String bizregnum,
			String storewebsite, String storeemail, String loginemail, String loginpasswd, String addressstreet,
			String addressunitnum, String PostalCode, Timestamp op_starttime, Timestamp op_endtime,
			String contact_num) {

		this.StoreName = storename;
		this.OwnerFirstName = ownerfirstname;
		this.OwnerLastName = ownerlastname;
		this.BizRegNum = bizregnum;
		this.StoreWebsite = storewebsite;
		this.StoreEmail = storeemail;
		this.LoginEmail = loginemail;
		this.LoginPasswd = loginpasswd;
		this.AddressStreet = addressstreet;
		this.AddressUnitNum = addressunitnum;
		this.PostalCode = PostalCode;
		this.Operate_StartTime = op_starttime;
		this.Operate_EndTime = op_endtime;
		this.Contact_Num = contact_num;

	}
	
	
}
