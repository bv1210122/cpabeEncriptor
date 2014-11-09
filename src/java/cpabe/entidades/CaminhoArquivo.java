/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.entidades;

import java.io.File;

/**
 *
 * @author BV1210122
 */
public class CaminhoArquivo {

    private String nome;
    private String way;
    private String chave;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   
    
    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String localizar(String file) {
        String caminho = "";
        File arquivo = new File(file);
        caminho = arquivo.getAbsolutePath();

        if (arquivo.exists()) {
            System.out.println("O caminho especificado existe !\nVamos aos testes:\n");

            if (arquivo.isAbsolute()) {
                System.out.println("É um caminho absoluto");
            } else {
                System.out.println("Não é um caminho absoluto");
            }

            if (arquivo.isFile()) {
                System.out.printf("É um arquivo de tamanho %s bytes\n"
                        + "Útima vez modificado %s\n"
                        + "Cujo caminho é %s\n"
                        + "De caminho absoluto %s\n"
                        + "E está no diretório pai %s\n",
                        arquivo.length(), arquivo.lastModified(), arquivo.getPath(), arquivo.getAbsolutePath(), arquivo.getParent());
            } else {
                System.out.println("É um diretório cujo conteúdo tem os seguintes arquivos: ");
                String[] arquivos = arquivo.list();

                for (String filefinal : arquivos) {
                    System.out.println(filefinal);
                }
            }

        } else {
            System.out.println("Endereço errado");
        }

        return caminho;
    }

}
