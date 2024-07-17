package com.example.crawlerjdbc.model.crawl;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 店舗ランク
 * 各enumのname値は、shopテーブルの各ブランドカラムの名前と一致している必要があるので注意が必要
 */
@Getter(AccessLevel.PUBLIC)
//@RequiredArgsConstructor
public enum BrandName {

    // enumの値をそのまま出力するには `name()` メソッドを使用する
    // name要素はそのままDBのカラムに格納される値になるので注意.
//    ALEXANDER_MCQUEEN("A1", "Alexander Maqueen"),
//    BURBERRY("B1", "Burberry"),
//    BOTTEGA_VENETA("B2", "Bottega Veneta");

    ALEXANDER_MCQUEEN("A1", "Alexander Maqueen", "alexanderMaqueen"),
    BURBERRY("B1", "Burberry", "burberry"),
    BOTTEGA_VENETA("B2", "Bottega Veneta", "bottegaVeneta");


    private String brandCode;

    private String displayName;

    private String columnName;

    private BrandName(String brandCode, String displayName, String columnName){
        this.brandCode = brandCode;
        this.displayName = displayName;
        this.columnName = columnName;
    }
}
