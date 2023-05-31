package IOCaracter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercicio2IOCaracter {
   
    public static void abrirTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out); //inizializa a impressão no console
        pw.write("Recomende 3 filmes e para finalizar digite 'fim': ");
        //exibe a mensagem no console 
        pw.println(); //pula uma linha 
        pw.flush(); //descarrega p conteudo de write no console 

        Scanner scanner = new Scanner(System.in); //inicializa o teclado 
        String line = scanner.nextLine(); //faz a leitura de cada linha e armazena 

        File f = new File("Recomendacoes.txt"); //especifica onde o conteudo será armazenado 

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));
        //armazena o que foi escrito dentro de um buffer para maior eficiencia 

        do { 
            bw.write(line); //escreve a linha capturada no scanner dentro do buffer
            bw.newLine(); //pula uma linha 
            line = scanner.nextLine(); //lê a proxima linha 
        } while(!line.equalsIgnoreCase("fim")); //para o laço quando for digitada a palavra fim
        bw.flush(); //descarrega as informações no arquivo criado anteriormente 

        pw.printf("Tudo certo! Arquivo '%s' foi criado com tamanho '%s' bytes." , f.getName(), f.length());
        //utilizando o método printf da classe PrintWrite para formatar a mensagem que será exibida no console.
        
        //fechando os fluxos 
        scanner.close(); //fecha o fluxo de entrada 
        bw.close(); //fecha o fluxo de saida 
        pw.close(); //fecha o fluxo de saida para o console 
    }

    public static void main(String[] args) throws IOException {
        abrirTecladoEscreverDocumento();
    }
}
