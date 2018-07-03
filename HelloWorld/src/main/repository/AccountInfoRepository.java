package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

public interface AccountInfoRepository extends Repository<AccountInfoEntity, BigInteger> {

    /**
     * 根据账户Id获取账户信息
     *
     * @param id 账户Id
     * @return 账户信息
     */
    AccountInfoEntity getAccountInfoEntityById(BigInteger id);

}
