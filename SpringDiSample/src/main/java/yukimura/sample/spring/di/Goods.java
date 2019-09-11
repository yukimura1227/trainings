package yukimura.sample.spring.di;

/**
 * 製品
 */
public class Goods {
	private String name;
	private int price;

	public Goods(String name,int price) {
		this.name  = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Goods name=" + this.name + ", price=" + this.price ;
	}

}
