package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dao.StocksRepository;
import com.hackerrank.stocktrade.model.Stock;

import java.sql.Timestamp;

public class StocksServiceImpl implements StocksService{

    public final StocksRepository stocksRepository;

    public StocksServiceImpl(StocksRepository stocksRepository) {
        this.stocksRepository = stocksRepository;
    }


    @Override
    public Stock findHighestAndLowestPriceByStockSymbolInDateRange(String symbol, Timestamp start, Timestamp end) {
        return stocksRepository.findHighestAndLowestPriceByStockSymbolInDateRange(symbol, start, end);
    }
}
