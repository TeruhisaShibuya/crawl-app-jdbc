package com.example.crawlerjdbc.service.mapper;

import com.example.crawlerjdbc.model.crawl.Crawl;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * クロール マッパー
 * テーブルから取得した情報をクロールエンティティにマッピングします
 */
public class CrawlRowMapper implements RowMapper<Crawl>  {

    @Override
    public Crawl mapRow(ResultSet rs, int rowNum) throws SQLException {
        Crawl crawl = new Crawl();

        crawl.setId(rs.getLong("id"));
        crawl.setBrandName(rs.getString("brandName"));
        crawl.setItemCategory(rs.getString("itemCategory"));
        crawl.setSearchRange(rs.getString("searchRange"));
        crawl.setSex(rs.getString("sex"));
        crawl.setExchangeRate(rs.getInt("exchangeRate"));
        crawl.setItemPrice(rs.getInt("itemPrice"));
        crawl.setCurrency(rs.getString("currency"));
        crawl.setItemImage(rs.getString("itemImage"));
        crawl.setStatus(rs.getString("status"));
        crawl.setCustomerId(rs.getLong("customerId"));

        return crawl;
    }

}
