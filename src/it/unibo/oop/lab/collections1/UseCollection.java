package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {
	
	private static final int N_ELEMENTS = 1_000;
	private static final int OFFSET = 1_000;
	private static final int ELEMENTS_TO_ADD = 100_000;
	private static final int TO_MS = 1_000_000;
	private static final int TIMES_TO_READ = 1_000;

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {

        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	
    	ArrayList<Integer> arrayList = new ArrayList<Integer>();
    	
    	for(int i=0;i<N_ELEMENTS;i++) {
    		arrayList.add(i+OFFSET);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	
    	LinkedList<Integer> linkedList = new LinkedList<Integer>();
    	linkedList.addAll(arrayList);
    	
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	
    	int tmp = arrayList.get(arrayList.size()-1);
    	arrayList.set(arrayList.size()-1, arrayList.get(0));
    	arrayList.set(0,tmp);
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	
    	for(int n: arrayList ) {
    		System.out.println(n);
    	}
    	
    	
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	
    	long time = System.nanoTime();
    	
    	for(int i=0;i<ELEMENTS_TO_ADD;i++) {
    		arrayList.add(0,i);
    	}
    	
    	time = System.nanoTime() - time;
        System.out.println("Adding " + ELEMENTS_TO_ADD
                + " int in an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        
        time = System.nanoTime();
        
        for(int i=0;i<ELEMENTS_TO_ADD;i++) {
    		linkedList.addFirst(i);
    	}
        
        time = System.nanoTime() - time;
        System.out.println("Adding " + ELEMENTS_TO_ADD
                + " int in a LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        
        time = System.nanoTime();
        
        for(int i = 0;i<TIMES_TO_READ;i++) {
        	tmp = arrayList.get((arrayList.size()-1) / 2 );
        }
        
        time = System.nanoTime() - time;
        System.out.println("Reading " + TIMES_TO_READ
                + " int in an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        
        time = System.nanoTime();
        
        for(int i = 0;i<TIMES_TO_READ;i++) {
        	tmp = linkedList.get((linkedList.size()-1) / 2 );
        }
        
        time = System.nanoTime() - time;
        System.out.println("Reading " + TIMES_TO_READ
                + " int in an ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
        
        Map<String,Integer> worldPopulation = new HashMap<>();
        
        
        
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
        
        worldPopulation.put("Africa", 1_110_635);
        worldPopulation.put("Americas", 972_005);
        worldPopulation.put("Antartica", 0);
        worldPopulation.put("Asia", 4_298_723);
        worldPopulation.put("Europe", 742_452);
        worldPopulation.put("Oceania", 38_304);
        
        /*
         * 8) Compute the population of the world
         */
        
        int totalPopulation = 0;
        
        for(int peoples : worldPopulation.values()) {
        	totalPopulation += peoples;
        }
        
        System.out.println("There are " + totalPopulation + " pepoles in the world");
    }
}
