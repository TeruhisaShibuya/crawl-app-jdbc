package com.example.crawlerjdbc.controller;

import com.example.crawlerjdbc.model.common.SearchRange;
import com.example.crawlerjdbc.model.crawl.BrandName;
import com.example.crawlerjdbc.model.crawl.Currency;
import com.example.crawlerjdbc.model.crawl.ItemCategory;
import com.example.crawlerjdbc.model.crawl.Sex;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * クロール フォーム
 * <p>
 * バリデーションエラー時のテキストは `messages_ja.properties` ファイルを参照
 * </p>
 *
 */
@Data
public class CrawlForm {

    /** ブランド名 */
    // enum型のフィールドの場合、定義されていない値が送信されると`null`扱いになる
    @NotNull
    private BrandName brandName;

    /** 検索範囲 */
    private SearchRange searchRange;

    /** 性別 */
    @NotNull
    private Sex sex;

    /** カテゴリ名 */
    @NotNull
    private ItemCategory itemCategory;

    /** 為替レート */
    @Min(0)
    @Max(999)
    private Integer exchangeRate;

    /** 商品価格 */
    // エラーとして表示するメッセージのカスタムが可能 {0} でフィールド名(itemPrice)が表示される
    //@NotNull(message = "{0}は必ず選択してください")
    @NotNull
    @Min(0)
    @Max(99999)
    private Integer itemPrice;

    /** 価格単位 */
    @NotNull
    private Currency currency;

    /** 商品画像 */
    private MultipartFile itemImage;
}