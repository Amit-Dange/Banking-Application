package net.AmitDange.banking.service.implementation;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.AmitDange.banking.dto.AccountDto;
import net.AmitDange.banking.entity.Account;
import net.AmitDange.banking.mapper.AccountMapper;
import net.AmitDange.banking.repository.AccountRepository;
import net.AmitDange.banking.service.AccountService;

@Service // to automatically create spring bean for the class
public class AccountServiceImpl implements AccountService {
	
//	injecting dependencies 
	private AccountRepository accountReposotory ;
	
//	@Autowired //this may not need as in boot there are features 
	public AccountServiceImpl(AccountRepository accountReposotry) {
	this.accountReposotory = accountReposotry;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
//		convert accountdto into accountjpa and then store entity into database
		System.out.println(accountDto.getId());
		System.out.println(accountDto.getAccountHolderName());
		System.out.println(accountDto.getBalance());
		Account account = AccountMapper.mapToAccount(accountDto);
		System.out.println(account.getId());
		System.out.println(account.getAccountHolderName());
		System.out.println(account.getBalance());
		Account savedAccount = accountReposotory.save(account);
		System.out.println(savedAccount.getId());
		System.out.println(savedAccount.getAccountHolderName());
		System.out.println(savedAccount.getBalance());
		return AccountMapper.mapToAccountDto(savedAccount) ;
//		return accountDto ;
	}


	@Override
	public AccountDto getAccountById(Long id) {
		Account account = accountReposotory
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not exist"));
		return AccountMapper.mapToAccountDto(account);
	}


	@Override
	public AccountDto deposit(Long id, double amount) {
		
//		initially check the weather the account is present or not 
		Account account = accountReposotory
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not exist"));
		
//		finding the net ammount 
		double total = account.getBalance() + amount ;
		account.setBalance(total);
		
//		depositing it into database so this method saves account into db and return the saved account object
		Account savedAccount = accountReposotory.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public AccountDto withdraw(Long id, double amount) {
		
//		initially check the weather the account is present or not 
		Account account = accountReposotory
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not exist"));
		
//		check if given withdraw amount is greater than balance or not
		double balance = account.getBalance() ;
		if(balance < amount ) {
			throw new RuntimeException("Insufficient amount");
		}
		
		double total = balance - amount ;
		account.setBalance(total);
		Account savedAccount = accountReposotory.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}


	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountReposotory.findAll();
		return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account))
		.collect(Collectors.toList());
	}


	@Override
	public void deleteAccount(Long id) {
//		initially check the weather the account is present or not 
		Account account = accountReposotory
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account Does not exist"));
		
		accountReposotory.deleteById(id);
		
	}

}
