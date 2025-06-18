package my.uum;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * This class initializes the Telegram Bots API and registers the bot.
 * <p>
 * It is the entry point of the application, creating a {@link TelegramBotsApi} instance
 * and registering an instance of {@link WeatherBot}.
 * </p>
 */
public class Bot {

    /**
     * The main method that initializes the bot session and registers the bot.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Initialize the Telegram Bots API
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            // Register your bot
            botsApi.registerBot(new WeatherBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
