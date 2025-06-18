package my.uum;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code WeatherBot} class represents a Telegram bot that provides weather information for various cities.
 * <p>
 * This bot responds to user commands, displays a list of city names as clickable buttons,
 * and fetches weather information based on the selected city.
 * </p>
 */
public class WeatherBot extends TelegramLongPollingBot {

    /** Handles commands and weather information retrieval */
    private final CommandHandler commandHandler = new CommandHandler();

    /**
     * Retrieves the bot's username as required by the Telegram API.
     *
     * @return the bot's username
     */
    @Override
    public String getBotUsername() {
        return "s296015_bot";
    }

    /**
     * Retrieves the bot's token as required by the Telegram API.
     *
     * @return the bot's token
     */
    @Override
    public String getBotToken() {
        return "7586651174:AAEbIARC8DuQO3ymOxOeKz540g8_FnEDnvo";
    }

    /**
     * Processes incoming updates from users.
     * <p>
     * If the update contains a text message, this method will either send the list of cities as buttons
     * (in response to the "/start" command) or fetch and display weather information for a specified city.
     * </p>
     *
     * @param update the update received from the Telegram API
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equalsIgnoreCase("/start")) {
                // Display the list of cities as clickable buttons
                sendCityList(chatId);
            } else {
                // Handle other commands or city names
                String response = commandHandler.handleCommand(messageText);
                sendMessage(chatId, response);
            }
        }
    }

    /**
     * Sends a text message to the specified chat.
     *
     * @param chatId the chat ID to which the message should be sent
     * @param text the text content of the message
     */
    private void sendMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            ErrorHandler.handleError(e);
        }
    }

    /**
     * Sends a list of available cities as clickable buttons.
     *
     * @param chatId the chat ID to which the city list should be sent
     */
    private void sendCityList(long chatId) {
        List<String> cities = commandHandler.getCityList();
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Select a state to get the current weather:");

        // Create a keyboard with cities as buttons
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        for (String city : cities) {
            KeyboardRow row = new KeyboardRow();
            row.add(new KeyboardButton(city));
            keyboardRows.add(row);
        }

        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            ErrorHandler.handleError(e);
        }
    }
}
