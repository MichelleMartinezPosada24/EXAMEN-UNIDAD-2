/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen_3_;

import java.util.Scanner;



/**
 *
 * @author Michelle
 */
public class EXAMEN_3_ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

interface Empleado {
    double calcularSalarioAnual();
}

class EmpleadoTiempoCompleto implements Empleado {
    private String nombre;
    private double salarioBase;

    public EmpleadoTiempoCompleto(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalarioAnual() {
        double salarioAnual = salarioBase * 12;
        double bonoAnual = salarioAnual * 0.1;
        return salarioAnual + bonoAnual;
    }
}

class EmpleadoPorHoras implements Empleado {
    private String nombre;
    private double salarioPorHora;
    private int horasTrabajadas;

    public EmpleadoPorHoras(String nombre, double salarioPorHora, int horasTrabajadas) {
        this.nombre = nombre;
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSalarioAnual() {
        return salarioPorHora * horasTrabajadas * 52; // Se asumen 52 semanas en un año
    }
}

class EmpleadoPorContrato implements Empleado {
    private String nombre;
    private double salarioBase;

    public EmpleadoPorContrato(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalarioAnual() {
        return salarioBase * 12;
    }
}

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nIngrese el tipo de empleado:");
            System.out.println("Tiempo completo");
            System.out.println("Horas");
            System.out.println("Contrato");
            System.out.println("4.Salir");
            System.out.print("Opcion: ");
            String opcion = scanner.nextLine();

            if (opcion.equals("Tiempo completo ")) {
                System.out.print("Ingrese el nombre del empleado a tiempo completo: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el salario base mensual del empleado: ");
                double salarioBase = Double.parseDouble(scanner.nextLine());
                Empleado empleado = new EmpleadoTiempoCompleto(nombre, salarioBase);
                double salarioAnual = empleado.calcularSalarioAnual();
                System.out.println("El salario anual del empleado " + nombre + " es: $" + salarioAnual);
            } else if (opcion.equals("Horas")) {
                System.out.print("Ingrese el nombre del empleado por horas: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el salario por hora del empleado: ");
                double salarioPorHora = Double.parseDouble(scanner.nextLine());
                System.out.print("Ingrese las horas trabajadas por semana del empleado: ");
                int horasTrabajadas = Integer.parseInt(scanner.nextLine());
                Empleado empleado = new EmpleadoPorHoras(nombre, salarioPorHora, horasTrabajadas);
                double salarioAnual = empleado.calcularSalarioAnual();
                System.out.println("El salario anual del empleado " + nombre + " es: $" + salarioAnual);
            } else if (opcion.equals("Contato")) {
                System.out.print("Ingrese el nombre del empleado por contrato: ");
                String nombre = scanner.nextLine();
                System.out.print("Ingrese el salario base mensual del empleado: ");
                double salarioBase = Double.parseDouble(scanner.nextLine());
                Empleado empleado = new EmpleadoPorContrato(nombre, salarioBase);
                double salarioAnual = empleado.calcularSalarioAnual();
                System.out.println("El salario anual del empleado " + nombre + " es: $" + salarioAnual);
            } else if (opcion.equals("4")) {
                System.out.println("Hasta luego, gracias por confiar :)");
                break;
            } else {
                System.out.println("Por favor, ingrese una opción valida. ");
            }
        } 
    }
}