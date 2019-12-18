/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 *
 * @author Edwin
 */
@Entity
@Table(name = "icd_10", indexes = {@Index(columnList = "full_code")})
public class Icd10Entity implements Serializable
{

    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "category_code")
    private String categoryCode;
    
    @Column(name = "diagnosis_code")
    private String diagnosisCode;
    
    @Column(name = "full_code")
    private String fullCode;

    @Column(name = "abbreviated_description")
    private String abbreviatedDescription;

    @Column(name = "full_description")
    private String fullDescription;

    @Column(name = "category_title")
    private String categoryTitle;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
    
    public LocalDateTime getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate)
    {
        this.createdDate = createdDate;
    }
    
    public String getFullCode()
    {
        return fullCode;
    }

    public void setFullCode(String fullCode)
    {
        this.fullCode = fullCode;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Icd10Entity other = (Icd10Entity) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "Icd10Entity{" + "id=" + id + ", categoryCode=" + categoryCode + ", diagnosisCode=" + diagnosisCode + ", fullCode=" + fullCode + ", abbreviatedDescription=" + abbreviatedDescription + ", fullDescription=" + fullDescription + ", categoryTitle=" + categoryTitle + ", createdDate=" + createdDate + '}';
    }

}
