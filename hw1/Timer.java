package hw1;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

/**
 * This demonstrates that Vector is slower than ArrayList; I believe this is the case
 * because Vector is thread-safe, while ArrayList is not. Synchronized actions force
 * it to be a little slower.
 */
public class Timer {
    public static void timeFill(String name, List<Integer> buffer, long numberOfValues){
        long start = System.nanoTime();
        for(int i = 0; i < numberOfValues; i++){
            buffer.add(i);
        }
        long end = System.nanoTime();

        long time = (end - start);
        System.out.println(String.format("Filled %s with %,d values in %,d nanoseconds.",name, buffer.size(), time));
    }
    public static void main(String[] args) {
        List<Integer> buffer1 = new ArrayList<>();
        List<Integer> buffer2 = new Vector<>();
        Thread arraylistfill = new Thread( () -> {
            
            timeFill("ArrayList", buffer1, 100000000);            
            
        });
        Thread vectorlistfill = new Thread( () -> {
            
            timeFill("Vector", buffer2, 100000000);
        });

        arraylistfill.start();
        vectorlistfill.start();
    }
}
