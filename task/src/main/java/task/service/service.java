package task.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class service
{
	@Value("${exchange.rates.api.url}")
     private String apiUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getExchangeRates(String baseCurrency) 
    {
    	  String url = apiUrl+ "/" + baseCurrency;
    	 System.out.println(url);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        if (response != null && response.containsKey("conversion_rates")) 
        {
            return (Map<String, Double>) response.get("conversion_rates");
        }
        throw new RuntimeException("Failed to fetch exchange rates");
  
    }
    public Double convertCurrency(String from, String to, Double amount) 
    {
        Map<String, Double> rates = getExchangeRates(from);
        if (rates.containsKey(to))
        {
            return amount * rates.get(to);
        }
        throw new IllegalArgumentException("Invalid currency code: " + to);
    }
}
