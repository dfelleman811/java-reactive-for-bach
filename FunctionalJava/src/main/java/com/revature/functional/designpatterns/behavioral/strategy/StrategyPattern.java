package com.revature.functional.designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {
	
	public static void main(String[] args) {
		
		List<Stock> stocks = new ArrayList<>();
		
		stocks.add(new Stock("IBM", 576.3, 33));
		stocks.add(new Stock("GLG", 76.3, 212));
		stocks.add(new Stock("POF", 7856.3, 22.6));
		stocks.add(new Stock("IBM", 53, 45));
		stocks.add(new Stock("IBM", 257.3, 42));
		stocks.add(new Stock("STA", 460.3, 2));
		stocks.add(new Stock("AMZ", 226.3, 3));
		
		
		StockFilters.bySymbol(stocks, "IBM").forEach(System.out::println);
		
		System.out.println("*****************");
		
		StockFilters.byPrice(stocks, 300).forEach(System.out::println);
		
		System.out.println("*****************");
		
		StockFilters.byUnit(stocks, 20).forEach(System.out::println);
		
		System.out.println("*****************");
		
		// using the filter and supplying the predicate using lambdas at runtime
		
		StockFilters.filter(stocks, stock -> stock.getSymbol().equals("IBM")).forEach(System.out::println);;
		StockFilters.filter(stocks, stock -> stock.getPrice() >= 300).forEach(System.out::println);;
		StockFilters.filter(stocks, stock -> stock.getUnits() >= 20).forEach(System.out::println);;
		
		
	}

}
