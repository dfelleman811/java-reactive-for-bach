package com.revature.reactive.projectreactor;

import java.time.Duration;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMono {
	
	
	public static void main(String[] args) {
		
		
		FluxAndMono fluxAndMono = new FluxAndMono();
		
		
		System.out.println("*******Flux********");
		// consume the values from the flux
		// by subscribing (nothing happens until you subscribe!)
		fluxAndMono.namesFlux()
			.subscribe(System.out::println);
		
		System.out.println("*******Mono********");
		fluxAndMono.namesMono()
			.subscribe(System.out::println);
		
		
		System.out.println("*******Map Operator********");
		fluxAndMono.namesFluxMap()
			.subscribe(System.out::println);
		
		
		System.out.println("*******Immutability********");
		fluxAndMono.namesFluxImmutability()
			.subscribe(System.out::println);
		
	}
	
	public Flux<String> namesFluxImmutability() {
		Flux<String> namesFlux = Flux.fromIterable(List.of("dan", "jerry", "tom", "chloe"));
		namesFlux.map(String::toUpperCase);
		return namesFlux;
		
	}

	public Flux<String> namesFluxMap() {
		return Flux.fromIterable(List.of("dan", "jerry", "tom", "chloe"))
				//.map(name -> name.toUpperCase())
				.map(String::toUpperCase)
				.delayElements(Duration.ofSeconds(2))
				.log();
	}

	// function to return a flux of type string - this is a Publisher
	public Flux<String> namesFlux() {
		
		return Flux.fromIterable(List.of("dan", "jerry", "tom", "chloe"))
				.log(); // in reality this might be coming from a DB or a remote service call
		
	}
	
	// function to return a Mono - this is a Publisher
	public Mono<String> namesMono() {
		
		return Mono.just("dan")
				.log();
		
	}
	
	

	// N.B. See src/test/java for simple example unit tests
}
