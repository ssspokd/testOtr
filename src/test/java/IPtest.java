import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.ipv4.IPv4Address;
import inet.ipaddr.ipv4.IPv4AddressSeqRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import  org.apache.commons.validator.routines.InetAddressValidator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPtest {

    private String ip1 = "192.168.1.4";
    private String ip2 = "192.168.0.6";

    private List<String> resulIP;

    @BeforeEach
    public  void init(){
        resulIP = new ArrayList<String>();
    }

    @Test
    public void getIPTest() throws UnknownHostException {
        assertEquals(true, validateIP(ip1));
        assertEquals(true, validateIP(ip2));

        IPAddressString ipAddressString1 =  new IPAddressString(ip1);
        IPAddressString ipAddressString2 =  new IPAddressString(ip2);
        IPAddress addr1 = ipAddressString1.getAddress(),
                 addr2 = ipAddressString2.getAddress();
        IPAddressSeqRange range = addr1.toSequentialRange(addr2);
        System.out.println("count IP address" + ((IPv4AddressSeqRange) range).getIPv4Count());
        range.getIterable().forEach(System.out::println);
    }

    private boolean validateIP(String ip){
        InetAddressValidator validator =  new InetAddressValidator();
        return validator.isValid(ip);
    }
}
