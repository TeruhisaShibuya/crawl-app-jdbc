//package com.example.crawlerjdbc.service.mapper;
//
//import com.example.crawlerjdbc.model.Customer;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * 会員 マッパー
// * テーブルから取得した情報を会員エンティティにマッピングします
// */
//public class CustomerRowMapper implements RowMapper<Customer> {
//
//    @Override
//    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Customer customer = new Customer();
//
//        try {
//            customer.setId(rs.getLong("id"));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        customer.setEmail(rs.getString("email"));
//        customer.setPassword(rs.getString("password"));
//        customer.setName(rs.getString("name"));
//        customer.setRole(rs.getString("role"));
//
//        return customer;
//    }
//}
