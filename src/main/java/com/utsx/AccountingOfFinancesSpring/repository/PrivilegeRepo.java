package com.utsx.AccountingOfFinancesSpring.repository;

import com.utsx.AccountingOfFinancesSpring.entities.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.jpa.JpaVendorAdapter;

public interface PrivilegeRepo extends JpaRepository<Long, Privilege> {
    Privilege findByName(String name);
}
