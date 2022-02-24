package minimumSpaningTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Student[] list = new Student[5];
        List<Student> list1 = new ArrayList<>();

        Student s1 = new Student(1, "s1");
        Student s2 = new Student(2, "s2");
        Student s3 = new Student(3, "s3");
        Student s4 = new Student(4, "s4");
        Student s5 = new Student(5, "s5");


        list[0] = s3;
        list[1] = s5;
        list[2] = s1;
        list[3] = s4;
        list[4] = s2;

        for (int i = 0; i < 5; i++) {
            list1.add(list[i]);
        }

        Arrays.sort(list);

        System.out.println(Arrays.toString(list));

        Collections.sort(list1);
        System.out.println(list1.toString());

    }

    private static class Student implements Comparable<Student> {
        int age;
        String name;


        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Student o) {
            return (this.age - o.age) * (-1);
        }
    }

}
