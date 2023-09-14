package org.example;

public class Persona {
    private int edad;
    private double peso, altura;

    public Persona(int edad, double peso, double altura) {
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona() {
        this.edad  = 0;
        this.altura = 0;
        this.peso  = 0;
    }

    public boolean verificarPersona(){
        return edad > 0 && altura > 0 && peso > 0;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int calcularIndiceMasaCorporal(){
        double imc = peso / (Math.pow(altura,2));
        if (imc < 20){
            return -1;
        }else if (imc >= 20 && imc <= 25){
            return 0;
        }else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }
}
