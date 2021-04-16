package activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo{
    public static void main(String[] args) throws UnknownHostException{

        InetAddress host = InetAddress.getLocalHost();
        System.out.println(host.getHostName());
        System.out.println(host.getHostAddress());
        InetAddress loopback = InetAddress.getLoopbackAddress();
        System.out.println(loopback.getHostName());
        System.out.println(loopback.getHostAddress());


        InetAddress rit = InetAddress.getByName("cs.rit.edu");
        System.out.println(rit.getHostName());
        System.out.println(rit.getHostAddress());
    }
}