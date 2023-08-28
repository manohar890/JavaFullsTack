package com.wipro.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.wipro.bank.Model.Account;
import com.wipro.bank.repository.AccountRepository;
import com.wipro.bank.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@MockBean 
	AccountRepository ar;
	
	@Autowired
	CustomerService cs;
	
	 @Test
	 void fundTransferSuccesss() {
		 Long sorc =1L;
		 Long dest=2L;
		 double amt=1000.0;
		 Account ac1=new Account(1L,"savings",122333.0,new Date());
		 Account ac2=new Account(2L,"Current",122333.0,new Date());
		 when(ar.findById(sorc)).thenReturn(Optional.of(ac1));
		 when(ar.findById(dest)).thenReturn(Optional.of(ac2));
		 assertEquals(HttpStatus.ACCEPTED, cs.fundTransfer(sorc, dest, amt).getStatusCode()); 
		 assertEquals(122333.0-amt, ac1.getAccountBalance());
		 assertEquals(122333.0+amt, ac2.getAccountBalance());
	 }
	 @Test
	 void fundTransferFailureByamountLessthanOne() {
		 Long sorc =1L;
		 Long dest=2L;
		 double amt=1;
		 
		 when(ar.findById(sorc)).thenReturn(Optional.of(new Account(1L,"savings",122333.0,new Date())));
		 when(ar.findById(dest)).thenReturn(Optional.of(new Account(2L,"Current",122333.0,new Date())));
		 assertEquals(HttpStatus.BAD_REQUEST, cs.fundTransfer(sorc, dest, amt).getStatusCode()); 
	 }
	 @Test
	 void fundTransferFailureByIdNotFound() {
		 Long sorc =1L;
		 Long dest=2L;
		 double amt=1;
		 
		 when(ar.findById(sorc)).thenReturn(Optional.of(new Account(1L,"savings",122333.0,new Date())));
		 when(ar.findById(dest)).thenReturn(Optional.empty());
		 assertEquals(HttpStatus.BAD_REQUEST, cs.fundTransfer(sorc, dest, amt).getStatusCode()); 
	 }
	 @Test
	 void fundTransferFailureByLessAmount() {
		 Long sorc =1L;
		 Long dest=2L;
		 double amt=1000000.0;
		 
		 when(ar.findById(sorc)).thenReturn(Optional.of(new Account(1L,"savings",122333.0,new Date())));
		 when(ar.findById(dest)).thenReturn(Optional.of(new Account(2L,"Current",122333.0,new Date())));
		 assertEquals(HttpStatus.BAD_REQUEST, cs.fundTransfer(sorc, dest, amt).getStatusCode()); 
	 }
}
