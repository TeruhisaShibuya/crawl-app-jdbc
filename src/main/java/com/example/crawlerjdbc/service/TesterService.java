package com.example.crawlerjdbc.service;

import com.example.crawlerjdbc.controller.dto.TesterFormDTO;

/**
 * DTO・DAOパターンテスト用のService
 */
public interface TesterService {

    /**
     * 引数にDTOを指定した登録メソッド
     */
     public void entry(TesterFormDTO dto);

}
