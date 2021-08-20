 package com.hung.springh2.util;
 
 import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.ValidationUtils;

 
 public class ConvertUtils
 { 
   public static float toFloat(Object value)
   {
     return toFloat(value, 0.0F);
   }
   
   public static float toFloat(Object value, float def) {
     if (value == null) {
       return def;
     }
     if ((value instanceof Number)) {
      return ((Number)value).floatValue();
     }
     try {
      return Float.valueOf(value.toString()).floatValue();
     } catch (Exception e) {}
     return def;
   }
   
   public static double toDouble(Object value)
   {
    return toDouble(value, 0.0D);
   }
   
   public static double toDouble(Object value, double def) {
    if (value == null) {
      return def;
     }
    if ((value instanceof Number)) {
      return ((Number)value).doubleValue();
     }
     try {
       return Double.valueOf(value.toString()).doubleValue();
     } catch (Exception e) {}
     return def;
   }
   
   public static int toInt(Object value) {
     return toInt(value, 0);
   }
   
   public static int toInt(Object value, int def) {
     if (value == null) {
       return def;
     }
    if ((value instanceof Number)) {
       return ((Number)value).intValue();
     }
     try {
      return Integer.valueOf(value.toString()).intValue();
     } catch (Exception e) {}
     return def;
   }
   
   public static long toLong(Object value)
   {
     return toLong(value, 0L);
   }
   
   public static long toLong(Object value, long def) {
     if (value == null) {
      return def;
     }
     if ((value instanceof Number)) {
       return ((Number)value).longValue();
     }
     try {
       return Long.valueOf(value.toString()).longValue();
     } catch (Exception e) {}
     return def;
   }
   
   public static String toString(Object obj)
   {
     return toString(obj, "");
   }
   
   public static String toString(Object obj, String defaultValue) {
     try {
       if (obj == null) {
         return defaultValue;
       }
      if ((obj instanceof java.util.Date)) {
        return toString((java.util.Date)obj);
       }
      return obj.toString();
     } catch (Exception e) {}
     return defaultValue;
   }
   
   
 }