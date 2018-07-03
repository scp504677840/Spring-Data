package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

/**
 * CrudRepository
 * 1.增删改查
 */
public interface AccountInfoRepository extends CrudRepository<AccountInfoEntity, BigInteger> {
}
