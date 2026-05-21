import java.util.ArrayList;

public class Roster {
    private int ID;
    private ArrayList<SchoolClass> Classes;
    private Student student;


    public Roster(Student student, ArrayList<SchoolClass> FullClassList,int ID) {
        this.ID = ID;
        Classes = new ArrayList<>();
        this.student = student;
        for (int i = 1; i <= 10; i++) { // go through periods 1 to 10
            ArrayList<SchoolClass> ClassList = new ArrayList<>();
            for (SchoolClass schoolClass : FullClassList) {
                if (schoolClass.getPeriod() == i) {
                    ClassList.add(schoolClass); // goes through the full list of classes from SQLGenerator and ONLY grabs the classes with same period as the current iteration
                }
            }
            int rand = (int) ( Math.random() * (ClassList.size() - 1) );
            Classes.add(ClassList.get(rand)); // gets a random class and adds it to the student's roster list of classes
            ClassList.get(rand).addStudents(student);
            student.setRoster(this);
        }

        /*
        for (int i = 1; i < Classes.size(); i++) {
            SchoolClass currentClass = Classes.get(i);
            if (currentClass.get)
            int j = i;

            while ( j > 0 && temp.getPeriod() < ClassArrayList.get(j - 1).getPeriod() ) {
                ClassArrayList.set(j, ClassArrayList.get(j - 1));
                j--;
            }
            ClassArrayList.set(j, temp);
        }

         */

        ID++;

    }
    public ArrayList<SchoolClass> getClasses(){
        return Classes;
    }
    public int getID() {
        return ID;
    }
    @Override
    public String toString() {
        return "INSERT INTO Rosters(period1_ClassID ,period2_ClassID ,\n" +
                "        period3_ClassID ,\n" +
                "        period4_ClassID ,\n" +
                "        period5_ClassID ,\n" +
                "        period6_ClassID ,\n" +
                "        period7_ClassID ,\n" +
                "        period8_ClassID ,\n" +
                "        period9_ClassID ,\n" +
                "        period10_ClassID) \n" +
                " VALUES (" +Classes.get(0).getID() + "," +Classes.get(1).getID() + ","+Classes.get(2).getID() + ","+Classes.get(3).getID() + ","+Classes.get(4).getID() + ","+Classes.get(5).getID() + ","+Classes.get(6).getID() + ","+Classes.get(7).getID() + ","+Classes.get(8).getID() + ","+Classes.get(9).getID() +  ");";
    }
}

