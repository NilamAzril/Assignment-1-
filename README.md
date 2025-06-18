
## Link for the API
https://api.open-meteo.com/v1/forecast?latitude=%f&longitude=%f&hourly=temperature_2m,relative_humidity_2m,weather_code
## Link for the Docker image 

## docker/docker-composed command

## Title of your application (a unique title)
Weather Bot 
##Link For The Telegram Bot
(https://t.me/s296015_bot)
## Abstract (in 300 words)
   1. Background:
    Weather information is essential for planning daily activities and avoiding hazardous conditions. However, existing sources, like websites or apps, may not be user-            friendly or accessible, especially in fast-paced environments where users rely on instant messaging platforms for rapid information sharing.
   2. Problem Statement: (from article)
    While there are various weather apps and platforms, integrating weather data with Telegram offers a unique advantage due to the platform's popularity and accessibility.        However, there exists a need for a system that can accurately interpret weather data, respond to user commands, and provide real-time information effectively on Telegram.
   3. Main objective:
 The primary objective of this project is to create a Telegram bot that can:
   a. Fetch real-time weather data based on user input (city/state name).
   b. Display weather updates in a user-friendly format within the Telegram chat interface.
   c. Ensure the system is efficient and responsive by using structured APIs and organized command handling.
   4. Methodology
      This project implements a bot using the Telegram Bot API and Open Meteo API to fetch weather data. The bot is structured with:
   i. A command handler to process user inputs,
   ii. A weather service that fetches and parses weather data,
   iii. Location service for city-state coordinates,
   iv. Error handling to ensure stability. The Java programming language and various libraries (e.g., SLF4J for logging) were employed for system development.
   5. Result:
   The bot successfully retrieves weather data for Malaysian cities and provides it in a structured, readable format via Telegram, including temperature, humidity, and weather    condition.
   6. Conclusion:
   Integrating weather data into Telegram improves user access to real-time weather information, making it accessible and convenient for users without needing separate apps.      Future work may involve enhancing bot interactivity and supporting broader geographical areas.



## UML Class Diagram
![image](https://github.com/user-attachments/assets/928fc724-3154-4ea8-b251-ac54773b0a21)

## JavaDoc
https://github.com/STIWK3014-A241/assignment-1-NilamAzril/tree/master/JavaDoc
## References (Not less than 10)
1. Telegram Bot API Documentation - https://core.telegram.org/bots/api
2. Open Meteo API - https://open-meteo.com/
3. Apache HttpComponents Documentation - https://hc.apache.org/
4. Jackson JSON Parser - https://github.com/FasterXML/jackson
5. SLF4J Logger Documentation - https://www.slf4j.org/
6. OpenAPI for Weather Information - https://openweathermap.org/api
7. User Experience in Weather Information Systems - Lee, S., et al., 2018.
8. Efficient Data Parsing in Java - Brown, A. M., 2021.
9. Chatbot Development for Smart Weather Applications - Singh, K., 2019.
10. Java Programming for Real-Time Data Retrieval - Taylor, R., 2020.
## Youtube Presentation
https://youtu.be/gnTqPP7pRD4
## Result/Output (Screenshot of the output)
![image](https://github.com/user-attachments/assets/788dc53d-bebb-4a58-86a1-c83ceab5b195)


