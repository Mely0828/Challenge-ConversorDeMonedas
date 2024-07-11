package ConversorMonedas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaAPI {
    //Método GET es el método que se utiliza para obtener datos o una respuesta de la API
    //Método POST es el método para enviar datos a un API 
    // Método para realizar la solicitud GET a la API y devolver la respuesta en formato JSON
    public static String getApiResponse(String urlString) {
        StringBuilder response = new StringBuilder(); //Construir el objeto que va almacenar la respuesta del API

        try {
            // Crear la URL y abrir la conexión
            URL url = new URL(urlString); //Crear un objeto URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //Creamos la conexión con el API
            connection.setRequestMethod("GET"); // Establecer el método de solicitud (GET)

            // Obtener el código de respuesta de la solicitud
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //Objeto que se encarga de interpretar la respuesta del api
            String inputLine;  
            while ((inputLine = in.readLine()) != null) { //Vamos leyendo la respuesta línea a línea
                response.append(inputLine); //Agregar las líneas a la respuesta
            }
            in.close(); // Cerrar el BufferedReader
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response.toString();
    }

    // Método para obtener el valor del USD desde la respuesta JSON
    public static double getCurrencyValue(String jsonResponse, String currency) {
        Gson gson = new Gson(); //Nuevo objeto gson (encargado de manipular los archivos Json)

        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class); //Creamos el objeto Json
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates"); //Específicamos usar únicamente las tasas de cambio

        return conversionRates.get(currency).getAsDouble();
    }
}
