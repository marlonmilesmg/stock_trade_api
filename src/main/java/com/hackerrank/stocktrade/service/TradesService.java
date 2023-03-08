package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.model.Trade;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface TradesService {

    Trade placeTrade(Trade trade);

    Optional<Trade> getTradeById(Long id);


    List<Trade> findAllTradesWithUserId(Long id);


    List<Trade> findAllTradesWithStockSymbolAndTradeTypeInDateRange(String symbol, String type, Timestamp timestamp, Timestamp timestamp1);


    List<Trade> findAllTrades();


}
