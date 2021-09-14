package com.finance.microfinance.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRepository, Long> {
    User findByUserName(String userName);
}
