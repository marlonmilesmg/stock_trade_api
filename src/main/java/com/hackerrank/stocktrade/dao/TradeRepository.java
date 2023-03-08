package com.hackerrank.stocktrade.dao;

import com.hackerrank.stocktrade.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Query(value = "SELECT * FROM Trades t WHERE t.id =: id", nativeQuery = true)
    List<Trade> findAllWithUserId(@Param("id") Long id);

    @Query(value = "SELECT * FROM Trades t WHERE t.symbol =: symbol and t.type =: type between t.timestamp =: timestamp and t.timestamp =: timestamp1", nativeQuery = true)
    List<Trade> findAllTradesByStockSymbolAndTradeTypeInDateRange(@Param("symbol") String symbol, @Param("type") String type, @Param("timestamp") Timestamp timestamp, @Param("timestamp1") Timestamp timestamp1);
}
