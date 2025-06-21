package com.strizhevskiy.market_data;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class StockQuoteController {

    @GetMapping("/api/quote")
    public QuoteResponse getMockQuote(@RequestParam String symbol) {
        // Mocked quote value
        return new QuoteResponse(
                symbol.toUpperCase(),
                new BigDecimal("217.35"),
                LocalDateTime.now()
        );
    }

    // Inner class to define the response format
    public record QuoteResponse(String symbol, BigDecimal price, LocalDateTime timestamp) {}
}