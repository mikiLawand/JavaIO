package IOByte;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExercicioIOBytes {
    
    public static void copiarArquivo(String arquivo) throws IOException {
        File f = new File(arquivo); //mostra o caminho até o arquivo que você deseja copiar 
        String nomeArquivo = f.getName(); //obtem o nome do arquivo original 

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo));
        //arzenando os dados lidos em um buffer 

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf(".txt")).concat("-coy2.txt");
        //formata o nome do arquivo copia 
        File fcopy = new File(nomeArquivoCopy);
        //criando uma referencia para o arquivo copia 

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fcopy));
        //grava os dados no arquivo de copia 

        int line = 0;
        while ((line = bis.read()) != -1) { //faz a leitura dos dados enquanto a linha for preenchida,
            bos.write((char) line); //abre o teclado para escrita
            bos.flush(); //descarrega as informações no arquivo txt 
        }

        bis.close();
        bos.close();

        System.out.printf("Arquivo %s copiado com sucesso e está no diretório %s com %d bytes ",
                fcopy.getName(), fcopy.getPath(), fcopy.length());
    }

    public static void main(String[] args) throws IOException {
        copiarArquivo("recomendacoes-copy.txt");
    }
}
