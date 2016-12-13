/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAF
 */
import java.util.Date;

public class Guest extends Human {
    
    private CreditCard creditCard;
    private int guestID;
    private Date checkIn;
    private Date checkOut;
    private int occupantsNumber;
    private int guestRoom;
    private Bill bill;

    public Guest (int guestID, String firstName, String lastName,  String phoneNumber, String email, 
            Address address,  CreditCard creditCard, Date checkIn, Date checkOut, 
            int occupantsNumber, int guestRoom,Bill bill) {
        
        super(firstName, lastName, phoneNumber, email, address);
        setGuestID(guestID);
        setCreditCard(creditCard);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        setOccupantsNumber(occupantsNumber);
        setGuestRoom(guestRoom);
        setBill(bill);
    }
    
    public Guest ( String firstName, String lastName,  String phoneNumber, String email, 
            Address address, CreditCard creditCard, Date checkIn, Date checkOut, 
            int occupantsNumber, int guestRoom,Bill bill) {
        
        super(firstName, lastName,  phoneNumber, email, address);
        setCreditCard(creditCard);
        setCheckIn(checkIn);
        setCheckOut(checkOut);
        setOccupantsNumber(occupantsNumber);
        setGuestRoom(guestRoom);
        setBill(bill);
    }
    
   public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * @param creditCard the creditCard to set
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * @return the guestID
     */
    public int getGuestID() {
        return guestID;
    }

    /**
     * @param guestID the guestID to set
     */
    public void setGuestID(int guestID) {
        this.guestID = guestID;
    }

    /**
     * @return the checkIn
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the occupantsNumber
     */
    public int getOccupantsNumber() {
        return occupantsNumber;
    }

    /**
     * @param occupantsNumber the occupantsNumber to set
     */
    public void setOccupantsNumber(int occupantsNumber) {
        this.occupantsNumber = occupantsNumber;
    }

    /**
     * @return the guestRoom
     */
    public int getGuestRoom() {
        return guestRoom;
    }

    public void setGuestRoom(int guestRoom) {
        this.guestRoom = guestRoom;
    }

    public Bill getBill() {
        return bill;
    }
   
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
}
