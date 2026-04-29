public class Student {
    private String first;
    private String last;
    private int roster;
    private int id;

    public Student (){

    }


    public Student (String first, String last, int roster, int id){
        this.first = first;
        this.last = last;
        this.id=id;
        this.roster=roster;
    }
    public int getRoster() {
        return roster;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {return last;}
    public int getId() {
        return id;
    }
}
