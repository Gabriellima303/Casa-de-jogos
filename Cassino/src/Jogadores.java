import java.util.ArrayList;
public class Jogadores {

    public static int calcularValorMao(ArrayList<Carta> mao) {
        int soma = 0;
        int as = 0;


        for (Carta c : mao) {
            if (c.getValor().equals("Ás")) {
                as++;
                soma += 1;
            } else {
                soma += c.getValorNumerico();
            }
        }

        // tenta transformar Ás em 10 se possível
        while (as > 0 && soma + 9 <= 21) {
            soma += 9; // já tinha contado 1, então soma mais 9 = 10
            as--;
        }

        return soma;


    }
    public static int turnoDoCrupie(ArrayList<Carta> maoCrupie) {
        int soma = 0;
        int as = 0;
        for (Carta c : maoCrupie) {
            if (c.getValor().equals("Ás")) {
                as++;
                soma += 1;
            } else {
                soma += c.getValorNumerico();
            }
        }

        // tenta transformar Ás em 10 se possível
        while (as > 0 && soma + 9 <= 21) {
            soma += 9; // já tinha contado 1, então soma mais 9 = 10
            as--;
        }
        return soma;

    }}
