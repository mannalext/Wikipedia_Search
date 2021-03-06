package wikisearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.client.HttpClient;


public class WikiBot {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		
		//hi from mac on jan 22
		Boolean isContinue = false;
		String continueValue = "";
		String url = buildRequest(args, isContinue, continueValue);
		String rawResult = callAPI(url);


		System.out.println("debug");
		//windows commit worked

	}

	private static String buildRequest(String[] args, Boolean isContinue, String continueValue)
	{
		StringBuilder urlConstruction = new StringBuilder();

		String endpoint = "https://en.wikipedia.org/w/api.php?";
		String action = "action=query";
		String prop = "prop=links";
		String format = "format=json";
		String namespace = "plnamespace=0";
		String limit = "pllimit=500&";
		String order = "pldir=ascending";
		String plcontinue = "plcontinue="; //the plcontinue argument replaces order in a new query which uses it
		String rawcontinue = "rawcontinue=";
		String title = "titles=";
		String begin = args[0];
		String end = args[1];
		String delimiter = "&";

		String tempContinueValue = "14640471%7C0%7CIbragimov_(Martian_crater)";

		if (!isContinue)
		{
			urlConstruction.append(endpoint + action + delimiter + prop + delimiter + format + delimiter + namespace + delimiter + limit + delimiter + order + delimiter + rawcontinue + delimiter + title + begin);
		}
		else
		{
			plcontinue = plcontinue + continueValue;
			urlConstruction.append(endpoint + action + delimiter + prop + delimiter + format + delimiter + namespace + delimiter + limit + delimiter + plcontinue + delimiter + rawcontinue + delimiter + title + begin);
		}

		String url = urlConstruction.toString();
		return url;
	}

	private static String callAPI(String url) //if the return from this function has a continue, set "isContinue" to true in main, so that "buildRequest" will know whether to build a continue or not
	{
		String rawResultAsString = "failed";

		try
		{
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);
			HttpResponse httpResponse = client.execute(request);

			BufferedReader rd = new BufferedReader(
					new InputStreamReader(httpResponse.getEntity().getContent()));

			StringBuffer rawResultAsBuffer = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) 
			{
				rawResultAsBuffer.append(line);
			}

			rawResultAsString = rawResultAsBuffer.toString();
			return rawResultAsString;
		}
		catch (Exception e)
		{
			System.out.println("failed in callAPI");
		}
		
		return rawResultAsString;
	}
}

