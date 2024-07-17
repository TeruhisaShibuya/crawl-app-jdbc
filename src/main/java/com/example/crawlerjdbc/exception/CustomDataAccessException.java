package com.example.crawlerjdbc.exception;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 独自例外クラス (DataAccessExceptionを模倣)
 * データアクセス時、springFrameWorkレイヤー (高レイヤーの例外) で生じた例外を管理するクラス
 *
 * キャッチ例)
 * 重複キー例外(DuplicateKeyException) キーの値が重複している時
 * ロック取得不能例外(CannotAcquireLockException) : 他のトランザクションがすでにリソースをををロックしている場合など
 */
@Getter(AccessLevel.PUBLIC)
public class CustomDataAccessException extends RuntimeException {

    /** エラーコード */
    //private String errorCode;

//    public CustomDataAccessException(String message, String errorCode) {
//        super(message);
//        this.errorCode = errorCode;
//    }

    public CustomDataAccessException(String errorCode) {
        super(errorCode);
    }
}
