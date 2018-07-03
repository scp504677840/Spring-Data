package main;

import main.entities.AccountInfoEntity;
import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 修改或删除操作
 * 1.需要@Query和@Modifying
 * 2.更新和删除必须需要事务
 * 3.按理说SpringData查询方法也需要加上事务
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountInfoService accountInfoService = (AccountInfoService) ctx.getBean("accountInfoService");
        //saveAndFlush，当数据不存在时执行保存操作，当数据存在时，执行更新操作，注意我们得给主键赋值。
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        accountInfoEntity.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfoEntity.setGmtModified(Timestamp.from(Instant.now()));
        accountInfoEntity.setName("Jk");
        accountInfoEntity.setBalance(BigDecimal.valueOf(888L));
        accountInfoEntity.setId(BigInteger.valueOf(7L));
        AccountInfoEntity ac = accountInfoService.saveAndFlush(accountInfoEntity);
        System.out.println(accountInfoEntity == ac);

    }
}
//当数据不存在时
/*
Hibernate:
    select
        max(id)
    from
        account_info
Hibernate:
    insert
    into
        lab.account_info
        (balance, gmt_create, gmt_modified, name, id)
    values
        (?, ?, ?, ?, ?)
true
 */

//当数据存在时
/*
Hibernate:
    select
        accountinf0_.id as id1_0_0_,
        accountinf0_.balance as balance2_0_0_,
        accountinf0_.gmt_create as gmt_crea3_0_0_,
        accountinf0_.gmt_modified as gmt_modi4_0_0_,
        accountinf0_.name as name5_0_0_
    from
        lab.account_info accountinf0_
    where
        accountinf0_.id=?
Hibernate:
    update
        lab.account_info
    set
        balance=?,
        gmt_create=?,
        gmt_modified=?,
        name=?
    where
        id=?
false
 */