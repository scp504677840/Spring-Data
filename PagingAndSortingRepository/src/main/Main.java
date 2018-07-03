package main;

import main.entities.AccountInfoEntity;
import main.service.AccountInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Iterator;

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
        //排序，按照什么字段属性进行排序。注意：这里写类中的属性，而不是数据库表中的字段。
        Sort sort = Sort.by(Sort.Order.desc("gmtCreate"));
        //排序页可以写作下面这种形式；第三个参数表示升序还是降序。第四个参数表示按哪个字段升序或降序。
        //PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC,"gmtCreate");
        //page从0开始
        PageRequest pageRequest = PageRequest.of(0, 3, sort);
        Page<AccountInfoEntity> page = accountInfoService.findAll(pageRequest);
        System.out.println("总记录数: " + page.getTotalElements());
        System.out.println("总页数: " + page.getTotalPages());
        System.out.println("当前第几页: " + page.getNumber());
        System.out.println("当前页的记录数: " + page.getNumberOfElements());
        System.out.println("当前页的List: " + page.getContent().size());

        Iterator<AccountInfoEntity> iterator = page.iterator();
        while (iterator.hasNext()) {
            AccountInfoEntity accountInfoEntity = iterator.next();
            System.out.println(accountInfoEntity);
        }

    }
}
/*
Hibernate:
    select
        accountinf0_.id as id1_0_,
        accountinf0_.balance as balance2_0_,
        accountinf0_.gmt_create as gmt_crea3_0_,
        accountinf0_.gmt_modified as gmt_modi4_0_,
        accountinf0_.name as name5_0_
    from
        lab.account_info accountinf0_
    order by
        accountinf0_.gmt_create desc limit ?
Hibernate:
    select
        count(accountinf0_.id) as col_0_0_
    from
        lab.account_info accountinf0_
总记录数: 5
总页数: 2
当前第几页: 0
当前页的记录数: 3
当前页的List: 3
AccountInfoEntity{id=6, gmtCreate=2018-07-03 23:54:42.0, gmtModified=2018-07-03 23:54:42.0, name='Lik', balance=1000.00}
AccountInfoEntity{id=3, gmtCreate=2018-07-02 04:08:58.0, gmtModified=2018-07-02 04:08:58.0, name='LLKK', balance=5555.00}
AccountInfoEntity{id=5, gmtCreate=2018-07-02 03:37:10.0, gmtModified=2018-07-02 03:37:10.0, name='TL', balance=5555.00}
 */