import inet.ipaddr.IPAddress;
import inet.ipaddr.IPAddressSeqRange;
import inet.ipaddr.IPAddressString;
import inet.ipaddr.ipv4.IPv4AddressSeqRange;
import org.apache.log4j.Logger;
import utils.Validate;


public class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        if(args.length != 2){
            LOGGER.error("need only 2 arguments \n" +
                    "example 192.168.0.1 192.168.0.100");
        }
        Application application =  new Application();
        application.run(args[0],args[1]);
    }

    public void run(String ip1, String ip2){
        if(!Validate.validateIP(ip1) || !Validate.validateIP(ip2)){
            LOGGER.error("ip1 or ip2 is not valid");
            System.exit(-1);
        }
        printBetweenIPRange(ip1,ip2);
    }

    private void printBetweenIPRange(String ip1, String ip2){
        IPAddressString ipAddressString1 =  new IPAddressString(ip1);
        IPAddressString ipAddressString2 =  new IPAddressString(ip2);
        IPAddress addr1 = ipAddressString1.getAddress(),
                addr2 = ipAddressString2.getAddress();
        IPAddressSeqRange range = addr1.toSequentialRange(addr2);
        System.out.println("count IP address" + ((IPv4AddressSeqRange) range).getIPv4Count());
        range.getIterable().forEach(LOGGER::info);
    }
}
