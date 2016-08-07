<<<<<<< HEAD
package lib.payjinn.hostedpayments;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.google.gson.Gson;

public class NewPaymentRequest 
{
	@SuppressWarnings("unused")
	private String wsClientId;
	
	@SuppressWarnings("unused")
	private String wsClientOrderCode;
	
	@SuppressWarnings("unused")
	private String wsTransferAmount;
	
	@SuppressWarnings("unused")
	private String wsClientNotificationURL;
	
	@SuppressWarnings("unused")
	private String wsClientSuccessURL;
	
	@SuppressWarnings("unused")
	private String wsBaseAccountIBAN;
	
	public String getAPIInputString()
	{
		return new Gson().toJson(this, this.getClass());
	}

	public void setInputs
	(
		String clientId,
		String clientOrderCode,
		double transferAmount,
		String clientNotificationURL,
		String clientSuccessURL,
		String baseAccountIBAN
	)
    {
		wsClientId = clientId;
		wsClientOrderCode = clientOrderCode;				
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		wsTransferAmount = df.format(transferAmount);
		
		wsClientNotificationURL = clientNotificationURL;
		wsClientSuccessURL = clientSuccessURL;
		wsBaseAccountIBAN = baseAccountIBAN;
	}
	
	public NewPaymentRequest	
	(
		String clientId,
		String clientOrderCode,
		double transferAmount,
		String clientNotificationURL,
		String clientSuccessURL,
		String baseAccountIBAN
	)
	{
		setInputs(clientId, clientOrderCode, transferAmount, clientNotificationURL, clientSuccessURL, baseAccountIBAN);
	}
	
	public NewPaymentRequest() {}
}
=======
package lib.payjinn.hostedpayments;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.google.gson.Gson;

public class NewPaymentRequest 
{
	@SuppressWarnings("unused")
	private String wsClientId;
	
	@SuppressWarnings("unused")
	private String wsClientOrderCode;
	
	@SuppressWarnings("unused")
	private String wsTransferAmount;
	
	@SuppressWarnings("unused")
	private String wsClientNotificationURL;
	
	@SuppressWarnings("unused")
	private String wsClientSuccessURL;
	
	@SuppressWarnings("unused")
	private String wsBaseAccountIBAN;
	
	public String getAPIInputString()
	{
		return new Gson().toJson(this, this.getClass());
	}

	public void setInputs
	(
		String clientId,
		String clientOrderCode,
		double transferAmount,
		String clientNotificationURL,
		String clientSuccessURL,
		String baseAccountIBAN
	)
    {
		wsClientId = clientId;
		wsClientOrderCode = clientOrderCode;				
		
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.DOWN);
		wsTransferAmount = df.format(transferAmount);
		
		wsClientNotificationURL = clientNotificationURL;
		wsClientSuccessURL = clientSuccessURL;
		wsBaseAccountIBAN = baseAccountIBAN;
	}
	
	public NewPaymentRequest	
	(
		String clientId,
		String clientOrderCode,
		double transferAmount,
		String clientNotificationURL,
		String clientSuccessURL,
		String baseAccountIBAN
	)
	{
		setInputs(clientId, clientOrderCode, transferAmount, clientNotificationURL, clientSuccessURL, baseAccountIBAN);
	}
	
	public NewPaymentRequest() {}
}
>>>>>>> origin/master
