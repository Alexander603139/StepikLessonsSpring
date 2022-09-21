package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {

    public static void main(String[] args) {
        // создаем SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession(); // создаем сессию
            Employee employee = new Employee("Misha", "Sidorov", "HR", 850);
            Detail detail = new Detail("London", "80090012345", "mishanya@mail.ru");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);
            session.beginTransaction(); // начинаем транзакцию
            session.save(detail);
            session.getTransaction().commit(); // закрываем транзакцию
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close(); // закрываем SessionFactory
        }
    }
}