package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Repository
 * 1.Repository是一个空接口，即是一个标记接口。
 * 2.也可以用注解@RepositoryDefinition替换继承。
 * <p>
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

    /**
     * 使用@Query注解可以自定义JPAQL语句以实现更灵活的查询
     *
     * @return 最大Id值的余额
     */
    @Query("select a.balance from AccountInfoEntity a where a.id = (select max(a2.id) from AccountInfoEntity a2)")
    BigDecimal getBalanceWithMaxId();

    /**
     * 使用占位符的方式
     *
     * @param id 账户Id
     * @return 账户
     */
    @Query("select a from AccountInfoEntity a where a.id = ?1")
    AccountInfoEntity getAccountInfoEntityByPlaceholder(BigInteger id);

    /**
     * 使用命名参数的方式
     *
     * @param id 账户Id
     * @return 账户
     */
    @Query("select a from AccountInfoEntity a where a.id = :id")
    AccountInfoEntity getAccountInfoEntityByName(@Param("id") BigInteger id);

    /**
     * 使用like
     * 1.占位符和命名参数查询都可以。
     * 2.建议在SQL里带上 % 百分号
     *
     * @return 账户
     */
    //@Query("select a from AccountInfoEntity a where a.name like %?1%")
    @Query("select a from AccountInfoEntity a where a.name like %:name%")
    List<AccountInfoEntity> getAccountInfoEntityByLike(@Param("name") String name);

    /**
     * 原始SQL
     *
     * @return 账户
     */
    @Query(value = "select * from account_info", nativeQuery = true)
    List<AccountInfoEntity> getAccountInfoEntityByNativeQuery();

}
