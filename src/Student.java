import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
        return "INSERT INTO Students(id, roster, first, last) VALUES ("+ id+ "," + roster.getId() +",'" + first + " " + last +"');";
    }


    public static ArrayList<Student> createStudents() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scan = new Scanner(new File(SqlGenerator.directory+"students"));
        int count = 1;
        while(scan.hasNextLine()){
            String[] name = scan.nextLine().split(" ");
            studentList.add(new Student(name[0],name[1],count));
            count++;
        }
        return studentList;
    }
}
