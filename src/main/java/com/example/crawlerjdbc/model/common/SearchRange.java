package com.example.crawlerjdbc.model.common;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 店舗検索範囲
 */
@Getter(AccessLevel.PUBLIC)
//@RequiredArgsConstructor
public enum SearchRange {

    VIP("VIPカテゴリ"),
    NORMAL("ノーマルカテゴリ"),
    HIGH("ハイプライスカテゴリ");

    private String displayName;

    private SearchRange(String displayName){
        this.displayName = displayName;
    }
}
