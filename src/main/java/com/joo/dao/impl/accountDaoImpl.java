package com.joo.dao.impl;

import com.joo.dao.IAccountDao;
import com.joo.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository(value = "accountDao")
public class accountDaoImpl implements IAccountDao {

    @Autowired
    @Qualifier(value = "runner")
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",
                    new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ?",
                    new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name, money) value(?,?)",
                    account.getName(),account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id = ?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ?",
                    account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query("select * from account where name = ?",
                    new BeanListHandler<Account>(Account.class), accountName);

            if (accounts == null || accounts.size() == 0) { //没有结果 返回null
                return null;
            } else if (accounts.size() > 1) { //结果大于1 数据有问题
                throw new RuntimeException("结果》1");
            } else {
                return accounts.get(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
