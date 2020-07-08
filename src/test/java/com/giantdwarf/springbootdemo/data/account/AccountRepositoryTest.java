package com.giantdwarf.springbootdemo.data.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void hi() throws SQLException {
        Account account = new Account();
        account.setUsername("seungin");
        account.setPassword("pass");

        Account savedAccount = accountRepository.save(account);
        assertThat(savedAccount).isNotNull();

        Optional<Account> existingAccount = accountRepository.findByUsername(savedAccount.getUsername());
        assertThat(existingAccount).isNotEmpty();

        Optional<Account> nonExistingAccount = accountRepository.findByUsername("giant");
        assertThat(nonExistingAccount).isEmpty();


    }

}