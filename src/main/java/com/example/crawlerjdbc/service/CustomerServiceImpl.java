package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.config.SqlConfig;
import com.example.crawlerjdbc.model.Customer;
import com.example.crawlerjdbc.service.mapper.CustomerRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final JdbcTemplate jdbcTemplate;

    /** sqlプロパティの内容をオブジェクト化したインスタンス */
    private final SqlConfig sqlConfig;

    /**
     * ID(サロゲートキー)指定で会員を取得
     *
     * @param customerId 会員ID
     * @return 会員情報
     * @throws DataAccessException
     */
    @Override
    @Transactional
    public Customer findById(Long customerId) throws DataAccessException{
        // コンフィグファイルからID指定のselect文を取得
        String sql = sqlConfig.getQuery("customer.selectById");

        // DB検索して会員レコードを取得 sql文にわたす値が複数ある場合は、Object[]{x, y,z} で渡す.
        Customer customer = jdbcTemplate.queryForObject(sql, new Object[]{customerId} , new CustomerRowMapper());

        return customer;
    }

    /**
     * すべての会員を取得
     *
     * @return すべての会員情報
     */
    @Override
    @Transactional
    public List<Customer> findAll(){
        String sql = sqlConfig.getQuery("customer.selectAll");

        List<Customer> customers;
        try {
            customers = jdbcTemplate.query(sql, new CustomerRowMapper());
        } catch (DataAccessException ex) {
            System.out.println("Error execute findAll(): " + ex.getMessage());
            return null;
        }

        return customers;
    }
}
