package com.tony.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class MyURL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }


    public static LocalDateTime convertDate(String textDate, LocalDateTime defaultValue) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            TemporalAccessor ta = dtf.parse(textDate);
            return LocalDateTime.from(ta);
        } catch (RuntimeException e) {
            return defaultValue;
        }
    }
}
