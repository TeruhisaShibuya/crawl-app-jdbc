package com.example.crawlerjdbc.controller.restcontroller;

/**
 * コントローラーの共通処理をまとめたもの
 */
public class AbstractController {

    /**
     * 引数で指定したURLにリダイレクトします
     *
     * @param pathString リダイレクトパス
     * @return リダイレクト先URL文字列
     */
    public String redirectTo(String pathString){
        return "redirect:" + pathString;
    }
}
