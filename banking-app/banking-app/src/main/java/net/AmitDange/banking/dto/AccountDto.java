package net.AmitDange.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@Data  
////to automatically generate constructor , getter , setters 
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	private Long id;
	private String accountHolderName;
	private double balance ;
	
	public AccountDto(Long id, String accountHolderName, double balance) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
