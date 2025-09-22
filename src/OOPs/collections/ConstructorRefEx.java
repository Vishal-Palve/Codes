package OOPs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Students{
    private String name ;
    private int age;

    public Students() {

    }
    @Override
    public String toString() {
        return "Students{name='" + name + "', age=" + age + "}";
    }


    public Students(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class ConstructorRefEx {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Vishal", "Rudrani", "Ayush", "Prasad");

        List<Students> studs = new ArrayList<>();
//        for(String name : names ){
//            studs.add(new Students(name));
//        }

//        studs = names.stream()
//                        .map(name -> new Students(name))
//                                .toList();
        studs = names.stream()
                .map(Students::new )
                .toList();


        System.out.println(studs );

    }
}
