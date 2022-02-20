package com.tse.archintiers.photosharing.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tse.archintiers.photosharing.model.dto.User;
import java.util.Collection;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsAuth implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String email;

    private String password;

    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsAuth(Long id, String email, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsAuth build(User user) {

        return new UserDetailsAuth(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsAuth user = (UserDetailsAuth) o;
        return Objects.equals(id, user.id);
    }
}
