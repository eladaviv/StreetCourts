package colman.android.streetcourts.services;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class TemperatureApiService {
    private static final String API_KEY = "e7bdda751af48f57f592c3d1a496d77e";
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?";

    public static double getTemperature(double latitude, double longitude) throws IOException, JSONException {
        // Create a new HTTP client
        OkHttpClient client = new OkHttpClient();
        String complete_url = API_URL + "lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=" + API_KEY;

        // Create a new request
        Request request = new Request.Builder()
                .url(complete_url)
                .build();

        // Make the API call and get the response
        Response response = client.newCall(request).execute();

        // Parse the response to get the temperature
        JSONObject json = new JSONObject(response.body().string());
        JSONObject main = json.getJSONObject("main");
        double temperature = main.getDouble("temp");

        // Return the temperature
        return temperature;
    }


}
