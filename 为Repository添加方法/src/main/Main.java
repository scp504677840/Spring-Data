package main;

import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;

/**
 * 为某一个Repository添加自定义方法
 * 1.定义一个接口: 声明要添加的, 并自实现的方法
 * 2.提供该接口的实现类: 类名需在要声明的 Repository 后添加 Impl, 并实现方法
 * 3.声明 Repository 接口, 并继承 1) 声明的接口
 * 4.使用
 * 5.注意: 默认情况下, Spring Data 会在 base-package 中查找 "接口名Impl" 作为实现类. 也可以通过　repository-impl-postfix　声明后缀
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountInfoService accountInfoService = (AccountInfoService) ctx.getBean("accountInfoService");
        System.out.println(accountInfoService.getAccountInfoByDao(BigInteger.valueOf(7L)));
    }
}