/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.akedwin.mpharma.icd10.model;

import java.util.List;

/**
 *
 * @author Edwin
 */
public class Icd10ListResponse
{        
    private boolean successful;
    private String error = "";
    private long totalCount;
    private int page;
    private int totalPages;
    private int pageSize;
    
    private List<Icd10> data;

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

    public long getTotalCount()
    {
        return totalCount;
    }

    public void setTotalCount(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public List<Icd10> getData()
    {
        return data;
    }

    public void setData(List<Icd10> data)
    {
        this.data = data;
    }
    
    
    
    
}
