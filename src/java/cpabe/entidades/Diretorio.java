/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.entidades;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BV1210122
 */
public class Diretorio {

    private String UPLOAD_DIRECTORY;
    private String way;

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public String CriarDiretorio() {

        //UPLOAD_DIRECTORY = getServletContext().getRealPath("/uploads");
        UPLOAD_DIRECTORY = "/home/user/cpabe-0.11/arquivos/";

        //             + "/";                            
        // Cria o diretório caso ele não exista
        File diretorio = new File(UPLOAD_DIRECTORY);

        if (!diretorio.exists()) {
            diretorio.mkdir();
        }
        return UPLOAD_DIRECTORY;
    }

    public List<Diretorio> getTodos() {

        File dir = new File("C:/");

        List<Diretorio> lista = new ArrayList<Diretorio>();

        if (dir.isDirectory()) {
            String[] filhos = dir.list();
            for (int i = 0; i < filhos.length; i++) {
                File nome = new File(dir, filhos[i]);
                if (nome.isFile()) {
                    if (nome.getName().toUpperCase().endsWith(".GBK")) {
                        lista.add(this);
                    }
                } else if (nome.isDirectory()) {
                    getTodos();
                }
            }
        } else {
            lista.add(this);
        }
        return lista;
    }
}
