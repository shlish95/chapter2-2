package com.project.infrastructure.persistence;

import com.project.domain.entity.Users;
import com.project.inserfaces.UserRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepositoryInterface {

    private final SpringDataUserRepository userRepository;

    public JpaUserRepository(SpringDataUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users save(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }
}
