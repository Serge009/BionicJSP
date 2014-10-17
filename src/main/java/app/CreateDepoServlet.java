package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by oper4 on 17.10.2014.
 */
@WebServlet("/create_depo")
public class CreateDepoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("newdepo.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String bank = req.getParameter("bank");
            String depoId = req.getParameter("depoId");


            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startDate"));


            int dayLong = Integer.parseInt(req.getParameter("dayLong"));
            double sum = Double.parseDouble(req.getParameter("sum"));
            double interestRate = Double.parseDouble(req.getParameter("interestRate"));

            DepoBase depo;

            if (req.getParameter("simple") != null && req.getParameter("simple").equals("on")) {
                depo = new DepoSimple(bank, depoId, startDate, dayLong, sum, interestRate);
            } else {
                depo = new DepoMonthCapitalize(bank, depoId, startDate, dayLong, sum, interestRate);
            }

            ListDepo listDepo = new ListDepo();
            listDepo.init();
            ArrayList<DepoBase> listDepoList = listDepo.getList();
            listDepoList.add(depo);

            listDepo.save("C:\\Depo.txt");

        } catch (ParseException e) {}

        resp.sendRedirect("DSelectServlet");

    }
}
