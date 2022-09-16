package com.vinsguru.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinsguru.userservice.dto.UserDto;
import com.vinsguru.userservice.repository.UserRepository;
import com.vinsguru.userservice.util.EntityDtoUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public Flux<UserDto> getAll() {
		return this.repository.findAll().map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> getUserById(int id) {
		return this.repository.findById(id).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> createUser(Mono<UserDto> userDtoMono) {
		return userDtoMono.map(EntityDtoUtil::toEntity).flatMap(this.repository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<UserDto> updateUser(int id, Mono<UserDto> userDtoMono) {
		return this.repository.findById(id)
				.flatMap(u -> userDtoMono.map(EntityDtoUtil::toEntity).doOnNext(e -> e.setId(id)))
				.flatMap(this.repository::save).map(EntityDtoUtil::toDto);
	}

	@Override
	public Mono<Void> deleteUserById(int id) {
		return this.repository.deleteById(id);
	}

}
