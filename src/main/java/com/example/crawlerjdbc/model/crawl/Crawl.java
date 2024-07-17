package com.example.crawlerjdbc.model.crawl;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.net.URL;

/**
 * クロール情報
 *
 * OneToManyのオプションについては以下のリンクを参照のこと
 * <a href="https://itpfdoc.hitachi.co.jp/manuals/link/cosmi_v0870/APR4/EU260088.HTM#ID00376">OneToMany解説</a>
 *
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Crawl {

    @Id
    private Long id;

    /** ブランド名 */
    // enum型のフィールドの場合、定義されていない値が送信されると`null`扱いになる
    @NotNull
    private String brandName;

    /** カテゴリ名 */
    @NotNull
    private String itemCategory;

    /** 検索範囲 */
    private String searchRange;

    /** 性別 */
    private String sex;

    /** 為替レート */
    @Min(0)
    @Max(999)
    private Integer exchangeRate;

    /** 商品価格 */
    @NotNull
    @Min(0)
    @Max(99999)
    private Integer itemPrice;

    /** 価格単位 */
    @NotNull
    private String currency;

    /** 商品画像 */
    private String itemImage;

    /** 実行ステータス */
    @NotNull
    private String status;

    // -- 以下外部キー関連のカラム

    /** FK `会員情報` に対して `多対一` の関係 */
    @NotNull
    private Long customerId;
}
