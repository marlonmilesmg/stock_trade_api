package com.hackerrank.stocktrade.model;

public class Stock {

    private Long id;
    private Float maxPrice;
    private Float minPrice;

    public Stock() {
    }

    public Stock(Long id, Float maxPrice, Float minPrice) {
        this.id = id;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }
}
