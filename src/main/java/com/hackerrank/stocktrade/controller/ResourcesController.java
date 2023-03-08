package com.hackerrank.stocktrade.controller;

import com.hackerrank.stocktrade.dao.TradeRepository;
import com.hackerrank.stocktrade.model.Trade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
    private TradeRepository tradeRepository;

    @PostMapping
    public ResponseEntity<Trade> eraseAllRecords(){
        tradeRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
