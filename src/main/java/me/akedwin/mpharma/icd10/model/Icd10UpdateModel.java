/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.model;

/**
 *
 * @author Edwin
 */

public class Icd10UpdateModel
{
    private String fullCode;
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
    
    
}
