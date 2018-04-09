import java.util.Scanner;
import java.util.Random;

public class Exercicio03 {

    public static void main (String args[]) {
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);
        int num = ran.nextInt(10)+1;
        int erros = 0;
        for(int i = 0;i<3;i++){
            System.out.println("Digite a tentativa: ");
            int tentativa = scan.nextInt();
            if(tentativa == num){
                System.out.printf("Parabéns! O número era %d.\n", num);
                i = 3;
            }else{
                System.out.println("Tente Novamente ;-;");
                erros++;
            }
        }
        if(erros == 3){
            System.out.printf("Que pena, você errou! O número era %d.\n", num);
        }
    }
}

