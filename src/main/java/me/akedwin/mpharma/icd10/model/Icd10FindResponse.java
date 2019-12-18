/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.model;

import java.util.Objects;

/**
 *
 * @author Edwin
 */
public class Icd10FindResponse
{        
    private boolean successful;
    private String error = "";
    private Icd10 data ;

    public boolean isSuccessful()
    {
        return successful;
    }

    public void setSuccessful(boolean successful)
    {
        this.successful = successful;
    }

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public Icd10 getData()
    {
        return data;
    }

    public void setData(Icd10 data)
    {
        this.data = data;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 53 * hash + (this.successful ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.error);
        hash = 53 * hash + Objects.hashCode(this.data);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Icd10FindResponse other = (Icd10FindResponse) obj;
        if (this.successful != other.successful)
        {
            return false;
        }
        if (!Objects.equals(this.error, other.error))
        {
            return false;
        }
        if (!Objects.equals(this.data, other.data))
        {
            return false;
        }
        return true;
    }

    
    
    
}
