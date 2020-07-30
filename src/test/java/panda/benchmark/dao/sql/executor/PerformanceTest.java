package panda.benchmark.dao.sql.executor;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import panda.bean.Beans;
import panda.bean.fast.FastBeans;
import panda.dao.sql.SqlExecutor;
import panda.dao.sql.executor.DynamicSqlExecutors;
import panda.dao.sql.executor.FreemarkerSqlExecutors;
import panda.dao.sql.executor.SimpleSqlExecutors;
import panda.io.Streams;
import panda.lang.Classes;
import panda.lang.Exceptions;
import panda.log.Log;
import panda.log.Logs;


/**
 * PerformanceTest
 */
public class PerformanceTest {
	private static Log log = Logs.getLog(PerformanceTest.class);

	private final static int PCOUNT = 10;
	private final static int ECOUNT = 10000;

	private String loadSql(String sql) throws Exception {
		return Streams.toStringBom(this.getClass().getResourceAsStream(sql));
	}

	private void executeSql(SqlExecutor executor, String sql) throws Exception {
		String[] sqls = new String[] { sql, sql, sql, sql };
		executeSqls(executor, sqls);
	}

	private void executeSqls(SqlExecutor executor, String[] sqls) throws Exception {
		int i = 0;

		TestBean param;
		List<Integer> idList;

		List<TestBean> results;

		param = new TestBean();
		param.setId(1005);
		results = executor.selectList(sqls[i++], param, TestBean.class);
		Assert.assertEquals(1, results.size());

		param = new TestBean();
		param.setId(0);
		idList = new ArrayList<Integer>();
		param.setIntList(idList);
		param.setFstr("NAME 1001");
		results = executor.selectList(sqls[i++], param, TestBean.class);
		Assert.assertEquals(1, results.size());

		param = new TestBean();
		param.setId(0);
		idList = new ArrayList<Integer>();
		idList.add(1002);
		idList.add(1003);
		param.setIntList(idList);
		results = executor.selectList(sqls[i++], param, TestBean.class);
		Assert.assertEquals(2, results.size());

		param = new TestBean();
		param.setId(0);
		idList = new ArrayList<Integer>();
		idList.add(1003);
		idList.add(1004);
		param.setIntList(idList);
		param.setOrderCol("FSTR");
		param.setOrderDir("DESC");
		results = executor.selectList(sqls[i++], param, TestBean.class);
		Assert.assertEquals(2, results.size());
	}

	private void prepare() {
		Beans.setInstance(new Beans());
	}

	private void _testSimple(String name) {
		try {
			String[] sqls = new String[] {
					"SELECT * FROM TEST WHERE ID=:id ORDER BY ID",
					"SELECT * FROM TEST WHERE FSTR=:fstr ORDER BY ID", 
					"SELECT * FROM TEST WHERE ID IN (:intList) ORDER BY ID", 
					"SELECT * FROM TEST WHERE ID IN (:intList) ORDER BY ::orderCol ::orderDir"
			};

			SqlExecutor exe = new SimpleSqlExecutors().getExecutor(TestSupport.getHsqldbConnection());;
			for (int i = 0; i < PCOUNT; i++) {
				executeSqls(exe, sqls);
			}

			long start = System.currentTimeMillis();
			for (int i = 0; i < ECOUNT; i++) {
				executeSqls(exe, sqls);
			}
			long end = System.currentTimeMillis();

			log.info(name + " - elapsed - " + (end - start));
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw Exceptions.wrapThrow(e);
		}
	}

	private void _testExtend(String name) {
		try {
			SqlExecutor exe = new DynamicSqlExecutors().getExecutor(TestSupport.getHsqldbConnection());;

			String sql = loadSql("test.sql");
			for (int i = 0; i < PCOUNT; i++) {
				executeSql(exe, sql);
			}

			long start = System.currentTimeMillis();
			for (int i = 0; i < ECOUNT; i++) {
				executeSql(exe, sql);
			}
			long end = System.currentTimeMillis();

			log.info(name + " - elapsed - " + (end - start));
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw Exceptions.wrapThrow(e);
		}
	}

	private void _testFreemarker(String name) {
		try {
			SqlExecutor exe = new FreemarkerSqlExecutors().getExecutor(TestSupport.getHsqldbConnection());;

			String sql = Classes.getResourcePath(this.getClass(), "test.sql.ftl");
			for (int i = 0; i < PCOUNT; i++) {
				executeSql(exe, sql);
			}

			long start = System.currentTimeMillis();
			for (int i = 0; i < ECOUNT; i++) {
				executeSql(exe, sql);
			}
			long end = System.currentTimeMillis();

			log.info(name + " - elapsed - " + (end - start));
		}
		catch (Exception e) {
			log.error(e.getMessage(), e);
			throw Exceptions.wrapThrow(e);
		}
	}

	private void prepareFast() {
		Beans.setInstance(new FastBeans());
	}

	/**
	 * testSimple
	 */
	@Test
	public void testSimple() {
		prepare();
		_testSimple("testSimple");
	}

	/**
	 * testExtend
	 */
	@Test
	public void testExtend() {
		prepare();
		_testExtend("testExtend");
	}

	/**
	 * testFreemarker
	 */
	@Test
	public void testFreemarker() {
		prepare();
		_testFreemarker("testFreemarker");
	}

	/**
	 * testSimpleFast
	 */
	@Test
	public void testSimpleFast() {
		prepareFast();
		_testSimple("testSimpleFast");
	}

	/**
	 * testExtendFast
	 */
	@Test
	public void testExtendFast() {
		prepareFast();
		_testExtend("testExtendFast");
	}

	/**
	 * testFreemarkerFast
	 */
	@Test
	public void testFreemarkerFast() {
		prepareFast();
		_testFreemarker("testFreemarkerFast");
	}


}