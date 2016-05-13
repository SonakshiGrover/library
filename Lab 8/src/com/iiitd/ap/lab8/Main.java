/**
  * @author:  Sonakshi Grover 2014106
 */

package com.iiitd.ap.lab8;

import java.util.*;

public class Main 
{

	public static void main(String[] args) 
	{
        Integer cur_user_index=-1;
		Scanner in=new Scanner(System.in);
		String a;
		DataBaseBook dbb = new DataBaseBook();
		DataBaseUser dbu = new DataBaseUser();
		
		System.out.println("\nONLINE PUBLIC ACCESS CATALOG");
		
		
		
		//System.out.println("you chose "+a);
	   while(true)
	   {
		   if((cur_user_index!=null)&&(cur_user_index!=(-1))) 
		   { 
			 if(dbu.getdb_user().get(cur_user_index).getlibid().equals("admin"))
				 System.out.println("\nwelcome admin ");
			 else
				 System.out.println("\nwelcome user "+dbu.getdb_user().get(cur_user_index).getlibid());
		     System.out.println("\n\n1 Manage account\n1.1 login\n1.2 New User\n1.3 logout\n\n2 Search catalog\n2.1 search by name\n2.2 search by author\n\n3 Reserve book\n4 Release Book");
			 
		   }
		   else
		   {
			   System.out.println("\n\n1 Manage account\n1.1 login\n1.2 New User\n");
				   
		   }
		   a=in.nextLine();
		   
		if(a.equals("1.1"))
		{
			if((cur_user_index!=null)&&(!cur_user_index.equals(-1)))
	    	{
	    		System.out.println("you are already logged in!!!");
	    		continue;
	    	}
	    	
			
			
			String libid;
			Integer libpin;
			
			Scanner in1=new Scanner(System.in);
			System.out.println("\nenter library id");
			libid=in1.nextLine();
			System.out.println("\nenter library pin");
			libpin=in1.nextInt();
			cur_user_index=dbu.authenticate(libid,libpin);
			if(cur_user_index!=null)
				{System.out.println("\nLogged in \n"); 		
				
				}
			else
				System.out.println("Incorrect id / pin");
		   	
		}
		else
	    if(a.equals("1.2"))
	    {   
	    	if(!cur_user_index.equals(-1))
	    	{
	    		System.out.println("you need to first logout!!!");
	    		continue;
	    	}
	    	
	    	Scanner in2=new Scanner(System.in);
	    	String batch;
	    	Integer pin; 
	    	System.out.println("Enter your roll number");
	    	batch=in2.nextLine();
	    	System.out.println("Enter a 6 digit pin");
	    	pin=in2.nextInt();
	    	if(!(pin>=100000)&&(pin<=999999))
	    		{System.out.println("pin should be of 6 digits!!!");
	    	    continue;}
	    	cur_user_index=dbu.DataBaseUser_add(batch,pin);
	        System.out.println("your unique id= "+batch+ "and pin = "+pin );    	
	    }
	    else
	    if(a.equals("1.3"))
	    {
	    	if(dbu.getdb_user().get(cur_user_index).getchklog()==true)
	    	{	System.out.println("Successfully Logged out");
	    	    dbu.getdb_user().get(cur_user_index).setchklog(false);
	    	    cur_user_index=-1;
	    	}    	
	    	else
	    		System.out.println("you are already logged out");
	    }
	    else
	    if(a.equals("2.1"))
	 	 {
	    	
	    	  
	    	 ArrayList<Book> ans=new ArrayList<Book> ();
	    	 System.out.println("enter item name");
	    	 Scanner in3=new Scanner(System.in);
		     String it;
		     it=in3.nextLine();
	 	     ans=dbb.searchbyname(it);
	 	     if(ans!=null)
	 	     { Integer d;
	 	       System.out.println("no of copies = "+ans.size());
	 	    	for(d=0;d<ans.size();d++)
	 	    	{  if(ans.get(d).res.equals("")) 
	 	    		System.out.println("\nid = "+ans.get(d).bookid+ ", name  "+ans.get(d).name+ " ,author "+ans.get(d).author+", reserved= "+"No\n" );
	 	    	   else
	 	    		System.out.println("\nid = "+ans.get(d).bookid+ ", name  "+ans.get(d).name+ " ,author "+ans.get(d).author+", reserved= "+"Yes\n" );
	 		 	    	
	 	    	
	 	    	}
	 	    	
	 	     }
	 	     else
	 	     System.out.println("No book found");	 
	 	 }
	    else
		if(a.equals("2.2"))
		{
		    	
		    	   
		    	 ArrayList<Book> ans=new ArrayList<Book> ();
		    	 System.out.println("enter author name");
		    	 Scanner in4=new Scanner(System.in);
			     String aut;
			     aut=in4.nextLine();
		 	     ans=dbb.searchbyauthor(aut);
		 	     if(ans!=null)
		 	     { Integer d;
		 	        System.out.println("no of copies = "+ans.size());
	 	    	
		 	    	for(d=0;d<ans.size();d++)
		 	    	{
		 	    		if(ans.get(d).res.equals("")) 
			 	    		System.out.println("\nid = "+ans.get(d).bookid+ ", name  "+ans.get(d).name+ ", author "+ans.get(d).author+", reserved= "+"No\n" );
			 	    	   else
			 	    		System.out.println("\nid = "+ans.get(d).bookid+ ", name  "+ans.get(d).name+ ", author "+ans.get(d).author+", reserved= "+"Yes\n" );
			 		 	    	
			 	    	
		 	    	}
		 	     }
		 	     else
		 	     System.out.println("No book found");	 
		}
		else
	    if(a.equals("3"))
		{
			       if(cur_user_index.equals(-1))
			       {	   System.out.println("you need to first login!!!");
			               continue;
		           }   
			       else
	    	       if(dbu.getdb_user().get(cur_user_index).getlibid().equals("admin"))
	    	       {
	    	    	   System.out.println("This the status of all the items \n");
				 	     ArrayList<Book> ans=new ArrayList<Book> ();
				    	 
				 	     ans=dbb.getdb_books();
				 	     if(ans!=null)
				 	     { Integer d;
				 	        //System.out.println("no of copies = "+ans.size());
			 	    	
				 	    	for(d=0;d<ans.size();d++)
				 	    	{
				 	    		
				 	    		
				 	    		if(ans.get(d).res.equals("")) 
					 	    		System.out.println("\nid = "+ans.get(d).bookid+ " name  "+ans.get(d).name+ " author "+ans.get(d).author+" reserved= "+"No\n" );
					 	    	   else
					 	    		System.out.println("\nid = "+ans.get(d).bookid+ " name  "+ans.get(d).name+ " author "+ans.get(d).author+" reserved= "+"Yes\n" );
					 		 	    	
					 	    	
				 	    	}
				 	     }
				 	     else
				 	     System.out.println("No book reserved");	 
	    	       
	    	    	    
	    	
	    	
	    	
	    	
	    	       } 
	    	       else
	    	       { Integer i; 
			    	 System.out.println("\nenter book id");
			    	 Scanner in5=new Scanner(System.in);
				     Integer id;
				     id=in5.nextInt();
			 	     i=dbb.searchbyid(id);
			 	     if(i.equals(-1))
			 	     {
			 	    	System.out.println("\nthere is no book with this id");	 
					 	   
			 	     }
			 	     else
			 	     if(dbb.getdb_books().get(i).res.equals(""))
			 	     {
			 	    	 
			 	     
			 	    	System.out.println("\ni= "+i+"id = "+dbb.getdb_books().get(i).bookid+ " name  "+dbb.getdb_books().get(i).name+ " author "+dbb.getdb_books().get(i).author+"\n"+"this book is now reserved in your account\n" );
			 	    	 dbb.getdb_books().get(i).setres(dbu.getdb_user().get(cur_user_index).getlibid());   
			 	     }
			 	     else
			 	     {
			 	    	 System.out.println("This book is already reserved!!!");
			 	     }
			 	     
			 	    //System.out.println(" ... "+dbb.getdb_books().get(i).res+"jffk "+dbu.getdb_user().get(cur_user_index).getlibid() );   
			 	     System.out.println("These books are reserved in your account \n");
			 	     ArrayList<Book> ans=new ArrayList<Book> ();
			    	 
			 	     ans=dbb.searchbyres(dbu.getdb_user().get(cur_user_index).getlibid());
			 	     if(ans!=null)
			 	     { Integer d;
			 	        //System.out.println("no of copies = "+ans.size());
		 	    	
			 	    	for(d=0;d<ans.size();d++)
			 	    	{
			 	    		
			 	    		
			 	    		if(ans.get(d).res.equals("")) 
				 	    		System.out.println("\nid = "+ans.get(d).bookid+ " name  "+ans.get(d).name+ " author "+ans.get(d).author+" reserved= "+"No\n" );
				 	    	   else
				 	    		System.out.println("\nid = "+ans.get(d).bookid+ " name  "+ans.get(d).name+ " author "+ans.get(d).author+" reserved= "+"Yes\n" );
				 		 	    	
				 	    	
			 	    	}
			 	     }
			 	     else
			 	     System.out.println("No book reserved");	 
			 	     
	    	       } 
			 	     
		}
	    else
		if(a.equals("4"))
		{ 
			
			     if(cur_user_index.equals(-1))
		         {	   System.out.println("you need to first login!!!");
		               continue;
	             } 
			     if(dbu.getdb_user().get(cur_user_index).getlibid().equals("admin"))
			     {	 System.out.println("\nadmin cannot release a book"); 
			         continue;
		         }    
				    	 Integer i; 
				    	 System.out.println("\nenter book id to be released");
				    	 Scanner in6=new Scanner(System.in);
					     Integer id;
					     id=in6.nextInt();
				 	     i=dbb.searchbyid(id);
				 	     if(i.equals(-1))
				 	     {
				 	    	System.out.println("\nthere is no book with this id");	 
						 	   
				 	     }
				 	     else
				 	     if(dbb.getdb_books().get(i).res.equals(dbu.getdb_user().get(cur_user_index).getlibid())==false)
				 	     {
				 	    	 System.out.println("this is book was never reserved in your account");
				 	     }
				 	     else
				 	     {
				 	    	System.out.println("\n"+"id = "+dbb.getdb_books().get(i).bookid+ " name  "+dbb.getdb_books().get(i).name+ " author "+dbb.getdb_books().get(i).author+"\n"+"this book is now released\n" );
				 	    	 dbb.getdb_books().get(i).setres("");   
				 	     }
				 	     
				 	   // System.out.println(" ... "+dbb.getdb_books().get(i).res+"jffk "+dbu.getdb_user().get(cur_user_index).getlibid() );   
				 	     
				 	     
				 	     
				 	     
		 }
			
		
	   }	
	   
	}

}
