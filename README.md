# Weather Bot

A Telegram bot that provides real-time weather updates for Malaysian cities using the Open Meteo API. The bot is designed for ease of use within the Telegram chat interface, offering quick access to temperature, humidity, and weather conditions.

---

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Reference](#api-reference)
- [Architecture](#architecture)
- [JavaDoc](#javadoc)
- [References](#references)
- [Author](#author)
- [Screenshots & Demo](#screenshots--demo)

---

## Features
- Fetches real-time weather data for Malaysian cities
- User-friendly Telegram chat interface
- Displays temperature, humidity, and weather conditions
- Robust command and error handling
- Modular Java architecture

---

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Telegram account

### Installation
1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd assignment-1-NilamAzril-1
   ```
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Configure your Telegram bot token (see BotFather on Telegram).
4. Run the bot:
   ```bash
   mvn exec:java -Dexec.mainClass="my.uum.WeatherBot"
   ```

---

## Usage
- Start a chat with your bot on Telegram: [@s296015_bot](https://t.me/s296015_bot)
- Use commands like `/weather <city>` to get weather updates.

---

## API Reference
- [Open Meteo API](https://open-meteo.com/)
  - Example endpoint: `https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=temperature_2m,relative_humidity_2m,weather_code`
- [Telegram Bot API](https://core.telegram.org/bots/api)

---

## Architecture

### UML Class Diagram
![UML Diagram](https://github.com/user-attachments/assets/928fc724-3154-4ea8-b251-ac54773b0a21)

### Main Components
- `WeatherBot.java`: Main entry point for the Telegram bot
- `CommandHandler.java`: Processes user commands
- `WeatherService.java`: Fetches and parses weather data
- `LocationService.java`: Handles city/state to coordinates mapping
- `ErrorHandler.java`: Manages error responses

---

## JavaDoc
- [JavaDoc Documentation](https://github.com/STIWK3014-A241/assignment-1-NilamAzril/tree/master/JavaDoc)

---

## References
1. [Telegram Bot API Documentation](https://core.telegram.org/bots/api)
2. [Open Meteo API](https://open-meteo.com/)
3. [Apache HttpComponents Documentation](https://hc.apache.org/)
4. [Jackson JSON Parser](https://github.com/FasterXML/jackson)
5. [SLF4J Logger Documentation](https://www.slf4j.org/)
6. [OpenAPI for Weather Information](https://openweathermap.org/api)
7. Lee, S., et al., 2018. User Experience in Weather Information Systems.
8. Brown, A. M., 2021. Efficient Data Parsing in Java.
9. Singh, K., 2019. Chatbot Development for Smart Weather Applications.
10. Taylor, R., 2020. Java Programming for Real-Time Data Retrieval.

---

## Author
- **Matric Number:** 296015
- **Name:** Nilam Muhammad Azrilluqman Bin Jaafar
- **Telegram Bot:** [@s296015_bot](https://t.me/s296015_bot)


---

## Screenshots & Demo

### Output Example
![Bot Output](https://github.com/user-attachments/assets/788dc53d-bebb-4a58-86a1-c83ceab5b195)

### YouTube Presentation
[Watch the demo](https://youtu.be/gnTqPP7pRD4)

---

## License
This project is for academic purposes.
