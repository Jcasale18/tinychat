package hw1;
public class EvensAndOdds {
    public static void main(String[] args) {
        Object lockevens = new Object();
        Object lockodds = new Object();


        Thread odds = new Thread( () -> {
            for(int i = 1; i < 100; i+=2){
                System.out.println(i);
                
                synchronized(lockevens){
                    lockevens.notify();
                }
                try {
                    synchronized(lockodds){
                        lockodds.wait();
                    }
                } catch (InterruptedException e) {}
            }
            synchronized(lockevens){
                lockevens.notifyAll();
            }      
            
        });
        Thread evens = new Thread( () -> {
            synchronized(lockevens){
                try {
                    lockevens.wait();
                } catch (InterruptedException e) {
                }
            }
                //wait since even starts after odd starts with 1.
            for(int i = 2; i < 101; i+=2){
                System.out.println(i);
                synchronized(lockodds){
                    lockodds.notify();
                }

                try {
                    synchronized(lockevens){
                        lockevens.wait();
                    }
                } catch (InterruptedException e1) {}
            }
            synchronized(lockodds){
                lockodds.notifyAll();
            }
        });

        odds.start();
        evens.start();
    
    }
}
