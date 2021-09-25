package com.finance.microfinance.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServices implements UserDetailsService {
    private final UserRepository userRepository;
    private final AuthGroupRepository authGroupRepository;

    public UserDetailServices(UserRepository userRepository, AuthGroupRepository authGroupRepository) {
        super();
        this.userRepository = userRepository;
        this.authGroupRepository = authGroupRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUserName(userName);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("کاربری با نام کاربری " + userName + " وجود ندارد");
        }
        List<AuthGroup> authGroupList = authGroupRepository.findByUserName(userName);
        return new UserPrincipal(user, authGroupList);
    }
}
