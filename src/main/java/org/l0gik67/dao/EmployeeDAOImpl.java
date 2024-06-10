package org.l0gik67.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.l0gik67.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAllEmployees(){
        Session session = sessionFactory.getCurrentSession();
        List<Employee> result = session.createQuery("from Employee", Employee.class).getResultList();
        return result;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id){
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id){
        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("delete from Employee where id =: empId");
        query.setParameter("empId", id);
        query.executeUpdate();
    }
}
