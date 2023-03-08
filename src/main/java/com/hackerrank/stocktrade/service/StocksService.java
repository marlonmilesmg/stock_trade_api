package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.model.Stock;

import java.sql.Timestamp;

public interface StocksService {

    Stock findHighestAndLowestPriceByStockSymbolInDateRange(String symbol, Timestamp start, Timestamp end);
}
