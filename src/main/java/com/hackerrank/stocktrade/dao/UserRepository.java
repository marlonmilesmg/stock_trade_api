package com.hackerrank.stocktrade.dao;

import com.hackerrank.stocktrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
