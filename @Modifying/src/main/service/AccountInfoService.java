package main.service;

import main.repository.AccountInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountInfoService {

    @Autowired
    private AccountInfoRepository accountInfoRepository;

    /**
     * 修改所有账户的余额
     *
     * @param balance 余额
     */
    @Transactional
    public void updateAccountInfoBalance(BigDecimal balance){
        accountInfoRepository.updateAccountInfoBalance(balance);
    }

}
