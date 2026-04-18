import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== MENU DE EXERCÍCIOS =====");
            System.out.println("1 - Ex01 | 2 - Ex02 | 3 - Ex03 | 4 - Ex04 | 5 - Ex05 | 6 - Ex06 | 0 - Sair");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> System.out.println(Arrays.toString(ex01()));
                case 2 -> System.out.println(Arrays.toString(ex02()));
                case 3 -> System.out.println(Arrays.toString(ex03()));
                case 4 -> {
                    int[] v = ex04();
                    System.out.println(Arrays.toString(v));
                    System.out.println("Soma total: " + calcularSoma(v));
                }
                case 5 -> exibirMatriz(ex05());
                case 6 -> {
                    int[][][] r = ex06();
                    exibirMatriz(r[0]);
                    exibirMatriz(r[1]);
                    exibirMatriz(r[2]);
                }
            }
        }
    }

    private static int lerValor(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            valor = sc.nextInt();
        } while (valor <= min || valor > max);
        return valor;
    }

    private static void exibirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.printf("%4d ", valor);
            }
            System.out.println();
        }
    }

    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) return null;

        int[] n = new int[10];
        n[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            n[i] = n[i - 1] * 2;
        }
        return n;
    }

    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) return null;

        int[] n = new int[10];
        n[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            n[i] = n[i - 1] - 1;
        }
        return n;
    }

    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) return null;

        int[] n = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            n[i] = i + 1;
        }
        return n;
    }

    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] n = new int[10];
        n[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            n[i] = n[i - 1] + 1;
        }
        return n;
    }

    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int v : vetor) soma += v;
        return soma;
    }

    public static int[][] matrizIncrementais(int tamanho) {
        int[][] m = new int[tamanho][tamanho];
        int cont = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                m[i][j] = cont++;
            }
        }
        return m;
    }

    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] n = new int[tamanho][tamanho];
        int[][] z = new int[tamanho][tamanho];
        int[][] soma = new int[tamanho][tamanho];

        int cont = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                n[i][j] = cont;
                z[i][j] = cont;
                soma[i][j] = cont * 2;
                cont++;
            }
        }

        return new int[][][]{n, z, soma};
    }

    // ===================== AUTOGRADER =====================

    public static int[] ex01() {
        Scanner sc = new Scanner(System.in);
        int v = lerValor(sc, "Informe valor (<=20): ", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(v);
    }

    public static int[] ex02() {
        Scanner sc = new Scanner(System.in);
        int v = lerValor(sc, "Informe valor (1-99): ", 1, 99);
        return sequenciaDecrescente(v);
    }

    public static int[] ex03() {
        Scanner sc = new Scanner(System.in);
        int t = lerValor(sc, "Informe tamanho (1-1000): ", 1, 1000);
        return vetorDinamico(t);
    }

    public static int[] ex04() {
        Scanner sc = new Scanner(System.in);
        int v = lerValor(sc, "Informe valor (1-99): ", 1, 99);
        return sequenciaCresenteComSoma(v);
    }

    public static int[][] ex05() {
        Scanner sc = new Scanner(System.in);
        int t = lerValor(sc, "Informe valor (3-50): ", 3, 50);
        return matrizIncrementais(t);
    }

    public static int[][][] ex06() {
        Scanner sc = new Scanner(System.in);
        int t = lerValor(sc, "Informe valor (3-50): ", 3, 50);
        return operacaoEntreMatrizes(t);
    }
}