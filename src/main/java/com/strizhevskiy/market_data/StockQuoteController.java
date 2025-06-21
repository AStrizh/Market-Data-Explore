package com.strizhevskiy.market_data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockQuoteController {

    private final PolygonService polygonService;

    public StockQuoteController(PolygonService polygonService) {
        this.polygonService = polygonService;
    }

    @GetMapping("/api/quote")
    public PublicQuote getLiveQuote(@RequestParam String symbol) {
        QuoteResponse raw = polygonService.fetchQuote(symbol);

        return new PublicQuote(
                raw.ticker(), raw.open(), raw.close(), raw.high(),
                raw.low(), raw.volume(), raw.vwap(), raw.timestamp(), raw.numTrades()
        );
    }
}
