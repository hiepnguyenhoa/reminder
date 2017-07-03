package com.walmart.reminder.converter;

import com.walmart.reminder.exception.StringToDateException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HiepNguyen on 7/2/2017.
 */

@Service
public class DateConverter implements BaseConverter<String, Date> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    @Deprecated
    public String toDto(Date date) {
        return toString(date);
    }

    @Override
    @Deprecated
    public Date toEntity(String s) {
        return toDate(s);
    }

    public String toString(Date date){
        validateInput(date);
        return DATE_FORMAT.format(date);
    }

    public Date toDate(String value){
        validateInput(value);
        try {
            return DATE_FORMAT.parse(value);
        } catch (ParseException e) {
            throw new StringToDateException(e.getMessage());
        }
    }


}
