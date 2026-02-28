package com.ptk.infrastructure.security;

import com.ptk.domain.model.user.UserBackoffice;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * UserDetails implementation for UserBackoffice.
 */
@Getter
public class UserBackofficeDetails implements UserDetails {

    private final String id;
    private final String username;
    private final String password;
    private final String roleId;
    private final String grosirId;
    private final String areaServiceId;
    private final String status;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserBackofficeDetails(UserBackoffice user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roleId = user.getRoleId();
        this.grosirId = user.getGrosirId();
        this.areaServiceId = user.getAreaServiceId();
        this.status = user.getStatus();
        // Use roleId as authority - can be enhanced to fetch actual role permissions
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getRoleId()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !"LOCKED".equalsIgnoreCase(status);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return "ACTIVE".equalsIgnoreCase(status);
    }
}
