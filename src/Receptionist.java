import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
public class Receptionist extends User {
    DatabaseConnection dbc=new DatabaseConnection();
    String query;
    public Receptionist(String firstName, String lastName, String phoneNumber, 
                 String email, Address address , String userName, String password) {
        super(firstName, lastName,phoneNumber, email, address, userName, password);
    }
    public Receptionist(String username,String password){
        super(username,password);
    }
    
    public static boolean isManager() {
      ismanager=false;
        return ismanager;
    }
    public ArrayList<Room> CheckRoomAvailability (Date checkin,Date checkout)
    {
     ArrayList  <Room> available=new ArrayList<Room>();
      query="SELECT * FROM roomdetails "
                + "where room_no NOT IN (SELECT room_number FROM guests WHERE (DATE(checkin) >= '" 
                + checkin + "' AND DATE(checkin) <= '" + checkout + "') OR(DATE(checkout) > '" 
                + checkin + "') );";
     ResultSet resultSet = dbc.getData(query);
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

      
       return available;
    }
    
    public void BookRoom(Room r,String firstname,String lastName,String phonenumber,String email, 
            String country,String city,String street,String zipCode , String cardnumber,String cardholder,
            Date expiry,Date checkIn, Date checkOut, 
            int occupantsNumber,double totalamount,double paidamount)
    {
        Address ad=new Address(country,city,street,zipCode);
        CreditCard cc=new CreditCard(cardnumber,cardholder,expiry);
        Bill bill=new Bill(totalamount,paidamount);
        Guest g=new Guest(firstname,lastName,phonenumber,email,ad,cc,checkIn,checkOut,occupantsNumber,r,bill);
        query = "INSERT INTO guests ( firstname, lastname, phonenum, mail, address,cardnumber ,cardholdername, cardexpiry, checkin, checkout,occupants_number, room_number, paidamount,totalamount  ) VALUES ( '"
                +g.getFirstName()+"', '"+g.getLastName()+"', '"+g.getPhoneNumber()+"', '"+g.getEmail()+"', '"+g.getAddress().getCountry()+"', '"+g.getAddress().getCity()+"', '"+g.getAddress().getStreet()+"', '"
                +g.getAddress().getZipCode()+"', '"+g.getCreditCard().getCardNumber()+"', '"+g.getCreditCard().getCardHolder()+"', '"+g.getCreditCard().getExpiryDate()+"', '"+g.getCheckIn()+"', '"+g.getCheckOut()+"', '"
                +g.getOccupantsNumber()+"', '"+g.getGuestRoom().getRoomNo()+"', '"+g.getBill().getPaidamount()+"', '"+g.getBill().getTotalamount()+"')";
        dbc.storeData(query);
    }
    
}
