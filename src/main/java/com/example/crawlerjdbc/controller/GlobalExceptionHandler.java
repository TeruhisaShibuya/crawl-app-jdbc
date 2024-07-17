package com.example.crawlerjdbc.controller;

import com.example.crawlerjdbc.exception.CustomDataAccessException;
import com.example.crawlerjdbc.exception.CustomEmptyResultDataException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 例外発生時の処理を管理するクラス
 *
 * システム中で発生する各種例外処理に対する処理内容をまとめている
 * どの例外においても以下3点をエラー画面に渡します
 * HTTPステータス / 独自エラーコード / エラーが発生する直前に表示していた画面URL
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    // NoDataFoundException : id検索などを実施してもレコードが見つからない場合

    /**
     * データ取得例外
     * キー指定にも関わらずデータが取得不可能であった場合の処理
     *
     * @param ex カスタム例外
     * @param request リクエスト
     * @param modelAndView モデルビュー
     * @return モデルビュー
     */
    @ExceptionHandler(CustomEmptyResultDataException.class)
    public ModelAndView handleCustomEmptyResultDataException(CustomEmptyResultDataException ex
                                                   //HttpServletRequest request,
                                                   ) {
        ModelAndView modelAndView = new ModelAndView();

        // HTTPステータス / 独自エラーコード / 直前のリンク ３点の情報を添えてエラービューを返却する
        modelAndView.setViewName("error-view");
        modelAndView.addObject("httpStatus", HttpStatus.NOT_FOUND.value());
        modelAndView.addObject("errorCode", ex.getMessage());
        //modelAndView.addObject("previousLink", request.getHeader("Referer"));

        return modelAndView;
    }


    /**
     * データアクセス例外発生時の処理
     *
     * @param ex カスタム例外
     * @param request リクエスト
     * @param model モデル
     * @return エラー画面
     */
    @ExceptionHandler(CustomDataAccessException.class)
    public String handleCustomDataAccessException(CustomDataAccessException ex,
                                                  HttpServletRequest request,
                                                  Model model) {

        model.addAttribute("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("errorCode", ex.getMessage());
        model.addAttribute("previousLink", request.getHeader("Referer"));

        return "error-view";
    }
    }
