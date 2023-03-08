package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Stock;
import com.hackerrank.stocktrade.service.StocksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/stocks")
public class StocksController {

    private StocksService stocksService;
    @GetMapping("/{symbol}/price{start}{end}")
    public ResponseEntity<Stock> findHighestAndLowestPriceByStockSymbolInDateRange(@PathVariable String symbol, @PathVariable Timestamp start, @PathVariable Timestamp end){

       Stock stock = stocksService.findHighestAndLowestPriceByStockSymbolInDateRange(symbol, start, end);
       if(stock == null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }

        return ResponseEntity.status(HttpStatus.OK).body(stock);

    }


}
