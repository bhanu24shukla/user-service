package com.vinsguru.userservice.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;

public class UserTransaction {

	@Id
	private Integer id;
	private Integer userId;
	private Integer amount;
	private LocalDateTime transactionDate;

	public UserTransaction() {
	}

	public UserTransaction(Integer id, Integer userId, Integer amount, LocalDateTime transactionDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, id, transactionDate, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UserTransaction))
			return false;
		UserTransaction other = (UserTransaction) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(id, other.id)
				&& Objects.equals(transactionDate, other.transactionDate) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "UserTransaction [id=" + id + ", userId=" + userId + ", amount=" + amount + ", transactionDate="
				+ transactionDate + "]";
	}

}
