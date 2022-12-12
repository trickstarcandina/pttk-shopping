package pttk.controller;

import pttk.model.electronic.Computer;
import pttk.model.electronic.ItemElectronic;
import pttk.model.electronic.Mobile;
import pttk.model.shoes.ItemShoes;
import pttk.model.shoes.ShoesForMan;
import pttk.model.shoes.ShoesForWomen;
import pttk.service.ItemElectronicService;
import pttk.service.ItemShoesService;
import pttk.service.impl.ItemElectronicServiceImpl;
import pttk.service.impl.ItemShoesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/detailItemShoes"})
public class DetailItemShoesController extends HttpServlet {
    private final ItemShoesService itemShoesService = new ItemShoesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {
                String id = request.getParameter("id");
                ItemShoes itemShoes = new ItemShoes();
                itemShoes = itemShoesService.findShoesById(Integer.parseInt(id));
                ShoesForMan shoesForMan = itemShoesService.findShoesForMan(Integer.parseInt(id));
                ShoesForWomen shoesForWomen = itemShoesService.findShoesForWomen(Integer.parseInt(id));
                request.setAttribute("itemShoesForMan", shoesForMan);
                request.setAttribute("itemShoesForWomen", shoesForWomen);
                request.setAttribute("itemShoes", itemShoes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/shoes-detail.jsp");
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
