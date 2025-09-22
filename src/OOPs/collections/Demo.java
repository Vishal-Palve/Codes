package OOPs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable {
    int age;
    String name;

    public Student(int rollno, String name) {
        this.age = rollno;
        this.name = name;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" + "rollno=" + age + ", name='" + name + '\'' + '}';
    }



    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age > o2.age) return 1;
                else return -1 ;
            }
        };

        Comparator<Student> com2 = ( o1, o2) ->  o1.age > o2.age?1:-1;


        List<Student> studss = new ArrayList<>();
        studss.add(new Student(112, "Vishal" ));
        studss.add(new Student(24, "Prathmesh" ));
        studss.add(new Student(65, "Arjun" ));
        studss.add(new Student(62, "Ram" ));

        Collections.sort(studss, com2);
        for(Student s : studss){
            System.out.println(s);
        }
    //  System.out.println(studss);
    }
    }

