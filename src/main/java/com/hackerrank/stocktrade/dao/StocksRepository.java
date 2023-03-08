package com.hackerrank.stocktrade.dao;

import com.hackerrank.stocktrade.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface StocksRepository extends JpaRepository {

    @Query(value = "SELECT symbol FROM Stocks s WHERE s.symbol =: symbol and MAX(s.price) and MIN(s.price) between s.timestamp =: start and s.timestamp =: end", nativeQuery = true)
    Stock findHighestAndLowestPriceByStockSymbolInDateRange(@Param("symbol") String symbol, @Param("start") Timestamp start, @Param("end") Timestamp end);
}
