package com.project.application;

import com.project.domain.entity.Users;
import com.project.domain.usecase.CreateUserUseCase;
import com.project.inserfaces.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {

    private final UserRepositoryInterface userRepository;

    @Override
    public Users create(String name, String password) {
        Users user = new Users(name, password);
        return userRepository.save(user);
    }
}
