package com.example.crawlerjdbc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * SQLコンフィグ
 * sql.propertiesファイルの内容を読み込みjavaのオブジェクトにマッピングします
 *
 */
@Component
@PropertySource("classpath:sql/sql.properties") // resourcesディレクトリ配下にあるファイル名を指定
@RequiredArgsConstructor
public class SqlConfig {

    /** ファイルの読み込みに必要 */
    private final Environment environment;

    /**
     * 引数に応じたsql文をプロパティファイルから取得する
     *
     * @param key プロパティファイルに記述されたキー
     * @return
     */
    public String getQuery(String key) {
        return environment.getProperty(key);
    }
}
