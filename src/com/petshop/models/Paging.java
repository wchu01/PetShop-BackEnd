package com.petshop.models;

import java.util.ArrayList;

public class Paging {
	public ResourceLink Next;
	public ResourceLink Prev;
	public ArrayList<ResourceLink> Pages;
	
	public Paging() {
		this.Next = new ResourceLink();
		this.Prev = new ResourceLink();
		this.Pages = new ArrayList<ResourceLink>();
	}
}
