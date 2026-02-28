package com.ptk.infrastructure.security;

import com.ptk.domain.model.user.UserBackoffice;
import com.ptk.infrastructure.persistence.JpaUserBackofficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService implementation for UserBackoffice.
 */
@Service
@RequiredArgsConstructor
public class UserBackofficeDetailsService implements UserDetailsService {

    private final JpaUserBackofficeRepository userBackofficeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBackoffice user = userBackofficeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        
        return new UserBackofficeDetails(user);
    }
}
