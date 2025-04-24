package main;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Contexto contexto = new Contexto();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Comprueba mayoria de edad de Juan, Pedro y Luis");

        while (true) {
            System.out.print(">... ");
            String linea = scanner.nextLine().trim();
            String[] partes = linea.split(" ");

            if (partes.length == 4 && partes[0].equalsIgnoreCase("si") && partes[2].equalsIgnoreCase("mayor")) {
                String nombreVar = partes[1];

                int valor = Integer.parseInt(partes[3]);
                Expresion expr = new ExpresionMayorQue(nombreVar, valor);
                boolean resultado = expr.interpretar(contexto);

                if (resultado) {
                    System.out.println("✅ TRUE, puedes continuar. Escribe 'acceso permitido' para entrar.");

                    String respuesta = scanner.nextLine().trim();
                    if (respuesta.equalsIgnoreCase("acceso permitido")) {
                        System.out.println("🎉 Bienvenido al bar 🥂");
                    } else {
                        System.out.println("⛔ Acceso cancelado.");
                    }

                } else {
                    System.out.println("❌ FALSE, largo.");
                }            
            } 
            if (partes.length > 4 && partes[0].equalsIgnoreCase("si") && partes[2].equalsIgnoreCase("mayor") 
                && partes[4].equalsIgnoreCase("sino")) {
                    String nombrePersona = partes[1];

                    int edadPersona = Integer.parseInt(partes[3]);
                    Expresion expr = new ExpresionMayorQue(nombrePersona, edadPersona);
                    boolean resultado = expr.interpretar(contexto);

                    if(resultado) {
                        System.out.println("✅ TRUE, puedes continuar. Escribe 'acceso permitido' para entrar.");

                        String respuesta = scanner.nextLine().trim();
                        if (respuesta.equalsIgnoreCase("acceso permitido")) {
                            System.out.println("🎉 Bienvenido al bar 🥂");
                        }

                    } else if(!resultado) {
                        int posicionInicial = 5; // Posición inicial del subarreglo
                        String[] subarreglo = Arrays.copyOfRange(partes, posicionInicial, partes.length);
                        String rtaMenorEdad = String.join(" ", subarreglo);
                        System.out.println("FALSO "+rtaMenorEdad);
                    }
            } 
            if (partes.length == 4 && partes[0].equalsIgnoreCase("si") && partes[2].equalsIgnoreCase("menor")) {
                String nombreVar = partes[1];

                int valor = Integer.parseInt(partes[3]);
                Expresion expr = new ExpresionMenorQue(nombreVar, valor);
                boolean resultado = expr.interpretar(contexto);

                if (resultado) {
                    System.out.println("✅ TRUE, puedes continuar. Escribe 'acceso permitido' para entrar.");

                } else {
                    System.out.println("❌ VERDADERO, largo.");
                }            
            }
        } 
    }
}

