package main.repository;

import main.entities.AccountInfoEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

/**
 * 提供该接口的实现类: 类名需在要声明的 Repository 后添加 Impl, 并实现方法
 */
public class AccountInfoRepositoryImpl implements Dao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AccountInfoEntity getAccountInfoByDao(BigInteger id) {
        return entityManager.find(AccountInfoEntity.class, id);
    }
}
