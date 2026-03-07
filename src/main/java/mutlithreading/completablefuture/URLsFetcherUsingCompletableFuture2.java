package mutlithreading.completablefuture;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class URLsFetcherUsingCompletableFuture2 {
  public static void main(String[] args) {
    // We have a list of URLs that we want to fetch data from. We want to fetch the data from all
    // URLs concurrently and then process the results once all the data has been fetched. Use
    // CompletableFuture to achieve this.
    var urls =
        new String[] {
          "https://jsonplaceholder.typicode.com/posts/1",
          "https://jsonplaceholder.typicode.com/posts/2",
          "https://jsonplaceholder.typicode.com/posts/3"
        };
    CompletableFuture.runAsync(()-> {
      System.out.println("Fetching data from URLs...");
    })
        .thenApply(
            v ->
                Arrays.stream(urls)
                    .map(url -> CompletableFuture.supplyAsync(() -> url))
                    .collect(Collectors.toList()))
        .thenAccept(
            futures -> {
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
