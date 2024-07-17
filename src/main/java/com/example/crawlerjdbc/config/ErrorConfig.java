package com.example.crawlerjdbc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:error.properties") // resourcesディレクトリ配下にあるファイル名を指定
@RequiredArgsConstructor
public class ErrorConfig {

    /** ファイルの読み込みに必要 */
    private final Environment environment;

    /**
     * 引数に応じたsql文をプロパティファイルから取得する
     *
     * @param key プロパティファイルに記述されたキー
     * @return
     */
    public String getError(String key) {
        return environment.getProperty(key);
    }

}
