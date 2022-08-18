package aop;

import org.springframework.stereotype.Component;

@Component("libraryBean")
public class Library {
    public void getBook() {
        System.out.println("Мы берем книгу из Library");
    }

    public void getMagazine() {
        System.out.println("Мы берем журнал из Library");
    }
}
