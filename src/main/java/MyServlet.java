import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet{
    ItemDAO itemDAO = new ItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println(req.getParameter("param"));
        resp.getWriter().println("Test!");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        BufferedReader br = req.getReader();



        ObjectMapper mapper = new ObjectMapper();
        Item item = null;
        try {
            item = mapper.readValue(br, Item.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(item);
        itemDAO.save(item);


//        req.getInputStream();
//        req.getReader();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    // get - получить информацию из БД
    // post - сохранение информации (регистрация пользователя, заказ и т.д.)
    // put - обновление существующей информации
    // delete - удаление информации из БД
}
