/**
  * @author:  Sonakshi Grover 2014106
 */

package com.iiitd.ap.lab8;

import java.util.ArrayList;

public class DataBaseUser
{

	ArrayList<User> db_user=new ArrayList<User>();
		
	
	public DataBaseUser()
	{
		db_user.add(new User("admin",000000,false));
		db_user.add(new User("2014106",123456,false));
		db_user.add(new User("2013199",100000,false));
			
		
	}
	
	public Integer DataBaseUser_add(String b,Integer a)
	{
	    
		db_user.add(new User(b,a,true));
		return db_user.size()-1;
	
	}
	
	
	public Integer authenticate(String s,Integer i)
	{
		//User x=new User();
		for(Integer j=0;j<db_user.size();j++ )
		{
			if((db_user.get(j).libid.equals(s))&&(db_user.get(j).pin.equals(i)))
			{   
				db_user.get(j).chklog=true; 
				return j;
			}	
			
		}
		return null;
	}
	
	
	public ArrayList<User> getdb_user()
	{
		return db_user;
	}
	
	
}
