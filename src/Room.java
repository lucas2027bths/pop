public class Room {
    public int ID;
    private String location;
    public boolean[] booked;

    public Room(int ID, String name){
        this.ID = ID;
        this.location = name;
        booked = new boolean[10];
    }


    @Override
    public String toString(){
        return "INSERT INTO Rooms VALUES ("+ID+",'" + location +"');";
    }

}
