# 本アプリの概要
BUYMA用のクローラーアプリを、jdbcドライパを使用した構成で作っています。



## アプリ起動方法
ローカルのposgreSQLを立ち上げた状態で本アプリを起動してください。
posgreSQLが立ち上がっていない場合、DBのコネクションに失敗して立ち上げエラーとなります。

## posgreSQLコマンド一覧
### 1.サーバ起動
postgres -D /usr/local/var/postgres

### 2.posgreSQLログイン
psql -d postgres

### 3.DB選択
\c crawldb;


## DB一覧
crawldbを使用してください

tspc:~ ts$ psql -l
-----------+-------+----------+-------------+-------------+-------------------
crawldb   | ts    | UTF8     | ja_JP.UTF-8 | ja_JP.UTF-8 |
postgres  | ts    | UTF8     | ja_JP.UTF-8 | ja_JP.UTF-8 |
template0 | ts    | UTF8     | ja_JP.UTF-8 | ja_JP.UTF-8 | =c/ts            +
|       |          |             |             | ts=CTc/ts
template1 | ts    | UTF8     | ja_JP.UTF-8 | ja_JP.UTF-8 | =c/ts            +
|       |          |             |             | ts=CTc/ts
test_db   | tuser | UTF8     | ja_JP.UTF-8 | ja_JP.UTF-8 |



## テーブル一覧
customer と tester の2つを利用しています

crawldb=# \dt;
List of relations
Schema |    Name    | Type  | Owner
--------+------------+-------+-------
public | customer   | table | ts
public | test_table | table | ts
public | tester     | table | ts