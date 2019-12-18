/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.service;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import me.akedwin.mpharma.icd10.entities.Icd10Entity;
import me.akedwin.mpharma.icd10.model.Icd10;
import me.akedwin.mpharma.icd10.model.Icd10CreateResponse;
import me.akedwin.mpharma.icd10.model.Icd10FindResponse;
import me.akedwin.mpharma.icd10.model.Icd10UpdateModel;
import org.jboss.weld.junit5.WeldInitiator;
import org.jboss.weld.junit5.WeldSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

/**
 *
 * @author Edwin
 */

@TestMethodOrder(OrderAnnotation.class)
public class Icd10ServiceTest
{
    
     @WeldSetup
    public WeldInitiator weld = WeldInitiator.of(Icd10Service.class);
     
    public Icd10ServiceTest()
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
        
    }
    
    @AfterEach
    public void tearDown()
    {
    }
    
      /**
     * Test of validateIcd10 method, of class Icd10Service.
     */
    @Test
    @Order(-1)
    public void testValidateIcd10()
    {
        System.out.println("validateIcd10");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        Icd10 icd10 = TestDataGenerators.newIcd10();
//        Icd10Service instance = new Icd10Service();
        Icd10CreateResponse expResult = TestDataGenerators.newIcd10CreateResponseSuccessful();
        expResult.setSuccessful(false);
        Icd10CreateResponse result = instance.validateIcd10(icd10);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveIcd10 method, of class Icd10Service.
     */
    @Test
    @Order(1)
    public void testSaveIcd10()
    {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        System.out.println("saveIcd10");
        Icd10 icd10 = TestDataGenerators.newIcd10();
//        Icd10Service instance = new Icd10Service();
        Icd10CreateResponse expResult = TestDataGenerators.newIcd10CreateResponseSuccessful();
        Icd10CreateResponse result = instance.saveIcd10(icd10);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of findByCode method, of class Icd10Service.
     */
    @Test
    @Order(2)
    public void testFindByCode()
    {
        System.out.println("findByCode");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        String fullCode = TestDataGenerators.newIcd10().getFullCode();
//        Icd10Service instance = new Icd10Service();
        Icd10FindResponse expResult = TestDataGenerators.newIcd10FindResponseSuccessful();
        Icd10FindResponse result = instance.findByCode(fullCode);
        assertEquals(expResult.getData().getFullCode(), result.getData().getFullCode());
        
    }

    /**
     * Test of updateIcd10 method, of class Icd10Service.
     */
    @Test
    public void testUpdateIcd10()
    {
        System.out.println("updateIcd10");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        Icd10UpdateModel icd10UpdateModel = TestDataGenerators.newIcd10UpdateModel();
        icd10UpdateModel.setAbbreviatedDescription("Testing Updating");
//        Icd10Service instance = new Icd10Service();
//        Icd10FindResponse expResult = TestDataGenerators.newIcd10FindResponseSuccessful();
        Icd10FindResponse result = instance.updateIcd10(icd10UpdateModel);
        System.out.println(result);
        assertEquals(result.getData().getAbbreviatedDescription(), "Testing Updating");
        
    }

    /**
     * Test of findIcd10EntityByCode method, of class Icd10Service.
     */
    @Test
    public void testFindIcd10EntityByCode()
    {
        System.out.println("findIcd10EntityByCode");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        String fullCode = TestDataGenerators.newIcd10().getFullCode();
//        Icd10Service instance = new Icd10Service();
        Icd10Entity expResult = TestDataGenerators.newRecordIcd10Entity();
        Icd10Entity result = instance.findIcd10EntityByCode(fullCode);
        assertEquals(expResult.getFullCode(), result.getFullCode());
        
    }

    /**
     * Test of codeExist method, of class Icd10Service.
     */
    @Test
    public void testCodeExist_True()
    {
        System.out.println("codeExist");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        String fullCode = TestDataGenerators.newIcd10().getFullCode();
//        Icd10Service instance = new Icd10Service();
        boolean expResult = true;
        boolean result = instance.codeExist(fullCode);
        assertEquals(expResult, result);
    }

    /**
     * Test of codeExist method, of class Icd10Service.
     */
    @Test
    public void testCodeExist_False()
    {
        System.out.println("codeExist");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        String fullCode = "Dummy";
//        Icd10Service instance = new Icd10Service();
        boolean expResult = false;
        boolean result = instance.codeExist(fullCode);
        assertEquals(expResult, result);
    }

  

    /**
     * Test of toNewIcd10Entity method, of class Icd10Service.
     */
    @Test
    public void testToNewIcd10Entity()
    {
        System.out.println("toNewIcd10Entity");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        Icd10 icd10 = TestDataGenerators.newIcd10();
//        Icd10Service instance = new Icd10Service();
        Icd10Entity expResult = TestDataGenerators.newRecordIcd10Entity();
        Icd10Entity result = instance.toNewIcd10Entity(icd10);
        assertEquals(expResult.getFullCode(), result.getFullCode());
    }

    /**
     * Test of toIcd10Model method, of class Icd10Service.
     */
    @Test
    public void testToIcd10Model()
    {
        System.out.println("toIcd10Model");
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Icd10Service instance = container.select(Icd10Service.class).get();
        
        Icd10Entity icd10Entity = TestDataGenerators.newRecordIcd10Entity();
//        Icd10Service instance = new Icd10Service();
        Icd10 expResult = TestDataGenerators.newIcd10();
        Icd10 result = instance.toIcd10Model(icd10Entity);
        assertEquals(expResult, result);
        
    }

    
    
}
