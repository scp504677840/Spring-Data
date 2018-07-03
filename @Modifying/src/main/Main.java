package main;

import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

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
        accountInfoService.updateAccountInfoBalance(BigDecimal.valueOf(5555L));
    }
}
