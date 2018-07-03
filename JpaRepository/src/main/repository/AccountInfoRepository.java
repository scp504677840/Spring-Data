package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

/**
 * JpaRepository
 * 1.PagingAndSortingRepository的子接口
 * 2.方法：
 * findAll
 * findAll
 * findAllById
 * saveAll
 * flush
 * saveAndFlush
 * deleteInBatch
 * deleteAllInBatch
 * getOne
 * findAll
 * findAll
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, BigInteger> {
}
