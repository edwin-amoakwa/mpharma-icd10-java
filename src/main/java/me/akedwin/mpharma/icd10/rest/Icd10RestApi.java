/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.rest;

import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import me.akedwin.mpharma.icd10.entities.Icd10Entity;
import me.akedwin.mpharma.icd10.service.CrudService;
import me.akedwin.mpharma.icd10.model.Icd10;
import me.akedwin.mpharma.icd10.model.Icd10CreateResponse;
import me.akedwin.mpharma.icd10.model.Icd10FindResponse;
import me.akedwin.mpharma.icd10.model.Icd10ListResponse;
import me.akedwin.mpharma.icd10.model.Icd10UpdateModel;
import me.akedwin.mpharma.icd10.service.Icd10Service;

/**
 *
 * @author Edwin
 */
@Path("/api")
public class Icd10RestApi
{
//    private Gson gson =  new Gson();
    
    @Inject private CrudService crudService;
    @Inject private Icd10Service icd10Service;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test()
    {
        return LocalDateTime.now().toString();
    }
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/icd10/find/{fullCode}")
    public Icd10FindResponse findByCode(@PathParam("fullCode") String fullCode)
    {
        Icd10FindResponse response = icd10Service.findByCode(fullCode);
        
        return response;
    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/icd10/create")
    public Icd10CreateResponse icd10Create(Icd10 icd10)
    {
         Icd10CreateResponse response = icd10Service.saveIcd10(icd10);

        return response;
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/icd10/delete/{fullCode}")
    public Icd10FindResponse deleteIcd10(@PathParam("fullCode") String fullCode)
    {
        Icd10FindResponse response = icd10Service.deleteCode(fullCode);
        
        return response;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/icd10/update")
    public Icd10FindResponse updateIcd10(Icd10UpdateModel updateModel)
    {
        Icd10FindResponse response = icd10Service.updateIcd10(updateModel);
        
        return response;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/icd10/list")
    public Icd10ListResponse loadIcd10Codes(@QueryParam("page") int page)
    {        
        int pageSize = 5;
        
        
        return icd10Service.loadIcd10Codes(pageSize, page);
    }
    
    
}
