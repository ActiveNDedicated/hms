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
    
    public boolean isManager() {
      ismanager=false;
        return ismanager;
    }
    
    
}
