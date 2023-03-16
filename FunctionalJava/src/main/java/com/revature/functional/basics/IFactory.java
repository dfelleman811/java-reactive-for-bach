package com.revature.functional.basics;

/**
 * Takes care of the process of producing and configuring the product
 * Producing {@link com.revature.functional.basics.IProducer}
 * Configuring {@link com.revature.functional.basics.IConfigurator}
 * @author DanielFelleman
 *
 * @param <T>
 */
public interface IFactory<T> {
	
	T create();

}
