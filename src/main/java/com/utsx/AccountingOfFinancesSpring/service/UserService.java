package com.utsx.AccountingOfFinancesSpring.service;

import com.utsx.AccountingOfFinancesSpring.entities.User;
import com.utsx.AccountingOfFinancesSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepo userRepo;


    public UserService(UserRepo userRepo) {

        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not failed"));
    }
    public boolean saveUser(User user)
    {
        if(userRepo.findUserByLogin(user.getUsername()).isPresent())
        {
            return false;
        }
        userRepo.save(user);
        return true;

    }
    public UserRepo getUserRepo() {
        return userRepo;
    }
}
