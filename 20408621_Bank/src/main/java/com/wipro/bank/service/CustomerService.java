package com.wipro.bank.service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.wipro.bank.Model.Account;
import com.wipro.bank.Model.Customer;
import com.wipro.bank.Model.TransactionHistory;
import com.wipro.bank.exception.InternalServerException;
import com.wipro.bank.repository.AccountRepository;
import com.wipro.bank.repository.CustomerRepository;
import com.wipro.bank.repository.TransactionRepository;

@Service
public class CustomerService {
	@Autowired
	private TransactionRepository trep;
	@Autowired
	private AccountRepository acrep;
	@Autowired
	CustomerRepository cr;
	
	public ResponseEntity<?> fundTransfer(Long sorc,Long dest,double amt){
		
		try {
			Map <String,String> msg=new HashMap<String,String>();
			if(sorc==dest) {
				msg.put("status ","Transaction failed");
				msg.put("Message "," Source and Destination Account should not be same");
				TransactionHistory t=new TransactionHistory(sorc,dest,amt,"Failed",new Date());
				trep.save(t);
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
			Optional<Account> sorcacc=acrep.findById(sorc); 
			Optional<Account> destacc=acrep.findById(dest);
			if(sorcacc.isPresent() && destacc.isPresent()) {
				if(amt>1) {
				Account sac=sorcacc.get();
				Account dac=destacc.get();
				if(sac.getAccountBalance()>=amt) {
					sac.setAccountBalance(sac.getAccountBalance()-amt);
					acrep.save(sac);
					dac.setAccountBalance(dac.getAccountBalance()+amt);
					acrep.save(dac);
					TransactionHistory t=new TransactionHistory(sorc,dest,amt,"Success",new Date());
					trep.save(t);
					msg.put("status ","Transaction success");
					msg.put("FromAccount ",""+sorc);
					msg.put("toAccount", ""+dest);
					msg.put("amount",""+amt);
					return new ResponseEntity<>(msg,HttpStatus.ACCEPTED);		
				}else {
					msg.put("status ","Transaction failed");
					msg.put("Message "," Insufficient Funds");
					TransactionHistory t=new TransactionHistory(sorc,dest,amt,"Failed due to less min amount transactiom",new Date());
					trep.save(t);
					return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
				}
				}else {
					msg.put("status ","Transaction failed");
					msg.put("Message ","Minium transaction amount should  greater than 1");
					TransactionHistory t=new TransactionHistory(sorc,dest,amt,"Failed",new Date());
					trep.save(t);
					return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
				}
			}else {
				msg.put("status ","Transaction failed");
				msg.put("Message ","Either source or destination account not found");
				TransactionHistory t=new TransactionHistory(sorc,dest,amt,"Failed",new Date());
				trep.save(t);
				return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			}
		}catch (InternalServerException e) {
			throw new InternalServerException();
		}
	}	
	public Customer save(Customer cus) {
		return cr.save(cus);
	}
	public void deleteCustomerById(Long id) {
		try {
		cr.deleteById(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
