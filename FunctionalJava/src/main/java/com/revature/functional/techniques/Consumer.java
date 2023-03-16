package com.revature.functional.techniques;

import java.util.Objects;

/**
 * We are creating our own - this already exists in java.util.function
 * @author DanielFelleman
 *
 */
@FunctionalInterface
public interface Consumer<T> {

	void accept(T t);

	// we need to make this default so that this can remain a functional interface
	// we also want to supply implementation for this method here
	default Consumer<T> thenAccept(Consumer<T> next) {
		
		Objects.requireNonNull(next); // for safety - so we can't create a conusmer chain that will throw an exception
		
		return (T t) -> {
			this.accept(t);
			next.accept(t);
		};
		
	}
	
}
