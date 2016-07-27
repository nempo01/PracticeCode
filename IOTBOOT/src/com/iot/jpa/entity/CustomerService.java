package com.iot.jpa.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.jpa.rest.ClientRepository;

@Service
public class CustomerService {

	
	@Autowired
	private CustomerDAO custmerDAO;
	
	@Autowired
	private ClientRepository clientRepository;

	public static void main(String[] args) {

		CustomerDAO empDAO = new CustomerDAO();

		/*
		 * Customer createEmp1 = new Customer(1, "Sachin",10000,"R&D"); Customer
		 * createEmp2 = new Customer(2, "Rohit",20000,"R&D");
		 * empDAO.insertCustomer(createEmp1);//Create
		 * empDAO.insertCustomer(createEmp2);//Create
		 * 
		 * Customer readEmp = empDAO.getCustomer(1);//Read
		 * System.out.println(readEmp);
		 * 
		 * Customer updateEmp = new Customer(1,"Sachin Tendulkar",3000,"R&D");
		 * empDAO.updateCustomer(updateEmp);//Update
		 * 
		 * empDAO.deleteCustomer(1);
		 */

	}

	public Iterable<Customer> getAllCustomers() {
		List<Customer> empList = null;
		Iterable<Customer> iterList = null;
		try {

			iterList = clientRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iterList;
	}

	/**
	 * 
	 * @param empId
	 * @return
	 */
	public Customer getCustomer(int empId) {
		Customer customer = null;

		try {
			customer = clientRepository.findNameById((long) empId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	/**
	 * 
	 * @param emp
	 * @return
	 */
	public Customer addCustomer(Customer emp) {
		try {

			clientRepository.save(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 
	 * @param emp
	 * @return
	 */
	public Customer updateCustomer(Customer emp) {
		try {

			clientRepository.save(emp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * 
	 * @param empId
	 * @return
	 */
	public Customer deleteCustomer(int empId) {
		Customer empObj = null;
		try {

			clientRepository.delete((long) empId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empObj;
	}

}