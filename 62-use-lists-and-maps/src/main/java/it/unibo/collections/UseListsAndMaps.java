package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int START = 1000;
        final int END = 2000;

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = START; i < END; i++) {
            numbers.add(i);
        }
        IO.println(numbers);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> numbersLinked = new LinkedList<>(numbers);
        //numbersLinked.addAll(numbers);
        IO.println(numbersLinked);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer temp = numbers.getFirst();
        numbers.set(0, numbers.getLast());
        numbers.set(numbers.size()-1, temp);
        IO.println(numbers);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer elm : numbers) {
            IO.println(elm);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int N_ELEMENTS = 100000;

        long timeArrayList = System.nanoTime();
        for (int i = 0; i < N_ELEMENTS; i++) {
            numbers.add(0, i);
        }
        timeArrayList = System.nanoTime() - timeArrayList;

        long timeLinkedList = System.nanoTime();
        for (int i = 0; i < N_ELEMENTS; i++) {
            numbersLinked.add(0, i);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;

        var millisArrayList = TimeUnit.NANOSECONDS.toMillis(timeArrayList);
        var millisLinkedList = TimeUnit.NANOSECONDS.toMillis(timeLinkedList);

        IO.println("Arraylist time: " + millisArrayList + "ms \nLinked List time: " + millisLinkedList + "ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        final int READING_TIMES = 1000;

        int middle = numbers.size()/2;

        timeArrayList = System.nanoTime();
        for (int i = 0; i < READING_TIMES; i++) {
            numbers.get(middle);
        }
        timeArrayList = System.nanoTime() - timeArrayList;

        middle = numbersLinked.size()/2;

        timeLinkedList = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            numbersLinked.get(middle);
        }
        timeLinkedList = System.nanoTime() - timeLinkedList;

        millisArrayList = TimeUnit.NANOSECONDS.toMillis(timeArrayList);
        millisLinkedList = TimeUnit.NANOSECONDS.toMillis(timeLinkedList);

        IO.println("Arraylist time: " + millisArrayList + "ms \nLinked List time: " + millisLinkedList + "ms");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Long POPULATION_AFRICA = 1110635000L;
        final Long POPULATION_AMERICANS = 972005000L;
        final Long POPOLATION_ANTARTICA = 0L;
        final Long POPULATION_ASIA = 4298723000L;
        final Long POPULATION_EUROPE = 742452000L;
        final Long POPULATION_OCENIA = 38304000L;

        Map<String, Long> mapContinents = new HashMap<>();
        mapContinents.put("Africa", POPULATION_AFRICA);
        mapContinents.put("Americas", POPULATION_AMERICANS);
        mapContinents.put("Antartica", POPOLATION_ANTARTICA);
        mapContinents.put("Asia", POPULATION_ASIA);
        mapContinents.put("Europe", POPULATION_EUROPE);
        mapContinents.put("Ocenia", POPULATION_OCENIA);
        IO.println(mapContinents);
        /*
         * 8) Compute the population of the world
         */
        Long worldPopulation = 0L;
        for (Long elm : mapContinents.values()) {
            worldPopulation += elm;
        }
        IO.println(worldPopulation);
    }
}
