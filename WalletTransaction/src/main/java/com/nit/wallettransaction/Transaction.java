package com.nit.wallettransaction;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Transaction {
	private String type;
	private double amount;
	private LocalDateTime timeStamp;
	
	public Transaction(String type, double amount) {
		this.type = type;
		this.amount = amount;
		this.timeStamp = LocalDateTime.now();
	}
}
