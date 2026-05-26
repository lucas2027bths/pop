import java.util.ArrayList;

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

    public static ArrayList<Room> createRooms(){
        ArrayList<Room> roomList = new ArrayList<>();
        int id = 1;
        for (int floor = 0; floor <= 8;floor++){

            for (int wing = 0; wing < 4; wing++){
                String realWing;


                if (wing == 0){
                    realWing = "N";
                }
                else if (wing == 1){
                    realWing = "E";
                }
                else if (wing == 2){
                    realWing = "S";
                }
                else {
                    realWing = "W";
                }


                for (int room = 1; room <= 20; room++){
                    String location;
                    if (floor == 0){
                        location = ("B" + realWing + room);
                    }else{
                        location = (floor + realWing + room );
                    }
                    roomList.add(new Room(id,location));
                    id++;

                }

            }

        }
        return roomList;
    }

}
