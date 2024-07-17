package com.example.crawlerjdbc.model.crawl;

import lombok.Getter;

/**
 * 通貨単位
 */
@Getter
public enum Currency {

    EURO("ユーロ"),
    DOLLAR("ドル"),
    POND("ポンド");

    /** フィールド */
    private String displayName;

    /** コンストラクタ */
    private Currency(String displayName) {
        this.displayName = displayName;
    }
}