import java.util.ArrayList;

public class Assignment {
    private int type;
    private String name;
    private int id;
    private int classId;
    public Assignment (int type, int id, String name, int classId){
        this.type = type;
        this.name = name;
        this.id = id;
        this.classId = classId;
    }
    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Assignment> createAssignmentList(ArrayList<SchoolClass> classList){
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        for (SchoolClass cur : classList) {

            assignmentList.addAll(cur.getAssignments());

        }

        return assignmentList;

    }


    public String toString(){
       return "INSERT INTO Assignment(assignmentID, assignmentName, assignment_typeID, classID) VALUES" +
                " (" + id + ",'" + name +"'," + type + "," + classId + ");";
    }

    public static String insertTypes (){
        return "INSERT INTO AssignmentTypes Values(1,'Major');INSERT INTO AssignmentTypes Values(2,'Minor');";
    }


}
