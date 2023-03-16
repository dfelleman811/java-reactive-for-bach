package com.revature.functional.techniques.composition;

// again this already exists - we are breaking it down to do our own and see how compose works
@FunctionalInterface
public interface Function<T, R> {

	R apply(T t);

	// will takes a square and directly returns the length of the square
	default <V> Function<V, R> compose(Function<V, T> before) {
		
		return (V v) -> apply(before.apply(v));
		
		// note that we are executing/invoking the function passed into the compose method first (fun1)
		// and then calling apply on its result (fun2)
		
		
	}
	
}
