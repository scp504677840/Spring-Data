package main.controller;

import main.entities.AccountInfoEntity;
import main.service.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Controller
public class AccountInfoController {

    @Autowired
    private AccountInfoService accountInfoService;

    @ResponseBody
    @RequestMapping("/show")
    public AccountInfoEntity getAccountInfo() {
        AccountInfoEntity entity = accountInfoService.getAccountInfoById(BigInteger.valueOf(3L));
        System.out.println(entity);
        return entity;
    }

}
