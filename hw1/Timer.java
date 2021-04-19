package hw1;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * This demonstrates that Vector is slower than ArrayList; I believe this is the case
 * because Vector is thread-safe, while ArrayList is not. Synchronized actions force
 * it to be a little slower.
 */
public class Timer {
    public static long timeFill(String name, List<Integer> buffer, long numberOfValues){
        long start = System.nanoTime();
        for(int i = 0; i < numberOfValues; i++){
            buffer.add(i);
        }
        long end = System.nanoTime();

        return (end - start);
    }
    public static void main(String[] args) {
        List<Integer> buffer1 = new ArrayList<>();
        List<Integer> buffer2 = new Vector<>();
        Thread arraylistfill = new Thread( () -> {
            
            long time = timeFill("ArrayList", buffer1, 100000000);
            System.out.println("Filled ArrayList with " + buffer1.size() + " values in " + time + " nanoseconds.");
            
            
        });
        Thread vectorlistfill = new Thread( () -> {
            
            long time = timeFill("Vector", buffer2, 100000000);
            System.out.println("Filled vector with " + buffer2.size() + " values in " + time + " nanoseconds.");

        });

        arraylistfill.start();
        vectorlistfill.start();
    }
}
