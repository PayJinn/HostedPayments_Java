<<<<<<< HEAD
package lib.payjinn.hostedpayments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HostedPaymentsClient 
{	
	private static String _clientId = ""; 	// Your PayJinn API Client Id
	private static String _apiKey = "";		// Your PayJinn API Key
	
	public static String getClientId()
	{
		return _clientId;
	}
		
	public static void SetAPICredentials(String clientId, String apiKey)
	{
		_clientId = clientId;
		_apiKey = apiKey;
	}
	
	private static URL GetAPIURL(String method) throws KeyManagementException, NoSuchAlgorithmException, MalformedURLException
	{
		URL url = null;
		
		if (ProgramConditionals.LOCAL_TEST)	
		{
			// For local testing we should disable certificate validation
			HttpsTrustAll.Init();
			
			// use localhost api url
			url = new URL("https://localhost:44300/api/HostedPayments/" + method);
		}
		else
			url = new URL("https://www.payjinn.com/api/HostedPayments/" + method);
		
		return url;
	}
	
	private static HttpURLConnection GetAPIConnectionObject(URL url, APIRequestMethods method) throws IOException
	{
		HttpURLConnection conn = null;
		
		if (ProgramConditionals.ENABLE_PROXY)
		{
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ProgramConditionals.PROXY_SERVER, ProgramConditionals.PROXY_PORT));
			conn = (HttpURLConnection) url.openConnection(proxy);
		}
		else 
			conn = (HttpURLConnection) url.openConnection();
		
		if (method.equals(APIRequestMethods.POST))
			conn.setDoOutput(true);
		
		conn.setRequestMethod(method.toString());

		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	
		// API is using HTTP Basic Authorization
		String basicAuthStr = _clientId + ":" + _apiKey;
	    conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(basicAuthStr.getBytes()));
	    
	    return conn;
	}
	
	private static String CallAPI(HttpURLConnection conn, String input) throws IOException
	{
		if (input != null && input.length() > 0)
		{
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
		}

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) 
			throw new RuntimeException("API Call Failed With HTTP Error Code: " + conn.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		StringBuilder output = new StringBuilder();
		
		String line;
		
		while ((line = br.readLine()) != null) 
		{
			if (line.trim().length() > 0)
				output.append(line);
		}
		
		return output.toString();
	}	
	
	public static NewPaymentReply NewPaymentClient(NewPaymentRequest newPaymentRequest) 
	{
		HttpURLConnection conn = null;
		
		try 
		{		
			conn = GetAPIConnectionObject(GetAPIURL("NewPayment"), APIRequestMethods.POST);
			
			String jsonReply = CallAPI(conn, newPaymentRequest.getAPIInputString());
						
			return NewPaymentReply.ParseJSON(jsonReply);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally
		{
			if (conn != null)
				conn.disconnect();
		}
	}
	
	public static PaymentDetailReply GetPaymentDetailsClient(String transactionId) 
	{
		HttpURLConnection conn = null;
		
		try 
		{			
			conn = GetAPIConnectionObject(GetAPIURL(_clientId + "/" + transactionId), APIRequestMethods.GET);
			
			String jsonReply = CallAPI(conn, null);
						
			return PaymentDetailReply.ParseJSON(jsonReply);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally
		{
			if (conn != null)
				conn.disconnect();
		}
	}
	
    public static Boolean ValidateResponseHash(
            String sessionCode,
            String orderCode,
            String payjinnStatus,
            String responseHash) throws UnsupportedEncodingException, NoSuchAlgorithmException
        {
            return HashingUtilities.ValidateResponseHash(_clientId, _apiKey, sessionCode, orderCode, payjinnStatus, responseHash);
        }
}
=======
package lib.payjinn.hostedpayments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HostedPaymentsClient 
{	
	private static String _clientId = ""; 	// Your PayJinn API Client Id
	private static String _apiKey = "";		// Your PayJinn API Key
	
	public static String getClientId()
	{
		return _clientId;
	}
		
	public static void SetAPICredentials(String clientId, String apiKey)
	{
		_clientId = clientId;
		_apiKey = apiKey;
	}
	
	private static URL GetAPIURL(String method) throws KeyManagementException, NoSuchAlgorithmException, MalformedURLException
	{
		URL url = null;
		
		if (ProgramConditionals.LOCAL_TEST)	
		{
			// For local testing we should disable certificate validation
			HttpsTrustAll.Init();
			
			// use localhost api url
			url = new URL("https://localhost:44300/api/HostedPayments/" + method);
		}
		else
			url = new URL("https://www.payjinn.com/api/HostedPayments/" + method);
		
		return url;
	}
	
	private static HttpURLConnection GetAPIConnectionObject(URL url, APIRequestMethods method) throws IOException
	{
		HttpURLConnection conn = null;
		
		if (ProgramConditionals.ENABLE_PROXY)
		{
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ProgramConditionals.PROXY_SERVER, ProgramConditionals.PROXY_PORT));
			conn = (HttpURLConnection) url.openConnection(proxy);
		}
		else 
			conn = (HttpURLConnection) url.openConnection();
		
		if (method.equals(APIRequestMethods.POST))
			conn.setDoOutput(true);
		
		conn.setRequestMethod(method.toString());

		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	
		// API is using HTTP Basic Authorization
		String basicAuthStr = _clientId + ":" + _apiKey;
	    conn.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString(basicAuthStr.getBytes()));
	    
	    return conn;
	}
	
	private static String CallAPI(HttpURLConnection conn, String input) throws IOException
	{
		if (input != null && input.length() > 0)
		{
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
		}

		if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) 
			throw new RuntimeException("API Call Failed With HTTP Error Code: " + conn.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		StringBuilder output = new StringBuilder();
		
		String line;
		
		while ((line = br.readLine()) != null) 
		{
			if (line.trim().length() > 0)
				output.append(line);
		}
		
		return output.toString();
	}	
	
	public static NewPaymentReply NewPaymentClient(NewPaymentRequest newPaymentRequest) 
	{
		HttpURLConnection conn = null;
		
		try 
		{		
			conn = GetAPIConnectionObject(GetAPIURL("NewPayment"), APIRequestMethods.POST);
			
			String jsonReply = CallAPI(conn, newPaymentRequest.getAPIInputString());
						
			return NewPaymentReply.ParseJSON(jsonReply);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally
		{
			if (conn != null)
				conn.disconnect();
		}
	}
	
	public static PaymentDetailReply GetPaymentDetailsClient(String transactionId) 
	{
		HttpURLConnection conn = null;
		
		try 
		{			
			conn = GetAPIConnectionObject(GetAPIURL(_clientId + "/" + transactionId), APIRequestMethods.GET);
			
			String jsonReply = CallAPI(conn, null);
						
			return PaymentDetailReply.ParseJSON(jsonReply);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally
		{
			if (conn != null)
				conn.disconnect();
		}
	}
}
>>>>>>> origin/master
