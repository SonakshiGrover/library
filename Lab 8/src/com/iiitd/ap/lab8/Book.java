/**
  * @author:  Sonakshi Grover 2014106
 */

package com.iiitd.ap.lab8;

public class Book 
{

	Integer bookid;
	String name;
	String author;
	String res;
	
	
	public Book(int bookid,String name,String author,String res)
	{
		this.bookid=bookid;
		this.name=name;
		this.author=author;
		this.res=res;
		
	}
	
	public void setres(String s)
	{
		this.res=s;
	}
	
	
}
