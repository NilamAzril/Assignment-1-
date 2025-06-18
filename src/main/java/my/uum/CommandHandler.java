package my.uum;

import java.util.List;
import java.util.ArrayList;

/**
 * The {@code CommandHandler} class processes user commands and retrieves relevant weather information.
 * <p>
 * It communicates with {@link WeatherService} to fetch weather data and {@link LocationService}
 * to resolve city names to geographic coordinates.
 * </p>
 */
public class CommandHandler {

    /** The service used to fetch weather data */
    private final WeatherService weatherService = new WeatherService();

    /** The service used to obtain location coordinates */
    private final LocationService locationService = new LocationService();

    /**
     * Processes a user command and returns a response.
     * <p>
     * Recognizes the "/start" command to provide a welcome message and any other command as a city name
     * for which weather data should be retrieved.
     * </p>
     *
     * @param command the command or city name entered by the user
     * @return a response string with either a welcome message, weather information, or an error message
     */
    public String handleCommand(String command) {
        if (command.equalsIgnoreCase("/start")) {
            return "Welcome to WeatherBot! Select a city to get the current weather.";
        } else {
            double[] coordinates = locationService.getCoordinates(command);
            if (coordinates[0] == 0.0 && coordinates[1] == 0.0) {
                return "City not found. Please try another city.";
            } else {
                return weatherService.getWeather(coordinates[0], coordinates[1]);
            }
        }
    }

    /**
     * Retrieves a list of available city names.
     *
     * @return a list of city names supported by the {@link LocationService}
     */
    public List<String> getCityList() {
        return new ArrayList<>(locationService.getCityNames());
    }
}
