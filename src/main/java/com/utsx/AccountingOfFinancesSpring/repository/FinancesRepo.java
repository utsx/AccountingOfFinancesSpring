package com.utsx.AccountingOfFinancesSpring.repository;

import com.utsx.AccountingOfFinancesSpring.entities.Finances;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FinancesRepo extends PagingAndSortingRepository<Finances, Long> {
}
