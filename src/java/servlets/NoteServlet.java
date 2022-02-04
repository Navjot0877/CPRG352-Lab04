
package servlets;


import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
// to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String title = br.readLine();
        String content = br.readLine();
        
        br.close();
        
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        
        if(request.getParameter("edit") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
        else
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        return;
        
    }
    

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
       String contents =  content.replace("\r\n", "<br>");
        
        
        
        Note note = new Note(title, contents);
        
        request.setAttribute("note", note);
        
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        
        pw.write(title + "\n" + contents);
        
        pw.close();
       
        
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }

   

}
