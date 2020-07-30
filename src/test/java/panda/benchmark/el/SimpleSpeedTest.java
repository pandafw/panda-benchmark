package panda.benchmark.el;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.nutz.lang.Lang;
import org.nutz.lang.util.Context;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import panda.bind.json.Jsons;
import panda.el.EL;
import panda.lang.Exceptions;
import panda.lang.Strings;
import panda.lang.time.StopWatch;

/**
 * 一个基本的速度测试。 同 Java 代码相比，大约慢了 100－300倍 随着表达式的复杂，会更慢 s*
 */
public class SimpleSpeedTest {

	static int max = 50000;
	static int i = 0;

	public int abc(int i) {
		return i % 13;
	}

	public static class Tc {
		long i;
		long num;
		SimpleSpeedTest z;

		/**
		 * @return the i
		 */
		public long getI() {
			return i;
		}

		/**
		 * @param i the i to set
		 */
		public void setI(long i) {
			this.i = i;
		}

		/**
		 * @return the num
		 */
		public long getNum() {
			return num;
		}

		/**
		 * @param num the num to set
		 */
		public void setNum(long num) {
			this.num = num;
		}

		/**
		 * @return the z
		 */
		public SimpleSpeedTest getZ() {
			return z;
		}

		/**
		 * @param z the z to set
		 */
		public void setZ(SimpleSpeedTest z) {
			this.z = z;
		}
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSpeed() throws SecurityException, NoSuchMethodException {
		final SimpleSpeedTest z = new SimpleSpeedTest();
		final String elstr = "num + (i - 1 + 2 - 3 + 4 - 5 + 6 - 7) - z.abc(i)";
		final Map<String, Object> context = new HashMap<String, Object>();
		context.put("num", 0);
		context.put("z", z);

		final Map map = Jsons.fromJson("{'num':0}", Map.class);
		map.put("z", z);

		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw = StopWatch.run(new Runnable() {
			public void run() {
				int num = 0;
				for (int i = 0; i < max; i++) {
					num = num + (i - 1 + 2 - 3 + 4 - 5 + 6 - 7) - z.abc(i);
				}
				System.out.println("Num: " + num);
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw3 = StopWatch.run(new Runnable() {
			public void run() {
				try {
					final Context context = Lang.context("{num:0}");
					context.set("z", z);
					context.set("num", 0);
					for (int i = 0; i < max; i++) {
						context.set("num", org.nutz.el.El.eval(context.set("i", i), elstr));
					}
					System.out.println("Num: " + context.getInt("num"));
				}
				catch (Exception e) {
					throw Exceptions.wrapThrow(e);
				}
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw4 = StopWatch.run(new Runnable() {
			public void run() {
				try {
					org.nutz.el.El el2pre = new org.nutz.el.El(elstr);
					final Context context = Lang.context("{num:0}");
					context.set("num", 0);
					context.set("z", z);
					for (int i = 0; i < max; i++) {
						context.set("num", el2pre.eval(context.set("i", i)));
					}
					System.out.println("Num: " + context.getInt("num"));
				}
				catch (Exception e) {
					throw Exceptions.wrapThrow(e);
				}
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw5 = StopWatch.run(new Runnable() {
			public void run() {
				try {
					org.nutz.el.El el2pre = new org.nutz.el.El(elstr);
					final Context context = Lang.context("{num:0}");
					context.set("z", z);
					context.set("num", 0);
					for (int i = 0; i < max; i++) {
						context.set("num", el2pre.eval(context.set("i", i)));
					}
					System.out.println("Num: " + context.getInt("num"));
				}
				catch (Exception e) {
					throw Exceptions.wrapThrow(e);
				}
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw6 = StopWatch.run(new Runnable() {
			public void run() {
				try {
					Tc context = new Tc();
					Expression el2pre = new SpelExpressionParser().parseExpression(elstr);
					context.setNum(0);
					context.setZ(z);
					for (int i = 0; i < max; i++) {
						context.setI(i);
						context.setNum((Long)el2pre.getValue(context));
					}
					System.out.println("Num: " + context.getNum());
				}
				catch (Exception e) {
					throw Exceptions.wrapThrow(e);
				}
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw7 = StopWatch.run(new Runnable() {
			public void run() {
				map.put("num", 0);
				for (int i = 0; i < max; i++) {
					map.put("i", i);
					map.put("num", EL.eval(elstr, map));
				}
				System.out.println("Num: " + map.get("num"));
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw8 = StopWatch.run(new Runnable() {
			public void run() {
				EL el2pre = new EL(elstr);
				map.put("num", 0);
				map.put("z", z);
				for (int i = 0; i < max; i++) {
					map.put("i", i);
					map.put("num", el2pre.eval(map));
				}
				System.out.println("Num: " + map.get("num"));
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		StopWatch sw9 = StopWatch.run(new Runnable() {
			public void run() {
				EL el2pre = new EL(elstr);
				map.put("num", 0);
				map.put("z", z);
				for (int i = 0; i < max; i++) {
					map.put("i", i);
					map.put("num", el2pre.eval(map));
				}
				System.out.println("Num: " + map.get("num"));
			}
		});
		System.out.println("\n" + Strings.repeat('=', 100));

		System.out.printf("\n%20s : %s", "Java", sw.toString());
		System.out.printf("\n%20s : %s", "NEL ", sw3.toString());
		System.out.printf("\n%20s : %s", "NELP", sw4.toString());
		System.out.printf("\n%20s : %s", "NELP", sw5.toString());
		System.out.printf("\n%20s : %s", "SPEL", sw6.toString());
		System.out.printf("\n%20s : %s", "PEL ", sw7.toString());
		System.out.printf("\n%20s : %s", "PELP", sw8.toString());
		System.out.printf("\n%20s : %s", "PELP", sw9.toString());
		System.out.println();
	}

}
