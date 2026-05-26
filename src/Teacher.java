public class Teacher {
    private int ID;
    private String first;
    private String last;
    private int DEPTID;
    public boolean[] booked; // boolean used to check if a teacher is book for a certain period
    public Teacher(int ID, String first, String last, int DEPTID){
        this.ID = ID;
        if (first.contains("'")) {
            first = first.substring(0, first.indexOf("'")) + "'" + first.substring(first.indexOf("'"));
        }
        this.first = first;
        if (last.contains("'")) {
            last = last.substring(0, last.indexOf("'")) + "'" + last.substring(last.indexOf("'"));
        }
        this.last = last;
        this.DEPTID = DEPTID;
        booked = new boolean[10];
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString(){
        return "INSERT INTO Teachers (ID,first_name,last_name,departmentID) VALUES(" + ID + ",'" + first + "','" + last + "'," + DEPTID + ")";
    }
}
