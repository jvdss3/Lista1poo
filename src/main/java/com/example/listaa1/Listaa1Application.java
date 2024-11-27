package com.example.listaa1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class Listaa1Application {
    //Input do usuario
    Scanner input = new Scanner(System.in);
    //func para randomizar numeros
    Random rand = new Random();

    public void questao1() {
        System.out.println("Digite uma mensagem para criptografar:");
        String mensagem = input.nextLine(); //
        String criptografia = "";

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);

            // Verificar se é uma letra maiúscula
            if (caractere >= 'A' && caractere <= 'Z') {
                char novoCaractere = (char) (((caractere - 'A' + 3) % 26) + 'A');
                criptografia = criptografia + novoCaractere;
            }
            // Verificar se é uma letra minúscula
            else if (caractere >= 'a' && caractere <= 'z') {
                char novoCaractere = (char) (((caractere - 'a' + 3) % 26) + 'a');
                criptografia = criptografia + novoCaractere;
            }
            // Outros caracteres permanecem inalterados
            else {
                criptografia = criptografia + caractere;
            }
        }
        System.out.println("Mensagem criptografada:" + criptografia);
    }

    public void questao2(){
        int tentativas = 10;
        int n = rand.nextInt(100)+1;
        while(tentativas > 0){
            System.out.println("\nDigite seu palpite:");
            int palpite = input.nextInt();
            //System.out.println(n);

            if(palpite == n){
                System.out.println("Parabéns!");
                break;
            } if (palpite < n) {
                System.out.println("Muito baixo!");
            }if (palpite > n){
                System.out.println("Muito Alto!");
            }
            tentativas--;
        }

    }

    public static void questao3() {
        System.out.println("Números perfeitos entre 1 e 10.000:");

        for (int numero = 1; numero <= 10000; numero++) {
            int somaDivisores = 0;

            for (int i = 1; i <= numero / 2; i++) {
                if (numero % i == 0) {
                    somaDivisores += i;

                }
            }

            if (somaDivisores == numero && numero != 0) {
                System.out.println(numero + " é um número perfeito.");
            }
        }
    }

    public void questao4() {

        System.out.println("Numero de linhas(N):");
        int N = input.nextInt();
        System.out.println("Numero de colunas(M):");
        int M = input.nextInt();

        //input matriz.
        int[][] matriz = new int[N][M];
        System.out.println("Elementos da matriz:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matriz[i][j] = input.nextInt();
            }
        }

        //esparsidade
        int elementos = N * M;
        int contador = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matriz[i][j] == 0) {
                    contador++;
                }
            }
        }

        double percentual = (double) contador / elementos * 100;

        if (percentual > 70) {
            System.out.println("A matriz é esparsa.");
        } else {
            System.out.println("Matriz não é esparsa");
        }
    }
    public static void main(String[] args) {
        SpringApplication.run(Listaa1Application.class, args);
        Listaa1Application lista = new Listaa1Application();
        lista.questao3();
    }





}





