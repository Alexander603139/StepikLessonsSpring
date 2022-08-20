package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniLogAspect {

    @Before("execution(* getStudents())")
    public void beforeGetLogAdv() {
        System.out.println("beforeGetLogAdv: логгируем получение списка "
                + "студентов перед методом getStudent()");
    }

    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
    public void afterGetLogAdv(List<Student> students) {
        Student firstStudent = students.get(0);

        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr." + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterGetLogAdv: логгируем получение списка "
                + "студентов после работы метода getStudent()");
    }

    @After("execution(* getStudent())")
    public void afterGetStudentsLogAdv(){
        System.out.println("afterGetStudentsLogAdv: логгируем нормальное окончание или выброс исключения");
    }
}
