package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.dao.TradeRepository;
import com.hackerrank.stocktrade.model.Trade;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class TradesServiceImpl implements TradesService{

    public final TradeRepository tradeRepository;

    public TradesServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Trade placeTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    public Optional<Trade> getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    @Override
    public List<Trade> findAllTradesWithUserId(Long id) {
        return tradeRepository.findAllWithUserId(id);
    }

    @Override
    public List<Trade> findAllTradesWithStockSymbolAndTradeTypeInDateRange(String symbol, String type, Timestamp timestamp, Timestamp timestamp1) {
        return tradeRepository.findAllTradesByStockSymbolAndTradeTypeInDateRange(symbol, type, timestamp, timestamp1);
    }

    @Override
    public List<Trade> findAllTrades() {
        return tradeRepository.findAll();
    }
}
