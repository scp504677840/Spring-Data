package main.repository;

import main.entities.AccountInfoEntity;

import java.math.BigInteger;

/**
 * 定义一个接口: 声明需要自定义的方法
 */
public interface Dao {
    AccountInfoEntity getAccountInfoByDao(BigInteger id);
}
