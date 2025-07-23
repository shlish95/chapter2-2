package com.project.application;

import com.project.domain.entity.Users;
import com.project.interfaces.UserRepositoryInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class BalanceServiceTest {

    @Mock
    UserRepositoryInterface userRepo;

    @InjectMocks
    BalanceService balanceService;

    @DisplayName("충전 후 잔액 증가")
    @Test
    void charge_increaseBalanceTest() {
        //given
        int ownBalance = 100;
        int chargeBalance = 50;
        Users user = new Users(1L, "name1", "pw1", ownBalance, null);

        given(userRepo.findById(1L)).willReturn(Optional.of(user));
        given(userRepo.save(any(Users.class))).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        //when
        Users updatedUser = balanceService.charge(1L, chargeBalance);

        //then
        then(userRepo).should().save(any(Users.class));
        assertThat(updatedUser.getBalance()).isEqualTo(ownBalance + chargeBalance);
    }

    @DisplayName("유효하지 않은 ID로 조회 시 예외 발생")
    @Test
    void charge_userNotFoundTest() {
        //given
        given(userRepo.findById(99L)).willReturn(Optional.empty());

        //when
        //then
        assertThatThrownBy(() -> balanceService.charge(99L, 50))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 유저를 찾을 수 없습니다.");
    }

    @DisplayName("잔액 조회")
    @Test
    void getBalanceTest() {
        //given
        Users user = new Users(2L, "name2", "pw2", 100, null);
        given(userRepo.findById(2L)).willReturn(Optional.of(user));

        //when
        int balance = balanceService.getBalance(2L);

        //then
        assertThat(balance).isEqualTo(user.getBalance());
    }
}
