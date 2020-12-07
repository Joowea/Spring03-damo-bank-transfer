package com.joo.dao;

import com.joo.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 通过id查询一个account
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 增
     */
    void saveAccount(Account account);

    /**
     * 删
     */
    void deleteAccount(Integer accountId);

    /**
     * 改
     */
    void updateAccount(Account account);

    /**
     * 根据名称查询账户
     * @return 有唯一结果就返回；没有结果返回null；多个结果抛异常
     */
    Account findAccountByName(String accountName);

}
