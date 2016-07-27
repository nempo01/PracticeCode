package com.iot.jpa.rest;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.iot.jpa.entity.Customer;
import com.iot.jpa.entity.Purchase;





@Repository
@ComponentScan
@RepositoryRestResource(collectionResourceRel = "client", path = "clients")
public interface ClientRepository extends CrudRepository<Customer, Long> {
	/**
	 * * Method that returns a lista of clients doing a search by the passed
	 * name parameter. * * @param name * @return list of clients
	 */
	List<Purchase> findByName(@Param("name") String name);

	/**
	 * * Method that returns a client with only its name doing a search by the
	 * passed id parameter. * * @param id * @return client of the id passed as
	 * parameter.
	 */
	@Query("SELECT c.name FROM Customer c where c.id = :id")
	Customer findNameById(@Param("id") Long id);

	/**
	 * * Method that returns a list of clients doing a search by the passed name
	 * parameter and sorting them by the name. * * @param name * @return list of
	 * clients
	 */
	//List<Client> findByNameOrderByName(@Param("name") String name);
}
