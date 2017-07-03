package com.walmart.reminder.utils;

import com.walmart.reminder.exception.EmptyException;
import com.walmart.reminder.exception.NotNullException;
import com.walmart.reminder.exception.NullObjectException;
import org.hibernate.criterion.NotNullExpression;

import java.util.Collection;

/**
 * Created by HiepNguyen on 7/3/2017.
 */
public class ValidateUtils {

    public static boolean validateNotNull(Object o){
        if(o==null){
            throw new NullObjectException();
        }
        return true;
    }

    public static boolean validateNull(Object o){
        if(o!=null){
            throw new NotNullException(o.toString());
        }
        return true;
    }

    public static <E> boolean validateNotEmpty(Collection<E> collection){
        if(validateNotNull(collection)&&collection.size()==0){
            throw new EmptyException();
        }
        return true;
    }

    public static <E> boolean validateNotEmpty(E[] array){
        if(validateNotNull(array)&&array.length==0){
            throw new EmptyException();
        }
        return true;
    }
}
