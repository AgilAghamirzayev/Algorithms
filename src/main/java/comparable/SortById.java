package comparable;

import java.util.Comparator;

public class SortById implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.studentId - b.studentId;
    }

}
