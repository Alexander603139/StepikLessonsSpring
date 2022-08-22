package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        // создаем SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // создаем сессию
            Session session = factory.getCurrentSession();
            // создаем объект
            Employee emp = new Employee("Jackob", "Smirnov", "Sales", 700);

            session.beginTransaction(); // начинаем транзакцию
            session.persist(emp); // сохраняем объект = SQL-команда insert
            session.getTransaction().commit(); // закрываем транзакцию

            System.out.println("Done!");
        } finally {
            factory.close(); // закрываем SessionFactory
        }
    }
}
