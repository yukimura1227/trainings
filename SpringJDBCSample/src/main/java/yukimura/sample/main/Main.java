package yukimura.sample.main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import yukimura.sample.dao.SampleDaoWithJdbcTemplate;
import yukimura.sample.bean.BookInfo;

public class Main {
	private static final String TARGET_TABLE_NAME = "book_info";
	private static final String[] COLUMNS = {"isbn","title","author","price","publish","published_date"};

	private static final RowMapper<BookInfo> rowMapper = new RowMapper<BookInfo>() {
		@Override
		public BookInfo mapRow(ResultSet resultset, int i) throws SQLException {
			BookInfo bookInfo = new BookInfo();
			bookInfo.setIsbn         ( resultset.getString("isbn") );
			bookInfo.setTitle        ( resultset.getString("title") );
			bookInfo.setPrice        ( resultset.getInt   ("price") );
			bookInfo.setAuthor       ( resultset.getString("author") );
			bookInfo.setPublish      ( resultset.getString("publish") );
			bookInfo.setPublishedDate( resultset.getDate  ("published_date") );

			return bookInfo;
		}

	};

	public static void main(String[] args) {
		System.out.println("処理開始");
		// Springの設定ファイルの読み込み
		ApplicationContext appContext = new ClassPathXmlApplicationContext("/sample/config/applicationContext.xml");

		// JdbcTemplateを使ったdaoを取得
		SampleDaoWithJdbcTemplate daoWithJdbcTemplate = appContext.getBean(SampleDaoWithJdbcTemplate.class);

		// select count(*) を行う例。
		System.out.println("サンプル１");
		int bookCnt = daoWithJdbcTemplate.count(TARGET_TABLE_NAME);
		System.out.println(bookCnt);

		// 単一カラムを取得する例（String型）
		System.out.println("サンプル２");
		String isbn = daoWithJdbcTemplate.select2SimpleObject("isbn", String.class, TARGET_TABLE_NAME);
		System.out.println(isbn);

		// 単一カラムを取得する例（Date型）
		System.out.println("サンプル３");
		Date date  = daoWithJdbcTemplate.select2SimpleObject("now()", Date.class, TARGET_TABLE_NAME);
		System.out.println(date);

		// 複数カラムを取得する例（Map型）
		System.out.println("サンプル４");
		Map<String,Object> resultMap = daoWithJdbcTemplate.select2Map(COLUMNS, TARGET_TABLE_NAME);
		System.out.println(resultMap);

		// 複数カラムを取得する例（rowMapperを利用して、任意の型（この例は、独自クラスのBookInfo）
		System.out.println("サンプル５");
		BookInfo bookInfo = daoWithJdbcTemplate.select2Object(COLUMNS, rowMapper, TARGET_TABLE_NAME);
		System.out.println(bookInfo);

		// 複数カラム・複数レコードを取得する例（rowMapperを利用して、任意の型（この例は、独自クラスのBookInfo）
		System.out.println("サンプル６");
		List<BookInfo> bookInfoList = daoWithJdbcTemplate.select2ObjectList(COLUMNS, rowMapper, TARGET_TABLE_NAME);
		printOutList(bookInfoList);

		// 直２つ上のRowMapperをSpringが提供するBeanPropertyRowMapperにした版
		System.out.println("サンプル７");
		RowMapper<BookInfo> bpRowMapper = new BeanPropertyRowMapper<BookInfo>(BookInfo.class);
		BookInfo bookInfo2 = daoWithJdbcTemplate.select2Object(COLUMNS, bpRowMapper, TARGET_TABLE_NAME);
		System.out.println(bookInfo2);

		// 直２つ上のRowMapperをSpringが提供するBeanPropertyRowMapperにした版
		System.out.println("サンプル８");
		List<BookInfo> bookInfoList2 = daoWithJdbcTemplate.select2ObjectList(COLUMNS, bpRowMapper, TARGET_TABLE_NAME);
		printOutList(bookInfoList2);

		// 複数カラム、複数レコードを取得する例（MapのList）
		System.out.println("サンプル９");
		List<Map<String,Object>> resultList = daoWithJdbcTemplate.select2MapList(COLUMNS, TARGET_TABLE_NAME);
		printOutList(resultList);

		// 複数カラム、単一レコードを取得する例（Stringの例）
		System.out.println("サンプル１０");
		List<String> resultList2 = daoWithJdbcTemplate.select2SimpleObjectList("isbn", String.class, TARGET_TABLE_NAME);
		printOutList(resultList2);

		// 以下は、insert,update,deleteのサンプルです！！！

		// INSERT実行
		System.out.println("INSERT実行");
		daoWithJdbcTemplate.insert("INSERT INTO " + TARGET_TABLE_NAME + " VALUES (?,?,?,?,?,?)", "ISBN","TITLE","AUTHOR",300,"PUBLISH","2012-12-05");
		printOutList(daoWithJdbcTemplate.select2ObjectList(COLUMNS, bpRowMapper, TARGET_TABLE_NAME));

		// UPDATE実行
		System.out.println("UPDATE実行");
		daoWithJdbcTemplate.update("UPDATE " + TARGET_TABLE_NAME + " SET TITLE = ?, PRICE = ? WHERE ISBN = ?", "TITLE_UPDATE",300,"ISBN");
		printOutList(daoWithJdbcTemplate.select2ObjectList(COLUMNS, bpRowMapper, TARGET_TABLE_NAME));

		// DELETE実行
		System.out.println("DELETE実行");
		daoWithJdbcTemplate.delete("DELETE FROM " + TARGET_TABLE_NAME + " WHERE ISBN = ?","ISBN");
		printOutList(daoWithJdbcTemplate.select2ObjectList(COLUMNS, bpRowMapper, TARGET_TABLE_NAME));


	}

	private static <T> void printOutList(List<T> list) {
		for( T target : list ) {
			System.out.println(target);
		}
	}

}
