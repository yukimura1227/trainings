package yukimura.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDaoWithJdbcTemplate {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String SELECT_SINGLE_LECORD_TEMPLATE = "select %s from %s LIMIT 0,1";
	private static final String SELECT_MULTI_RECORD_TEMPLATE  = "select %s from %s";

	/**
	 * 特定テーブルのカウントを取得する。
	 * （jdbcTemplateのqueryForIntのSample）
	 * @param tableName
	 * @return
	 */
	public int count(String tableName) {
		return jdbcTemplate.queryForObject("select count(*) from " + tableName,Integer.class);
	}


	/**
	 * 特定テーブルの特定カラムを取得する。
	 * 複数件とれた場合は、1件目を評価する。
	 * ※第一オペランドで指定したカラムの型に対応する、javaのクラス型を第二オペランドに指定する。
	 * （queryForObjectのサンプルその１）
	 *
	 * @param targetColumn
	 * @param targetColumnType
	 * @param tableName
	 * @return
	 */
	public <T> T select2SimpleObject(String targetColumn, Class<T> targetColumnType,String tableName) {
		final String sql = String.format(SELECT_SINGLE_LECORD_TEMPLATE, targetColumn,tableName);
		return jdbcTemplate.queryForObject(sql, targetColumnType);
	}


	/**
	 * 特定テーブルから、第一引数で指定したカラムを取得する。
	 * 複数件とれた場合は、1件目を評価する。
	 * ※第一オペランドで指定したカラムの型を、独自のjavaオブジェクトに変換するためのRowMapperを第二オペランドに指定する。
	 * （queryForObjectのサンプルその２）
	 * @param targetColumnArray
	 * @param rowMapper
	 * @param tableName
	 * @return
	 */
	public <T> T select2Object(String[] targetColumnArray, RowMapper<T> rowMapper, String tableName) {
		final String sql = String.format(SELECT_SINGLE_LECORD_TEMPLATE, str2Csv(targetColumnArray),tableName);
		return jdbcTemplate.queryForObject(sql, rowMapper);
	}

//	public <T> T select2Object(String[] targetColumnArray, BeanPropertyRowMapper<T> rowMapper, String tableName) {
//		final String sql = String.format(SELECT_SINGLE_LECORD_TEMPLATE, str2Csv(targetColumnArray),tableName);
//		return jdbcTemplate.queryForObject(sql, rowMapper);
//	}

	/**
	 * 特定テーブルから、第一引数で指定したカラムを取得する。
	 * ※第一オペランドで指定したカラムの型を、独自のjavaオブジェクトに変換するためのRowMapperを第二オペランドに指定する。
	 * （queryのSample）
	 * @param targetColumnArray
	 * @param rowMapper
	 * @param tableName
	 * @return
	 */
	public <T> List<T> select2ObjectList(String[] targetColumnArray, RowMapper<T> rowMapper,String tableName) {
		final String sql = String.format(SELECT_MULTI_RECORD_TEMPLATE, str2Csv(targetColumnArray),tableName);
		return jdbcTemplate.query(sql, rowMapper);
	}


	/**
	 * 特定テーブルから、第一引数で指定したカラムを取得する。
	 * 複数件とれた場合は、1件目を評価する。
	 * （queryForMapのサンプル）
	 * @param targetColumnArray
	 * @param tableName
	 * @return
	 */
	public Map<String, Object> select2Map(String[] targetColumnArray, String tableName) {
		final String sql = String.format(SELECT_SINGLE_LECORD_TEMPLATE, str2Csv(targetColumnArray),tableName);
		return jdbcTemplate.queryForMap(sql);
	}


	/**
	 * 特定テーブルから、第一引数で指定したカラムを取得する。
	 * （queryForListのSampleその１）
	 * @param targetColumnArray
	 * @param tableName
	 * @return
	 */
	public List<Map<String, Object>> select2MapList(String[] targetColumnArray, String tableName) {
		final String sql = String.format(SELECT_MULTI_RECORD_TEMPLATE, str2Csv(targetColumnArray),tableName);
		return jdbcTemplate.queryForList(sql);
	}


	/**
	 * 特定テーブルから、第一引数で指定した特定カラムを取得する。
	 * （queryForListのSampleその２）
	 * @param targetColumn
	 * @param columnType
	 * @param tableName
	 * @return
	 */
	public <T> List<T> select2SimpleObjectList(String targetColumn, Class<T> columnType, String tableName) {
		final String sql = String.format(SELECT_SINGLE_LECORD_TEMPLATE, targetColumn,tableName);
		return jdbcTemplate.queryForList(sql, columnType);
	}


	public int insert(String insertSql, Object... params) {
		return jdbcTemplate.update(insertSql, params);
	}

	public int update(String updateSql, Object... params) {
		return jdbcTemplate.update(updateSql,params);
	}

	public int delete(String deleteSql, Object... params) {
		return jdbcTemplate.update(deleteSql,params);
	}

	/**
	 * 引数で渡された文字列配列を、","区切った文字列を作成する。
	 * @param strArray
	 * @return
	 */
	private static String str2Csv(String[] strArray) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for( i = 0; i < strArray.length - 1; i++ ) {
			sb.append(strArray[i] + ",");
		}
		sb.append(strArray[i]);
		return sb.toString();
	}
}
