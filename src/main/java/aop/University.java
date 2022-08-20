package aop;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents(){
        Student st1 = new Student("Бугров Александр", 4, 7.5);
        Student st2 = new Student("Михаил Иванов", 2, 8.3);
        Student st3 = new Student("Елена Сидорова", 1, 9.1);

        students.add(st1);
        students.add(st2);
        students.add(st3);

    }

    public List<Student> getStudents(){
        System.out.println("Информация о методе: getStudents()");
        System.out.println(students);
        return students;
    }
}
