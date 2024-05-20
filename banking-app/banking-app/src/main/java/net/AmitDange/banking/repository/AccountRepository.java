package net.AmitDange.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.AmitDange.banking.entity.Account;


//this AccountRepository will get a crud database methods to perform operation on an account jpa entity 
public interface AccountRepository extends JpaRepository<Account, Long>{
	
}
