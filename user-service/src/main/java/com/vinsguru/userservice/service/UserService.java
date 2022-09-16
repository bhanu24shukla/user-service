package com.vinsguru.userservice.service;

import com.vinsguru.userservice.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Flux<UserDto> getAll();

	Mono<UserDto> getUserById(int id);

	Mono<UserDto> createUser(Mono<UserDto> userDtoMono);

	Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono);

	Mono<Void> deleteUserById(int id);

}
