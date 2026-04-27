public class Teacher {
    private int ID;
    private String first;
    private String last;
    private int DEPTID;
    public Teacher(int ID, String first, String last, int DEPTID){
        this.ID = ID;
        this.first = first;
        this.last = last;
        this.DEPTID = DEPTID;
    }

    @Override
    public String toString(){
        return "INSERT INTO Teachers (ID,first_name,last_name,departmentID) VALUES(" + ID + ",'" + first + "','" + last + "'," + DEPTID + ")";
    }
}
