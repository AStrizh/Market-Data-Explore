package com.strizhevskiy.market_data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record QuoteResponse(
    @JsonProperty("T") String ticker,
    @JsonProperty("o") double open,
    @JsonProperty("h") double high,
    @JsonProperty("l") double low,
    @JsonProperty("c") double close,
    @JsonProperty("v") long volume,
    @JsonProperty("vw") double vwap,
    @JsonProperty("t") long timestamp,
    @JsonProperty("n") int numTrades
) {}