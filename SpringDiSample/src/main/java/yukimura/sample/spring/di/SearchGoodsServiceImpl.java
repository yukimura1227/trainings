package yukimura.sample.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yukimura.sample.spring.di.GoodsDao;
import yukimura.sample.spring.di.Goods;

@Component
public class SearchGoodsServiceImpl implements SearchGoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Override
	public Goods executeService() {

		System.out.println("SearchGoodsServiceImplのexecuteService()の呼び出しです。");

		// productDaoのインスタンスを生成していないのにproductDaoのインスタンスメソッドを呼び出していることに注目！！！
		return goodsDao.searchGoods();
	}

}
