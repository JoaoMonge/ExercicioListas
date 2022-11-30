import com.sun.source.tree.ArrayAccessTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /*
    Exercício 4: Crie um programa que cria e gera uma lista de cartas (correspondência).
     Deve ter em consideração que as cartas são empilhadas na lista e devem ser entregues,
      tendo sempre em consideração que,
     a primeira carta a ser entregue será sempre aquela que se encontra no fim.

O programa deve permitir:

•   Inserir uma carta;
•   Remover carta;
•   Verificar se a lista de cartas está cheia ou vazia;
•   Verificar a próxima carta a ser entregue;
•   Informar quantas cartas existem na lista;*/

    public static void main(String[] args) {

        ArrayList<ArrayList<Character>> tabuleiro = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            ArrayList<Character> linha = new ArrayList<>();
            linha.add(' ');
            linha.add(' ');
            linha.add(' ');
            tabuleiro.add(linha);
        }

        Character jog1 = 'X';
        Character jog2 = 'O';
        Character current_player = jog1;
        Scanner s = new Scanner(System.in);

        int count_jogadas = 0;
        while(count_jogadas < 9){

            boolean isInvalid = true;

            while(isInvalid) {
                System.out.println("Insira a coordenada: x,y");
                String coord = s.nextLine();

                //Verifica se a string se encontra de acordo com uma certa formatação
                if(!coord.matches("^[0-2]{1},[0-2]{1}$") ){
                    System.out.println("Formatação inválida!!");
                    continue;
                }

                String coords[] = coord.split(",");

                int x = Integer.valueOf(coords[0]);
                int y = Integer.valueOf(coords[1]);

                if ( tabuleiro.get(y).get(x) == ' ') {
                    isInvalid = false;
                    tabuleiro.get(y).set(x,current_player);
                }else{
                    System.out.println("Coordenada inválida!!");
                }
            }


            for (ArrayList<Character> linha:
                 tabuleiro) {
                System.out.println(linha);
            }


            for(int i = 0; i < 3; i++) {



                boolean condicao_vitoria_linha = tabuleiro.get(i).get(0) != ' ' && tabuleiro.get(i).get(0) == tabuleiro.get(i).get(1) && tabuleiro.get(i).get(1) == tabuleiro.get(i).get(2);
                boolean condicao_vitoria_coluna = tabuleiro.get(0).get(i) != ' ' && tabuleiro.get(0).get(i) == tabuleiro.get(1).get(i) && tabuleiro.get(1).get(i) == tabuleiro.get(2).get(i);

                boolean condicao_vitoria_diagonal = tabuleiro.get(1).get(1) != ' ' && ((tabuleiro.get(0).get(0) == tabuleiro.get(1).get(1) && tabuleiro.get(1).get(1) == tabuleiro.get(2).get(2)) || (tabuleiro.get(0).get(2) == tabuleiro.get(1).get(1) && tabuleiro.get(1).get(1) == tabuleiro.get(2).get(0)));


                if(condicao_vitoria_linha || condicao_vitoria_coluna || condicao_vitoria_diagonal){
                    System.out.println("Ganhou o "+ current_player +" !! FIM");
                    return;
                }



            }

            if(current_player == jog1){
                current_player = jog2;
            }else{
                current_player = jog1;
            }

            count_jogadas++;
        }

        System.out.println("Terminou o jogo.");

    }
}