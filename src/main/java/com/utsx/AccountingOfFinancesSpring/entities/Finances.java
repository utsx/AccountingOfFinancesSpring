package com.utsx.AccountingOfFinancesSpring.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Finances {
    @Id
    private Long id;
    //@OneToOne
   // private User user;
    @OneToMany(mappedBy = "finances")
    private Set<Category> categories;

    public Finances() {
    }

    public Finances(final User user){
        //this.user = user;
        this.categories = new HashSet<>();
    }

}
