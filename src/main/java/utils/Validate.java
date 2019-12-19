package utils;

import org.apache.commons.validator.routines.InetAddressValidator;

public class Validate {
    public static boolean validateIP(String ip){
        InetAddressValidator validator =  new InetAddressValidator();
        return validator.isValid(ip);
    }
}
