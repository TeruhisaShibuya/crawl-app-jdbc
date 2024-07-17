package com.example.crawlerjdbc.controller;

import com.example.crawlerjdbc.model.Customer;
import com.example.crawlerjdbc.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    /**
     * 会員一覧画面を表示します
     *
     * http://localhost:8080/customer/list
     *
     * @param model モデル
     * @return 会員一覧画面
     */
    @GetMapping("/list")
    public String showList(Model model) {

        // 会員情報を全て取得する
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);

        return "customer/list";
    }


    /**
     * 会員情報詳細画面を表示します
     *
     * http://localhost:8080/customer/1/detail
     *
     * 例外処理の確認
     * http://localhost:8080/customer/10/detail
     *
     * @param customerId 会員ID(サロゲートキー)
     * @param model モデル
     * @return 会員詳細画面
     */
    @GetMapping("/{ID}/detail")
    public String showDetail(@PathVariable("ID") Long customerId,
                             Model model) {

        // 対象の会員情報を取得する
        Customer customer = customerService.findById(customerId);

        // 対象の会員情報をフロントへ返却
        model.addAttribute("customer", customer);

        return "customer/detail";
    }

    /**
     *
     * http://localhost:8080/customer/test
     *
     * @param customerId
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "customer/test";
    }

}

