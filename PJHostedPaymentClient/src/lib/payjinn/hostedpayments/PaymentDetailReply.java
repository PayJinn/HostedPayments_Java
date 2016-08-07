<<<<<<< HEAD
package lib.payjinn.hostedpayments;

import com.google.gson.Gson;

public class PaymentDetailReply 
{
    public String wsSessionCode;
    public String wsClientId;
    public String wsSessionType;
    public String wsBeginDate;
    public String wsBeginTime;
    public String wsEndDate;
    public String wsEndTime;
    public String wsClientOrderCode;

    public String wsTransferAmount;

    public String wsBaseAccountHolderName;
    public String wsBaseCountryCode;
    public String wsBaseBLZ;
    public String wsBaseBIC;
    public String wsBaseIBAN;
          
    public String wsSenderAccountHolderName;
    public String wsSenderCountryCode;
    public String wsSenderBLZ;
    public String wsSenderBIC;
    public String wsSenderIBAN;
    
    public boolean wsTransactionState;
    public String wsTranResult;
    
    // External Payments Related
    public String wsProviderCode;
    public String wsPaymentCode;

    public static PaymentDetailReply ParseJSON(String json)
    {
    	return new Gson().fromJson(json, PaymentDetailReply.class);
    }
    
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("wsSessionCode = " + wsSessionCode + "\n");
    	sb.append("wsClientId = " + wsClientId + "\n");
    	sb.append("wsSessionType = " + wsSessionType + "\n");
    	sb.append("wsPaymentCode = " + wsPaymentCode + "\n");
    	sb.append("wsProviderCode = " + wsProviderCode + "\n");
    	sb.append("wsBeginDate = " + wsBeginDate + "\n");
    	sb.append("wsBeginTime = " + wsBeginTime + "\n");
    	sb.append("wsEndDate = " + wsEndDate + "\n");
    	sb.append("wsEndTime = " + wsEndTime + "\n");
    	sb.append("wsClientOrderCode = " + wsClientOrderCode + "\n");
    	sb.append("wsTransferAmount = " + wsTransferAmount + "\n");
    	sb.append("wsBaseAccountHolderName = " + wsBaseAccountHolderName + "\n");
    	sb.append("wsBaseCountryCode = " + wsBaseCountryCode + "\n");
    	sb.append("wsBaseBLZ = " + wsBaseBLZ + "\n");
    	sb.append("wsBaseBIC = " + wsBaseBIC + "\n");
    	sb.append("wsBaseIBAN = " + wsBaseIBAN + "\n");
    	sb.append("wsSenderAccountHolderName = " + wsSenderAccountHolderName + "\n");
    	sb.append("wsSenderCountryCode = " + wsSenderCountryCode + "\n");
    	sb.append("wsSenderBLZ = " + wsSenderBLZ + "\n");
    	sb.append("wsSenderBIC = " + wsSenderBIC + "\n");
    	sb.append("wsSenderIBAN = " + wsSenderIBAN + "\n"); 
    	sb.append("wsTransactionState = " + (wsTransactionState ? "TRUE" : "FALSE") + "\n");
    	sb.append("wsTranResult = " + wsTranResult + "\n");
    	
    	return sb.toString();
    }
}
=======
package lib.payjinn.hostedpayments;

import com.google.gson.Gson;

public class PaymentDetailReply 
{
    public String wsSessionCode;
    public String wsClientId;
    public String wsSessionType;
    public String wsBeginDate;
    public String wsBeginTime;
    public String wsEndDate;
    public String wsEndTime;
    public String wsClientOrderCode;

    public String wsTransferAmount;

    public String wsBaseAccountHolderName;
    public String wsBaseCountryCode;
    public String wsBaseBLZ;
    public String wsBaseBIC;
    public String wsBaseIBAN;
          
    public String wsSenderAccountHolderName;
    public String wsSenderCountryCode;
    public String wsSenderBLZ;
    public String wsSenderBIC;
    public String wsSenderIBAN;
    
    public boolean wsTransactionState;
    public String wsTranResult;
    
    public static PaymentDetailReply ParseJSON(String json)
    {
    	return new Gson().fromJson(json, PaymentDetailReply.class);
    }
    
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("wsSessionCode = " + wsSessionCode + "\n");
    	sb.append("wsClientId = " + wsClientId + "\n");
    	sb.append("wsSessionType = " + wsSessionType + "\n");
    	sb.append("wsBeginDate = " + wsBeginDate + "\n");
    	sb.append("wsBeginTime = " + wsBeginTime + "\n");
    	sb.append("wsEndDate = " + wsEndDate + "\n");
    	sb.append("wsEndTime = " + wsEndTime + "\n");
    	sb.append("wsClientOrderCode = " + wsClientOrderCode + "\n");
    	sb.append("wsTransferAmount = " + wsTransferAmount + "\n");
    	sb.append("wsBaseAccountHolderName = " + wsBaseAccountHolderName + "\n");
    	sb.append("wsBaseCountryCode = " + wsBaseCountryCode + "\n");
    	sb.append("wsBaseBLZ = " + wsBaseBLZ + "\n");
    	sb.append("wsBaseBIC = " + wsBaseBIC + "\n");
    	sb.append("wsBaseIBAN = " + wsBaseIBAN + "\n");
    	sb.append("wsSenderAccountHolderName = " + wsSenderAccountHolderName + "\n");
    	sb.append("wsSenderCountryCode = " + wsSenderCountryCode + "\n");
    	sb.append("wsSenderBLZ = " + wsSenderBLZ + "\n");
    	sb.append("wsSenderBIC = " + wsSenderBIC + "\n");
    	sb.append("wsSenderIBAN = " + wsSenderIBAN + "\n"); 
    	sb.append("wsTransactionState = " + (wsTransactionState ? "TRUE" : "FALSE") + "\n");
    	sb.append("wsTranResult = " + wsTranResult + "\n");
    	
    	return sb.toString();
    }
}
>>>>>>> origin/master
