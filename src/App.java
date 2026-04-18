import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        while (op != 0) {
            System.out.println("\n1-Ex01  2-Ex02  3-Ex03  4-Ex04  5-Ex05  6-Ex06  0-Sair");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println(Arrays.toString(ex01()));
                    break;

                case 2:
                    System.out.println(Arrays.toString(ex02()));
                    break;

                case 3:
                    System.out.println(Arrays.toString(ex03()));
                    break;

                case 4:
                    int[] res = ex04();
                    System.out.println(Arrays.toString(res));
                    System.out.println("Soma: " + calcularSoma(res)); // ✔ CORRIGIDO AQUI
                    break;

                case 5:
                    imprimir(ex05());
                    break;

                case 6:
                    int[][][] r = ex06();
                    imprimir(r[0]);
                    imprimir(r[1]);
                    imprimir(r[2]);
                    break;
            }
        }
    }

    /**
     * Metodo auxiliar para ler e validar entrada do usuario
     * @param scanner Scanner para leitura
     * @param mensagem Mensagem a ser exibida
     * @param min Valor minimo (exclusivo)
     * @param max Valor maximo (inclusivo)
     * @return Valor valido lido
     */
    private static int ler(Scanner sc, String msg, int min, int max) {
        int v;
        do {
            System.out.print(msg);
            v = sc.nextInt();
        } while (v <= min || v > max);
        return v;
    }

    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void imprimir(int[][] m) {
        for (int[] linha : m) {
            for (int valor : linha) {
                System.out.printf("%4d ", valor);
            }
            System.out.println();
        }
    }

    /**
     * Exercicio 01: Progressao Geometrica
     * @param valorInicial Valor inicial (deve ser <= 20)
     * @return Vetor de 10 elementos com progressao geometrica (dobro) ou null se invalido
     */
    public static int[] progressaoGeometrica(int valorInicial) {
        if (valorInicial > 20) return null;

        int[] v = new int[10];
        v[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            v[i] = v[i - 1] * 2;
        }

        return v;
    }

    /**
     * Exercicio 02: Sequencia Decrescente
     * @param valorInicial Valor inicial (deve ser > 1)
     * @return Vetor de 10 elementos com sequencia decrescente ou null se invalido
     */
    public static int[] sequenciaDecrescente(int valorInicial) {
        if (valorInicial <= 1) return null;

        int[] v = new int[10];
        v[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            v[i] = v[i - 1] - 1;
        }

        return v;
    }

    /**
     * Exercicio 03: Vetor Dinamico
     * @param tamanho Tamanho do vetor (deve ser <= 1000)
     * @return Vetor com sequencia de 1 ate tamanho ou null se invalido
     */
    public static int[] vetorDinamico(int tamanho) {
        if (tamanho > 1000) return null;

        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = i + 1;
        }

        return v;
    }

    /**
     * Exercicio 04: Sequencia Crescente com Soma
     * @param valorInicial Valor inicial
     * @return Vetor de 10 elementos com sequencia crescente
     */
    public static int[] sequenciaCresenteComSoma(int valorInicial) {
        int[] v = new int[10];
        v[0] = valorInicial;

        for (int i = 1; i < 10; i++) {
            v[i] = v[i - 1] + 1;
        }

        return v;
    }

    /**
     * Calcula a soma de todos os elementos do vetor
     * @param vetor Vetor para calcular a soma
     * @return Soma de todos os elementos
     */
    public static int calcularSoma(int[] vetor) {
        int soma = 0;
        for (int v : vetor) soma += v;
        return soma;
    }

    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em tamanho+1
     */
    public static int[][] matrizIncrementais(int tamanho) {
        int[][] m = new int[tamanho][tamanho];
        int c = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                m[i][j] = c++;
            }
        }

        return m;
    }

    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Soma
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        int[][] A = new int[tamanho][tamanho];
        int[][] B = new int[tamanho][tamanho];
        int[][] S = new int[tamanho][tamanho];

        int c = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                A[i][j] = c;
                B[i][j] = c;
                S[i][j] = c * 2;
                c++;
            }
        }

        return new int[][][]{A, B, S};
    }

    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================

    public static int[] ex01() {
        Scanner sc = new Scanner(System.in);
        int valorInicial = ler(sc, "Valor (<=20): ", Integer.MIN_VALUE, 20);
        return progressaoGeometrica(valorInicial);
    }

    public static int[] ex02() {
        Scanner sc = new Scanner(System.in);
        int valorInicial = ler(sc, "Valor (1<v<100): ", 1, 99);
        return sequenciaDecrescente(valorInicial);
    }

    public static int[] ex03() {
        Scanner sc = new Scanner(System.in);
        int tamanho = ler(sc, "Valor (1<v<=1000): ", 1, 1000);
        return vetorDinamico(tamanho);
    }

    public static int[] ex04() {
        Scanner sc = new Scanner(System.in);
        int valorInicial = ler(sc, "Valor (1<v<100): ", 1, 99);
        return sequenciaCresenteComSoma(valorInicial);
    }

    public static int[][] ex05() {
        Scanner sc = new Scanner(System.in);
        int tamanho = ler(sc, "Valor (3<v<=50): ", 3, 50);
        return matrizIncrementais(tamanho);
    }

    public static int[][][] ex06() {
        Scanner sc = new Scanner(System.in);
        int tamanho = ler(sc, "Valor (3<v<=50): ", 3, 50);
        return operacaoEntreMatrizes(tamanho);
    }
}