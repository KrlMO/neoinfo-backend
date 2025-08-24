/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.neoinfo.shared.dto;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;


/**
 *
 * @author calmo
 */
public class PaginationDTO<T> {

    private List<T> items;
    private int totalPages;
    private int currentPage;
    private long totalItems;
    private int size;

    public PaginationDTO(Page<T> page) {
        this.items = page.getContent();
        this.totalPages = page.getTotalPages();
        this.currentPage = page.getNumber();
        this.totalItems = page.getTotalElements();
        this.size = page.getSize();
    }

    public PaginationDTO() {
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    

}
