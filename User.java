
/**
  * @author:  Sonakshi Grover 2014106
 */


package com.iiitd.ap.lab8;

public class User
{

	String libid;
	Integer pin;
	boolean chklog; 
	
	
	public User(String libid,int pin,boolean chklog)
	{
		this.libid=libid;
		this.pin=pin;
		this.chklog=chklog;
		
		
	}


	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getlibid()
	{
		return this.libid;
	}
	public void setlibid(String id)
	{
		this.libid=id;
		
	}
	
	public Integer getpin()
	{
		return this.pin;
	}
	public void setpin(Integer pin)
	{
		this.pin=pin;
		
	}
	
	public boolean getchklog()
	{
		return this.chklog;
	}
	public void setchklog(boolean log)
	{
		this.chklog=log;
		
	}
}
