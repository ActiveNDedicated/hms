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
            System.out.println("\nConnecting  : "+databaseName+"\n");
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
                Statement statement = null;
                connectToDB();
                statement = connection.createStatement();
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
		System.out.println("Getting data .........\n");

    	return this.resultSet;
     }
    
    public void storeData(String query) 
    {
    	try
		{
			
			Statement statement = null;
                        connectToDB();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data sent to Database......\n");
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
			Statement statement = null;
                        connectToDB();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Database updated .........\n");
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
			
			Statement statement = null;

                        connectToDB();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data deleted  .........\n");
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
