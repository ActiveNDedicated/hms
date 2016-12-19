import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.Calendar;


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
    DatabaseConnection dbc=new DatabaseConnection();
    String query;
    
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
     public boolean isManager() {
        return ismanager;
    }
        
        public Vector<Room> CheckRoomAvailability (Date checkin,Date checkout,int numOccupants)
    {
     Vector  <Room> available=new Vector<Room>();
      query="SELECT * FROM roomdetails "
                + "where room_no NOT IN (SELECT room_number FROM guests WHERE (DATE(checkin) >= '" 
                + checkin + "' AND DATE(checkin) <= '" + new java.sql.Date(checkout.getTime()) + "') OR(DATE(checkout) > '" 
                + new java.sql.Date(checkin.getTime()) + "') ) AND typeofbed>='"+numOccupants/2+"';";
     ResultSet resultSet = dbc.getData(query);
     /*
     */
     try
            {
                while (resultSet.next()) 
                {
                        int roomno = resultSet.getInt("room_no");
                        int bedtype= resultSet.getInt("typeofbed");
                        double cost=resultSet.getDouble("cost");
                        String roomtype=resultSet.getString("typeofroom");
                        boolean ava = (resultSet.getInt("availability")==1)?true:false;
                        Room r=new Room();
                        r.setAvailability(ava);
                        r.setCost(cost);
                        r.setRoomNo(roomno);
                        r.setTypeOfBed(bedtype);
                        r.setTypeOfRoom(roomtype);
                        available.add(r);
                        
                        
                }
            }
            catch(SQLException e)
            {
                    System.out.println(e);
            }

       dbc.closeconnection();
       return available;
    }
    
    public double showRoomPrice(Date checkIn, Date checkOut, double roomRate){
        long diffTime = checkOut.getTime() - checkIn.getTime();
        int diffDays = (int) (diffTime / (1000 * 60 * 60 * 24));
        double total = diffDays * roomRate;
        return total;
    }
    
    public Bill generateBill(Date checkIn, Date checkOut, double roomRate){
        Bill bill = new Bill(showRoomPrice(checkIn, checkOut, roomRate) , 0.0);
        return bill;
    }
    
    public void BookRoom(int r,String firstname,String lastName,String phonenumber,String email, 
            String country,String city,String street,String zipCode , 
            CreditCard creditcard,Date checkIn, Date checkOut, 
            int occupantsNumber,Bill bill)
    {
        Address ad=new Address(country,city,street,zipCode);
        Guest g=new Guest(firstname,lastName,phonenumber,email,ad,creditcard,checkIn,checkOut,occupantsNumber,r,bill);
        query = "INSERT INTO guests ( firstname, lastname, phonenum, mail,country,city,street,zipcode,cardnumber ,cardholdername, cardexpiry, checkin, checkout,occupants_number, room_number, paidamount,totalamount  ) VALUES ( '"
                +g.getFirstName()+"', '"+g.getLastName()+"', '"+g.getPhoneNumber()+"', '"+g.getEmail()+"', '"+g.getAddress().getCountry()+"', '"+g.getAddress().getCity()+"', '"+g.getAddress().getStreet()+"', '"
                +g.getAddress().getZipCode()+"', '"+g.getCreditCard().getCardNumber()+"', '"+g.getCreditCard().getCardHolder()+"','"+new java.sql.Date(g.getCreditCard().getExpiryDate().getTime())+"', '"+new java.sql.Date(g.getCheckIn().getTime())+"', '"+new java.sql.Date(g.getCheckOut().getTime())+"', '"
                +g.getOccupantsNumber()+"', '"+g.getGuestRoom()+"', '"+g.getBill().getPaidamount()+"', '"+g.getBill().getTotalamount()+"')";
        dbc.storeData(query);
        dbc.closeconnection();
    
    }
    
    public Vector<User> searchUser(String fname, String lname){return null;}
    
    public void registerUser(String fname,String lname,String phone,String mail, String country,String city,String street,String zipCode , String usern,String passw,boolean isManager){}
    
    public void deleteUser(String username) {}
    public void modifyUser(String fname,String lname,String phone,String mail, String usern,String passw,String country,String city,String street,String zipcode,int ismanager)
        {}
   public Vector<Room> searchRoom(int roomNum){return null;}
   public void createRoom(int roomNum,int typeOfBed,int cost, String typeofRoom)
    {}
    
   public void modifyRoom(int roomNum,double cost, int typeOfBed,String typeOfRoom)
   {
   }
   public void deleteRoom(int roomNum){}
   
   public Vector<Guest> searchGuest(String fname,String lname,Date today,boolean checkedIn)
   {
       if (checkedIn){
                if (fname==null&&lname==null)
                    query="SELECT * FROM guests WHERE (DATE(checkin)<='"+new java.sql.Date(today.getTime())
                            +"' AND DATE(checkout)>='"+new java.sql.Date(today.getTime())+"' )";
            else
                    query="SELECT * FROM guests WHERE (DATE(checkin)<='"+new java.sql.Date(today.getTime())
                            +"' AND DATE(checkout)>='"+new java.sql.Date(today.getTime())+"' )AND (firstname='"+fname
                            +"' OR lastname='"+lname+"');";
       }
       else{    
                if (fname==null&&lname==null)
                query="SELECT * FROM guests WHERE (DATE(checkin)>'"+new java.sql.Date(today.getTime())
                        +"' )";
            else
                query="SELECT * FROM guests WHERE (DATE(checkin)>'"+new java.sql.Date(today.getTime())
                        +"' )AND (firstname='"+fname+"' OR lastname='"+lname+"');";
            } 
           Vector  <Guest> found=new Vector<Guest>();
       ResultSet rs = dbc.getData(query);
       Guest guest;
     try
            {
                while (rs.next()) 
                {Date d=rs.getDate("cardexpiry");
                    guest=new Guest(rs.getInt("id"),rs.getString("firstname"),rs.getString("lastname"),
                                       rs.getString("phonenum"),rs.getString("mail"),new Address(rs.getString("country"),
                                       rs.getString("city"),rs.getString("street"),rs.getString("zipcode")),new CreditCard(rs.getString("cardnumber"),
                                       rs.getString("cardholdername"),d.getMonth(),d.getYear()),
                                       rs.getDate("checkin"),rs.getDate("checkout"),rs.getInt("occupants_number"),
                                       rs.getInt("room_number"),new Bill(rs.getDouble("totalamount"),rs.getDouble("paidamount")));
                 found.add(guest);
                }
            }
            catch(SQLException e)
            {
                    System.out.println(e);
            }
       dbc.closeconnection();
       return found;
   }
   
   public void modifyGuest(int id,String firstname,String lastName,String phonenumber,String email, 
            String country,String city,String street,String zipCode , 
            String cardnumber,String cardholder, double total,double paid)
   {
      if (total!=0) query = "UPDATE guests SET firstname='"+firstname+"', lastname='"+lastName+"', phonenum='"+phonenumber
               +"',mail='"+email+"',country='"+country+"',city='"+city+"',street='"+street+"',zipcode='"+
               zipCode+"',cardnumber='"+cardnumber+"' ,cardholdername='"+cardholder+"',totalamount='"
               +total+"',paidamount='"+paid+"' WHERE id='"+id+"' ;";
      else query = "UPDATE guests SET firstname='"+firstname+"', lastname='"+lastName+"', phonenum='"+phonenumber
               +"',mail='"+email+"',country='"+country+"',city='"+city+"',street='"+street+"',zipcode='"+
               zipCode+"',cardnumber='"+cardnumber+"' ,cardholdername='"+cardholder+"', WHERE id='"+id+"' ;";
        dbc.storeData(query);
        dbc.closeconnection();}
   public void checkOut(int id){
   query="Delete from guests WHERE id='"+id+"';";
         dbc.deleteData(query);
         dbc.closeconnection(); 
   }
   
}


