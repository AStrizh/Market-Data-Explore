package com.strizhevskiy.market_data;

public record PublicQuote(
        String ticker,
        double open,
        double close,
        double high,
        double low,
        long volume,
        double vwap,
        long timestamp,
        int numTrades
) {}
