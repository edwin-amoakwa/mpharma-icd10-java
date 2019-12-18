/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.service;

import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edwin
 */
@Named
@ApplicationScoped

public class CrudService
{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("icd10PU");
    private EntityManager em = emf.createEntityManager();

    public String generateId()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

//    @PostConstruct
    public void init()
    {
        System.out.println("DB Connection initialised");
    }

    public EntityManager getEm()
    {
        return em;
    }

    public <T> T persist(Object object)
    {

        em.getTransaction().begin();
        try
        {
            em.persist(object);
            em.getTransaction().commit();

            return (T) object;
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally
        {
//            em.close();
        }

        return null;
    }

    public int execueUpdate(String qryString)
    {

        em.getTransaction().begin();
        try
        {
           int affected = em.createQuery(qryString).executeUpdate();
            em.getTransaction().commit();
            return affected;
        } catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally
        {
//            em.close();
        }

        return 0;
    }

}
