/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.service;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.QueryParam;
import me.akedwin.mpharma.icd10.AppUtilities;
import me.akedwin.mpharma.icd10.constants.ValidationStatus;
import me.akedwin.mpharma.icd10.entities.Icd10Entity;
import me.akedwin.mpharma.icd10.model.Icd10;
import me.akedwin.mpharma.icd10.model.Icd10CreateResponse;
import me.akedwin.mpharma.icd10.model.Icd10FindResponse;
import me.akedwin.mpharma.icd10.model.Icd10ListResponse;
import me.akedwin.mpharma.icd10.model.Icd10UpdateModel;

/**
 *
 * @author Edwin
 */
@Named
//@SessionScoped
public class Icd10Service implements Serializable
{

    @Inject private CrudService crudService;

    public void setCrudService(CrudService crudService)
    {
        this.crudService = crudService;
    }

    public Icd10CreateResponse saveIcd10(Icd10 icd10)
    {
        Icd10CreateResponse response = validateIcd10(icd10);

        if (response.getValidationStatus() == ValidationStatus.FAILED)
        {
            return response;
        }

        if (codeExist(icd10.getFullCode()))
        {
            response.setError("fullCode exists already");
            response.setValidationStatus(ValidationStatus.FAILED);
            response.setSuccessful(false);
            return response;
        }

        Icd10Entity icd10Entity = toNewIcd10Entity(icd10);

        Icd10Entity savedEntity = crudService.persist(icd10Entity);

        if (savedEntity == null)
        {
            response.setError("Error saving Code. Please try again");
            return response;
        }

        response.setError("");
        response.setSuccessful(true);

        return response;
    }

    public Icd10FindResponse findByCode(String fullCode)
    {
        Icd10FindResponse response = new Icd10FindResponse();
        Icd10Entity entity = findIcd10EntityByCode(fullCode);

        if (entity == null)
        {
            response.setError("ICD10 code not found");
            response.setSuccessful(false);
            return response;
        }

        response.setError("");
        response.setSuccessful(true);
        response.setData(toIcd10Model(entity));

        return response;
    }

    public Icd10FindResponse updateIcd10(Icd10UpdateModel icd10UpdateModel)
    {
        Icd10FindResponse response = new Icd10FindResponse();
        Icd10Entity entity = findIcd10EntityByCode(icd10UpdateModel.getFullCode());

        if (entity == null)
        {
            response.setError("could not update, ICD10 code not found");
            response.setSuccessful(false);
            return response;
        }

        entity.setAbbreviatedDescription(icd10UpdateModel.getAbbreviatedDescription());
        entity.setCategoryTitle(icd10UpdateModel.getCategoryTitle());
        entity.setFullDescription(icd10UpdateModel.getFullCode());

        if (crudService.persist(entity) != null)
        {
            response.setError("");
            response.setSuccessful(true);
            response.setData(toIcd10Model(entity));
        } else
        {
            response.setError("could not update, ICD10 code not found");
            response.setSuccessful(false);
            return response;
        }

        return response;
    }

