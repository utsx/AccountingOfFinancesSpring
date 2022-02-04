package com.utsx.AccountingOfFinancesSpring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role {
    @Id
    private Long id;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
