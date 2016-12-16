import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class Manager extends User {
    DatabaseConnection dbc=new DatabaseConnection();
    String query;
    public Manager(String firstName, String lastName, String phoneNumber, 
                 String email, Address address, String userName, String password) {
        
        super(firstName, lastName,phoneNumber, email, address, userName, password);
    }
    
    public static boolean isManager() {
      ismanager=true;
        return ismanager;
    }
    
    public void createRoom()
    {
        ArrayList<Room> r=new   ArrayList<Room>();
        for (int i=0;i<10;i++)
        {
            Room room =new Room ();
            room.setAvailability(true);
            room.setRoomNo(101+i);
            room.setTypeOfRoom("Standard");
            if (i<2)
            {    room.setTypeOfBed(1);
                 room.setCost(50);
            }
            else if (i<5)
            { room.setTypeOfBed(2);
              room.setCost(70);
            }
            else if(i<10)
            {   room.setTypeOfBed(3);
                room.setCost(90);
            }
            r.add(room);
            
        }
         for (int i=0;i<10;i++)
        {
            Room room =new Room ();
            room.setAvailability(true);
            room.setRoomNo(201+i);
            room.setTypeOfRoom("Superior");
            if (i<2)
            {   room.setTypeOfBed(1);
                room.setCost(200);
            }
            else if (i<5)
            {   room.setTypeOfBed(2);
                room.setCost(220);
            }
            else if(i<10)
            {  room.setTypeOfBed(3);
               room.setCost(240);
            }
            r.add(room);
        }
          for (int i=0;i<10;i++)
        {
            Room room =new Room ();
            room.setAvailability(true);
            room.setRoomNo(301+i);
            room.setTypeOfRoom("Deluxe");
            if (i<2)
            { room.setTypeOfBed(1);
              room.setCost(350);
            }
            else if (i<5)
            {   room.setTypeOfBed(2);
                room.setCost(370);
            }else if(i<10)
            {   room.setTypeOfBed(3);
                room.setCost(390);
            }r.add(room);
        }
          for (int i=0;i<r.size();i++)
          { 
            query = "INSERT INTO roomdetails ( room_no, typeofbed, cost, typeofroom, availability ) VALUES ( '"+r.get(i).getRoomNo()+"', '"+r.get(i).getTypeOfBed()+"', '"+r.get(i).getCost()+"', '"+r.get(i).getTypeOfRoom()+"', '"+1+"')";
            dbc.storeData(query);
          }
          
    }
    
    public void registerUser(String fname,String lname,String phone,String mail, Address addr,String gender, String usern,String passw,boolean isManager)
   {
   if (isManager)
   {
       Manager m= new Manager(fname,lname,phone,mail,addr,usern,passw);
       query = "INSERT INTO users ( username, password, isManager, firstname, lastname, phonenumber, email, gender,country, city, street, zipcode ) VALUES ( '"+m.getUserName()+"', '"+m.getPassword()+"', '"+1+"', '"+m.getFirstName()+"', '"
               +m.getLastName()+"', '"+m.getPhoneNumber()+"', '"+m.getEmail()+"','"+m.getAddress().getCountry()+"', '"+m.getAddress().getCity()+"', '"+m.getAddress().getStreet()+"', '"+m.getAddress().getZipCode()+"')";
       dbc.storeData(query);
   }
   else 
   {
       Receptionist m=new Receptionist(fname,lname,phone,mail,addr,usern,passw);
       query = "INSERT INTO users ( username, password, isManager, firstname, lastname, phonenumber, email, gender,country, city, street, zipcode ) VALUES ( '"+m.getUserName()+"', '"+m.getPassword()+"', '"+0+"', '"+m.getFirstName()+"', '"
               +m.getLastName()+"', '"+m.getPhoneNumber()+"', '"+m.getEmail()+"', '"+m.getAddress().getCountry()+"', '"+m.getAddress().getCity()+"', '"+m.getAddress().getStreet()+"', '"+m.getAddress().getZipCode()+"')";
       dbc.storeData(query);
   }
   }
    
   public void deleteUser(String username)
   {
         query="Delete * from users WHERE username='"+username+"'";
         dbc.deleteData(query);
   }
   public void modifyUser(String fname,String lname,String phone,String mail, Address addr, String usern,String passw){
   
       query="Update users SET password ='"+passw+"',firstname ='"+fname+"',lastname ='"+lname+"',phonenumber ='"+phone+"',email ='"+mail+"',country ='"+addr.getCountry()+"',city ='"+addr.getCity()+"',street ='"+addr.getStreet()+"',zipcode ='"+addr.getZipCode()+"', WHERE username = '"+usern+"'";
       dbc.updateData(query);
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
       return found;
   }
   
   
}
