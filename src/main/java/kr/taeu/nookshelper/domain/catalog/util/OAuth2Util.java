package kr.taeu.nookshelper.domain.catalog.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.core.io.ClassPathResource;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

public class OAuth2Util {
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String CREDENTIALS_FILE_PATH = "json/nookshelper-62990be5af39.json";
	
	private static GoogleCredentials getCredentials(final HttpTransport HTTP_TRANSPORT) throws IOException, GeneralSecurityException {
		ClassPathResource resource = new ClassPathResource(CREDENTIALS_FILE_PATH);
		if(resource == null) {
			throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH); 
		}
		
		GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());
		return credentials;
	}
	
	private static Sheets createSheetsService() throws IOException, GeneralSecurityException {
		final HttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
		
		HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(OAuth2Util.getCredentials(HTTP_TRANSPORT));
		
	    Sheets sheets = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer)
	    		.setApplicationName("Google Sheets API")
	    		.build();
	    
	    return sheets;
	}
	
	
	public static void test() throws IOException, GeneralSecurityException {
		OAuth2Util.createSheetsService();
	}
}
