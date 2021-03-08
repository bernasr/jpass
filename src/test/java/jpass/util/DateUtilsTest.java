package jpass.util;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

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
        String result = DateUtils.formatIsoDateTime(validDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Assert.assertEquals(validDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(validDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME).truncatedTo(ChronoUnit.SECONDS)));


    }


    @Test
    public void shouldHandleInvalidDateTime() {
        String invalidDateTime = "2012-12-03";
        String result = DateUtils.formatIsoDateTime(invalidDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Assert.assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneId.systemDefault())), result);


    }

    @Test
    public void shouldHandleNullDateTime() {
        String nullDateTime = null;
        String result = DateUtils.formatIsoDateTime(nullDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Assert.assertEquals(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneId.systemDefault())), result);


    }

    @Test
    public void shouldHandleNullFormater() {
        String validDateTime = "2012-12-03T10:15:30";
        String result = DateUtils.formatIsoDateTime(validDateTime, null);
        Assert.assertEquals(validDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.parse(validDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME).truncatedTo(ChronoUnit.SECONDS)));

    }

}
