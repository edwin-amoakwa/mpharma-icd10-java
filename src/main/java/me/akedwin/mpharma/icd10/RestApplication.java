/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

/**
 *
 * @author Edwin
 */
public class RestApplication extends ResourceConfig
{
    public RestApplication()
    {
        packages("me.akedwin.mpharma.icd10.rest");
//        property(ServerProperties.TRACING, "ALL");
    }
    
    
}
