package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Persona persona = new Persona();
        System.out.println("Por favor digite su edad");
        persona.setEdad(scanner.nextInt());
        System.out.println("Por favor digite su altura en centimetros");
        persona.setAltura(scanner.nextDouble());
        System.out.println("Por favor digite su peso en kg");
        persona.setPeso(scanner.nextDouble());

        if (persona.verificarPersona()){
            switch (persona.calcularIndiceMasaCorporal()){
                case -1:
                    System.out.println("Peso insuficiente");
                break;
                case 0:
                    System.out.println("Bajo el peso ideal");
                break;
                case 1:
                    System.out.println("Sobrepeso");
                break;
            }

            // Verificar si es mayor de edad
            if (persona.esMayorDeEdad()){
                System.out.println("Es mayor de edad");
            }else {
                System.out.println("No es mayor de edad");
            }

        }else {
            System.out.println("Por favor digite valores validos");
        }
    }
}