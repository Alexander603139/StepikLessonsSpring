package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.security.spec.ECParameterSpec;

public class Test1 {

    public static void main(String[] args) {
        // создаем SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = factory.getCurrentSession(); // создаем сессию
//            Department dep = new Department("Sales", 800, 1500);
//            Employee emp1 = new Employee("Alex", "Ivanov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//            dep.addEmployeeToDepartment(emp3);
//            session.beginTransaction(); // начинаем транзакцию
//            session.save(dep);
//            session.getTransaction().commit(); // закрываем транзакцию
//**************************************************************************
            session = factory.getCurrentSession(); // создаем сессию
            session.beginTransaction(); // начинаем транзакцию

            System.out.println("получить департамент");
            Department department = session.get(Department.class, 2);

            System.out.println("вывести департамент");
            System.out.println(department);

            System.out.println("вывести всех работников департамента");
            System.out.println(department.getEmps());

            session.getTransaction().commit(); // закрываем транзакцию
//**************************************************************************
//            session = factory.getCurrentSession(); // создаем сессию
//            session.beginTransaction(); // начинаем транзакцию
//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);
//            session.getTransaction().commit(); // закрываем транзакцию

            System.out.println("Done!");
        } finally {
            session.close();
            factory.close(); // закрываем SessionFactory
        }


    }
}
