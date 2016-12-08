/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAF
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Room {

    private int RoomNo ;
    private boolean Availability;
    private int TypeOfBed;
    private double cost;
    private String TypeOfRoom;
    
    Room(){
    }
    
    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int RoomNo) {
        this.RoomNo = RoomNo;
    }

    
    public boolean isAvailable() {
        return Availability;
    }

    
    public void setAvailability(boolean Availability) {
        this.Availability = Availability;
    }

    /**
     * @return the type
     */
    public int getTypeOfBed() {
        return TypeOfBed;
    }

    /**
     * @param type the type to set
     */
    public void setTypeOfBed(int type) {
       if(type<=3&&type>0)
           this.TypeOfBed = type;
       else
           this.TypeOfBed=1;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        if (cost>=0)
        this.cost = cost;
        else 
            this.cost=0;
    }

    public String getTypeOfRoom() {
        return TypeOfRoom;
    }

    public void setTypeOfRoom(String TypeOfRoom) {
        this.TypeOfRoom = TypeOfRoom;
    }
   
}

