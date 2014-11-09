/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpabe.controladores;

/**
 * @author Pankaj
 * disponível em
 * http://www.journaldev.com/1964/servlet-upload-file-and-download-file-example
 * adaptado por
 * @author BV1210122
 */

import cpabe.entidades.CaminhoArquivo;
import cpabe.entidades.FileLocationContextListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadDownloadFileAdvancedServlet")
public class UploadDownloadFileAdvancedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

    @Override
    public void init() throws ServletException {
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            throw new ServletException("O nome do arquivo não pode ser null ou vazio.");
        }
        File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
        if (!file.exists()) {
            throw new ServletException("O arquivo desejado não existe no Servidor.");
        }
        System.out.println("File location on server::" + file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("Content type is not multipart/form-data");
        }

            // response.setContentType("text/html");
        //  PrintWriter out = response.getWriter();
        // out.write("<html><head></head><body>");
        try {
            List<FileItem> fileItemsList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
            while (fileItemsIterator.hasNext()) {
                FileItem fileItem = fileItemsIterator.next();

                System.out.println("FieldName=" + fileItem.getFieldName());
                System.out.println("FileName=" + fileItem.getName());
                System.out.println("ContentType=" + fileItem.getContentType());
                System.out.println("Size in bytes=" + fileItem.getSize());

                File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileItem.getName());
                //setar no objeto CaminhoArquivo os dados do arquivo anexado
                String caminho = file.getAbsolutePath();
                String nome = fileItem.getName();

                CaminhoArquivo c = new CaminhoArquivo();
                c.setNome(nome);
                c.setWay(caminho);

                request.setAttribute("caminho", c);
                System.out.println("caminho=" + caminho);
                System.out.println("nome=" + nome);

                System.out.println("Absolute Path at server=" + file.getAbsolutePath());
                fileItem.write(file);

                request.getRequestDispatcher("/avancado/encriptar/encriptar1.jsp").forward(request, response);

                    // out.write("File " + fileItem.getName() + " uploaded successfully.");
                // out.write("<br>");
                // out.write("<a href=\"UploadDownloadFileServlet?fileName=" + fileItem.getName() + "\">Download " + fileItem.getName() + "</a>");
            }

        } catch (FileUploadException e) {
            //  out.write("Exception in uploading file.");
        } catch (Exception e) {
            //  out.write("Exception in uploading file.");
        }
        // out.write("</body></html>");
    }

}
