/**
 * SQLExceptionは try catch句では使用しない
 * SQLExceptionが発生した場合、サブクラスのDataAccessExceptionでラップして投げてくる
 * 理由からSQLExceptionではそもそも例外をキャッチできない
 */

//package com.example.crawlerjdbc.exception;
//
//import lombok.AccessLevel;
//import lombok.Getter;
//
///**
// * 独自例外クラス (SQLExceptionを模倣)
// * jdbcレベルの例外 (低レイヤーの例外) を本アプリケーション独自の `エラーコード` 付きでスロー可能
// *
// * キャッチ例)
// * データベースサーバーとの通信エラー / SQL構文エラー / データベース制約違反 ...など
// * SQL構文エラーは、DataAccessExceptionだと具体的な構文エラーを明らかにできないケースあり
// */
//@Getter(AccessLevel.PUBLIC)
//public class CustomSqlException extends RuntimeException {
//
//    /** 独自エラーコード */
//    private String errorCode;
//
//
//    /** コンストラクタ */
//    public CustomSqlException(String message, String errorCode) {
//        super(message);
//        this.errorCode = errorCode;
//    }
//
//    // getterは省略
//}