/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Азизбек Матчанов
 */

import java.sql.*;

public class DatabaseConnection
{  
    private String databaseName="hms";

    private Connection connection;  // use to establish database connection
    private Statement statement;	// use to execute SQL query statements
    private ResultSet resultSet;	// use to get the result set
   
	public DatabaseConnection()
	{
		connectToDB();
	}
	
	public DatabaseConnection(String databaseName)
    {
        setDatabaseName(databaseName);
        connectToDB();
    }
    
    public void setDatabaseName(String databaseName)
    {
        this.databaseName=databaseName;
    }
    public String getDatabaseName()
    {
        return databaseName;
    }
    	
	public Statement getStatement()
    {
        return statement;
    }
    public void connectToDB()
    {
        try{
            System.out.println("\nConnecting to Database : "+databaseName+"\n");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName,"root","admin");
            statement = connection.createStatement();
        }
       
        catch(SQLException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
        
       
    }

    public ResultSet getData(String query) 
    {
    	try{
    		resultSet = statement.executeQuery(query);
    	}
    	catch(SQLException e)
    	{
    		System.out.println(e);
    	}
//    	finally
//    	{
//    		try{
//    			if(statement!=null)
//    			{
//    				connection.close();
//    			}
//    		}
//    		catch(SQLException se)
//    		{
//    		}
//    	      
//    		try
//    		{
//    			if(connection!=null)
//    			{
//    				connection.close();
//    			}
//    		}
//    		catch(SQLException se)
//    		{
//    			se.printStackTrace();
//    		}
//    	}	
		System.out.println("Retrieving data .........\n");

    	return this.resultSet;
     }
    
    public void storeData(String query) 
    {
    	try
		{
			
			//Statement statement = null;

    		//connectToDB();
			//statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data stored successfully .........\n");
		}
		catch(SQLException e)
		{
			System.out.println(e);
                        
		}
    }
    
    public void updateData(String query) 
    {
    	try
		{			
//			Statement statement = null;
//                        connectToDB();
//			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data updated successfully .........\n");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
    }    
    
    
    public void deleteData(String query) 
    {
    	try
		{
			
//			Statement statement = null;
//
//                        connectToDB();
//			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data deleted successfully .........\n");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
    }    
    
    public void  closeconnection(){
    
    	
    		try{
    			if(statement!=null)
    			{
    				connection.close();
                                System.out.println("Connection closed!");
    			}
    		}
    		catch(SQLException se)
    		{
    		}
    	      
    		try
    		{
    			if(connection!=null)
    			{
    				connection.close();
                                System.out.println("Connection closed!");

    			}
    		}
    		catch(SQLException se)
    		{
    			se.printStackTrace();
    		}
    	
    
    }
    
   
}
