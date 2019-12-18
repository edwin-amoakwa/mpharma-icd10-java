/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10;

import io.netty.channel.Channel;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.akedwin.mpharma.icd10.service.CrudService;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Edwin
 */
public class Icd10ApMain
{
    private static final URI baseUri = URI.create("http://localhost:8080/");
    public static void main(String[] args)
    {
        
        Icd10ApMain icd10ApMain = new Icd10ApMain();
        icd10ApMain.start(baseUri);
    }
    
    
    public void start(URI uri)
    {
        final Weld weld = new Weld();
//        weld.initialize();
        
         WeldContainer weldContainer = weld.initialize();
            weldContainer.select(CrudService.class).get().init();
        
        
        RestApplication application = new RestApplication();
        ResourceConfig resourceConfig = new ResourceConfig(application);
        
        try
        {
            final Channel server = NettyHttpContainerProvider.createHttp2Server(uri, resourceConfig, null);
            Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    server.close();
                    weld.shutdown();
                }
            }));
            
            System.out.println("Starting mPharma Test App at " + LocalDateTime.now());
            System.out.println("Application Started .......... " + uri + " - " + LocalDateTime.now());
            
        } catch (Exception e)
        {
            Logger.getLogger(Icd10ApMain.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
