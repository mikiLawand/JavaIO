package IOCaracter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class ExercicioIOCaracter {

    public static void abrirTecladoExibirConsole() throws IOException {

        System.out.println("Digite 3 sugestões de filme: ");

        //abrindo teclado 
        //abrindo um fluxo de dados para receber atraves do teclado 
        InputStream is = System.in;
        //ponte que transforma o fluxo do InputStream em caracter
        Reader isr = new InputStreamReader(is);
        //lê o stream de carcater e armazena em buffer para facilitar a leitura 
        BufferedReader br = new BufferedReader(isr);

        //preparando escrita no console 
        //abrindo um fluxo de dados para enviar para o console 
        OutputStream os = System.out;
        //ponte que transforma o fluxo OutputStream em character
        OutputStreamWriter osr = new OutputStreamWriter(os);
        //grava o stream de carcater e armazena em um buffer para facilitar a leitura 
        BufferedWriter bw = new BufferedWriter(osr);

        //leitura e envio para o console 
        //método readLine lê cada linha de texto e rotorna uma string 
        String line = br.readLine();
        do {
            bw.write(line); //pega a linha lida e armazena no teclado
            bw.newLine();//insere uma nova linha vazia 
            line = br.readLine(); //copia a linha acima e preenche a linha novamente 
        } while(!line.isEmpty());//para quando a linha estiver vazia 

        br.close(); //fechamos o fluxo de entrada 
        bw.close(); //fechamos o fluxo de saida 
    }

     public static void main(String[] args) throws IOException {
        abrirTecladoExibirConsole();
    }
}