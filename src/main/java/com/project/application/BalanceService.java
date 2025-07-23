package com.project.application;

import com.project.domain.entity.Users;
import com.project.domain.usecase.BalanceUseCase;
import com.project.interfaces.UserRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceService implements BalanceUseCase {

    private final UserRepositoryInterface userRepository;

    @Override
    public Users charge(Long userId, int amount) {
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        user.charge(amount);
        return userRepository.save(user);
    }

    @Override
    public int getBalance(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."))
                .getBalance();
    }
}
