package com.revature.functional.basics;

/**
 * Generic interface to configure the product produced by {@link com.revature.functional.basics.IProducer}
 * 
 * @author DanielFelleman
 *
 * @param <T>
 * @param <R>
 */
public interface IConfigurator<T, R> {

	/**
	 * Generic method to take the product and configure it
	 * 
	 * @param t
	 * @return <R>
	 */
	R configure(T t);
	
}
