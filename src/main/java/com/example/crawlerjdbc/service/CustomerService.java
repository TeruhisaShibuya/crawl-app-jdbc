package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.model.Customer;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * 会員 サービス
 */
public interface CustomerService {

    /**
     * すべての会員を取得
     *
     * @return すべての会員情報
     */
    public List<Customer> findAll();


    /**
     * ID(サロゲートキー)指定で会員を取得
     *
     * @param customerId 会員ID
     * @return 会員情報
     */
    public Customer findById(Long customerId);

}
