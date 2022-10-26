package lu.etat.opendata;

import java.io.File;

import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class App {
    private App() {
    }

    /**
     * Update a resource on data.public.lu
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        Logger logger = LoggerFactory.getLogger(App.class);

        String api = dotenv.get("API");
        String apiKey = dotenv.get("API_KEY");
        String datasetId = dotenv.get("DATASET_ID");
        String resourceId = dotenv.get("RESOURCE_ID");
        String filename = dotenv.get("FILENAME");

        Unirest.config().defaultBaseUrl(api);

        HttpResponse<String> response = Unirest.post("/datasets/{datasetId}/resources/{resourceId}/upload/")
            .routeParam("datasetId", datasetId)
            .routeParam("resourceId", resourceId)
            .header("Accept", "application/json")
            .header("X-API-KEY", apiKey)
            .header("Cache-Control", "no-cache")
            .field("file", new File(filename))
            .asString();
        if (response.getStatus() == 200) {
            logger.info("File uploaded successfully!");
        } else {
            logger.error(response.getBody());
        }

    }
}


