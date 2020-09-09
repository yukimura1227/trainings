# MEMO
## check your spiders
```
scrapy list
```

## execute crawling
```
# quotesは、scrapy listで確認できるspiderの名前です。他のspiderを作って実行したい場合は、quotes部分を変えてください
scrapy crawl quotes
# ex) scrapy crawl green

# 結果をjsonファイルに落とす場合
# ただし、注意が必要で、
# 歴史的な理由により、Scrapyはファイルの内容を上書きする代わりに、指定されたファイルに追加します。 2回目の前にファイルを削除せずにこのコマンドを2回実行すると、JSONファイルが壊れてしまいます。
scrapy crawl quotes -o quotes.json

# 結果をjson linesファイルに落とす場合
scrapy crawl quotes -o quotes.jl
```

## 参考情報
`scrapy shell` を使うと、rails console的な使い方ができる
```
scrapy shell 'http://quotes.toscrape.com'
```
