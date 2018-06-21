import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class TaxonomyInfo {

    JsonObject kingdom;
    JsonObject phylum;
    JsonObject clss;
    JsonObject order;
    JsonObject family;
    JsonObject species;
    JsonObject genus;


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
            JsonObject JSONData = new JsonParser().parse(jsonString).getAsJsonArray().get(0).getAsJsonObject();

            this.species = JSONData;

            for( JsonElement classification : JSONData.get("higherClassification").getAsJsonArray() ) {
                switch(classification.getAsJsonObject().get("taxonRank").getAsString()) {
                    case ("kingdom"):
                        this.kingdom = classification.getAsJsonObject();
                        break;
                    case ("phylum"):
                        this.phylum = classification.getAsJsonObject();
                        break;
                    case ("class"):
                        this.clss = classification.getAsJsonObject();
                        break;
                    case ("order"):
                        this.order = classification.getAsJsonObject();
                        break;
                    case ("family"):
                        this.family = classification.getAsJsonObject();
                        break;
                    case ("genus"):
                        this.genus = classification.getAsJsonObject();
                        break;
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

    }
}
