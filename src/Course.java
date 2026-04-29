public class Course {
    private int ID;
    private String name;
    private int course_type_ID;

    public Course(int ID, String name , int course_type_ID){
        this.ID = ID;
        this.name = name;
        this.course_type_ID = course_type_ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "INSERT INTO Courses VALUES ("+ID+",'" + name +"'," + course_type_ID + ");";
    }
}
