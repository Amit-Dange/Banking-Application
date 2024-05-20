package net.AmitDange.banking.mapper;

import net.AmitDange.banking.dto.AccountDto;
import net.AmitDange.banking.entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDto accountDto) {
		Account account = new Account(
				accountDto.getId() ,
				accountDto.getAccountHolderName(),
				accountDto.getBalance() 
			);
		System.out.println("inside map to account");
		System.out.println(accountDto.getId());
		System.out.println(accountDto.getAccountHolderName());
		System.out.println(accountDto.getBalance());
		System.out.println("dto over now acc jpa");		
		System.out.println(account.getId());
		System.out.println(account.getAccountHolderName());
		System.out.println(account.getBalance());
		System.out.println("inside map to account end ");
				
		return account ; 
	}
	
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto (
				account.getId() ,
				account.getAccountHolderName(),
				account.getBalance() 
			);
				
		return accountDto ; 
	}
	

}
