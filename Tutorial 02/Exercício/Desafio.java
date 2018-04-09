import java.util.Scanner;


public class Desafio {

    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int i = num;
        String bin = "";
        while(num != 0){
            bin = bin + num % 2;
            num = num/2;
        }
        StringBuffer sb = new StringBuffer(bin);
        sb.reverse();
        System.out.printf("O Número %d convertido em binário é %s.\n", i, sb);
    }
}

