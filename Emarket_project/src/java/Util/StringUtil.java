/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author H
 */
public class StringUtil {
    
    public static String getString(String value){
        return value == null ? "" : value;
    } 
    
    public static String getString(Object value){
        return value == null ? "" : String.valueOf(value);
    }
}
