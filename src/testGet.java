import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class testGet {
    
    public static void main(String[] args) throws Exception {
        
        testGet obj = new testGet();
        
        System.out.println(" Send Https GET");
        obj.sendGet();
        
    }
    
    private void sendGet() throws Exception {
        
        String url = "https://slack.com/api/api.test";
        
        HttpURLConnection httpClient =
        (HttpURLConnection) new URL(url).openConnection();
        
        // optional default is GET
        httpClient.setRequestMethod("GET");
        
        //add request header
        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        int responseCode = httpClient.getResponseCode();
        System.out.println("\nSending 'GET' request to : " + url);
        System.out.println("HTTP Code : " + responseCode);
        
        try (BufferedReader in = new BufferedReader(
        new InputStreamReader(httpClient.getInputStream()))) {
            
            StringBuilder response = new StringBuilder();
            String line;
            
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            
            //print result
            System.out.println(response.toString());
            
        }
    }
    
}