package com.example.crawlerjdbc.controller.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * テスト用のレストコントローラー
 * Posgre接続確認など
 *
 */
@RestController
@RequiredArgsConstructor // Autowiredの記述省略のため
@RequestMapping("/rest")
public class TestRestController {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    private final JdbcTemplate jdbcTemplate;


    /**
     * テストURL
     * http://localhost:8080/rest/index
     */
    @GetMapping("/index")
    public String index() {

        // Sql文章を作成.
        String sqlString = "select * from test_table";

        // `test_table` から値を取得する Mapで値の受取が可能
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sqlString);
        return list.toString();
    }

    /**
     * テストURL
     * http://localhost:8080/rest/test
     */
    @GetMapping("/test")
    public String selectFromTestTableById() {

        // Sql文章を作成.
        String sqlString = "select * from test_table where id = ?";

        // `test_table` から値を取得する Mapで値の受取が可能
        Map<String,Object> map = jdbcTemplate.queryForMap(sqlString, 2);
        return map.toString();
    }
}
