/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tic.tac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class TicTac {

     static ArrayList<Integer> posicion = new ArrayList();
     static ArrayList<Integer> cpuPosicion = new ArrayList();

     public static void main(String[] args) {
          int a = 1;

          char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
          {'-', '+', '-', '+', '-'},
          {' ', '|', ' ', '|', ' '},
          {'-', '+', '-', '+', '-'},
          {' ', '|', ' ', '|', ' '}

          };
          printGameBoard(gameBoard);
          while (true) {
               Scanner scan = new Scanner(System.in);
               System.out.println("Enter your placement (1-9)");
               int pos = scan.nextInt();
               while(posicion.contains(pos)|| cpuPosicion.contains(pos)){
               pos=scan.nextInt();}
               placePiece(gameBoard, pos, "jugador");
                String resultado = checkWinner();
               Random rand = new Random();
               int cpuZ = rand.nextInt(9) + 1;
                while(posicion.contains(cpuZ)|| cpuPosicion.contains(cpuZ)){
               cpuZ = rand.nextInt(9) + 1;}
           
               placePiece(gameBoard, cpuZ, "cpu");
               printGameBoard(gameBoard);
               resultado = checkWinner();
               if(resultado.length()>0){
                    System.out.println(resultado);
               break;}
               
          }

     }

     public static void printGameBoard(char[][] gameBoard) {
          for (char[] row : gameBoard) {
               for (char c : row) {
                    System.out.print(c);
               }
               System.out.println();
          }
     }

     public static void placePiece(char[][] gameBoard, int pos, String user) {
          char symbolo = ' ';
          if (user.equals("jugador")) {
               symbolo = 'X';
               posicion.add(pos);
          } else if (user.equals("cpu")) {
               symbolo = '0';
               cpuPosicion.add(pos);
          }
          switch (pos) {
               case 1:
                    gameBoard[0][0] = symbolo;
                    break;
               case 2:
                    gameBoard[0][2] = symbolo;
                    break;
               case 3:
                    gameBoard[0][4] = symbolo;
                    break;
               case 4:
                    gameBoard[2][0] = symbolo;
                    break;
               case 5:
                    gameBoard[2][2] = symbolo;
                    break;
               case 6:
                    gameBoard[2][4] = symbolo;
                    break;
               case 7:
                    gameBoard[4][0] = symbolo;
                    break;
               case 8:
                    gameBoard[4][2] = symbolo;
                    break;
               case 9:
                    gameBoard[4][4] = symbolo;
                    break;
               default:
                    break;

          }

     }

     public static String checkWinner() {
          List a = Arrays.asList(1, 2, 3);
          List b = Arrays.asList(4, 5, 6);
          List c = Arrays.asList(7, 8, 9);
          List d = Arrays.asList(1, 5, 9);
          List e = Arrays.asList(3, 5, 7);
          List f = Arrays.asList(3, 6, 8);
          List g = Arrays.asList(1, 4, 7);
          List h = Arrays.asList(3, 6, 9);
          List<List> condiciones = new ArrayList<List>();
          condiciones.add(a);
          condiciones.add(b);
          condiciones.add(c);
          condiciones.add(d);
          condiciones.add(e);
          condiciones.add(f);
          condiciones.add(g);
          condiciones.add(h);
          for (List l : condiciones) {
               if (posicion.containsAll(l)) {
                    return "felicitaciones";
               } else if (cpuPosicion.containsAll(l)) {
                    return "game Over";
               } else if (posicion.size() + cpuPosicion.size() == 9) {
                    return "cat";
               }
          }

          return "";
     }
}
