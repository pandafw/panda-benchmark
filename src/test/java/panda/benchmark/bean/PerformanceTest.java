package panda.benchmark.bean;

import panda.bean.BeanHandler;
import panda.bean.Beans;
import panda.bean.fast.FastBeans;
import panda.benchmark.bean.fast.TestAHandler;
import panda.lang.time.StopWatch;
import panda.log.Log;
import panda.log.Logs;

import junit.framework.TestCase;


/**
 */
public class PerformanceTest extends TestCase {

	private static Log log = Logs.getLog(PerformanceTest.class);

	private static final int PCOUNT = 10;
	private static final int ECOUNT = 5000000;

	public static class AA {
		
	}

	public static void main(String[] args) {
		PerformanceTest pt = new PerformanceTest();
		
		pt.testDirect();
		pt.testJavaPropCall();
		pt.testNativePropCall();
		pt.testFastPropCall();
		pt.testJavaBeanCall();
		pt.testNativeBeanCall();
		pt.testFastBeanCall();
	}

	private void directCall() {
		TestA a = new TestA();
		a.isBoolField();
		a.setBoolField(true);
		a.getDateField();
		a.setDateField(null);
		a.getIntField();
		a.setIntField(0);
		a.getStringField();
		a.setStringField("");
	}

	/**
	 */
	public void testDirect() {
		for (int i = 0; i < PCOUNT; i++) {
			directCall();
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			directCall();
		}
		log.info("testDirect took " + watch);
	}

	@SuppressWarnings("unchecked")
	private void beanCall(BeanHandler bh) {
		Object a = bh.createObject();
		bh.getBeanValue(a, "boolField");
		bh.setBeanValue(a, "boolField", false);
		bh.getBeanValue(a, "dateField");
		bh.setBeanValue(a, "dateField", null);
		bh.getBeanValue(a, "intField");
		bh.setBeanValue(a, "intField", 0);
		bh.getBeanValue(a, "stringField");
		bh.setBeanValue(a, "stringField", "");
	}

	@SuppressWarnings("unchecked")
	private void propCall(BeanHandler bh) {
		Object a = bh.createObject();
		bh.getPropertyValue(a, "boolField");
		bh.setPropertyValue(a, "boolField", false);
		bh.getPropertyValue(a, "dateField");
		bh.setPropertyValue(a, "dateField", null);
		bh.getPropertyValue(a, "intField");
		bh.setPropertyValue(a, "intField", 0);
		bh.getPropertyValue(a, "stringField");
		bh.setPropertyValue(a, "stringField", "");
	}

	public void testJavaBeanCall() {
		Beans.setInstance(new Beans());
		BeanHandler bh = Beans.i().getBeanHandler(TestA.class);
		
		for (int i = 0; i < PCOUNT; i++) {
			beanCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			beanCall(bh);
		}
		log.info("testJavaBeanCall took " + watch);
	}

	public void testJavaPropCall() {
		Beans.setInstance(new Beans());
		BeanHandler bh = Beans.i().getBeanHandler(TestA.class);
		
		for (int i = 0; i < PCOUNT; i++) {
			propCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			propCall(bh);
		}
		log.info("testJavaPropCall took " + watch);
	}

	public void testNativeBeanCall() {
		Beans.setInstance(new Beans());
		BeanHandler bh = new TestAHandler(Beans.i());
		
		for (int i = 0; i < PCOUNT; i++) {
			beanCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			beanCall(bh);
		}
		log.info("testNativeBeanCall took " + watch);
	}

	public void testNativePropCall() {
		Beans.setInstance(new Beans());
		BeanHandler bh = new TestAHandler(Beans.i());
		
		for (int i = 0; i < PCOUNT; i++) {
			propCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			propCall(bh);
		}
		log.info("testNativePropCall took " + watch);
	}

	public void testFastBeanCall() {
		Beans.setInstance(new FastBeans());
		BeanHandler bh = Beans.i().getBeanHandler(TestA.class);
		
		for (int i = 0; i < PCOUNT; i++) {
			beanCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			beanCall(bh);
		}
		log.info("testFastBeanCall took " + watch);
	}

	public void testFastPropCall() {
		Beans.setInstance(new FastBeans());
		BeanHandler bh = Beans.i().getBeanHandler(TestA.class);
		
		for (int i = 0; i < PCOUNT; i++) {
			propCall(bh);
		}

		StopWatch watch = new StopWatch();
		for (int i = 0; i < ECOUNT; i++) {
			propCall(bh);
		}
		log.info("testFastPropCall took " + watch);
	}
}
