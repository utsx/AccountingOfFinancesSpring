package com.utsx.AccountingOfFinancesSpring.components;

import com.utsx.AccountingOfFinancesSpring.entities.Privilege;
import com.utsx.AccountingOfFinancesSpring.entities.Role;
import com.utsx.AccountingOfFinancesSpring.entities.User;
import com.utsx.AccountingOfFinancesSpring.repository.PrivilegeRepo;
import com.utsx.AccountingOfFinancesSpring.repository.RoleRepo;
import com.utsx.AccountingOfFinancesSpring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PrivilegeRepo privilegeRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(alreadySetup)
            return;
        Privilege readPrivilege
                = createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ADMIN", adminPrivileges);
        createRoleIfNotFound("USER", List.of(readPrivilege));

        Role adminRole = roleRepo.findByName("ADMIN");
        User user = new User();
        user.setFirstName("TEST");
        user.setLastName("TEST");
        user.setPassword(passwordEncoder.encode("test"));
        user.setEmail("test@test.ru");
        user.setRoles(Arrays.asList(adminRole));
        user.setActive(true);
        userRepo.save(user);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepo.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            //privilegeRepo.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(String name, Collection<Privilege> privileges){
        Role role = roleRepo.findByName(name);
        if(role == null)
        {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepo.save(role);
        }
        return role;
    }
}
