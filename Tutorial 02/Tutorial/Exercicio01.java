import java.util.Scanner;


public class Exercicio01 {

    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scan.next();
        System.out.println("Digite as horas trabalhadas: ");
        int hora = scan.nextInt();
        System.out.println("Digite o valor ganho por hora: ");
        float valor = Float.parseFloat(scan.next());
        float vtotal = valor*hora;
        System.out.printf("O funcionário %s receberá R$ %f.\n ", nome, vtotal);
    }
}

