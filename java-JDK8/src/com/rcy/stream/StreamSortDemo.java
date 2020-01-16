package com.rcy.stream;

import com.rcy.bean.Student;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: rencaiyu 2020年01月10日 16:48
 **/
public class StreamSortDemo {
    public static final List<Student> STUDENT_LIST = Collections.unmodifiableList(
            new ArrayList<Student>() {
                {
                    add(new Student("张三", 10, "男"));
                    add(new Student("李四", 15, "男"));
                    add(new Student("王五", 9, "男"));
                    add(new Student("赵六", 20, "男"));
                }
            }
    );


    /**
     * 降序
     */
    public static void desc() {
        List<Student> students = STUDENT_LIST.stream()
                .filter(student -> student.getAge() > 1)
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());

        for (Student student : students) {
            System.out.println(student);
        }


    }

    /**
     * 升序
     */
    public static void asc() {
        List<Student> students = STUDENT_LIST.stream()
                .filter(student -> student.getAge() > 1)
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());

        for (Student student : students) {
            System.out.println(student);
        }


    }

    public static void main(String[] args) {
        desc();
    }
}
