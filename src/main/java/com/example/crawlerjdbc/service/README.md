# 例外処理の実装に関して

## 実装における基本方針
controllerクラスで ［try〜catch］ 構文を記述すると、記述頻度が非常に多くメンテンナス性が低い。
これを避けるために［@ControllerAdvice］アノテーションを利用した例外処理専用のクラスを作り、
このクラスのみで例外発生時の処理を管理することにした。

## 実装手順
1.サービスクラス内にて、アプリ独自のエラーコードを添えた形式で各種例外をスロー
2.アプリ独自のエラーコードを引数に添えて例外をスローできるように、既存の例外クラスをカスタムした独自例外クラスを作成
  （既存のDataAccessExceptionクラスなどをカスタム）
2.1で発生した例外を try〜catchの記述無しで処理するため、@ControllerAdviceアノテーションを利用した［GlobalExceptionHandler］クラスを作成
3.Serviceクラス内でスローされる例外の種類に応じた処理を、GlobalExceptionHandlerクラス内に記述する
  (今回の開発ではCustomDataAccessExceptionなどの独自例外クラスに対する処理を記述している)

上記手順で実装することで、コントローラクラスでのtry〜catch構文を排除した。




# 独自の例外クラスの実装に関して

## 実装理由
エラーが生じた際、問題の解決を効率的に行うため、例外発生時にWEBアプリ独自のエラーコードを付与することにした。
ログに出力されたエラーコードを元に、エラーコードの一覧表を確認することで、どの部位でエラーが生じたかすぐに把握できるようにしている。

## 独自例外クラスの種類
1.CustomEmptyResultDataException
  既存のEmptyResultDataExceptionを模倣した独自クラス
2.CustomDataAccessException
  既存のDataAccessExceptionを模倣した独自クラス




# エラーページの表示内容に関して
メンテナンス性とユーザビリティの観点から、以下の情報を画面に表示する仕様とした

1.HTTPステータスコード
2.WEBアプリの独自エラーコード
3.エラーが発生する直前の画面に戻れるボタン

## 実装手順
1.例外発生時に表示する［error-view.html］を作成
(ファイル名にハイフンを使用しているのはURLフレンドリーの観点から)
2.例外発生時の処理内容を［GlobalExceptionHandler］クラスに記述。記述形式は例外の種類ごとに記載する形式である。

## 実装詳細
エラーページの表示する3点の情報を取得する方法を以下に記載

1.HTTPステータスコードの取得
  HttpStatusクラスの定数を使用。  例）HttpStatus.NOT_FOUND.value()
2.独自エラーコード情報の取得
  独自例外クラスのインスタンスに対してゲッターを使用。  例) customException.getErrorCode();
3.ボタンリンクURLの取得
  HttpServletRequestクラスのインスタンスに対して getHeader("Referer")メソッドを使用


