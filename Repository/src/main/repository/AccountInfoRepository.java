package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.repository.Repository;

import java.math.BigInteger;

/**
 * Repository
 * 1.Repository是一个空接口，即是一个标记接口。
 * 2.也可以用注解@RepositoryDefinition替换继承。
 *
 * 接口方法规范：
 * 1.查询需要以find、read、get开头。
 */
//@RepositoryDefinition(domainClass = AccountInfoEntity.class,idClass = BigInteger.class)
public interface AccountInfoRepository extends Repository<AccountInfoEntity, BigInteger> {

    /**
     * 根据账户Id获取账户信息
     *
     * @param id 账户Id
     * @return 账户信息
     */
    AccountInfoEntity getAccountInfoEntityById(BigInteger id);

}
