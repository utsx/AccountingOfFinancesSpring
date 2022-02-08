package com.utsx.AccountingOfFinancesSpring.entities;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {
    @Id
    @Value("${some.key:0}")
    private Long id;
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(){
    }

    public Role(final Set<User> users)
    {
        this.users = users;
        this.roleName = "USER";
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleNameAndId(String roleName, Long id) {
        this.roleName = roleName;
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
