package com.utsx.AccountingOfFinancesSpring.entities;

import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String secondName;
    private Date birthdayDate;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(){
    }

    public User(String firstName, String secondName,
                Date birthdayDate, String password)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthdayDate = birthdayDate;
        if(password.length() < 8)
        {
            throw new Invalid
        }
        this.password = password;
    }


}
