package IOCaracter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Exercicio3IOCaracter {
    
    //TODO: faça uma copia do arquivo recomendacoes.txt e adicione 3 recomendações de livro nele
    public static void copiarArquivo(String arquivo) throws IOException {
        File f = new File(arquivo); //mostra o caminho até o arquivo que você deseja copiar
        String nomeDoArquivoOriginal = f.getName(); //obtem o nome do arquivo original 

        BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivoOriginal));
        //abre o arquivo que será copiado 

        String nomeDoArquivoCopy = nomeDoArquivoOriginal.substring(0, nomeDoArquivoOriginal.indexOf(".")).concat("-copy.txt");
        //formata o nome do arquivo copia 

        File fcopy = new File(nomeDoArquivoCopy); 
        //criando uma referencia para o arquivo copia 
        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));
        //criando o arquivo copia 

        String linha = br.readLine();
        //lendo as linhas do arquivo que será copiado 
        do {
            bw.write(linha);
            //pegue a linha lida no arquivo original e armazene no buffer
            bw.newLine(); //pule uma linha 
            linha = br.readLine(); //preenche a linha novamente 
        } while(!(linha == null));
        //enquanto existir conteudo na linha,continue copiando 
        bw.flush(); //descarrega as informações no arquivo txt 

        PrintWriter pw = new PrintWriter(System.out); //inicializa a impressão no console 
        pw.printf("Arquivo '%s' criado com sucesso| \n diretório: '%s'\n", fcopy.getName(),
                fcopy.getAbsolutePath());
        //exibe a mensagem formatada da criação do arquivo copia 
        pw.println("Agora faça a recomendação de 3 livros: ");
        pw.flush(); //descarrega o conteudo do metodo writer no console 

        adicionarInformacoesArquivoJaExistente(nomeDoArquivoCopy);
        //executa o metodo 

        pw.printf("Ok!Tudo certo! Tamanho do arquivo %d bytes.", fcopy.length());
        //exibe a mensagem formatada no console 
        pw.flush();//descarrega o conteudo do metodo write no console 

        br.close(); //fecha o fluxo de entrada 
        bw.close(); //fecha o fluxo de saida 
        pw.close(); //fecha o fluxo de saida para o console 

    }

    public static void adicionarInformacoesArquivoJaExistente(String arquivoCopy) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //padrão decorator para ler (input) do teclado.

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoCopy, true));
        //padrão decorator para escrever (output) no arquivo sem apagar o conteúdo que já existia.

        String line = br.readLine();
        do { //faça
            bw.write(line); //escreva no buffer interno a linha capturada pelo scanner
            bw.newLine(); //pule para próxima linha no buffer
            line = br.readLine(); //pegue a proxima linha do teclado
        } while(!line.equalsIgnoreCase("fim"));
        //repita as operações do laço do-while. Quando digitar a palavra 'fim', pare.
        
        //fechando todos os fluxos
        br.close(); //fechamos o fluxo de entrada
        bw.close(); //fechamos o fluxo de saída para escrita no documento
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo("recomendacoes.txt");
    }
}
