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

		String endpoint = "https://en.wikipedia.org/w/api.php?";
		String action = "action=query";
		String prop = "prop=links";
		String format = "format=json";
		String namespace = "plnamespace=0";
		String limit = "pllimit=500&";
		String order = "pldir=ascending";
		String plcontinue = "plcontinue=14640471%7C0%7CIbragimov_(Martian_crater)"; //the plcontinue argument replaces order in a new query which uses it
		String rawcontinue = "rawcontinue=";
		String titleA = "titles=Mars";	
		String delimiter = "&";
		
		StringBuilder urlConstruction = new StringBuilder();
		urlConstruction.append(endpoint + action + delimiter + prop + delimiter + format + delimiter + namespace + delimiter + limit + delimiter + order + delimiter + rawcontinue + delimiter + titleA);
		String url = urlConstruction.toString();
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse httpResponse = client.execute(request);
		
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(httpResponse.getEntity().getContent()));

			StringBuffer rawResultAsBuffer = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				rawResultAsBuffer.append(line);
			}
			
		String rawResultAsString = rawResultAsBuffer.toString();

		System.out.println("debug");
		
	}

}
