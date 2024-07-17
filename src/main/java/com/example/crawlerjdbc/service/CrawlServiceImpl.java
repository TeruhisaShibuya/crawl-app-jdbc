package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.config.SqlConfig;
import com.example.crawlerjdbc.exception.CustomDataAccessException;
import com.example.crawlerjdbc.exception.CustomEmptyResultDataException;
import com.example.crawlerjdbc.model.crawl.Crawl;
import com.example.crawlerjdbc.service.mapper.CrawlRowMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * クロール サービス実装
 */
@Service
@RequiredArgsConstructor
public class CrawlServiceImpl implements CrawlService {

    /** ロガー */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** エラーコードコード出力用インスタンス */
    private final Environment propertySource;

    /** sqlプロパティの内容をオブジェクト化したインスタンス */
    private final SqlConfig sqlConfig;

    /** DBアクセス用インスタンス */
    private final JdbcTemplate jdbcTemplate;



    @Override
    @Transactional
    public List<Crawl> findAllByCustomerId(Long customerId) {
        String sql = sqlConfig.getQuery("crawl.selectAllByCustomerId");
        // 0件の場合は ifからの throw new
        List<Crawl> crawlList = jdbcTemplate.query(sql, new Object[]{customerId} ,new CrawlRowMapper());
        return crawlList;
    }


    /**
     * 指定IDのクロール情報を取得します.
     *
     * @param id クロールID
     * @return クロール情報
     */
    @Override
    @Transactional
    public Crawl findById(Long id) {
        String sql = sqlConfig.getQuery("crawl.selectById");

        Crawl crawl;
        try {
            crawl = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CrawlRowMapper());

            // queryForObjectメソッドは取得が0件でも例外をスローしない. よってif文で対応
            if (Objects.isNull(crawl)) {
                // 独自例外クラス(データ0件)
                throw new CustomEmptyResultDataException(propertySource.getProperty(""));
            }

        } catch (DataAccessException de) {
            throw new CustomDataAccessException(propertySource.getProperty(""));
        }

        return crawl;
    }
}