import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

import org.junit.Assert;
import org.junit.Test;

import jpass.util.ClipboardUtils;
import jpass.util.StringUtils;

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
		String testString = "test string\0xD8FF";
		String expected = "test string?";
		String result = StringUtils.stripNonValidXMLCharacters(testString);
		Assert.assertEquals(expected, result);
	}
}

