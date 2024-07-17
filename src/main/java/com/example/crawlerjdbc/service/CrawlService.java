package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.model.crawl.Crawl;

import java.util.List;

/**
 * クロール サービス
 */
public interface CrawlService {


    /**
     * 指定会員のクロール情報を全て取得します.
     *
     * @param customerId 顧客ID
     * @return クロール情報リスト
     */
    public List<Crawl> findAllByCustomerId(Long customerId);


    /**
     * 指定IDのクロール情報を取得します.
     *
     * @param id クロールID
     * @return クロール情報
     */
    public Crawl findById(Long id);

}
