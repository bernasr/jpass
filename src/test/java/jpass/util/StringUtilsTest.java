package jpass.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {
	
	/**
	 * stripNonValidXMLCharacters
	 * 
	 * input string
	 * null | empty | caracteres validos caracteres inválidos
	 */
	
	@Test
	public void shouldHandleNullStrings() {
		String testString = null;
		String result = StringUtils.stripNonValidXMLCharacters(testString);
		Assert.assertEquals(testString, result);

	}
	
	@Test
	public void shouldHandleEmptyString() {
		String testString = "";
		String result = StringUtils.stripNonValidXMLCharacters(testString);
		Assert.assertEquals(testString, result);

	}
	
	@Test
	public void shouldHandleValidCharacters() {
		String testString = "test string";
		String result = StringUtils.stripNonValidXMLCharacters(testString);
		Assert.assertEquals(testString, result);
	}
	
	@Test
	public void shouldHandleInvalidCharacters() {
		String testString = "test string\u0019";
		String expected = "test string?";
		String result = StringUtils.stripNonValidXMLCharacters(testString);
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void shouldHandleZeroLenght() {
		String testString = "test string";
		int len = 0;
		String result = StringUtils.stripString(testString, len);
		Assert.assertEquals("...", result);
	}

	@Test
	public void shouldHandleNegLenght() {
		String testString = "test string";
		int len = -1;
		try {
			String result = StringUtils.stripString(testString, len);
			Assert.fail();
		} catch (Exception e) {
			System.out.println(e);
			Assert.assertTrue(true);
		}
	}

	@Test
	public void shouldStripLenght() {
		String testString = "test string";
		int len = 5;
		String result = StringUtils.stripString(testString, len);
		Assert.assertEquals("test ...", result);
	}

	@Test
	public void shoulNotStripLenght() {
		String testString = "test string";
		int len = 20;
		String result = StringUtils.stripString(testString, len);
		Assert.assertEquals("test string", result);
	}

}

