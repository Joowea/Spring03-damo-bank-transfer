package com.joo.service.impl;

import com.joo.dao.IAccountDao;
import com.joo.domain.Account;
import com.joo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value = "accountService")
public class accountServiceImpl implements IAccountService {

    @Autowired
    @Qualifier(value = "accountDao")
    private IAccountDao accountDao;


    @Override
    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {

        accountDao.deleteAccount(accountId);
    }

    @Override
    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        //1. 根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);

        //2. 查询转入账户
        Account target = accountDao.findAccountByName(targetName);

        //3. 转出账户-钱
        source.setMoney(source.getMoney()-money);

        //4. 转入账户+钱
        target.setMoney(target.getMoney()+money);

        //5. 更新账户
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);

    }
}
