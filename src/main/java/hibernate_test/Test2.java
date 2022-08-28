package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

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
            Employee emp = new Employee("Elena",
                    "Petrova", "Sales", 800);

            session.beginTransaction(); // начинаем транзакцию
            session.persist(emp); // сохраняем объект = SQL-команда insert
            session.getTransaction().commit(); // закрываем транзакцию

            int myId = emp.getId();
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            System.out.println(employee);

            System.out.println("Done!");
        } finally {
            factory.close(); // закрываем SessionFactory
        }
    }
}
