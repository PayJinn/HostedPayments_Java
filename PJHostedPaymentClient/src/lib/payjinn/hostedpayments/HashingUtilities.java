package lib.payjinn.hostedpayments;

import java.io.UnsupportedEncodingException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.function.BooleanSupplier;

public class HashingUtilities 
{
	private HashingUtilities() {}

    private static String ToHexString(byte[] byteArray, int offset, int outputCount) 
    {
	   StringBuilder sb = new StringBuilder();
	   
	   for (int i=offset;i<offset+outputCount;i++)
	      sb.append(String.format("%02x", byteArray[i] & 0xff));
	   
	   return sb.toString().toUpperCase();
	}
	   
	private static String CreateSHA512Hash(String data) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] bytes = md.digest(data.getBytes("UTF-8"));
            
	    return ToHexString(bytes, 0, bytes.length);
	}
	
    public static Boolean ValidateResponseHash(
            String clientId,
            String apiKey,
            String sessionCode,
            String orderCode,
            String payjinnStatus,
            String responseHash) throws UnsupportedEncodingException, NoSuchAlgorithmException
	{
	    // Hashed_APIKey = SHA512(Clear_APIKey + ClientId)
	    String hashedAPIKey = CreateSHA512Hash(apiKey + clientId);
	
	    // SHA512(ClientId + Hashed_APIKey + SessionCode + ClientOrderCode + PayJinnStatus)
	    String calculatedHash = CreateSHA512Hash(clientId + hashedAPIKey + sessionCode + orderCode + payjinnStatus);
	
	    // Compare results
	    if (calculatedHash.toUpperCase().equals(responseHash.toUpperCase()))
	        return true;
	    else
	        return false;
	}
}
