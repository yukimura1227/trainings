package yukimura.sample.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yukimura.sample.spring.di.Goods;
import yukimura.sample.spring.di.SearchGoodsService;


public class SpringSampleMain {
	public static void main(String[] args) {
		// Springの設定ファイルの読み込み
		ApplicationContext appContext = new ClassPathXmlApplicationContext("/spring/conf/applicationContext.xml");

		// SearchGoodsServiceを取得する（☆interfaceを指定するのみで、その実装本体ををソースで指定してない点に注目！！☆
		SearchGoodsService searchGoodsService = appContext.getBean(SearchGoodsService.class);

		// SearchGoodsServiceのexecuteServiceのメソッド呼び出し（実装クラスを一度もnewしていないが、何が動くのか？？）
		Goods goods = searchGoodsService.executeService();

		// 実行結果を見てみよう
		System.out.println(goods);

		System.out.println("どうでしたか？？？");
	}
}
