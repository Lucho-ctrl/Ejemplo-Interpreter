package main;
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
                
        } else {
            System.out.println("Algo escribiste mal el formato es 'Si nombre mayor 18' ");
            }
        }
    }
}
