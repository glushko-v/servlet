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
public class MyServlet extends HttpServlet {
    private ItemController itemController = new ItemController();
    private ItemDAO itemDAO = new ItemDAO();
    ObjectMapper mapper = new ObjectMapper();
    private long id;
    Item item;
    BufferedReader br;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        id = Long.parseLong(req.getParameter("id"));
        PrintWriter pw = resp.getWriter();
        pw.println(itemController.findById(id));


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

        br = req.getReader();
        try {
            item = mapper.readValue(br, Item.class);


        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(item);
        itemController.update(item);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        br = req.getReader();

        try {
            item = mapper.readValue(br, Item.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        itemController.save(item);



    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

        br = req.getReader();
        try {

            item = mapper.readValue(br, Item.class);


        } catch (IOException e) {
            e.printStackTrace();
        }

        itemController.delete(item.getId());


    }

    // get - получить информацию из БД
    // post - сохранение информации (регистрация пользователя, заказ и т.д.)
    // put - обновление существующей информации
    // delete - удаление информации из БД
}
