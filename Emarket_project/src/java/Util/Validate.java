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
public class Validate {
     public static boolean checkName(String name){
       if(!name.matches("[\\w\\s]{2,20}")){
           return false;
       }
       return true;
    }
    public static boolean checkEmail(String email){
         if(!email.matches("^(.+)@(.+)$")){
                 return false;
          }
               return true;
    }
    
    public static boolean checkPhoneNumber(String sodt){
         if(!sodt.matches("[\\d]{9,11}")){
             return false;
         }
         return true;
    }
    public static boolean checkPassword(String password){
        if(!password.matches("[\\w]{8,20}")){
            return false;
        }
        return true;
    }
    
     public static boolean checkGia(String gia){
        if(!gia.matches("[\\d]{1,10}")){
            return false;
        }
        return true;
    }
     
     public static boolean checkAge(String age){
        if( Integer.parseInt(age) >= 26 || Integer.parseInt(age) <= 18){
            return false;
        }
        return true;
    }
     public static boolean checkPassword2(String x1, String x2){
        if(!x1.equals(x2)){
            return false;
        }
        return true;
    }
     
     public static boolean checkDate(String date){
         if(!date.matches("\\d{1,2}[\\/]\\d{1,2}[\\/]\\d{4}")){
             return false;
         }
         return true;        
     }
     
     public static boolean checkSogio(String sogio){
         if(!sogio.matches("[\\d]{2}")){
             return false;
         }
         return true;
     }
}
