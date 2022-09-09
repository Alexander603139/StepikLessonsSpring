package hibernate_test_2;

import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {

    public static void main(String[] args) {
        // создаем SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {

//            Session session = factory.getCurrentSession(); // создаем сессию
//            Employee employee = new Employee("Alex", "Bugroff", "IT", 500);
//            Detail detail = new Detail("Vologda", "12345", "info@mail.ru");
//            employee.setEmpDetail(detail);
//            session.beginTransaction(); // начинаем транзакцию
//            session.save(employee);
//            session.getTransaction().commit(); // закрываем транзакцию

//            Session session = factory.getCurrentSession(); // создаем сессию
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Baku", "54321", "susu@mail.ru");
//            employee.setEmpDetail(detail);
//            session.beginTransaction(); // начинаем транзакцию
//            session.save(employee);
//            session.getTransaction().commit(); // закрываем транзакцию

            session = factory.getCurrentSession(); // создаем сессию

            session.beginTransaction(); // начинаем транзакцию
            Employee emp = session.get(Employee.class, 2);
//            System.out.println(emp.getEmpDetail());
            session.delete(emp);

            session.getTransaction().commit(); // закрываем транзакцию

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close(); // закрываем SessionFactory
        }


    }
}
