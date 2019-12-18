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

public class Icd10
{
    private String fullCode;
    private String categoryCode;
    private String diagnosisCode;
    private String abbreviatedDescription;
    private String fullDescription;
    private String categoryTitle;

    public String getFullCode()
    {
        return fullCode;
    }

    public void setFullCode(String fullCode)
    {
        this.fullCode = fullCode;
    }

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode)
    {
        this.categoryCode = categoryCode;
    }

    public String getDiagnosisCode()
    {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode)
    {
        this.diagnosisCode = diagnosisCode;
    }

    public String getAbbreviatedDescription()
    {
        return abbreviatedDescription;
    }

    public void setAbbreviatedDescription(String abbreviatedDescription)
    {
        this.abbreviatedDescription = abbreviatedDescription;
    }

    public String getFullDescription()
    {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription)
    {
        this.fullDescription = fullDescription;
    }

    public String getCategoryTitle()
    {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle)
    {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.fullCode);
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
        final Icd10 other = (Icd10) obj;
        if (!Objects.equals(this.fullCode, other.fullCode))
        {
            return false;
        }
        return true;
    }
    
    
}
