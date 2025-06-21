package com.strizhevskiy.market_data;


import java.util.List;

public record PolygonTickerResponse(
        String ticker,
        List<QuoteResponse> results
) {}