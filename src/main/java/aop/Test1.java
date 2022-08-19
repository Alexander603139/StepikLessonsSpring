package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(MyConfig.class);
        UniLibrary uniLibrary = context.getBean("libraryBean", UniLibrary.class);
        Book book = context.getBean("book", Book.class);

        uniLibrary.getBook();
        uniLibrary.addBook("Александр", book);
        uniLibrary.addMagazine();

        context.close();
    }

}
