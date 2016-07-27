package com.iot.jpa.rest;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.iot.jpa.entity.Customer;
import com.iot.jpa.entity.CustomerService;
import com.iot.jpa.entity.Purchase;

@RestController
@RequestMapping("/contacts")
public class CustomerRestController  {
	CustomerService custServices = new CustomerService();

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public String getAll() {
		Iterable<Customer> listOfEmployees = custServices.getAllCustomers();
		Gson gson = new Gson();
		String jsonString = gson.toJson(listOfEmployees);
		return jsonString;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public Customer create(@RequestBody String contact) {

		JSONParser parser = new JSONParser();

		Customer cust = new Customer();
		Object obj;
		try {
			obj = parser.parse(contact);
			JSONObject ob = (JSONObject) obj;
			cust.setId(Long.parseLong(ob.get("id").toString()));
			cust.setNome(ob.get("custname").toString());
			cust.setCardId(ob.get("cardid").toString());
			cust.setAddress(ob.get("address").toString());

			JSONArray array = (JSONArray) ob.get("purchages");
			int i = 0;
			if (array.size() > 0) {
				List<Purchase> per = new ArrayList<Purchase>();
				while (i < array.size()) {
					JSONObject arrObj = (JSONObject) array.get(i);
					Purchase pur = new Purchase();
					pur.setId(Long.parseLong(arrObj.get("pid").toString()));
					pur.setNumberOfProducts(Integer.parseInt(arrObj.get("noofproducts").toString()));
					pur.setTotalValue(Float.parseFloat(arrObj.get("totalval").toString()));
					per.add(pur);
					i++;
				}
				cust.setPurchases(per);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custServices.addCustomer(cust);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
		custServices.deleteCustomer(Integer.parseInt(id));
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Customer update(@PathVariable String id, @RequestBody String contact) {

		JSONParser parser = new JSONParser();
		Customer cust = new Customer();
		Object obj;
		try {
			obj = parser.parse(contact);
			JSONObject ob = (JSONObject) obj;
			cust.setId(Long.parseLong(ob.get("id").toString()));
			cust.setNome(ob.get("custname").toString());
			cust.setCardId(ob.get("cardid").toString());
			cust.setAddress(ob.get("address").toString());

			JSONArray array = (JSONArray) ob.get("purchages");
			int i = 0;
			if (array.size() > 0) {
				List<Purchase> per = new ArrayList<Purchase>();
				while (i < array.size()) {
					JSONObject arrObj = (JSONObject) array.get(i);
					Purchase pur = new Purchase();
					pur.setId(Long.parseLong(arrObj.get("pid").toString()));
					pur.setNumberOfProducts(Integer.parseInt(arrObj.get("noofproducts").toString()));
					pur.setTotalValue(Float.parseFloat(arrObj.get("totalval").toString()));
					per.add(pur);
					i++;
				}
				cust.setPurchases(per);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custServices.updateCustomer(cust);

	}
}
