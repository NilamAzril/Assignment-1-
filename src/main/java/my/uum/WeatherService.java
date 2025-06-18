package my.uum;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code WeatherService} class fetches and parses weather data from an external API.
 * <p>
 * It retrieves hourly weather data, including temperature, humidity, and weather condition code,
 * and converts this information into a human-readable format.
 * </p>
 */
public class WeatherService {

    /** API URL to get hourly weather data */
    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=temperature_2m,relative_humidity_2m,weather_code";

    /**
     * Fetches the current weather data for a given latitude and longitude.
     *
     * @param latitude  the latitude of the location
     * @param longitude the longitude of the location
     * @return a formatted string with the current weather information, or an error message if data cannot be fetched
     */
    public String getWeather(double latitude, double longitude) {
        String url = String.format(API_URL, latitude, longitude);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String json = EntityUtils.toString(response.getEntity());
                return parseWeatherData(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error fetching weather data.";
        }
    }

    /**
     * Parses the JSON response from the weather API and extracts relevant weather data.
     *
     * @param json the JSON string response from the weather API
     * @return a formatted string containing the temperature, humidity, and weather description, or an error message
     */
    private String parseWeatherData(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);
            JsonNode hourlyData = root.path("hourly");

            // Get the first hourly data point for temperature, weather code, and humidity
            JsonNode temperatures = hourlyData.path("temperature_2m");
            JsonNode weatherCodes = hourlyData.path("weather_code");
            JsonNode humidities = hourlyData.path("relative_humidity_2m");

            if (temperatures.isEmpty() || weatherCodes.isEmpty() || humidities.isEmpty()) {
                return "Temperature, weather code, or humidity data is unavailable.";
            }

            double temperature = temperatures.get(0).asDouble();
            int weatherCode = weatherCodes.get(0).asInt();
            int humidity = humidities.get(0).asInt();

            String weatherDescription = getWeatherDescription(weatherCode);

            LocalDateTime currentTime = LocalDateTime.now();
            String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String date = currentTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String day = currentTime.format(DateTimeFormatter.ofPattern("EEEE"));

            return String.format(
                    "Current Weather:\nDate: %s\nDay: %s\nTime: %s\nTemperature: %.1f°C\nHumidity: %d%%\nWeather Condition: %s",
                    date, day, formattedTime, temperature, humidity, weatherDescription
            );
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing weather data.";
        }
    }

    /**
     * Maps a weather code to a human-readable weather condition description.
     *
     * @param code the weather code from the API
     * @return a string description of the weather condition corresponding to the code, or "Unknown weather condition" if the code is not recognized
     */
    private String getWeatherDescription(int code) {
        Map<Integer, String> weatherCodeMap = new HashMap<>();
        weatherCodeMap.put(0, "Clear sky");
        weatherCodeMap.put(1, "Mainly clear");
        weatherCodeMap.put(2, "Partly cloudy");
        weatherCodeMap.put(3, "Overcast");
        weatherCodeMap.put(45, "Fog");
        weatherCodeMap.put(48, "Depositing rime fog");
        weatherCodeMap.put(51, "Drizzle: Light intensity");
        weatherCodeMap.put(53, "Drizzle: Moderate intensity");
        weatherCodeMap.put(55, "Drizzle: Dense intensity");
        weatherCodeMap.put(61, "Rain: Slight intensity");
        weatherCodeMap.put(63, "Rain: Moderate intensity");
        weatherCodeMap.put(65, "Rain: Heavy intensity");
        weatherCodeMap.put(71, "Snow fall: Slight intensity");

        return weatherCodeMap.getOrDefault(code, "Unknown weather condition");
    }
}
