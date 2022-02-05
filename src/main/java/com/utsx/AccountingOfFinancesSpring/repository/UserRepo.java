package com.utsx.AccountingOfFinancesSpring.repository;

import com.utsx.AccountingOfFinancesSpring.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepo extends PagingAndSortingRepository<User, Long> {
}
