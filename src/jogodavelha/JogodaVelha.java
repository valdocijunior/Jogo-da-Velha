/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jogodavelha;
import java.util.*;
/**
 *
 * @author Valdoci Moraes Junior
 */
public class JogodaVelha {

    /**
     * @param args the command line arguments
     */
    
        static String[] tabuleiro;
        static String turno;
        
        static String verificarVencedor() {
            for (int i = 0; i < 8; i++) {
                String linha = null;
                //Combinações possíveis de vencedores. Montadas no switch case.
                    switch (i) {
                        case 0:
                            linha = tabuleiro[0] + tabuleiro[1] + tabuleiro[2];
                            break;
                        
                        case 1:
                            linha = tabuleiro[3] + tabuleiro[4] + tabuleiro[5];
                            break;
                        
                        case 2:
                            linha = tabuleiro[6] + tabuleiro[7] + tabuleiro[8];
                            break;
                            
                        case 3:
                            linha = tabuleiro[0] + tabuleiro[3] + tabuleiro[6];
                            break;
                            
                        case 4:
                            linha = tabuleiro[1] + tabuleiro[4] + tabuleiro[7];
                            break;
                            
                        case 5:
                            linha = tabuleiro[2] + tabuleiro[5] + tabuleiro[8];
                            break;
                        
                        case 6:
                            linha = tabuleiro[0] + tabuleiro[4] + tabuleiro[8];
                            break;
                            
                        case 7:
                            linha = tabuleiro[2] + tabuleiro[4] + tabuleiro[6];
                            break;
                    }
                    
                    //X vencedor;
                if (linha.equals("XXX")) {
                    return "X";
                    
                    //O vencedor;
                } else if (linha.equals("OOO")) {
                    return "0";
                }
            }
            
            for (int i = 0; i < 9; i++) {
                if (Arrays.asList(tabuleiro).contains (String.valueOf(i + 1))) {
                    break;
                } else if (i == 8) {
                    return "Empate";
                }
            }
            
            //Mensagem pra colocar o X ou O na posição do tabuleiro;
            System.out.println("Turno do " + turno + "! Digite um numero para ser sua jogada " + turno + " na posição:");
            return null;
        }
        
        //Função que printa o Tabuleiro.
        static void printTabuleiro() {
                System.out.println("|---|---|---|");
		System.out.println("| " + tabuleiro[0] + " | "
						+ tabuleiro[1] + " | " + tabuleiro[2]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tabuleiro[3] + " | "
						+ tabuleiro[4] + " | " + tabuleiro[5]
						+ " |");
		System.out.println("|-----------|");
		System.out.println("| " + tabuleiro[6] + " | "
						+ tabuleiro[7] + " | " + tabuleiro[8]
						+ " |");
		System.out.println("|---|---|---|");
        }
        
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            tabuleiro = new String[9];
            turno = "X";
            String vencedor = null;
            
            for (int i = 0; i < 9; i++) {
                tabuleiro[i] = String.valueOf(i + 1);
            }
            
            System.out.println("Bem vindo ao jogo da velha no formato 3x3!");
            printTabuleiro();
            
            System.out.println("X jogará primeiro! Digite um número de 1 a 9 para efetuar sua jogada: ");
            
            while (vencedor == null) {
                int numInput;
                
                
                //Lógica de try catch para verificar se o jogador estará inserindo um numero de 1 a 9;
                //Caso digite um número inválido, printará uma mensagem para repetir a jogada.
                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Jogada inválida! Digite novamente um número: ");
                        continue;
                    }
                }
                
                catch (InputMismatchException e) {
                    System.out.println("Jogada inválida! Digite novamente um número: ");
                    continue;
                }
                
                
                //Lógica para decidir a rodada e passar para o próximo jogador.
                if (tabuleiro[numInput - 1].equals(String.valueOf(numInput))) {
                    tabuleiro[numInput - 1] = turno;
                
                if (turno.equals("X")) {
                    turno = "O";
                } else {
                    turno = "X";
                }
                
                printTabuleiro();
                vencedor = verificarVencedor();
                
                } else {
                    System.out.println("Posição já escolhida! Digite um novo número: ");
                }
            }
            
            //Se ngm ganhar, lógica para mostrar Empate.
            if (vencedor.equalsIgnoreCase("Empate")) {
                System.out.println("Empate! Obrigado por jogar! :) ");
                
            //Com um vencedor, mostrará a mensagem de ganhador.
            } else {
                System.out.println("Parabéns!!! " + vencedor + " ganhou! Obrigado por jogar! :) ");
            }
        }
    }
    

