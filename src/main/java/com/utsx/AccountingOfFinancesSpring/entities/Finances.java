package com.utsx.AccountingOfFinancesSpring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
public class Finances {
    @Id
    private Long id;
    @OneToOne
    private User user;
    @OneToMany
    private HashSet<Category> categories;

    public Finances() {
    }

    public Finances(final User user){
        this.user = user;
        this.categories = new HashSet<>();
    }

}
