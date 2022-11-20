package com.company.readingIsGood.util;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@UtilityClass
public class Utility {

    public Date getDateFromString(String dateString) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateString);
    }
}
