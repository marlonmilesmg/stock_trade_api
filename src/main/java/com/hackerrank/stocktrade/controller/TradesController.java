package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {
    @Autowired
    private TradesService tradesService;

    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody Trade trade){

        Trade createdTrade = tradesService.placeTrade(trade);
        if(createdTrade == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTrade);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> findTradeById(@PathVariable Long id){

        Optional<Trade> optionalTrade = tradesService.getTradeById(id);

        if (!optionalTrade.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(optionalTrade.get());

    }

    @GetMapping("/users/{userID}")
    public ResponseEntity<Trade> findAllTradesByUserId(@PathVariable Long userID){

        List<Trade> userTrades = tradesService.findAllTradesWithUserId(userID);

        if (userTrades.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping("/stocks/{stockSymbol}{tradeType}{start}{end}")
    public ResponseEntity<Trade> findAllTradesByStockSymbolAndTradeTypeInDateRange(@PathVariable String stockSymbol, @PathVariable String tradeType, @PathVariable Timestamp start, @PathVariable Timestamp end){

        List<Trade> listTrades = tradesService.findAllTradesWithStockSymbolAndTradeTypeInDateRange(stockSymbol, tradeType, start, end);
        if(listTrades.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @GetMapping
    public ResponseEntity<Trade> findAllTrades(){

        List<Trade> allTrades = tradesService.findAllTrades();
        if(allTrades.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
