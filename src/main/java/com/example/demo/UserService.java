package com.example.demo;

public class UserService {
    private final UsersRepository repository;

    public UserService(UsersRepository repository) {
        this.repository = repository;
    }

    public <S extends User> S save(S s) {
        return repository.save(s);
    }

    public long count() {
        return repository.count();
    }
}
