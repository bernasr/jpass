package jpass.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class CryptUtilsTest {

	private byte[] copy_of_function(final char[] text, final int iteration) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		// md.update(salt);
		byte[] bytes = new String(text).getBytes(StandardCharsets.UTF_8);
		byte[] digest = md.digest(bytes);
		for (int i = 0; i < iteration; i++) {
			md.reset();
			digest = md.digest(digest);
		}
		return digest;
	}


	@Test
	public void shouldHandleOneIteration() {
		char[] text = {'t', 'e', 's', 't'};
		int iterations = 1;
		byte[] result = null;
		byte[] expected = null; 
		try {
			result = copy_of_function(text, iterations);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.reset();
			// md.update(salt);
			byte[] bytes = new String(text).getBytes(StandardCharsets.UTF_8);
			byte[] digest = md.digest(bytes);
			for (int i = 0; i < iterations; i++) {
				md.reset();
				digest = md.digest(digest);
			}
			expected = digest;
		} catch (NoSuchAlgorithmException e) {
			Assert.assertTrue(false);
		}
		Assert.assertArrayEquals(expected, result);



	}

	@Test
	public void shouldNotHandleZeroIteration() throws Exception {
		char[] text = {'t', 'e', 's', 't'};
		int iterations = 0;
		byte[] result = null;
		byte[] expected = null;
		result = copy_of_function(text, iterations);

		MessageDigest md;
		md = MessageDigest.getInstance("SHA-256");
		md.reset();
		// md.update(salt);
		byte[] bytes = new String(text).getBytes(StandardCharsets.UTF_8);
		byte[] digest = md.digest(bytes);
		for (int i = 0; i < iterations; i++) {
			md.reset();
			digest = md.digest(digest);
		}
		expected = digest;
		Assert.assertTrue(arrayNotEqual(expected, result));

	}
	
	
	private boolean arrayNotEqual(byte[] expected, byte[] actual) {
		if (expected.length != actual.length) {
			return true;
		}
		for (int i = 0; i < actual.length; i++) {
			if (expected[i] != actual[i]) {
				return true;
			}
		}
		return false;

	}
}
