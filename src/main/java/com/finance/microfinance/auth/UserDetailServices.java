package com.finance.microfinance.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserDetailServices implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServices(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(userName);
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("کاربری با نام کاربری " + userName + " وجود ندارد");
        }
        return new UserPrincipal(user);
    }
}
