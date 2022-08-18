package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    public String getName() {
        return name;
    }

    @Value("Преступление и наказание")
    private String name;
}
