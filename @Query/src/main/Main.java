package main;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountInfoService accountInfoService = (AccountInfoService) ctx.getBean("accountInfoService");
        List<AccountInfoEntity> list = accountInfoService.getAccountInfoEntityByNativeQuery();
        list.forEach(accountInfoEntity -> {
            System.out.println(accountInfoEntity);
        });
    }
}
