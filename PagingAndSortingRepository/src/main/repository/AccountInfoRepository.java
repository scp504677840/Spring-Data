package main.repository;

import main.entities.AccountInfoEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

/**
 * PagingAndSortingRepository
 * 1.增删改查
 * 2.分页
 * 3.排序
 */
public interface AccountInfoRepository extends PagingAndSortingRepository<AccountInfoEntity, BigInteger> {
}
