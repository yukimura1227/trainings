package yukimura.sample.spring.di;

import org.springframework.stereotype.Component;

@Component
public class GoodsDaoImpl implements GoodsDao {

    @Override
    public Goods searchGoods() {
        System.out.println("GoodsDaoImplのsearchGoods()の呼び出しです。");
        return new Goods("test", 333);

    }


}
