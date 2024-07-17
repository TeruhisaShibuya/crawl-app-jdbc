package com.example.crawlerjdbc.controller;

import com.example.crawlerjdbc.model.common.SearchRange;
import com.example.crawlerjdbc.model.crawl.Currency;
import com.example.crawlerjdbc.model.crawl.ItemCategory;
import com.example.crawlerjdbc.model.crawl.Sex;
import com.example.crawlerjdbc.model.crawl.BrandName;
import com.example.crawlerjdbc.model.crawl.Crawl;
import com.example.crawlerjdbc.model.Customer;
import com.example.crawlerjdbc.service.CrawlService;
import com.example.crawlerjdbc.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/crawl")
@RequiredArgsConstructor
public class CrawlController {

    public final CustomerService customerService;
    public final CrawlService crawlService;

    /**
     * クロール一覧画面を表示します
     * http://localhost:8080/crawl/1/list
     *
     * @param customerId 会員ID(サロゲートキー)
     * @param model モデル
     * @return クロール一覧画面
     */
    @GetMapping("/{CUSTOMER_ID}/list")
    public String showList(@PathVariable("CUSTOMER_ID") Long customerId,
                           Model model) {

        // 会員情報の取得
        Customer customer = customerService.findById(customerId);
        // 会員情報をフロントに渡す
        model.addAttribute("customer", customer);

        // 対象会員のクロール情報も全て取得
        List<Crawl> crawlList = crawlService.findAllByCustomerId(customerId);


        model.addAttribute("crawlList", crawlList);

        return "crawl/list";
    }


    /**
     * クロール情報登録画面を表示します.
     * http://localhost:8080/crawl/1/entry
     *
     * 例外処理の確認URL
     *
     * @param customerId
     * @param model
     * @return
     */
    @GetMapping("/{CUSTOMER_ID}/entry")
    public String showEntry(@PathVariable("CUSTOMER_ID") Long customerId,
                             Model model) {

        // フォーム入力に必要な値をmodelに詰める
        // ブランド名 / カテゴリ / 検索範囲 / 単位
        model.addAttribute("brandNames", BrandName.values());
        model.addAttribute("searchRanges", SearchRange.values());
        model.addAttribute("sexList", Sex.values());
        model.addAttribute("itemCategories", ItemCategory.values());
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("payload", new CrawlForm());

        return "crawl/entry";
    }


    /**
     * クロール情報を登録します
     * http://localhost:8080/crawl/1/entry
     *
     * @param customerId 会員ID
     * @param form 検索フォーム
     * @param bindingResult バリデーション結果
     * @param model モデル
     * @return 検索一覧画面
     */
    @PostMapping("/{CUSTOMER_ID}/entry")
    public String entry(@PathVariable("CUSTOMER_ID") Long customerId,
                         // MEMO フォームのクラス名と th:objectの変数名が異なる場合、@ModelAttributeの後に変数名を指定しないとバリデーションエラー時にviewが表示できずにエラーとなるので注意
                         @Valid @ModelAttribute("payload") CrawlForm form,
                         BindingResult bindingResult,
                         Model model) {

        if (bindingResult.hasErrors()) {
            // 入力内容に問題がある場合はフォーム画面に戻る.
            return "crawl/entry";
        }

        // 会員会員情報を取得する.
        Customer customer = customerService.findById(customerId);

        // クロール情報を保存する
//        crawlService.register(customer.get(), form);
//
//        // 検索一覧画面にリダイレクト
//        return redirectTo("/crawl/{CUSTOMER_ID}/list"
//                .replaceFirst("\\{CUSTOMER_ID}", customerId.toString()));
        return "crawl/list";
    }
}
