/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.service;

import me.akedwin.mpharma.icd10.constants.ValidationStatus;
import me.akedwin.mpharma.icd10.entities.Icd10Entity;
import me.akedwin.mpharma.icd10.model.Icd10;
import me.akedwin.mpharma.icd10.model.Icd10CreateResponse;
import me.akedwin.mpharma.icd10.model.Icd10FindResponse;
import me.akedwin.mpharma.icd10.model.Icd10UpdateModel;

/**
 *
 * @author Edwin
 */
public class TestDataGenerators
{
    public static Icd10 newIcd10()
    {
        Icd10 icd10 = new Icd10();
        icd10.setCategoryCode("A0");
        icd10.setDiagnosisCode("1234");
        icd10.setFullCode("A01234");
        icd10.setAbbreviatedDescription("Comma-ind anal ret");
        icd10.setFullDescription("Comma-induced anal retention");
        icd10.setCategoryTitle("Malignant neoplasm of anus and anal canal");
        return icd10;
    }
    public static Icd10Entity newRecordIcd10Entity()
    {
        Icd10Entity icd10Entity = new Icd10Entity();
        icd10Entity.setCategoryCode("A0");
        icd10Entity.setDiagnosisCode("1234");
        icd10Entity.setFullCode("A01234");
        icd10Entity.setAbbreviatedDescription("Comma-ind anal ret");
        icd10Entity.setFullDescription("Comma-induced anal retention");
        icd10Entity.setCategoryTitle("Malignant neoplasm of anus and anal canal");
        return icd10Entity;
    }
    
    public static Icd10UpdateModel newIcd10UpdateModel()
    {
        Icd10UpdateModel icd10Entity = new Icd10UpdateModel();
        icd10Entity.setFullCode("A01234");
        icd10Entity.setAbbreviatedDescription("Comma-ind anal ret");
        icd10Entity.setFullDescription("Comma-induced anal retention");
        icd10Entity.setCategoryTitle("Malignant neoplasm of anus and anal canal");
        return icd10Entity;
    }
    
    public static Icd10CreateResponse newIcd10CreateResponseSuccessful()
    {
        Icd10CreateResponse createResponse = new Icd10CreateResponse();
        createResponse.setError("");
        createResponse.setSuccessful(true);
        createResponse.setValidationStatus(ValidationStatus.SUCCESSFUL);
        return createResponse;
    }
    
    public static Icd10FindResponse newIcd10FindResponseSuccessful()
    {
        Icd10FindResponse findResponse = new Icd10FindResponse();
        findResponse.setError("");
        findResponse.setSuccessful(true);
        findResponse.setData(newIcd10());
        return findResponse;
    }
}
