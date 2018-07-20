
package com.waykichain.exchange.utils;

import java.io.IOException;

import com.waykichain.exchange.wallet.WalletMessage;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
* @auther: Water
* @time: 22 Jan 2018 14:46:19
* 
*/

public class HttpUtil {
	
	public static void main(String[] args){
				
		String url = "http://water:password@localhost:6968";
		String body = "{\"jsonrpc\": \"2.0\", \"id\":1, \"method\": \"getbalance\", \"params\": []}";  	
		String result = post(url, body);
		System.out.println("result:" + result);
		String getResult = get("https://api.coinmarketcap.com/v1/ticker/waykichain/?convert=CNY");
		
	}
	
	public static String post(WalletMessage walletMessage, String body) {
		String url = "http://" + walletMessage.getUserName() + ":" + walletMessage.getPassword() + "@" + walletMessage.getIP() + ":" + walletMessage.getPort();
		String result = post(url, body);
		return result;
	}
		
	public static String get(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		try {
			CloseableHttpResponse httpRes = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpRes.getEntity();
			String result = EntityUtils.toString(httpEntity);
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(httpClient!=null){
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}
	
	public static String post(String url, String body){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		try {
			StringEntity stringEntity = new StringEntity(body);
			stringEntity.setContentEncoding("UTF-8");
			stringEntity.setContentType("application/json");
		//	stringEntity.setContentType("text/plain");		
            httpPost.setEntity(stringEntity);
						
			CloseableHttpResponse httpRes = httpClient.execute(httpPost); 
			HttpEntity httpEntity = httpRes.getEntity();
			String result = EntityUtils.toString(httpEntity);
			return result;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
		
		return "";
	}

}
