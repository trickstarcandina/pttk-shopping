package pttk.controller;

import pttk.model.electronic.Computer;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;
import pttk.service.ItemElectronicService;
import pttk.service.impl.ItemElectronicServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detailItemElectronic"})
public class DetailItemElectronicController extends HttpServlet {
    private final ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {
                String id = request.getParameter("id");
                ItemElectronic itemElectronic = new ItemElectronic();
                itemElectronic = itemElectronicService.findElectronicById(Integer.parseInt(id));
                Mobile mobile = itemElectronicService.findMobile(Integer.parseInt(id));
                Computer computer = itemElectronicService.findComputer(Integer.parseInt(id));
                request.setAttribute("itemMobile", mobile);
                request.setAttribute("itemComputer", computer);
                request.setAttribute("itemElectronic", itemElectronic);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/electronic-detail.jsp");
                dispatcher.forward(request, response);
            }catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        }catch(Exception e){
            System.out.println(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
