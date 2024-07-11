package ConversorMonedas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // URL de la API para obtener el valor del dólar
        String apiUrl = "https://v6.exchangerate-api.com/v6/83e58ca0990759a94cd2f727/latest/USD";

        // Llamar al método getApiResponse para obtener la respuesta JSON
        String jsonResponse = ConversorMonedas.ConsultaAPI.getApiResponse(apiUrl);

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in); // Crear objeto que se encarga de leer texto de la consola

        while (true) { //Hace que el menú se ejecute infinitamente
            System.out.println("************************************************");
            System.out.println("¡Sea bienvenido/a al Conversor de Moneda!");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("************************************************");

            System.out.println("Elija una opción:");
            Integer opc = sc.nextInt(); // Leer dato de la consola

            System.out.println("************************************************");

            if (opc == 1) {
                System.out.println("Ingrese la cantidad de dólares:");
                double cantidadDol = sc.nextDouble(); //Recibe la cantidad de dolares
                double valorPeso = ConversorMonedas.ConsultaAPI.getCurrencyValue(jsonResponse, "ARS"); //Recibe el tipo de cambio
                double conversion = cantidadDol * valorPeso; //Calcula el cambio

                System.out.println("El equivalente en pesos argentinos es: " + conversion);
            } else if(opc == 2) {
                System.out.println("Ingrese la cantidad de pesos argentinos: ");
                double cantidadArg = sc.nextDouble(); //Recibe la moneda X
                double valorPeso = ConversorMonedas.ConsultaAPI.getCurrencyValue(jsonResponse, "ARS"); //Recibe el valor de la moneda X
                double conversion = cantidadArg / valorPeso; //Calcula su equivalente en dolares

                System.out.println("El equivalente en dolares es: " + conversion);
            } else if (opc == 3) {
                System.out.println("Ingrese la cantidad de dólares:");
                double cantidadDol = sc.nextDouble();
                double valorReal = ConversorMonedas.ConsultaAPI.getCurrencyValue(jsonResponse, "BRL");
                double conversion = cantidadDol * valorReal;

                System.out.println("El equivalente en real brasileño es: " + conversion);
            } else if(opc == 4) {
                System.out.println("Ingrese la cantidad de reales brasileño: ");
                double cantidadReal = sc.nextDouble();
                double valorPeso = ConversorMonedas.ConsultaAPI.getCurrencyValue(jsonResponse, "BRL");
                double conversion = cantidadReal / valorPeso;

                System.out.println("El equivalente en dolares es: " + conversion);
            } else if (opc == 5) {
                System.out.println("Ingrese la cantidad de dólares:");
                double cantidadDol = sc.nextDouble();
                double valorCol = ConsultaAPI.getCurrencyValue(jsonResponse, "COP");
                double conversion = cantidadDol * valorCol;

                System.out.println("El equivalente en pesos colombianos es: " + conversion);
            } else if(opc == 6) {
                System.out.println("Ingrese la cantidad de pesos colombianos: ");
                double cantidadCol = sc.nextDouble();
                double valorPeso = ConsultaAPI.getCurrencyValue(jsonResponse, "COP");
                double conversion = cantidadCol / valorPeso;

                System.out.println("El equivalente en dolares es: " + conversion);
            } else if (opc == 7) {
                System.out.println("Fin del programa.");
                break; //Romper el bucle o el menú
            }
            else { //En caso de no elegir un número del 1 al 7
                System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        }
    }
}
