package api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class ApiClient {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private HttpClient client;
    public ApiClient() {
        client = HttpClient.newHttpClient();
    }
    public String get(String endpoint) {
        try {
            //build request
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint))
                .GET()
                .build();
            //send request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
