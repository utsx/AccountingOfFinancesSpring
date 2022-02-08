package com.utsx.AccountingOfFinancesSpring.repository;

import com.utsx.AccountingOfFinancesSpring.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
}
