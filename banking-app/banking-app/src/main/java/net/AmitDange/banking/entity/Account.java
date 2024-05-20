package net.AmitDange.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="accounts")
@Entity
public class Account {
	
	@Id // this will make id as a primary key 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // this increment value of id by 1 each time 
	private long id ;
	
	@Column(name = "account_holder_name")
	private String accountHolderName;
	private double Balance ;
	
	public Account(Long long1, String string, double d) {
		super();
		this.setAccountHolderName(string);
		this.setBalance(d);
		
	}
	
	public Account() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	
	
}
