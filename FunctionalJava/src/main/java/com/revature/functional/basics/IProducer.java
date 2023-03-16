package com.revature.functional.basics;

/**
 * A generic interface that produces the product in this Higher Order Function example
 * @see com.revature.functional.basics.HigherOrderFunctions
 * 
 * @author DanielFelleman
 *
 * @param <T>
 */
public interface IProducer<T> {
	
	/**
	 * Generic method to create the 'product' object itself
	 * @return <T>
	 */
	T produce();

}
