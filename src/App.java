import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n1-Ex01  | 2-Ex02 | 3-Ex03  | 4-Ex04 | 5-Ex05 | 6-Ex06 | 0-Sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1: System.out.println(Arrays.toString(ex01())); break;
                case 2: System.out.println(Arrays.toString(ex02())); break;
                case 3: System.out.println(Arrays.toString(ex03())); break;
                case 4: int[] v = ex04(); System.out.println(Arrays.toString(v)); System.out.println("Soma: " + calcularSoma(v)); break;
                case 5: exibirMatriz(ex05()); break;
                case 6: int[][][] r = ex06(); exibirMatriz(r[0]); exibirMatriz(r[1]); exibirMatriz(r[2]); break;
            }
        }
    }

    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        int valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextInt();
        } while (valor <= min || valor > max);
        return valor;
    }

    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i = i + 1) {
            for (int j = 0; j < matriz[i].length; j = j + 1) {
                System.out.printf("%4d ", matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) {
            return null;
        }
        int[] resultado = new int[10];
        resultado[0] = valorInicial;

        for (int i = 1; i < resultado.length; i = i + 1) {
            int anterior = resultado[i - 1];
            resultado[i] = anterior * 2;
        }
        return resultado;
    }

    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) {
            return null;
        }
        int[] resultado = new int[10];
        resultado[0] = valorInicial;

        for (int i = 1; i < resultado.length; i = i + 1) {
            int anterior = resultado[i - 1];
            resultado[i] = anterior - 1;
        }
        return resultado;
    }

    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) {
            return null;
        }
        int[] resultado = new int[tamanho];

        for (int i = 0; i < resultado.length; i = i + 1) {
            int valor = i + 1;
            resultado[i] = valor;
        }
        return resultado;
    }

    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] resultado = new int[10];
        resultado[0] = valorInicial;

        for (int i = 1; i < resultado.length; i = i + 1) {
            int anterior = resultado[i - 1];
            resultado[i] = anterior + 1;
        }
        return resultado;
    }

    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int elemento : vetor) {
            soma += elemento;
        }
        return soma;
    }

    public static int[][] matrizIncrementais(int tamanho) {
        int[][] matriz = new int[tamanho][tamanho];
        int contador = tamanho + 1;

        for (int i = 0; i < matriz.length; i = i + 1) {
            for (int j = 0; j < matriz[i].length; j = j + 1) {
                matriz[i][j] = contador;
                contador = contador + 1;
            }
        }
        return matriz;
    }

    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] matrizN = new int[tamanho][tamanho];
        int[][] matrizZ = new int[tamanho][tamanho];
        int[][] soma = new int[tamanho][tamanho];
        int contador = tamanho + 1;

        for (int i = 0; i < matrizN.length; i = i + 1) {
            for (int j = 0; j < matrizN[i].length; j = j + 1) {
                matrizN[i][j] = contador;
                matrizZ[i][j] = contador;
                soma[i][j] = contador * 2;
                contador = contador + 1;
            }
        }
        return new int[][][]{matrizN, matrizZ, soma};
    }

    public static int[] ex01() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (<=20): ", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(valorInicial);
    }

    public static int[] ex02() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaDecrescente(valorInicial);
    }

    public static int[] ex03() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (1<v<=1000): ", 1, 1000);
        return vetorDinamico(tamanho);
    }

    public static int[] ex04() {
        Scanner scanner = new Scanner(System.in);
        int valorInicial = lerValor(scanner, "Valor (1<v<100): ", 1, 99);
        return sequenciaCresenteComSoma(valorInicial);
    }

    public static int[][] ex05() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return matrizIncrementais(tamanho);
    }

    public static int[][][] ex06() {
        Scanner scanner = new Scanner(System.in);
        int tamanho = lerValor(scanner, "Valor (3<v<=50): ", 3, 50);
        return operacaoEntreMatrizes(tamanho);
    }
}