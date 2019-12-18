/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10;

/**
 *
 * @author Edwin
 */
public class AppUtilities
{

    public static boolean isNullOrBlank(String param)
    {
        return param == null || param.trim().length() == 0;
    }
}
