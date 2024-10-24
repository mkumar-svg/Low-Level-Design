package com.nit.wallettransaction;

import java.util.HashMap;
import java.util.Map;

public class WalletService {
	private Map<String, Wallet> walletMap;
	
	public WalletService() {
		walletMap = new HashMap<>();
	}
	
	public void createWallet(String accountHolder, double amount) {
		if(walletMap.containsKey(accountHolder)) {
			System.out.println("Wallet already exists for " + accountHolder);
			return;
		}
		
		walletMap.put(accountHolder, new Wallet(accountHolder, amount));
		System.out.println("Wallet created for " + accountHolder + " with amount: " + amount);
	}
	
	public void transferMoney(String fromAccountHolder, String toAccountHolder, double amount) throws Exception {
		Wallet fromWallet = walletMap.get(fromAccountHolder);
		Wallet toWallet = walletMap.get(toAccountHolder);
		
		if(fromWallet == null || toWallet == null) {
			System.out.println("One of the account does not exist.");
			return;
		}
		
		fromWallet.debit(amount);
		toWallet.credit(amount);
		System.out.println("Transferred " + amount + " from " + fromAccountHolder + " to " + toAccountHolder);
	}
	
	public void printStatement(String accountHolder) {
		Wallet wallet = walletMap.get(accountHolder);
		if(wallet == null) {
			System.out.println("No wallet found for " + accountHolder);
			return;
		}
		
		System.out.println("Transaction history for " + accountHolder + ":");
		for(Transaction transaction : wallet.getTransactions()) {
			System.out.println(transaction);
		}
	}
	
	public void printOverView(String accountHolder) {
		Wallet wallet = walletMap.get(accountHolder);
		if(wallet == null) {
			System.out.println("No wallet found for " + accountHolder);
			return;
		}
		System.out.println("Current balance for " + accountHolder + ": " + wallet.getBalance());
	}
}
