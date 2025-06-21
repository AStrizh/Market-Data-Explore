package com.strizhevskiy.market_data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PolygonService {

    @Value("${polygon.api.key}")
    private String apiKey;


    private final RestTemplate restTemplate = new RestTemplate();

    public QuoteResponse fetchQuote(String symbol) {
        String url = String.format("https://api.polygon.io/v2/aggs/ticker/%s/prev?adjusted=true&apiKey=%s", symbol, apiKey);

        PolygonTickerResponse response = restTemplate.getForObject(url, PolygonTickerResponse.class);

        if (response == null || response.results() == null) {
            throw new RuntimeException("No results found");
        }

        return response.results().getFirst();
    }
}
