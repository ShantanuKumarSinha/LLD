package mutlithreading.problems.completablefuture;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class URLsFetcherUsingCompletableFuture {
  public static void main(String[] args) {
    System.out.println("UseCompletableFuture started");
    // We have a list of URLs that we want to fetch data from. We want to fetch the data from all
    // URLs concurrently and then process the results once all the data has been fetched. Use
    // CompletableFuture to achieve this.
    var urls =
        new String[] {
          "https://jsonplaceholder.typicode.com/posts/1",
          "https://jsonplaceholder.typicode.com/posts/2",
          "https://jsonplaceholder.typicode.com/posts/3"
        };

    // Create a list of CompletableFutures for fetching data from each URL
    List<CompletableFuture<String>> futures =
        Arrays.stream(urls)
            .map(url -> CompletableFuture.supplyAsync(() -> url))
            .collect(Collectors.toList());

    CompletableFuture<Void> allOf =
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

    // Register a callback to process results once all are done
    allOf.thenRun(
        () -> {
          System.out.println("All URLs fetched. Processing results...");
          futures.forEach(
              future -> {
                try {
                  String url = future.get();
                  System.out.println("Fetched data from: " + url);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              });
        });
  }
}
