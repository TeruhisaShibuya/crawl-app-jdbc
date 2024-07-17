package com.example.crawlerjdbc.exception;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 独自例外クラス (EmptyResultDataExceptionを模倣)
 *
 * データが1件も取得できなかった場合、本アプリケーション独自の `エラーコード` 付きで例外をスロー可能
 * 必ずデータが取得されるべき状況で取得に失敗した時に使用します
 */
@Getter(AccessLevel.PUBLIC)
public class CustomEmptyResultDataException extends RuntimeException {

    /** 独自エラーコード */
    //private String errorCode;

    /** コンストラクタ */
//    public CustomEmptyResultDataException(String message, String errorCode) {
//        super(message);
//        this.errorCode = errorCode;
//    }

    // getterは省略

    public CustomEmptyResultDataException(String errorCode) {
        super(errorCode);
    }
}
