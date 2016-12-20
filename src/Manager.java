import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;

public class Manager extends User {
    DatabaseConnection dbc=new DatabaseConnection();
    String query;
    public Manager(String firstName, String lastName, String phoneNumber, 
                 String email, Address address, String userName, String password) {
        
        super(firstName, lastName,phoneNumber, email, address, userName, password);
    }
    
    public boolean isManager() {
      ismanager=true;
        return ismanager;
    }
    
    public void createRoom(int roomNum,int typeOfBed,int cost, String typeOfRoom)
    {
        query = "INSERT INTO roomdetails ( room_no, typeofbed, cost, typeofroom, availability ) VALUES ( '"
                +roomNum+"', '"+typeOfBed+"', '"+cost+"', '"+typeOfRoom+"', '"+1+"');";
        dbc.storeData(query);
        dbc.closeconnection();
    }
    
    public void registerUser(String fname,String lname,String phone,String mail, String country,String city,String street,String zipCode , String usern,String passw,boolean isManager)
   {
   Address addr=new Address(country,city,street,zipCode);
       if (isManager)
   {
       Manager m= new Manager(fname,lname,phone,mail,addr,usern,passw);
       query = "INSERT INTO users ( username, password, isManager, firstname, lastname, phonenumber, email, country, city, street, zipcode ) VALUES ( '"+m.getUserName()+"', '"+m.getPassword()+"', '"+1+"', '"+m.getFirstName()+"', '"
               +m.getLastName()+"', '"+m.getPhoneNumber()+"', '"+m.getEmail()+"','"+m.getAddress().getCountry()+"', '"+m.getAddress().getCity()+"', '"+m.getAddress().getStreet()+"', '"+m.getAddress().getZipCode()+"')";
       dbc.storeData(query);
   }
   else 
   {
       Receptionist r=new Receptionist(fname,lname,phone,mail,addr,usern,passw);
       query = "INSERT INTO users ( username, password, isManager, firstname, lastname, phonenumber, email, country, city, street, zipcode ) VALUES ( '"+r.getUserName()+"', '"+r.getPassword()+"', '"+0+"', '"+r.getFirstName()+"', '"
               +r.getLastName()+"', '"+r.getPhoneNumber()+"', '"+r.getEmail()+"', '"+r.getAddress().getCountry()+"', '"+r.getAddress().getCity()+"', '"+r.getAddress().getStreet()+"', '"+r.getAddress().getZipCode()+"')";
       dbc.storeData(query);
   }
       dbc.closeconnection();
   }
    
   public void deleteUser(String username)
   {
         query="Delete from users WHERE username='"+username+"';";
         dbc.deleteData(query);
         dbc.closeconnection();
   }
   public void modifyUser(String fname,String lname,String phone,String mail, String usern,String passw,String country,String city,String street,String zipcode,int ismanager){
   
       query="Update users SET password ='"+passw+"',firstname ='"+fname+"',lastname ='"+lname+"',phonenumber ='"+phone+"',email ='"+mail+"',country ='"
               +country+"',city ='"+city+"',street ='"+street+"',zipcode ='"+zipcode+"',isManager='"+ismanager+"' WHERE username = '"+usern+"'";
       dbc.updateData(query);
       dbc.closeconnection();
   }
   
   public Vector<User> searchUser(String fname, String lname){
       if (fname==null&&lname==null)
           query="SELECT * FROM users;";
       else
           query="SELECT * FROM users WHERE firstname='"+fname+"' OR lastname='"+lname+"';";
       Vector  <User> found=new Vector<User>();
       ResultSet rs = dbc.getData(query);
       User user;
     try
            {
                while (rs.next()) 
                {
                   if (rs.getInt("isManager")==1)
                       
                      user=new Manager(rs.getString("firstname"),rs.getString("lastname"),
                                       rs.getString("phonenumber"),rs.getString("email"),new Address(rs.getString("country"),
                                       rs.getString("city"),rs.getString("street"),rs.getString("zipcode")),rs.getString("username"),
                                       rs.getString("password"));
                   else
                       user=new Receptionist(rs.getString("firstname"),rs.getString("lastname"),rs.getString("phonenumber"),
                                             rs.getString("email"),new Address(rs.getString("country"),rs.getString("city"),rs.getString("street"),
                                             rs.getString("zipcode")),rs.getString("username"),rs.getString("password"));
                found.add(user);
                }
            }
            catch(SQLException e)
            {
                    System.out.println(e);
            }
       dbc.closeconnection();
       return found;
   }
   
   
   
   public void modifyRoom(int roomNum,double cost, int typeOfBed,String typeOfRoom)
   {
       query = "UPDATE roomdetails SET typeofbed='"+typeOfBed+"', cost='"+cost+"', typeofroom='"+typeOfRoom
               +"' WHERE room_no='"+roomNum+"';";
        dbc.storeData(query);
        dbc.closeconnection();
   }
   
   public void deleteRoom(int roomNum){
    query="Delete from roomdetails WHERE room_no='"+roomNum+"';";
         dbc.deleteData(query);
         dbc.closeconnection();   
   }
   
   
   
}
