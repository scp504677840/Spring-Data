package main.service;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Transactional
    public AccountInfoEntity save(AccountInfoEntity accountInfoEntity) {
        return accountInfoRepository.save(accountInfoEntity);
    }

}
