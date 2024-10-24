package com.nit.wallettransaction;

import java.util.Scanner;

public class WalletSystem {

	public static void main(String[] args) {
		WalletService walletService = new WalletService();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Commands: ");
			String command = sc.nextLine();
			String[] parts = command.split(" ");
			
			try {
				switch(parts[0]) {
					case "CreateWallet":
						String accountHolder = parts[1];
						double amount = Double.parseDouble(parts[2]);
						walletService.createWallet(accountHolder, amount);
						break;
					
					case "TransferMoney":
						String fromAccount = parts[1];
						String toAccount = parts[2];
						double transferMoney = Double.parseDouble(parts[3]);
						walletService.transferMoney(fromAccount, toAccount, transferMoney);
						break;
						
					case "Statement":
						String statementAccount = parts[1];
						walletService.printStatement(statementAccount);
						break;
						
					case "Overview":
						String overviewAccount = parts[1];
						walletService.printOverView(overviewAccount);
						break;
						
					default:
						System.out.println("Invalid command!");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

}
