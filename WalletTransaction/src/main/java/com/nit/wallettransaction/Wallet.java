package com.nit.wallettransaction;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Wallet {
	private String accountHolder;
	private double balance;
	private List<Transaction> transactions;
	
	public Wallet(String accountHolder, double initialAmount) {
		this.accountHolder = accountHolder;
		this.balance = initialAmount;
		this.transactions = new ArrayList<>();
		addTransaction("CREDIT", initialAmount);
	}
	
	public void addTransaction(String type, double amount) {
		transactions.add(new Transaction(type, amount));
	}
	
	public void credit(double amount) {
		balance += amount;
		addTransaction("CREDIT", amount);
	}
	
	public void debit(double amount) throws Exception {
		if(amount > balance) {
			throw new Exception("Insufficient balance!");
		}
		
		balance -= amount;
		addTransaction("DEBIT", amount);
	}
}
