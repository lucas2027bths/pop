import java.util.ArrayList;

public class Roster {
    private static int ID;
    private ArrayList<SchoolClass> Classes;
    private Student student;

    public Roster(Student student) {
        Classes = new ArrayList<>();
        ArrayList<Integer> ClassesAdded = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ArrayList<SchoolClass> ClassList = new ArrayList<>();
            for (SchoolClass schoolClass : SqlGenerator.ClassList) {
                if (schoolClass.getPeriod() == i) {
                    ClassList.add(schoolClass);
                }
            }
            int rand = (int) ( Math.random() * ClassList.size() );
            if (!ClassesAdded.contains(rand)) {
                ClassesAdded.add(rand);
                Classes.add(ClassList.get(rand));
                ClassList.get(rand).addStudents(student);
            }
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

    @Override
    public String toString() {
        return student + " " + Classes;
    }
}

