package my.uum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The {@code LocationService} class provides functionality to retrieve geographic coordinates
 * for predefined Malaysian cities and regions.
 * <p>
 * This class contains a static map of city names to their respective latitude and longitude values.
 * </p>
 */
public class LocationService {

    /** A map that stores city names as keys and their corresponding latitude and longitude as values */
    private static final Map<String, double[]> cityCoordinates = new HashMap<>();

    // Static block to initialize the map with predefined city coordinates
    static {
        cityCoordinates.put("Johor", new double[]{1.9344, 103.3587});
        cityCoordinates.put("Kedah", new double[]{6.0499, 100.5296});
        cityCoordinates.put("Kelantan", new double[]{5.1151, 101.8892});
        cityCoordinates.put("Melaka", new double[]{2.1896, 102.2501});
        cityCoordinates.put("Negeri Sembilan", new double[]{2.8707, 102.2548});
        cityCoordinates.put("Pahang", new double[]{3.9743, 102.4381});
        cityCoordinates.put("Pulau Pinang", new double[]{5.2632, 100.4846});
        cityCoordinates.put("Perak", new double[]{4.8073, 100.8000});
        cityCoordinates.put("Perlis", new double[]{6.5170, 100.2152});
        cityCoordinates.put("Selangor", new double[]{3.5092, 101.5248});
        cityCoordinates.put("Terengganu", new double[]{5.0936, 102.9896});
        cityCoordinates.put("Sabah", new double[]{5.4204, 116.7968});
        cityCoordinates.put("Sarawak", new double[]{2.5574, 113.0012});
        cityCoordinates.put("Kuala Lumpur", new double[]{3.1319, 101.6841});
        cityCoordinates.put("Labuan", new double[]{5.2831, 115.2308});
        cityCoordinates.put("Putrajaya", new double[]{2.9264, 101.6964});
    }

    /**
     * Retrieves the geographic coordinates of the specified city.
     *
     * @param cityName the name of the city
     * @return an array containing the latitude and longitude of the city; returns {0.0, 0.0} if the city is not found
     */
    public double[] getCoordinates(String cityName) {
        return cityCoordinates.getOrDefault(cityName, new double[]{0.0, 0.0});
    }

    /**
     * Retrieves the set of available city names.
     *
     * @return a set containing the names of all cities with predefined coordinates
     */
    public Set<String> getCityNames() {
        return cityCoordinates.keySet();
    }
}
