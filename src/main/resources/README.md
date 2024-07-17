# 日本語化の仕組み
以下の実装を行うことで、日本語メッセージ表示用のファイルを読み込み、ファイルに記述したメッセージをオブジェクトとして扱うことが可能

1.application.propertiesで読み込むプロパティファイルの名前を以下のように指定する
2.日本語メッセージが必要なクラス内で、「MessageSource」クラスを@AutoWiredする
3.messageSource.getKey("キー名") で日本語メッセージ(値を取得可能)

手順1でのpropertiesファイルに対する記述は以下のとおり
------------------------------------------
# 読み込むプロパティファイルの設定
spring.messages.basename=messages_ja
spring.messages.locale=ja
------------------------------------------

