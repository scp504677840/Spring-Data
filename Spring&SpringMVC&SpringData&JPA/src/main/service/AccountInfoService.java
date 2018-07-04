package main.service;

import main.entities.AccountInfoEntity;

import java.math.BigInteger;

public interface AccountInfoService {
    /**
     * 根据账户Id
     *
     * @param id 账户Id
     * @return 账户信息
     */
    AccountInfoEntity getAccountInfoById(BigInteger id);
}
