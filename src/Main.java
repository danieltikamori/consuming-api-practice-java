import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Practicing API calls
        
        System.out.println("Type the book title to consult (e.g. The Hobbit): ");
        Scanner titleScanner = new Scanner(System.in);
        String bookTitle = titleScanner.nextLine().replaceAll("\\s+", "+"); //removes all whitespaces and replaces them with "+"
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + bookTitle;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


        System.out.println("Type the cryptocurrency to consult (e.g. bitcoin): ");
        Scanner cryptoScanner = new Scanner(System.in);
        String crypto = cryptoScanner.nextLine().replaceAll("\\s+", "-"); //removes all whitespaces and replaces them with "-"
        String cryptoUrl = "https://api.coingecko.com/api/v3/simple/price?ids=" + crypto + "&vs_currencies=usd";

        HttpClient cryptoClient = HttpClient.newHttpClient();
        HttpRequest cryptoRequest = HttpRequest.newBuilder()
                .uri(URI.create(cryptoUrl))
                .build();
        HttpResponse<String> cryptoResponse = cryptoClient.send(cryptoRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(cryptoResponse.body());
        System.out.println("Powered by CoinGecko API"); //Attribution necessary if using demo API key

        System.out.println("Type the recipe name to consult (e.g. Udon): ");
        Scanner recipeScanner = new Scanner(System.in);
        String recipe = recipeScanner.nextLine().replaceAll("\\s+", "-"); //removes all whitespaces and replaces them with "-"
        String recipeUrl = "https://www.themealdb.com/api/json/v1/1/filter.php?i=" + recipe;

        HttpClient recipeClient = HttpClient.newHttpClient();
        HttpRequest recipeRequest = HttpRequest.newBuilder()
                .uri(URI.create(recipeUrl))
                .build();
        HttpResponse<String> recipeResponse = recipeClient.send(recipeRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(recipeResponse.body());

    }
}
