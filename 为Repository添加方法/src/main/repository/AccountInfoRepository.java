package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

/**
 * 继承添加自定义的Repository
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, BigInteger>, Dao {
}
