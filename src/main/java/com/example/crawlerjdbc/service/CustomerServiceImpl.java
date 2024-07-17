package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.config.ErrorConfig;
import com.example.crawlerjdbc.config.SqlConfig;
import com.example.crawlerjdbc.exception.CustomDataAccessException;
import com.example.crawlerjdbc.model.Customer;
//import com.example.crawlerjdbc.service.mapper.CustomerRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    /** ロガー */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** sqlプロパティの内容をオブジェクト化したインスタンス */
    private final SqlConfig sqlConfig;

    /** エラーメッセージを管理するプロパティファイルをオブジェクト化したインスタンス */
    private final ErrorConfig errorConfig;

    /** 日本語メッセージを表示するためのインスタンス(messages_jaファイル) */
    private final MessageSource messageSource;


    // --


    /** DBアクセス用インスタンス */
    private final JdbcTemplate jdbcTemplate;




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
            // データ取得時に例外が発生した場合の例外処理
            logger.error(errorConfig.getError("message.customer.findAll") + errorConfig.getError("code.customer.findAll.dataAccess"));
            throw new CustomDataAccessException(errorConfig.getError("code.customer.findAll.dataAccess"));
        }

        return customers;
    }


    /**
     * ID(サロゲートキー)指定で会員を取得
     r
     * @param customerId 会員ID
     * @return 会員情報
     * @throws DataAccessException
     */
    @Override
    @Transactional
    public Customer findById(Long customerId) {
        // コンフィグファイルからID指定のselect文を取得
        String sql = sqlConfig.getQuery("customer.selectById");

        // DB検索して会員レコードを取得 sql文にわたす値が複数ある場合は、Object[]{x, y,z} で渡す.
        Customer customer = null;
        try {
            customer = jdbcTemplate.queryForObject(sql, new Object[]{customerId} , new CustomerRowMapper());

            // queryForObjectメソッドは取得が0件でも例外をスローしない. よってif文で対応
            if (customer == null) {
                logger.error(errorConfig.getError("message.customer.findById") + errorConfig.getError("code.customer.findById"));
                throw new CustomDataAccessException(errorConfig.getError("code.customer.findById"));
            }

        } catch(DataAccessException ex) {
            // DBアクセス中に `jdbc関連` `springframework関連` それぞれのDBアクセスエラーが生じた場合の例外処理
            // なお、SQLExceptionでは例外をキャッチできない. DataAccessExceptionにラップされてスローされるため、DataAccessExceptionで全ての例外お取得することになる.
            logger.error(errorConfig.getError("message.customer.findById") + errorConfig.getError("code.customer.findById.dataAccess"));
            throw new CustomDataAccessException(errorConfig.getError("code.customer.findById.dataAccess"));
        }

        return customer;
    }

    /**
     * rowMapperクラスは別のクラスで使用しないはずなので、インナークラスとして記述しても問題なさそう
     */
    private class CustomerRowMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();

            try {
                customer.setId(rs.getLong("id"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            customer.setEmail(rs.getString("email"));
            customer.setPassword(rs.getString("password"));
            customer.setName(rs.getString("name"));
            customer.setRole(rs.getString("role"));

            return customer;
        }
    }
}