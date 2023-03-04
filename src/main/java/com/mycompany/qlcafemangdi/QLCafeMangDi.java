/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.qlcafemangdi;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class QLCafeMangDi {
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
    public static void main(String[] args) {
        
        LocalDateTime ldt = LocalDateTime.now();
        ldt.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String date = ldt.format(format).toString();
        System.out.println(date.getClass().getName());
    }
}
