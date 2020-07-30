package panda.benchmark.lang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import panda.lang.Randoms;
import panda.lang.time.StopWatch;
import panda.util.crypto.Algorithms;
import panda.util.crypto.Cryptor;

/**
 * test class for Encrypts
 */
public class EncryptsSpeedTest {
	private void encdec(String text, String key, String trans) {
		key = key == null ? Algorithms.AES : key;
		
		Cryptor c = new Cryptor(trans, key);
		String enc = c.encrypt(text);
		String dec = c.decrypt(enc);

		Assert.assertEquals(text, dec);
	}

	private void speedTest(List<String> samples, String trans) {
		speedTest(samples, null, trans);
	}
	
	private void speedTest(List<String> samples, String key, String trans) {
		final int CNT = samples.size();
		final int MAX = 10;
		StopWatch sw = new StopWatch();
		for (int j = 0; j < MAX; j++) {
			for (int i = 0; i < CNT; i++) {
				encdec(samples.get(i), key, trans);
			}
		}
		System.out.println(trans + ": " + sw);
	}

	@Test
	public void testSpeed() {
		final int CNT = 1000;

		List<String> samples = new ArrayList<String>();
		for (int i = 0; i < CNT; i++) {
			samples.add(Randoms.randString(11));
		}

		speedTest(samples, Algorithms.AES);
		speedTest(samples, Algorithms.Blowfish);
		speedTest(samples, "12345678", Algorithms.DES);
		speedTest(samples, "123456781234567812345678", Algorithms.DESede);
		speedTest(samples, Algorithms.RC2);
		speedTest(samples, Algorithms.RC4);
	}
}
