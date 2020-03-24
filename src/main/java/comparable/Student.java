package comparable;

import java.util.Arrays;

public class Student implements Comparable<Student> {

    int studentId;
    int studentGeneration;

    public Student(int studentId, int studentGeneration) {
        this.studentId = studentId;
        this.studentGeneration = studentGeneration;
    }

    @Override
    public String toString() {
        return studentId + "/" + studentGeneration%100;
    }


    @Override
    public int compareTo( Student student) {
        int result = this.studentGeneration - student.studentGeneration;
        if (result != 0)
            return result;
        else
            return this.studentId-student.studentId;
    }

    public static void main(String[] args) {
        Student[] a = new Student[5];
        a[0] = new Student(75,2016);
        a[1] = new Student(52,2019);
        a[2] = new Student(57,2016);
        a[3] = new Student(220,2014);
        a[4] = new Student(25,2018);
        a[4] = new Student(85,2019);



        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, new SortById());
        System.out.println(Arrays.toString(a));


    }
}
