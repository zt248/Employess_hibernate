package dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import util.SessionUtil;
import dao.AddressDao;
import dao.DaoException;
import entity.Address;

import java.util.List;

public class AddressDaoImpl extends SessionUtil implements AddressDao{




    @Override
    public void add(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        //close session with a transaction
        closeTransactionSesstion();
    }

    @Override
    public List<Address> getAll() throws DaoException {

        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        closeTransactionSesstion();

        return addressList;
    }

    @Override
    public Address getById(Long id) throws DaoException {

        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();

        closeTransactionSesstion();

        return address;
    }

    @Override
    public void update(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        //close session with a transaction
        closeTransactionSesstion();

    }

    @Override
    public void remove(Address address) throws DaoException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        //close session with a transaction
        closeTransactionSesstion();

    }
}
