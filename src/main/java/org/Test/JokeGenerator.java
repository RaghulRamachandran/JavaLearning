package org.Test;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeGenerator {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://icanhazdadjoke.com/"))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Raw JSON response: ");
        System.out.println(response.body());
        Gson gson = new Gson();
        Joke joke = gson.fromJson(response.body(), Joke.class);
        System.out.println("Here's a joke for you: ");
        System.out.println(joke.getJoke());
    }
}

class Joke {
    private String joke;

    public String getJoke() {
        return joke;
    }
}
