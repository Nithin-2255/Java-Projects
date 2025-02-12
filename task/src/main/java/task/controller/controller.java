package task.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import task.service.service;
@RestController
@RequestMapping("/api")
public class controller 
{       
	    @Autowired
	    service s;
        @GetMapping("/rates")
	    public Map<String, Object> getExchangeRates(@RequestParam() String base) 
        {
	        Map<String, Object> response = new HashMap();
	        response.put("base", base);
	        response.put("rates", s.getExchangeRates(base));
	        return response;
	    }

	    @PostMapping("/convert")
	    public Map<String, Object> convertCurrency(@RequestBody Map<String, Object> request)
	    {
	    String from = (String) request.get("from");
        String to = (String) request.get("to");
        Double amount = ((Number) request.get("amount")).doubleValue();

        Double convertedAmount = s.convertCurrency(from, to, amount);

        Map<String, Object> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);
        response.put("amount", amount);
        response.put("convertedAmount", convertedAmount);
        return response;
	    }
	}

