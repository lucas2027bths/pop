public class Room {
    private int ID;
    private String location;

    public Room(int ID, String name){
        this.ID = ID;
        this.location = name;
    }

    @Override
    public String toString(){
        return "INSERT INTO Departments VALUES ("+ID+",'" + location +"');";
    }

}
