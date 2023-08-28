package com.wipro.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.bank.Model.Account;
import com.wipro.bank.Model.Customer;
import com.wipro.bank.repository.AccountRepository;
import com.wipro.bank.repository.CustomerRepository;
import com.wipro.bank.service.CustomerService;
import com.wipro.bank.controller.CustomerController;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
	@MockBean
	CustomerRepository rep;
	@MockBean
	CustomerService cs;
	@Autowired
	MockMvc mvc;
	@MockBean
	AccountRepository ar;
	@Autowired
	ObjectMapper obj;
	private List<Account> lis;
	private Customer cus;
	@BeforeEach
	void init() {
		lis=new ArrayList<Account>();
		 lis.add(new Account(1L,"savings",122333.0,new Date()));
		 lis.add(new Account(2L,"Current",122333.0,new Date()));
		   cus=new Customer(1L,"Manohar","male",new Date(),"cjdvcdbvbe","jbvdhvvc",
				   "8964734685","k.mnaohar@gamil.com",lis);
	}
	@Test
	  void shouldCreateCustomer() throws Exception {
	    mvc.perform(MockMvcRequestBuilders.post("/customer/addCustomer")
	        .content(obj.writeValueAsString(cus)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isCreated())
	        .andDo(print());
	    when(cs.save(cus)).thenReturn(cus);
	    assertEquals(cus, cs.save(cus));
	  }
	@Test
	void shouldgetAllCustomers() throws Exception {
		List<Customer> customers=new ArrayList<>();
		customers.add(cus);
		 when(rep.findAll()).thenReturn(customers);
		    mvc.perform(MockMvcRequestBuilders.get("/customer/getCustomers").accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(customers.size()))
		        .andDo(print());
	}
	 @Test
	 void EmptylistofCustomers() throws Exception {
		 List<Customer> list=Collections.emptyList();
		 when(rep.findAll()).thenReturn(list);
		 mvc.perform(get("/customer/getCustomers")).andExpect(status().isAccepted()).andDo(print());
	 }
	 @Test
	  void shouldUpdateCustomer() throws Exception {
	    Long id = 1L;
	    Customer cusup = new Customer(1L,"Manohar-updated","male",new Date(),"cjdvcdbvbe","jbvdhvvc",
				   "8964734685","k.mnaohar@gamil.com",lis);
	    when(rep.findById(id)).thenReturn(Optional.of(cusup));
	    when(rep.save(any(Customer.class))).thenReturn(cusup);
	    mvc.perform(put("/customer/updateCustomer/{id}",id)
	    		.contentType(MediaType.APPLICATION_JSON).
	    		content(obj.writeValueAsString(cusup))).
	    andExpect(status().isOk()).andExpect(jsonPath("$.customerName").value(cusup.getCustomerName())).
	    andExpect(jsonPath("$.customerEmail").value(cusup.getCustomerEmail()))
	    .andExpect(jsonPath("$.customerGender").value(cusup.getCustomerGender()))
	    .andExpect(jsonPath("$.customerAadhar").value(cusup.getCustomerAadhar())).
	    andExpect(jsonPath("$.customerPan").value(cusup.getCustomerPan())).
	    andExpect(jsonPath("$.customerId").value(cusup.getCustomerId())).
	    andExpect(jsonPath("$.customerContact").value(cusup.getCustomerContact()))
	    ;
	  }
	 @Test
	  void shouldUpdateCustomernotfound() throws Exception {
	    Long id = 1L;
	    Customer cusup = new Customer(1L,"Manohar-updated","male",new Date(),"cjdvcdbvbe","jbvdhvvc",
				   "8964734685","k.mnaohar@gamil.com",lis);
	    when(rep.findById(id)).thenReturn(Optional.empty());
	    when(rep.save(any(Customer.class))).thenReturn(cusup);
	    mvc.perform(put("/customer/updateCustome/{id}",id)
	    		.contentType(MediaType.APPLICATION_JSON).
	    		content(obj.writeValueAsString(cusup))).andExpect(status().isNotFound());
	 }
	    @Test
	 void shouldnotfoundCustomer() throws Exception {
		 Long id=1L;
		 when(rep.findById(id)).thenReturn(Optional.empty());
		 mvc.perform(MockMvcRequestBuilders.get("/customer/getById/{userId}",id)).andExpect(status().isNotFound());
	 }
	 @Test
	 void shouldfoundCustomer() throws Exception {
		 Long id=1L;
		 when(rep.findById(id)).thenReturn(Optional.of(cus));
		 mvc.perform(MockMvcRequestBuilders.get("/customer/getById/{id}",id)).andExpect(status().isOk());
	 }
	 @Test
	  void shouldDeleteCustomerById() throws Exception {
		 when(rep.findById(anyLong())).thenReturn(Optional.of(cus));
		    doNothing().when(rep).deleteById(anyLong());
		    mvc.perform(delete("/customer/deleteById/{id}", 1L))
		         .andExpect(status().isAccepted())
		         .andDo(print());
	  }
	 @Test
	  void shouldNotDeleteCustomerById() throws Exception {
		 when(rep.findById(anyLong())).thenReturn(Optional.empty());
		    doNothing().when(rep).deleteById(anyLong());
		    mvc.perform(delete("/customer/deleteById/{id}", 1L))
		         .andExpect(status().isNotFound())
		         .andDo(print());
	  }
	 @Test
	 void shouldDeleteAll() throws Exception {
		    doNothing().when(rep).deleteAll();
		    mvc.perform(delete("/customer/deleteAll"))
		         .andExpect(status().isAccepted())
		         .andDo(print());
		  }
}
