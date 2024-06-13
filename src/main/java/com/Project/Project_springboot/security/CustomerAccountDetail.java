package com.Project.Project_springboot.security;

import com.Project.Project_springboot.model.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerAccountDetail implements  UserDetails{
    private Account account;
    private Collection<? extends GrantedAuthority> authorities;


    //danh sach cac quyen
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    // mat khau
    @Override
    public String getPassword() {
        return account.getPassword();
    }
    //ten
    @Override
    public String getUsername() {
        return account.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //trang thai
    @Override
    public boolean isEnabled() {
        return true;
    }
}
