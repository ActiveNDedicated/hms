/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAF
 */
public class User extends Human{
    private String userName;
    private String password;
    protected static boolean ismanager;
    
    public User (String firstName, String lastName,  String phoneNumber, 
                 String email, Address address,  
                 String userName, String password) {
        
        super(firstName, lastName, phoneNumber, email, address);
        setUserName(userName);
        setPassword(password);   
    }
    public User(String username,String password)
    {
        setUserName(username);
        setPassword(password);
    }
    public User()
    {}

    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
