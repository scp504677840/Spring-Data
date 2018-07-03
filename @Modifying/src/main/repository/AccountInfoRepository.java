package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Repository
 * 1.Repository是一个空接口，即是一个标记接口。
 * 2.也可以用注解@RepositoryDefinition替换继承。
 * <p>
 * 接口方法规范：
 * 1.查询需要以find、read、get开头。
 * <p>
 * 修改：
 * 1.@Query
 * 2.@Modifying
 */
//@RepositoryDefinition(domainClass = AccountInfoEntity.class,idClass = BigInteger.class)
public interface AccountInfoRepository extends Repository<AccountInfoEntity, BigInteger> {

    /**
     * 修改所有账户的余额
     *
     * @param balance 余额
     */
    @Modifying
    @Query("update AccountInfoEntity a set a.balance = ?1")
    void updateAccountInfoBalance(BigDecimal balance);

}
