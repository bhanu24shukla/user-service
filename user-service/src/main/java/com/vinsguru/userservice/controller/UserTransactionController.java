package com.vinsguru.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vinsguru.userservice.dto.TransactionRequestDto;
import com.vinsguru.userservice.dto.TransactionResponseDto;
import com.vinsguru.userservice.entity.UserTransaction;
import com.vinsguru.userservice.service.UserTransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user/transaction")
public class UserTransactionController {

	@Autowired
	private UserTransactionService transactionService;

	@PostMapping
	public Mono<TransactionResponseDto> createTransaction(
			@RequestBody Mono<TransactionRequestDto> monoTransactionRequestDto) {
		return monoTransactionRequestDto.flatMap(this.transactionService::createTransaction);
	}

	@GetMapping
	public Flux<UserTransaction> getByUserId(@RequestParam("userId") int userId) {
		return this.transactionService.getByUserId(userId);
	}

}
