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

        ArrayList<ArrayList<String>> contactos = new ArrayList<>();

        ArrayList<String> contacto1 = new ArrayList<>();
        contacto1.add("Joao");
        contacto1.add("913124253");

        ArrayList<String> contacto2 = new ArrayList<>();
        contacto2.add("Maria");
        contacto2.add("923124253");

        ArrayList<String> contacto3 = new ArrayList<>();
        contacto3.add("Jose");
        contacto3.add("953124253");

        ArrayList<String> contacto4 = new ArrayList<>();
        contacto4.add("Pedro");
        contacto4.add("993124253");

        contactos.add(contacto1);
        contactos.add(contacto2);
        contactos.add(contacto3);
        contactos.add(contacto4);

        Scanner s = new Scanner(System.in);

        while (true) {
            //Procurar qual é o numero de contacto dado o nome da pessoa
            System.out.println("Indique o nome a pesquisar ou exit para sair: ");
            String nome = s.nextLine();

            if(nome.equals("exit")){
                break;
            }
            for (int i = 0; i < contactos.size(); i++) {
                if (contactos.get(i).get(0).equals(nome)) {
                    System.out.println("Contacto: " + contactos.get(i).get(1));
                    break;
                }
                if (i == contactos.size() - 1) {
                    System.out.println("Não existe este contacto na agenda!.");
                }
            }

        }


    }
}