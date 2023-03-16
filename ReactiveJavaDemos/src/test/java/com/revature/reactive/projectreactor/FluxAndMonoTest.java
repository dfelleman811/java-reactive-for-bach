package com.revature.reactive.projectreactor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {
	
	private FluxAndMono fluxAndMono = new FluxAndMono();
	
	@Test
	void namesFlux() {
		
		// when
		Flux<String> namesFlux = fluxAndMono.namesFlux(); 
		
		// this is reactive type so in order to test it we need to have a reactor test library - StepVerifier
		//then
		StepVerifier.create(namesFlux)
			//.expectNext("dan", "jerry", "tom", "chloe")
			.expectNext("dan")
			.expectNextCount(3)
			.verifyComplete();
		
	}
	
	@Test
	void namesMonoTest() {
		
		Mono<String> namesMono = fluxAndMono.namesMono();
		StepVerifier.create(namesMono)
			.expectNextCount(1)
			.verifyComplete();
	}
	
	@Test
	void namesFluxMapTest() {
		
		Flux<String> namesFluxMap = fluxAndMono.namesFluxMap();
		
		StepVerifier.create(namesFluxMap)
			.expectNext("DAN", "JERRY", "TOM", "CHLOE")
			.verifyComplete();
		
	}
	
	@Test
	void namesFluxImmutabilityTest() {
		Flux<String> flux = fluxAndMono.namesFluxImmutability();
		
		StepVerifier.create(flux)
		.expectNext("dan", "jerry", "tom", "chloe")
		.verifyComplete();
	}

}
