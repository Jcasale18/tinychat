

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SearchPrinter {

    public static void main(String[] args) {
        URL yahoo = null;
        try{
            yahoo = new URL("https://search.yahoo.com");
    
        }catch(MalformedURLException e){
            System.out.println("badurl");
        }  
        
        
        try{
            URLConnection connectionYahoo = yahoo.openConnection();
            connectionYahoo.connect();
            InputStream inputStream = connectionYahoo.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            System.out.println(scanner.nextLine());
            scanner.close();

        }catch(IOException e){
            System.out.println("Can't connect to site");
        }
    }

}
