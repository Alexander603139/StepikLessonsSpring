package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethods()") // перед выполнением метода
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); // получение сигнатуры метода
        System.out.println("methodSignature = " + methodSignature); // вывод сигнатура метода
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod()); // вывод полного имени и пути метода
        System.out.println("methodSignature.getReturnType() = "
                + methodSignature.getReturnType()); // вывод что возвращает метод
        System.out.println("methodSignature.getName() = "
                + methodSignature.getName()); // получение имени метода

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for(Object obj:arguments){
                if(obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - "
                            + myBook.getName() + ", автор - "
                            + myBook.getAuthor() + ", год издания - "
                            + myBook.getYearOfPublicaton());
                }
                else {
                    System.out.println("книгу в библиотеку добавляет " + obj);
                }
            }
        }
        System.out.println("beforeGetLoggingAdvice: логгирование" + " попытки получить книгу/журнал");
        System.out.println("---------------------------------");
    }
}
