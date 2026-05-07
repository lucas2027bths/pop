public class Student {
    private String first;
    private String last;
    private Roster roster;
    private int id;

    public Student (){

    }


    public Student (String first, String last,int id){
        this.first = first;
        this.last = last;
        this.id=id;
    }
    public Roster getRoster() {
        return roster;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {return last;}
    public int getId() {
        return id;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public String toString(){
        return "INSERT INTO Student(id, roster, first, last) VALUES ("+ id+ "," + roster.getID() +",'" + first + " " + last +"');";
    }
}
