package com.iot.jpa.entity;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDAO {

	
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional

	public Iterable<Customer> getCustomers() {

		return sessionFactory.openSession()
				.createCriteria(Customer.class)
				//.setFirstResult(offset!=null?offset:0)
				//.setMaxResults(maxResults!=null?maxResults:10)
				.list();
		//return iterList;
	}
	
	public Long count(){
		return (Long)sessionFactory.openSession()
				.createCriteria(Customer.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}
	
	
	public void save(){
		for(int itr=1;itr <= 100 ; itr++){
			Customer person = new Customer();
			sessionFactory.openSession()
			.save(person);
		}
	}

	/**
	 * 
	 * @param empId
	 * @return
	 *//*
	public Customer getCustomer(Integer empId) {
		Customer customer = null;

		try {
			
			return sessionFactory.openSession()
					.createCriteria(Customer.class)
			customer = clientRepository.findNameById((long) empId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	*//**
	 * 
	 * @param customer
	 *//*
	public void insertCustomer(Customer customer) {

		try {

			clientRepository.save(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*//**
	 * 
	 * @param customer
	 *//*
	public void updateCustomer(Customer customer) {

		try {

			clientRepository.save(customer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	*//**
	 * 
	 * @param empId
	 *//*
	public void deleteCustomer(Integer empId) {

		try {

			clientRepository.delete((long) empId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