    public Icd10Entity findIcd10EntityByCode(String fullCode)
    {
        try
        {
            String qry = "SELECT e FROM Icd10Entity e WHERE e.fullCode =:fullCode";

//            entity = (Icd10Entity) crudService.getEm()
//                    .createQuery(qry).setParameter("fullCode", qry)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList().get(0);
            List<Icd10Entity> responses = crudService.getEm()
                    .createQuery(qry).setParameter("fullCode", fullCode)
                    .setFirstResult(0)
                    .setMaxResults(1)
                    .getResultList();

            return responses.get(0);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public Icd10FindResponse deleteCode(String fullCode)
    {
        Icd10FindResponse response = new Icd10FindResponse();

        int noDeleted = 0;
        try
        {
            String qry = "DELETE FROM Icd10Entity e WHERE e.fullCode ='" + fullCode + "'";

            noDeleted = crudService.execueUpdate(qry);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        if (noDeleted == 0)
        {
            response.setError("ICD10 code not found and cannot be deleted");
            response.setSuccessful(false);
            return response;
        }

        response.setError("");
        response.setSuccessful(true);

        return response;
    }

    public boolean codeExist(String fullCode)
    {
        try
        {
            String qry = "SELECT count(e.id) FROM Icd10Entity e WHERE e.fullCode =:fullCode";

//            entity = (Icd10Entity) crudService.getEm()
//                    .createQuery(qry).setParameter("fullCode", qry)
//                    .setFirstResult(0)
//                    .setMaxResults(1)
//                    .getResultList().get(0);
            Long count = (Long) crudService.getEm()
                    .createQuery(qry).setParameter("fullCode", fullCode)
                    .getSingleResult();
            if (count > 0)
            {
                return true;
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;
    }

    //just basic validation
    public Icd10CreateResponse validateIcd10(Icd10 icd10)
    {
        Icd10CreateResponse response = new Icd10CreateResponse();
        response.setSuccessful(false);
        response.setValidationStatus(ValidationStatus.FAILED);

        if (AppUtilities.isNullOrBlank(icd10.getCategoryCode()))
        {
            response.setError("categoryCode not provided");
            return response;
        }

        if (AppUtilities.isNullOrBlank(icd10.getFullCode()))
        {
            response.setError("fullCode not provided");
            return response;
        }

        if (AppUtilities.isNullOrBlank(icd10.getDiagnosisCode()))
        {
            response.setError("diagnosisCode not provided");
            return response;
        }
        
        response.setSuccessful(false);
        response.setValidationStatus(ValidationStatus.SUCCESSFUL);

        return response;
    }

    public Icd10Entity toNewIcd10Entity(Icd10 icd10)
    {
        Icd10Entity entity = new Icd10Entity();
        entity.setId(crudService.generateId());
        entity.setCreatedDate(LocalDateTime.now());

        entity.setFullCode(icd10.getFullCode());
        entity.setCategoryCode(icd10.getCategoryCode());
        entity.setDiagnosisCode(icd10.getDiagnosisCode());

        entity.setCategoryTitle(icd10.getCategoryTitle());
        entity.setAbbreviatedDescription(icd10.getAbbreviatedDescription());

        return entity;
    }

    public Icd10 toIcd10Model(Icd10Entity icd10Entity)
    {
        Icd10 icd10Model = new Icd10();

        icd10Model.setCategoryCode(icd10Entity.getCategoryCode());
        icd10Model.setDiagnosisCode(icd10Entity.getDiagnosisCode());
        icd10Model.setFullCode(icd10Entity.getFullCode());
        icd10Model.setCategoryTitle(icd10Entity.getCategoryTitle());
        icd10Model.setAbbreviatedDescription(icd10Entity.getAbbreviatedDescription());

        return icd10Model;
    }

    public Icd10ListResponse loadIcd10Codes(int pageSize, int page)
    {
        Icd10ListResponse response = new Icd10ListResponse();

        if (page <= 0)
        {
            page = 1;
        }

        try
        {
            String qryCount = "SELECT COUNT(e) FROM Icd10Entity e";

            Long size = (Long) crudService.getEm().createQuery(qryCount).getSingleResult();
//                .count();
//         System.out.println("-- "+size);
            response.setTotalPages((int) Math.ceil(size / (double) pageSize));
            response.setPage(page);
            response.setTotalCount(size);
//         data.set

//         if(page)
            String loadQry = "SELECT e FROM Icd10Entity e";

            List<Icd10Entity> messagesList = crudService.getEm().createQuery(loadQry)
                    .setFirstResult((page - 1) * pageSize)
                    .setMaxResults(pageSize)
                    .getResultList();

            List<Icd10> dataList = new LinkedList<>();

            for (Icd10Entity icd10Entity : messagesList)
            {
                dataList.add(toIcd10Model(icd10Entity));
            }

            response.setData(dataList);
            response.setPageSize(pageSize);
            response.setSuccessful(true);
            return response;
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        response.setError("Unable to load data");
        response.setSuccessful(false);
        return response;
    }
}
