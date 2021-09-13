package com.Bean;

public class Admin {
	
	private int id;
	private String psw;
	
	public Admin()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
	public boolean isEquals(Admin obj)
	{
		if(this.id==obj.id && this.psw==obj.psw)
			return true;
		else
			return false;
	}
	

}
