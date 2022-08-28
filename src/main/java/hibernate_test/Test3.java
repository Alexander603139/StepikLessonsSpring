package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {

    public static void main(String[] args) {
        // создаем SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            // создаем сессию
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // все работает !!!
//            List<Employee> emps = session.createQuery("from Employee").getResultList(); // указано имя класса!

            // name - это не название столбца, это название поля в Employee
//            List<Employee> emps = session.createQuery("from Employee where name = 'Alexandr'").getResultList();
            List<Employee> emps = session.createQuery("from Employee where salary>600").getResultList();


            for (Employee e : emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
