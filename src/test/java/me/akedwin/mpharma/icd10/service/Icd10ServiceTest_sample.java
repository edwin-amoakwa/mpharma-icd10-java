/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.inject.Inject;
import me.akedwin.mpharma.icd10.entities.Icd10Entity;
import me.akedwin.mpharma.icd10.model.Icd10;
import me.akedwin.mpharma.icd10.model.Icd10CreateResponse;
import me.akedwin.mpharma.icd10.model.Icd10FindResponse;
import me.akedwin.mpharma.icd10.model.Icd10ListResponse;
import me.akedwin.mpharma.icd10.model.Icd10UpdateModel;
import org.jboss.weld.junit5.EnableWeld;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldJunit5Extension;
import org.jboss.weld.junit5.WeldSetup;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.WeldJunit5AutoExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author Edwin
 */
//@EnableWeld
//@ExtendWith(WeldJunit5Extension.class)
@ExtendWith(WeldJunit5AutoExtension.class)
//@AddPackages(Icd10Service.class)
//@AddPackages(CrudService.class)
public class Icd10ServiceTest_sample
{
    
//    SeContainer container = null;
//    SeContainer container = SeContainerInitializer.newInstance().initialize();
//     @WeldSetup
//    public WeldInitiator weld = WeldInitiator.of(Icd10Service.class);
     
//     @WeldSetup
//    public WeldInitiator weld = WeldInitiator.from(Icd10Service.class, CrudService.class)
//            .activate(SessionScoped.class, ApplicationScoped.class).build();
//            .build();
     
     
//     @Rule
//    public WeldInitiator weld = WeldInitiator.from(GreetingService.class)
//        .activate(RequestScoped.class)
//        .inject(this)
//        .build();
    
//    @Inject private Icd10Service instance;
//    private Icd10Service instance;
//    @Inject Instance<Icd10Service> instance1;
    public Icd10ServiceTest_sample()
    {
    }
    
    @BeforeAll
    public  void setUpClass()
    {
//        CrudService crudService = new CrudService();
//        instance = new Icd10Service();
//        instance.setCrudService(crudService);
       
        
    }
    
    @AfterAll
    public static void tearDownClass()
    {
    }
    
    @BeforeEach
    public void setUp()
    {
//         container = SeContainerInitializer.newInstance().initialize();
//        instance = container.select(Icd10Service.class).get();
//        instance = weld.select(Icd10Service.class).get();
        
//        System.out.println("instance ......" + instance);
    }
    
    @AfterEach
    public void tearDown()
    {
    }

    
    
    /**
     * Test of toNewIcd10Entity method, of class Icd10Service.
     */
    @Test
    public void testToNewIcd10Entity()
    {
        
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
//        myBean.doWork();
    
        
        System.out.println("toNewIcd10Entity");
        Icd10 icd10 = TestDataGenerators.newIcd10();
//        Icd10Service instance = new Icd10Service();
// Icd10Service instance = weld.select(Icd10Service.class).get();
        Icd10Entity expResult = TestDataGenerators.newRecordIcd10Entity();
        Icd10Entity result = instance.toNewIcd10Entity(icd10);
        assertEquals(expResult.getFullCode(), result.getFullCode());
//        assertEquals(expResult.getFullCode(), result.getFullCode());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    

}
