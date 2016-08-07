<<<<<<< HEAD
package lib.payjinn.hostedpayments;

import com.google.gson.Gson;

public class NewPaymentReply
{
    public String paymentURL;
    public String transactionId;
    
    public static NewPaymentReply ParseJSON(String json)
    {
    	return new Gson().fromJson(json, NewPaymentReply.class);
    }
=======
package lib.payjinn.hostedpayments;

import com.google.gson.Gson;

public class NewPaymentReply
{
    public String paymentURL;
    public String transactionId;
    
    public static NewPaymentReply ParseJSON(String json)
    {
    	return new Gson().fromJson(json, NewPaymentReply.class);
    }
>>>>>>> origin/master
}