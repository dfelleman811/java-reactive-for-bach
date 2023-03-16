package com.revature.observesubscribe;

import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

public class Playground {

  public static void main(String[] args) {



    Observable<String> observable = Observable.just("Hello");

    observable.subscribe(System.out::println);

    String[] letters = {"a", "b", "c", "d", "e", "f", "g"};

    Observable<String> letterObservable = Observable.fromArray(letters);

    letterObservable.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println(""));

  }

}
