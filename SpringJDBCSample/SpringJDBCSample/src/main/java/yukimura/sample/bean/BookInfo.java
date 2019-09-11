package yukimura.sample.bean;

import java.sql.Date;


public class BookInfo{
	public BookInfo() {
	}
	private String isbn;
	private String title;
	private String author;
	private int    price;
	private String publish;
	private Date   publishedDate;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	@Override
	public String toString() {
		return "isbn:" + isbn + " title:" + title + " author:" + author + " price:" + price +
				" publish:" + publish + " published_date:" + publishedDate;
	}


}
