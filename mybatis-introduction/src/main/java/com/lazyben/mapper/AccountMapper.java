package com.lazyben.mapper;

import com.lazyben.pojo.Account;

import java.util.List;

public interface AccountMapper {
    Account selectUserById(long id);

    List<Account> selectAllUsers();

    int updateUser();
}
