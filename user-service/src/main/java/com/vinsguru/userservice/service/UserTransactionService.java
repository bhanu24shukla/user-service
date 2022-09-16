package com.vinsguru.userservice.service;

import com.vinsguru.userservice.dto.TransactionRequestDto;
import com.vinsguru.userservice.dto.TransactionResponseDto;
import com.vinsguru.userservice.entity.UserTransaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserTransactionService {

	Mono<TransactionResponseDto> createTransaction(final TransactionRequestDto monoTransactionRequestDto);

	Flux<UserTransaction> getByUserId(int userId);

}
