package com.inmobia.classified.security;

import com.inmobia.classified.ISanitizable;
import java.lang.Class;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/**
 *
 * @author Duncan
 */
public class WebDataSanitizer {

    private static final List<String> LIST = new ArrayList();

    public WebDataSanitizer() {
        LIST.add("int");
        LIST.add("boolean");
        LIST.add("Long");
        LIST.add("Float");
    }

    Logger logger = Logger.getLogger(WebDataSanitizer.class.getName());

    public String sanitize(String string) {
        return string;
    }

    public ISanitizable sanitize(ISanitizable object) {

        Class cl = object.getClass();

        Field[] fields = cl.getDeclaredFields();
        Field field;
        if (fields.length != 0) {
            for (int x = 0; x < fields.length; x++) {
                try {
                    field = fields[x];
                    field.setAccessible(true);
                    Object value = field.get(object);
                    if (LIST.contains(field.getType().getName())) {
                        continue;
                    }
                    String valueOfField = (String) value;
                    String safe = Jsoup.clean(valueOfField, Whitelist.none());
                    field.set(object, safe);
                } catch (IllegalArgumentException ex) {
                    logger.error("specified object is not an instance of the class or interface declaring the underlying field");
                    logger.error(ex.getMessage());
                   
                } catch (IllegalAccessException ex) {
                    logger.error("Field object is enforcing Java language access control and the underlying field is inaccessible");
                    logger.error(ex.getMessage());
                   
                }
            }

        }

        return object;
    }

}
