package main.service;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public AccountInfoEntity getAccountInfo() {
        return accountInfoRepository.getAccountInfoEntityById(BigInteger.valueOf(3L));
    }

}
