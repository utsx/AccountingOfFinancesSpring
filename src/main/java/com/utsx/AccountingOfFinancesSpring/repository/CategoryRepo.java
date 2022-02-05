package com.utsx.AccountingOfFinancesSpring.repository;

import com.utsx.AccountingOfFinancesSpring.entities.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> {
}
