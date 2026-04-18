
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String iniciar = "";

        Baralho baralho = new Baralho();
        baralho.embaralhar();

        Scanner user = new Scanner(System.in);

        System.out.println("Bem vindo a mesa de blackjack, vamos jogar!!");
        System.out.println("Podemos começar? [s/n]");

        iniciar = user.next();
        String loop = ("s");
        if (iniciar.equals("s") || iniciar.equals("sim")) {

            while (loop.equals("s")) {
                ArrayList<Carta> mao = new ArrayList<>();
                ArrayList<Carta> maoCrupie = new ArrayList<>();

                mao.add(baralho.comprarCarta());
                mao.add(baralho.comprarCarta());

                maoCrupie.add(baralho.comprarCarta());
                maoCrupie.add(baralho.comprarCarta());

                while (true) {

                    System.out.println("O crupie entregou as cartas");

                    System.out.println("Ações :   1 - Ver sua mão   |   2 - Pedir mais uma carta(hit)   |   3 - Parar(stand) ");
                    String acao = user.next();
                    if (acao.equals("1")) {
                        System.out.println("Sua mão: " + mao + Jogadores.calcularValorMao(mao));
                    }

                     else if (acao.equals("2") ) {
                        mao.add(baralho.comprarCarta());
                    } else if (Jogadores.calcularValorMao(mao) > 21) {
                        System.out.println("Você Perdeu!!");
                        break;
                    } else if (Jogadores.calcularValorMao(mao) == 21) {
                        System.out.println("Você ganhou!!");
                        break;
                    } else if (acao.equals("3")) {
                        while (Jogadores.turnoDoCrupie(maoCrupie) < 17) {
                            maoCrupie.add(baralho.comprarCarta());
                        }

                        int jogador = Jogadores.calcularValorMao(mao);
                        int crupie = Jogadores.turnoDoCrupie(maoCrupie);

                        System.out.println("Sua mão: " + mao + " = " + jogador);
                        System.out.println("Mão do Crupie: " + maoCrupie + " = " + crupie);

                        if (crupie > 21 || jogador > crupie) {
                            System.out.println("Você venceu!!");
                        } else if (jogador == crupie) {
                            System.out.println("Empate!");
                        } else {
                            System.out.println("Você perdeu!");
                        }

                        break;
                    }

                }break;


            }
            System.out.println("Quer jogar novamente? [s/n]");
            loop = user.next();

        }
    }}


