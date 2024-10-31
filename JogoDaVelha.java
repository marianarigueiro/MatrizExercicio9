/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogodavelha;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author Yo
 */
public class JogoDaVelha { 

private static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    private static char jogadorAtual = 'X';

    public static void main(String[] args){ {
        Scanner scanner = new Scanner(System.in);
        int jogadas = 0;

        while (true) {
            printTabuleiro();
            System.out.println("É a vez do jogador " + jogadorAtual);
            int linha, coluna;

            while (true) {
                System.out.print("Escolha a linha (0, 1, 2): ");
                linha = scanner.nextInt();
                System.out.print("Escolha a coluna (0, 1, 2): ");
                coluna = scanner.nextInt();

                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    break;
                } else {
                    System.out.println("Posição inválida! Tente novamente.");
                }
            }

            jogadas++;

            if (verificaVencedor()) {
                printTabuleiro();
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            if (jogadas == 9) {
                printTabuleiro();
                System.out.println("O jogo terminou em empate!");
                break;
            }

            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; // Alterna entre jogadores
        }

        scanner.close();
    }

    private static void printTabuleiro() {
        for (char[] linha : tabuleiro) {
            System.out.println(" | " + linha[0] + " | " + linha[1] + " | " + linha[2] + " | ");
            System.out.println("---------------");
        }
    }

    private static boolean verificaVencedor() {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
            if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual) {
                return true;
            }
        }

        // Verifica diagonais
        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }
        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }
    }

