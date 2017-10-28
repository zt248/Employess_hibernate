import Util.HibernateUtil;
import entity.Address;
import entity.Department;
import entity.Employee;
import org.hibernate.Session;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {


    public static void main(String[] args)  {



        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCountry("Belarus");
        address.setCity("Minsk");
        address.setStreet("Fogela 1E");
        address.setPostCode("123456");

        Department department = new Department();
        department.setTitle("ТЦ Корона");

        Employee employee = new Employee();
        employee.setFirstName("Евгений");
        employee.setLastName("Царик");


        Calendar calendar = Calendar.getInstance();
        calendar.set(1939,Calendar.MAY,1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);

        department.setEmployees(employees);

        Set<Department> departments = new HashSet<Department>();
        departments.add(department);
        employee.setDepartments(departments);

        session.save(address);
        session.save(department);
        session.save(employee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();

    }
}
