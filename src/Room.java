public class Room {
    private int ID;
    private String location;
    private boolean[] booked;

    public Room(int ID, String name){
        this.ID = ID;
        this.location = name;
        booked = new boolean[10];
    }


    public boolean[] getBooked() {
        return booked;
    }

    public void setBooked(boolean[] booked) {
        this.booked = booked;
    }

    @Override
    public String toString(){
        return "INSERT INTO Departments VALUES ("+ID+",'" + location +"');";
    }

}
