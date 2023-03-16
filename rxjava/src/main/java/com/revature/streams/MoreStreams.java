package com.revature.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoreStreams {

    public static void main(String[] args) {

        mapVsFlatMap();

    }

    private static void mapVsFlatMap() {
        String[] hamlet = {"To be, or not to be, that is the question:",
                "Whether 'tis nobler in the mind to suffer",
                "The slings and arrows of outrageous fortune",
                "Or to take Arms against a Sea of troubles,",
                "And by opposing end them: to die, to sleep;"
        };

        Function<String, Stream<String>> fun = s -> Stream.of(s.split(" "));

        System.out.println("Map: ");
        System.out.println(Stream.of(hamlet).map(fun).collect(Collectors.toList()));
        System.out.println(Stream.of(hamlet).count());

        System.out.println("Flat map: ");
        System.out.println(Stream.of(hamlet).flatMap(fun).collect(Collectors.toList()));
        System.out.println(Stream.of(hamlet).flatMap(fun).count());

        System.out.println("Map and FlatMap: ");
        System.out.println(Stream.of(hamlet).map(fun).flatMap(s -> s).collect(Collectors.toList()));
    }
}
