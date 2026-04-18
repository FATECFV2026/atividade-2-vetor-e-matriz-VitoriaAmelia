import java.util.Arrays; 
import java.util.Scanner;

public class App {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        // TODO: Implementar menu interativo com as seguintes opcoes:
        // 1. Exercicio 01: Progressao Geometrica
        // 2. Exercicio 02: Sequencia Decrescente
        // 3. Exercicio 03: Vetor Dinamico
        // 4. Exercicio 04: Sequencia Crescente com Soma
        // 5. Exercicio 05: Matriz com Valores Incrementais
        // 6. Exercicio 06: Operacao entre Matrizes
        // 0. Sair
        
        // Utilize o método lerValor para validação de entrada
        // Exiba os resultados utilizando Arrays.toString() para vetores
        // Para matrizes, utilize o método exibirMatriz()

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n1-EX;  2-EX2;  3-EX3;  4-EX4;  5-EX5;  6-EX6;  0-Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: System.out.println(Arrays.toString(ex01())); break;
                case 2: System.out.println(Arrays.toString(ex02())); break;
                case 3: System.out.println(Arrays.toString(ex03())); break;
                case 4: 
                    int[] v = ex04(); 
                    System.out.println(Arrays.toString(v)); 
                    System.out.println("Soma: " + calcularSoma(v)); 
                    break;
                case 5: exibirMatriz(ex05()); break;
                case 6: 
                    int[][][] r = ex06(); 
                    exibirMatriz(r[0]); 
                    exibirMatriz(r[1]); 
                    exibirMatriz(r[2]); 
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
    private static int lerValor(Scanner scanner, String mensagem, int min, int max) {
        // TODO: Implementar validacao de entrada
        // Deve repetir a leitura ate que o valor seja valido (min < valor <= max)

        int valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextInt();
        } while (!(valor > min && valor <= max));

        return valor;
    }
    
    /**
     * Metodo auxiliar para exibir matriz formatada
     * @param matriz Matriz a ser exibida
     */
    private static void exibirMatriz(int[][] matriz) {
        

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%4d ", matriz[i][j]);
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

        for (int v : vetor) {
            soma += v;
        }

        return soma;
    }
    
    /**
     * Exercicio 05: Matriz com Valores Incrementais
     * @param tamanho Tamanho da matriz quadrada
     * @return Matriz NxN com valores incrementais iniciando em tamanho+1
     */
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
    
    /**
     * Exercicio 06: Operacao entre Matrizes
     * @param tamanho Tamanho das matrizes quadradas
     * @return Array com 3 matrizes: [0]=N, [1]=Z, [2]=Soma
     */
    public static int[][][] operacaoEntreMatrizes(int tamanho) {
        

        int[][] n = new int[tamanho][tamanho];
        int[][] z = new int[tamanho][tamanho];
        int[][] s = new int[tamanho][tamanho];

        int cont = tamanho + 1;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                n[i][j] = cont;
                z[i][j] = cont;
                s[i][j] = cont * 2;
                cont++;
            }
        }

        return new int[][][] { n, z, s };
    }
    
    // ========================================
    // METODOS REQUERIDOS PELO AUTOGRADER
    // NAO REMOVER - Necessarios para avaliacao automatica
    // ========================================
    
    /**
     * Metodo ex01 para compatibilidade com autograder
     * @return resultado do exercicio 01
     */
    public static int[] ex01() {
        // TODO: Implementar leitura de entrada e chamar progressaoGeometrica()
        int v = lerValor(scanner, "Valor <= 20: ", -1000000, 20);
        return progressaoGeometrica(v);
    }
    
    /**
     * Metodo ex02 para compatibilidade com autograder
     * @return resultado do exercicio 02
     */
    public static int[] ex02() {
        // TODO: Implementar leitura de entrada e chamar sequenciaDecrescente()
        int v = lerValor(scanner, "Valor (1< <100): ", 1, 99);
        return sequenciaDecrescente(v);
    }
    
    /**
     * Metodo ex03 para compatibilidade com autograder
     * @return resultado do exercicio 03
     */
    public static int[] ex03() {
        // TODO: Implementar leitura de entrada e chamar vetorDinamico()
        int v = lerValor(scanner, "Tamanho: ", 1, 1000);
        return vetorDinamico(v);
    }
    
    /**
     * Metodo ex04 para compatibilidade com autograder
     * @return resultado do exercicio 04
     */
    public static int[] ex04() {
        // TODO: Implementar leitura de entrada e chamar sequenciaCresenteComSoma()
        int v = lerValor(scanner, "Valor (1< <100): ", 1, 99);
        int[] r = sequenciaCresenteComSoma(v);
        return r;
    }
    
    /**
     * Metodo ex05 para compatibilidade com autograder
     * @return resultado do exercicio 05
     */
    public static int[][] ex05() {
        // TODO: Implementar leitura de entrada e chamar matrizIncrementais()
        int v = lerValor(scanner, "Valor (3< <=50): ", 3, 50);
        return matrizIncrementais(v);
    }
    
    /**
     * Metodo ex06 para compatibilidade com autograder
     * @return resultado do exercicio 06
     */
    public static int[][][] ex06() {
        // TODO: Implementar leitura de entrada e chamar operacaoEntreMatrizes()
        int v = lerValor(scanner, "Valor (3< <=50): ", 3, 50);
        return operacaoEntreMatrizes(v);
    }
}