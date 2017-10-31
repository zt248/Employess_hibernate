package dao.impl;

import dao.DaoException;
import dao.DepartmentDao;
import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.SessionUtil;

import java.util.List;

public class DepartmentDaoImpl extends SessionUtil implements DepartmentDao {

    @Override
    public void add(Department department) throws DaoException {
        openTransactionSession();

        Session session = getSession();
        session.save(department);

        closeTransactionSesstion();
    }

    @Override
    public List<Department> getAll() throws DaoException {

        openTransactionSession();

        String sql = "SELECT * FROM DEPARTMENT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Department.class);
        List<Department> departmentList = query.list();

        closeTransactionSesstion();

        return departmentList;
    }

    @Override
    public Department getById(Long id) throws DaoException {

        openTransactionSession();

        String sql = "SELECT * FROM DEPARTMENT WHERE id = :ID";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Department.class);
        query.setParameter("ID",id);

        Department department = (Department) query.getSingleResult();

        closeTransactionSesstion();

        return department;
    }

    @Override
    public void update(Department department) throws DaoException {
        openTransactionSession();

        Session session = getSession();
        session.update(department);

        closeTransactionSesstion();

    }

    @Override
    public void remove(Department department) throws DaoException {
        openTransactionSession();

        Session session = getSession();
        session.delete(department);

        closeTransactionSesstion();
    }
}
