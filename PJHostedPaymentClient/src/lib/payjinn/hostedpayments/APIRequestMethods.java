<<<<<<< HEAD
package lib.payjinn.hostedpayments;

public enum APIRequestMethods 
{
	  POST
	  ,GET
	  ,PUT
	  ,DELETE
	  ;
	
	public String toString()
	{
		if (this.equals(APIRequestMethods.POST))
			return "POST";
		else if (this.equals(APIRequestMethods.GET)) 
			return "GET";
		else if (this.equals(APIRequestMethods.PUT))
			return "PUT";
		else if (this.equals(APIRequestMethods.DELETE))
			return "DELETE";
		else 
			return "";
	}
}
=======
package lib.payjinn.hostedpayments;

public enum APIRequestMethods 
{
	  POST
	  ,GET
	  ,PUT
	  ,DELETE
	  ;
	
	public String toString()
	{
		if (this.equals(APIRequestMethods.POST))
			return "POST";
		else if (this.equals(APIRequestMethods.GET)) 
			return "GET";
		else if (this.equals(APIRequestMethods.PUT))
			return "PUT";
		else if (this.equals(APIRequestMethods.DELETE))
			return "DELETE";
		else 
			return "";
	}
}
>>>>>>> origin/master
