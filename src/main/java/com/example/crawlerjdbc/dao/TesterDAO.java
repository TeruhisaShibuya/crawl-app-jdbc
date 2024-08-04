package com.example.crawlerjdbc.dao;

import com.example.crawlerjdbc.controller.dto.TesterFormDTO;
import com.example.crawlerjdbc.model.Tester;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TesterモデルをDTO・DAOパターンで練習用に登録する処理
 * DAOのクラスは @Repository を付与しても良い
 *
 * DAOは一般的に以下の流れになる
 * 1.DB接続(JDBCなど)
 * 2.SQL実行
 * 3.クエリの実行 及び 実行絵結果の取得
 *
 */
@Repository
public class TesterDAO {

    public Tester entry(TesterFormDTO dto) throws ClassNotFoundException, SQLException {

        // DB接続
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ts",
                "");

        // SQL実行
        PreparedStatement ps = connection.prepareStatement("INSERT INTO tester (name, age) values ('テスター名', 10);");
        ResultSet resultSet = ps.executeQuery();

        // 実行結果取得
        //Tester tester = null; ← この記述だとNullPointerになるのでダメ 以下のようにnewすること

        Tester tester = new Tester(); // nullからnew Tester()に変更
        while(resultSet.next()) {
            tester.setName(resultSet.getString("name"));
            tester.setAge(resultSet.getInt("age"));
        }
        return tester;
    }
}
