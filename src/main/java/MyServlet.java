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


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        long id = Long.parseLong(req.getParameter("id"));
        PrintWriter pw = resp.getWriter();
        if (!itemController.isIdExists(id)) {
            resp.sendError(400, ("There's no item with id " + id));

        } else pw.println(itemController.findById(id));
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);

        //TODO


        BufferedReader br = req.getReader();
        itemController.update(itemController.mapJSONtoItem(br));
        resp.setStatus(200);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        BufferedReader br = req.getReader();
        itemController.save(itemController.mapJSONtoItem(br));
        resp.setStatus(200);


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);

        long id = Long.parseLong(req.getParameter("id"));
        PrintWriter pw = resp.getWriter();
        if (!itemController.isIdExists(id)) {
            System.err.println("There's no item with id " + id);

        } else itemController.delete(id);

//        itemController.delete(id);


    }

}
