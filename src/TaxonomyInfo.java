import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TaxonomyInfo {

    public JsonObject JSONData;
    public JsonObject kingdom;
    public JsonObject phylum;
    public JsonObject subphylum;
    public JsonObject clss;
    public JsonObject order;
    public JsonObject suborder;
    public JsonObject family;
    public JsonObject species;
    public JsonObject genus;


    private static String get_rest(URL url) throws Exception {
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection)connection;

        httpConnection.setRequestProperty("Content-Type", "application/json");


        InputStream response = connection.getInputStream();
        int responseCode = httpConnection.getResponseCode();

        if(responseCode != 200) {
            throw new RuntimeException("Response code was not 200. Detected response was "+responseCode);
        }

        String output;
        Reader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response, "UTF-8"));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            output = builder.toString();
        }
        finally {
            if (reader != null) try {
                reader.close();
            } catch (IOException logOrIgnore) {
                logOrIgnore.printStackTrace();
            }
        }
        return output;
    }


    TaxonomyInfo(String taxNameOfSpecies) {

        String jsonString;
        URL url;

        try {
            url = new URL( "https://artsdatabanken.no/Api/Taxon/ScientificName?scientificname="
                    + taxNameOfSpecies.replaceAll("/ /", "%20"));
            jsonString = get_rest(url);
            JSONData = new JsonParser().parse(jsonString).getAsJsonArray().get(0).getAsJsonObject();

            for( JsonElement classification : JSONData.get("higherClassification").getAsJsonArray() ) {
                switch(classification.getAsJsonObject().get("taxonRank").getAsString()) {
                    case ("kingdom"):
                        this.kingdom = classification.getAsJsonObject();
                        break;
                    case ("phylum"):
                        this.phylum = classification.getAsJsonObject();
                        break;
                    case ("subphylum"):
                        this.subphylum = classification.getAsJsonObject();
                        break;
                    case ("class"):
                        this.clss = classification.getAsJsonObject();
                        break;
                    case ("order"):
                        this.order = classification.getAsJsonObject();
                        break;
                    case ("suborder"):
                        this.suborder = classification.getAsJsonObject();
                        break;
                    case ("family"):
                        this.family = classification.getAsJsonObject();
                        break;
                    case ("genus"):
                        this.genus = classification.getAsJsonObject();
                        break;
                    case ("species"):
                        this.species = classification.getAsJsonObject();
                        break;
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

    }
}
