import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.ipv4.IPv4AddressSeqRange;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IPtest {

    private String ip1 = "192.168.1.4";
    private String ip2 = "192.168.0.6";
    private String ip3 = "192.168.1.s";
    private String ip4 = "192.168.0.s";

    private List<String> resulIP;

    @BeforeEach
    void init(){
        resulIP = new ArrayList<>();
    }

    @Test
    private void getIPTestTrue(){
        assertTrue(validateIP(ip1));
        assertTrue(validateIP(ip2));
    }
    @Test
    private void getIPTestFalse() {
        assertFalse(validateIP(ip3));
        assertFalse(validateIP(ip4));
    }

    @Test
    private void getIpEmptuStr(){
        assertFalse(validateIP(""));
        assertFalse(validateIP(""));
    }



    @Test
    private void printIP(){
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
