package com.example.crawlerjdbc.model.crawl;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 性別（商品に関する）
 */
@Getter(AccessLevel.PUBLIC)
public enum Sex {

    MAN("メンズ"),
    WOMAN("ウィメンズ"),
    UNISEX("ユニセックス");

    private String displayName;

    private Sex(String displayName){
        this.displayName = displayName;
    }
}
