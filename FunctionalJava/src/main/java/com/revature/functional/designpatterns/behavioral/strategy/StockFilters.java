package com.revature.functional.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class StockFilters {
	
	// methods to filter the stocks
	
	// by symbol
	public static List<Stock> bySymbol(List<Stock> listToFilter, String symbol) {
		
		List<Stock> filteredList = new ArrayList<>();
		
		for (Stock s : listToFilter) {
			if (s.getSymbol().equals(symbol))
				filteredList.add(s);
		}
		
		return filteredList;
		
	}
	
	// by price above a certain value
	public static List<Stock> byPrice(List<Stock> listToFilter, double price) {
		
		List<Stock> filteredList = new ArrayList<>();
		
		for (Stock s : listToFilter) {
			if (s.getPrice() >= price)
				filteredList.add(s);
		}
		
		return filteredList;
		
	}
	
	// by quantity
	public static List<Stock> byUnit(List<Stock> listToFilter, double units) {
		
		List<Stock> filteredList = new ArrayList<>();
		
		for (Stock s: listToFilter) {
			if (s.getUnits() >= units)
				filteredList.add(s);
		}
		
		return filteredList;
		
	}
	
	
	// lots of repetitive code right? 
	// we can condense this into one filter method - requiring a predicate to use as a coditional filter at runtime
	
	
	public static List<Stock> filter(List<Stock> listToFilter, Predicate<Stock> predicate) {
		
		List<Stock> filteredList = new ArrayList<>();
		
		for (Stock s : listToFilter) {
			
			if (predicate.test(s)) 
				filteredList.add(s);
		}
		
		return filteredList;
		
	}
	
	

}
