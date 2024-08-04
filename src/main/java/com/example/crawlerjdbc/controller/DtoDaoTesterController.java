package com.example.crawlerjdbc.controller;

import com.example.crawlerjdbc.controller.dto.TesterFormDTO;
import com.example.crawlerjdbc.controller.restcontroller.AbstractController;
import com.example.crawlerjdbc.service.TesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DTOとDAOと利用したMVC処理のテストを行うためのコントローラーです
 */
@Controller
@RequestMapping("/tester")
@RequiredArgsConstructor
public class DtoDaoTesterController extends AbstractController {

    private final TesterService testerService;




    /**
     * DTO・DAO練習パターンの登録画面を表示する.
     *
     * @return
     */
    @GetMapping("/entry")
    public String showEntry(Model model){

        model.addAttribute("payload", new TesterFormDTO());

        return "tester/entry";
    }


    /**
     * DTO・DAOパターンの登録処理を行う
     *
     * @param model
     * @return
     */
    @PostMapping("/entry")
    public String entry(Model model){

        // 登録処理の呼び出し




        return redirectTo("/tester/entry");
    }




}
