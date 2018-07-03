package main;

import main.entities.AccountInfoEntity;
import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
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
        AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
        accountInfoEntity.setGmtCreate(Timestamp.from(Instant.now()));
        accountInfoEntity.setGmtModified(Timestamp.from(Instant.now()));
        accountInfoEntity.setName("Lik");
        accountInfoEntity.setBalance(BigDecimal.valueOf(1000L));
        System.out.println(accountInfoService.save(accountInfoEntity));
    }
}
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
AccountInfoEntity{id=6, gmtCreate=2018-07-03 23:54:41.89094, gmtModified=2018-07-03 23:54:41.891429, name='Lik', balance=1000}
 */