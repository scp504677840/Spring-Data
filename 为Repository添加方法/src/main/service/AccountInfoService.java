package main.service;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Transactional
    public AccountInfoEntity getAccountInfoByDao(BigInteger id) {
        return accountInfoRepository.getAccountInfoByDao(id);
    }

}
