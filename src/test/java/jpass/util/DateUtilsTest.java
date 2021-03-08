package jpass.util;


import java.time.format.*;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilsTest {
	
	
	/**
	 * formatIsoDateTime
	 * 
	 * String
	 * valida | Invalida
	 * 
	 * Formater
	 * dar formater válido, dar formater inválido
	 */
	
	@Test
	public void shouldHandleValidDateTime() {
		String validDateTime = "2012-12-03T10:15:30";
		String result = DateUtils.formatIsoDateTime("2012-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		Assert.assertEquals(validDateTime, result);
		

	}
	
	
	@Test
	public void shouldHandleInvalidDateTime() {
		String validDateTime = "2012-12-03";
		String result = DateUtils.formatIsoDateTime("2012-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		Assert.assertNotEquals(validDateTime, result);
		

	}
	
	
	
}
