/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.model;

import java.util.Objects;
import me.akedwin.mpharma.icd10.constants.ValidationStatus;

/**
 *
 * @author Edwin
 */
public class Icd10CreateResponse
{   
    private boolean successful;
    private String error = "";
    private ValidationStatus validationStatus ;

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

    public ValidationStatus getValidationStatus()
    {
        return validationStatus;
    }

    public void setValidationStatus(ValidationStatus validationStatus)
    {
        this.validationStatus = validationStatus;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 53 * hash + (this.successful ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.error);
        hash = 53 * hash + Objects.hashCode(this.validationStatus);
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
        final Icd10CreateResponse other = (Icd10CreateResponse) obj;
        if (this.successful != other.successful)
        {
            return false;
        }
        if (!Objects.equals(this.error, other.error))
        {
            return false;
        }
        if (this.validationStatus != other.validationStatus)
        {
            return false;
        }
        return true;
    }

    
    
    
}
