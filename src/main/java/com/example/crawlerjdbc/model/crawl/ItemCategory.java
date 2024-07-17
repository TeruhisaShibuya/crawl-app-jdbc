package com.example.crawlerjdbc.model.crawl;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 商品カテゴリ
 */
@Getter(AccessLevel.PUBLIC)
//@RequiredArgsConstructor
public enum ItemCategory {

    CLOTHING("服"),
    SHOES("靴"),
    BAG("バッグ"),
    ACCESSORY("アクセサリー"),
    ALL("すべて");

    private String displayName;

    private ItemCategory(String displayName){
        this.displayName = displayName;
    }
}
