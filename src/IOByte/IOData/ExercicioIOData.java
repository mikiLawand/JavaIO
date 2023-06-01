package IOByte.IOData;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class ExercicioIOData {
    
    /*TODO: 
     * crie um arquivo "roupa.bin" e armazene:
     * nome do produto,tamanho,quantidade e preço 
     * leia este arquivo e imprima no console 
     */

     public static void incluirProduto() throws IOException {
        File f = new File("C:/Users/mklaw/OneDrive/Documentos/peca-de-roupa.bin");
        PrintStream ps = new PrintStream(System.out, true);
        //criando um fluxo de saida para o console 

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));
        //grava os dados em um arquivo e mostra onde eles estão 

        Scanner scan = new Scanner(System.in);
        //abrindo o teclado 

        ps.print("Nome do produto: ");
        String nome = scan.next(); //armazenando o input na variavel
        dos.writeUTF(nome); //escrevendo no documento

        ps.print("Quantidade: ");
        int quantidade = scan.nextInt();//armazenando o input na variavel 
        dos.writeInt(quantidade); //escrevendo no documento

        ps.print("Tamanho: ");
        char tamanho = (char) System.in.read();//armazena o input na variavel 
        dos.writeChar(tamanho);//escrevendo no documento 

        ps.print("Preço: ");
        double preço = scan.nextDouble(); //armazena o input na variavel 
        dos.writeDouble(preço);//escrevendo no documento 

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath());

        lerArquivoBin(f.getPath());

        scan.close();//fechando o fluxo de entrada pelo teclado
        dos.close(); //fechando o fluxo de escrita de dados 
        ps.close(); //fechando o fluxo de escrita no console 

     }

     public static void lerArquivoBin(String arquivo) throws IOException {

        File f = new File(arquivo); //apontando um arquivo
        PrintStream ps = new PrintStream(System.out);
        //criando um fluxo de saida para o console

        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));
        //fazendo a leitura dos dados 

        //variaveis 
        String nome;
        int quantidade;
        char tamanho;
        double preço;

        nome = dis.readUTF();//lendo a string
        quantidade = dis.readInt(); //lendo o int
        tamanho = dis.readChar(); //lendo o char
        preço = dis.readDouble(); //lendo o double 
        System.out.printf("\nNome..................: %s\n", nome);
        System.out.printf("Quantidade............: %d\n", quantidade);
        System.out.printf("Tamanho...............: %s\n", tamanho);
        System.out.printf("Preço.................: %f\n", preço);
     }

     public static void main(String[] args) throws IOException {
        incluirProduto();
     }
}
