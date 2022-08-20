package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdv(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdv: в библиотеку пытаются вернуть книгу");

        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        result = "\"здесь мы изменили название книги\"";
        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdv: в библиотеку успешно вернули книгу");
        System.out.println("метод returnBook() выполнялся: " + (end-begin) + " мс");
        return result;
    }
}
