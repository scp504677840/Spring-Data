package main.service;

import main.entities.AccountInfoEntity;
import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    public AccountInfoEntity getAccountInfo() {
        return accountInfoRepository.getAccountInfoEntityById(BigInteger.valueOf(3L));
    }

    public BigDecimal getBalanceWithMaxId() {
        return accountInfoRepository.getBalanceWithMaxId();
    }

    public AccountInfoEntity getAccountInfoEntityByPlaceholder(BigInteger id) {
        return accountInfoRepository.getAccountInfoEntityByPlaceholder(id);

    }

    public AccountInfoEntity getAccountInfoEntityByName(BigInteger id) {
        return accountInfoRepository.getAccountInfoEntityByName(id);
    }

    public List<AccountInfoEntity> getAccountInfoEntityByLike(String name) {
        return accountInfoRepository.getAccountInfoEntityByLike(name);
    }

    public List<AccountInfoEntity> getAccountInfoEntityByNativeQuery() {
        return accountInfoRepository.getAccountInfoEntityByNativeQuery();
    }

}
