package com.utsx.AccountingOfFinancesSpring.entities;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
    private Long totalAmount;
    @ManyToOne
    private Finances finances;

    public Category(){
    }

    public Category(final String categoryName){
        this.categoryName = categoryName;
        this.totalAmount = 0L;
    }

    public void addMoney(final Long currentSum)
    {
        totalAmount += currentSum;
    }

    public Finances getFinances() {
        return finances;
    }

}
