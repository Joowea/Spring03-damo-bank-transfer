package com.joo.service;

import com.joo.domain.Account;

import java.util.List;

public interface IAccountService {

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
     * 转账方法
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);

}
