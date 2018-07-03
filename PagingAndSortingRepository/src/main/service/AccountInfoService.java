package main.service;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    @Transactional
    public Page<AccountInfoEntity> findAll(PageRequest pageRequest) {
        return accountInfoRepository.findAll(pageRequest);
    }

}
