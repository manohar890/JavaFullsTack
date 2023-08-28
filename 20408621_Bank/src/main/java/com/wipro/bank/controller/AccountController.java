package com.wipro.bank.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.bank.Model.Account;
import com.wipro.bank.exception.InternalServerException;
import com.wipro.bank.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
   AccountRepository arep;
	@GetMapping("/getAllAccounts")
	public ResponseEntity<?> getAllAccounts(){
		
		try {
			List<Account> lis=arep.findAll();
			if(lis.size()>0) {
				return new ResponseEntity<>(lis,HttpStatus.OK);
			}else return new ResponseEntity<>("No Accounts Found",HttpStatus.OK);
		}catch (InternalServerException ex) {
			// TODO: handle exception
			throw new InternalServerException();
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") Long id){
		
		try {
			java.util.Optional<Account> acc=arep.findById(id);
			if(acc.isPresent())
			return new ResponseEntity<>(acc.get(),HttpStatus.OK);
			else
				return new ResponseEntity<>("Id "+id+" not found",HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			// TODO: handle exception
			throw new InternalServerException();
		}
		
	}
}
