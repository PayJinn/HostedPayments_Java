<<<<<<< HEAD
package demo.payjinn.hostedpayments;

import lib.payjinn.hostedpayments.HostedPaymentsClient;
import lib.payjinn.hostedpayments.NewPaymentReply;
import lib.payjinn.hostedpayments.NewPaymentRequest;
import lib.payjinn.hostedpayments.PaymentDetailReply;

public class HostedPaymentsAPIDemo 
{
	public static void main(String[] args) 
	{
		try
		{
			// Set api credentials (call once per run)
			HostedPaymentsClient.SetAPICredentials("TEST0001", "12345678");
			
			// Start a 1.25 EU transaction for TEST0001 user code whose API Key is 12345678
			NewPaymentRequest newPaymentRequest = new NewPaymentRequest
			(
				HostedPaymentsClient.getClientId() 	// Your PayJinn API Client Id
				,"" 		// Your specific order code goes here,  Max 128 characters 
				,1.25 		// Transaction amount in EURO with 2 significant digits after decimal seperator
				,"" 		// "www.YourCompanyURL.com/Notify" - Where should we redirect if an error occurs, Max 256 characters
				,"" 		// "www.YourCompanyURL.com/Success" - Where should we redirect if transaction ends successfully, Max 256 characters
				,"" 		// Base Account IBAN, send empty string to use default account, 0 (for default account ) or 22 characters
			);
						
			NewPaymentReply newPaymentReply = HostedPaymentsClient.NewPaymentClient(newPaymentRequest);
			
			// Print out result
			if (newPaymentReply != null)
			{
				System.out.println("NewPayment Result:");
				System.out.println("PayJinn Transaction Id: " + newPaymentReply.transactionId);
				System.out.println("PayJinn Payment Session URL: " + newPaymentReply.paymentURL);
				System.out.println("");
				
				// Query session details
				PaymentDetailReply paymentDetailReply = HostedPaymentsClient.GetPaymentDetailsClient(newPaymentReply.transactionId);
				
				if (paymentDetailReply != null)
				{
					// Print out result
					System.out.println("GetPaymentDetails Result:");
					System.out.println(paymentDetailReply.toString());
					System.out.println("");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
=======
package demo.payjinn.hostedpayments;

import lib.payjinn.hostedpayments.HostedPaymentsClient;
import lib.payjinn.hostedpayments.NewPaymentReply;
import lib.payjinn.hostedpayments.NewPaymentRequest;
import lib.payjinn.hostedpayments.PaymentDetailReply;

public class HostedPaymentsAPIDemo 
{
	public static void main(String[] args) 
	{
		try
		{
			// Set api credentials (call once per run)
			HostedPaymentsClient.SetAPICredentials("TEST0001", "12345678");
			
			// Start a 1.25 EU transaction for TEST0001 user code whose API Key is 12345678
			NewPaymentRequest newPaymentRequest = new NewPaymentRequest
			(
				HostedPaymentsClient.getClientId() 	// Your PayJinn API Client Id
				,"" 		// Your specific order code goes here,  Max 128 characters 
				,1.25 		// Transaction amount in EURO with 2 significant digits after decimal seperator
				,"" 		// "www.YourCompanyURL.com/Notify" - Where should we redirect if an error occurs, Max 256 characters
				,"" 		// "www.YourCompanyURL.com/Success" - Where should we redirect if transaction ends successfully, Max 256 characters
				,"" 		// Base Account IBAN, send empty string to use default account, 0 (for default account ) or 22 characters
			);
						
			NewPaymentReply newPaymentReply = HostedPaymentsClient.NewPaymentClient(newPaymentRequest);
			
			// Print out result
			if (newPaymentReply != null)
			{
				System.out.println("NewPayment Result:");
				System.out.println("PayJinn Transaction Id: " + newPaymentReply.transactionId);
				System.out.println("PayJinn Payment Session URL: " + newPaymentReply.paymentURL);
				System.out.println("");
				
				// Query session details
				PaymentDetailReply paymentDetailReply = HostedPaymentsClient.GetPaymentDetailsClient(newPaymentReply.transactionId);
				
				if (paymentDetailReply != null)
				{
					// Print out result
					System.out.println("GetPaymentDetails Result:");
					System.out.println(paymentDetailReply.toString());
					System.out.println("");
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
>>>>>>> origin/master
