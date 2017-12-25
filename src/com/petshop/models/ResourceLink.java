package com.petshop.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResourceLink {
	@XmlElement
	public String Href;
	@XmlElement
	public String Method;
	@XmlElement
	public String Rel;
	
	public ResourceLink() {
		
	}
	
	public ResourceLink(String url, String method, String rel) {
		this.Href = url;
		this.Method = method;
		this.Rel = rel;
	}
	
	public ResourceLink(String url) {
		this.Href = url;
	
	}
}
