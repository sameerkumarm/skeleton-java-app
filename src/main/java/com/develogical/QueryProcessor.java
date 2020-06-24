package com.develogical;

import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryProcessor {
	
	private static final Logger logger = Logger.getGlobal();
	
    public String process(String query) {
    	logger.log(Level.INFO, "***************" + query + "***************");
        if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("plus")) {
            return "William Shakespeare";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
        	String testString = "which of the following numbers is the largest";
        	String extractedNumbers = query.substring(query.indexOf(testString) + testString.length() + 1);
        	return Stream.of(extractedNumbers.split(","))
        			.map(a -> a.trim())
        			.map(a -> Integer.valueOf(Integer.parseInt(a)))
        			.max(Integer::compare)
        			.orElse(0).toString();
        }
        if (query.toLowerCase().contains("which of the following numbers are primes")) {
        	String testString = "which of the following numbers are primes";
        	Predicate<Integer> primePrdicate = new Predicate<Integer>() {

				@Override
				public boolean test(Integer a) {
					if (a <= 1) return false; 
  			      
    		        // Check from 2 to n-1 
    		        for (int i = 2; i < a; i++) 
    		            if (a % i == 0) 
    		                return false;
    		        System.out.println(a);
    				return true;
				}
        		
			};
        	String extractedNumbers = query.substring(query.indexOf(testString) + testString.length() + 1);
        	return Stream.of(extractedNumbers.split(","))
        			.map(a -> a.trim())
        			.map(a -> Integer.valueOf(Integer.parseInt(a)))
        			.filter(primePrdicate)
        			.peek(a -> System.out.println(a))
        			.map(String::valueOf)
        			.collect(Collectors.toSet()).toString().replace("[", "").replace("]","").replaceAll(" ","").trim();
        }
        
        return "";
    }
}
