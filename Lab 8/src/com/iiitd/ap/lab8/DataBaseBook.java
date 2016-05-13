/**
  * @author:  Sonakshi Grover 2014106
 */

package com.iiitd.ap.lab8;
import java.util.*;

public class DataBaseBook 
{

	ArrayList<Book> db_books=new ArrayList<Book>();
	ArrayList<Book> db_periodicals=new ArrayList<Book>();
	ArrayList<Book> db_audio=new ArrayList<Book>();
	ArrayList<Book> db_visualmaterials=new ArrayList<Book>();
	
	
	
	public DataBaseBook()
	{
		
		/*
		the code works the searching algo (and others) only on db_books
        and not on periodicals,audio,.... 		
		*/
		db_books.add(new Book(1,"Harry Potter","JK Rowling",""));
		db_books.add(new Book(10,"Harry Potter1","JK Rowling1",""));
		
		
		
		
		db_periodicals.add(new Book(2,"abc","def",""));
		db_audio.add(new Book(3,"ghi","jkl",""));
		db_visualmaterials.add(new Book(4,"mno","pqr",""));
		
		
	}
	
	
	public ArrayList<Book> searchbyname(String s)
	{
		//Book x=new Book();
		int flag=0;
		ArrayList<Book> ans_db_books=new ArrayList<Book>();
		for(Integer j=0;j<db_books.size();j++ )
		{
			if(db_books.get(j).name.equals(s))
			{   
				ans_db_books.add(db_books.get(j));
				flag=1;
			}	
			
		}
		if(flag==0)
		  return null;
		else
		  return ans_db_books;	
	}
	 
	public ArrayList<Book> searchbyauthor(String s)
	{
		//Book x=new Book();
		int flag=0;
		ArrayList<Book> ans_db_books=new ArrayList<Book>();
		for(Integer j=0;j<db_books.size();j++ )
		{
			if(db_books.get(j).author.equals(s))
			{   
				ans_db_books.add(db_books.get(j));
				flag=1;
			}	
			
		}
		if(flag==0)
		  return null;
		else
		  return ans_db_books;	
	}
	
	public ArrayList<Book> searchbyres(String s)
	{
		//Book x=new Book();
		int flag=0;
		ArrayList<Book> ans_db_books=new ArrayList<Book>();
		for(Integer j=0;j<db_books.size();j++ )
		{
			if(db_books.get(j).res.equals(s))
			{   
				ans_db_books.add(db_books.get(j));
				flag=1;
			}	
			
		}
		if(flag==0)
		  return null;
		else
		  return ans_db_books;	
	}

	public Integer searchbyid(Integer s)
	{
		
		for(Integer j=0;j<db_books.size();j++ )
		{
			//System.out.println("db_books.get(j).bookid"+db_books.get(j).bookid);
			
			if(db_books.get(j).bookid.equals(s))
			{  
				//System.out.println("hehehe "+db_books.get(j).bookid);
				
				return j;
			}	
			
		}
		
		return -1;
		
	}


	
	public ArrayList<Book> getdb_books()
	{
		
		return db_books;
	
	}

	public ArrayList<Book> getdb_periodicals()
	{
		
		return db_periodicals;
	
	}

	public ArrayList<Book> getdb_audio()
	{
		
		return db_audio;
	
	}
	public ArrayList<Book> getdb_visualmaterials()
	{
		
		return db_visualmaterials;
	
	}
	
	
	
}


