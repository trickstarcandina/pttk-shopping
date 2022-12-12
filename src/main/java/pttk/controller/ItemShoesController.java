package pttk.controller;

import pttk.model.shoes.ItemShoes;
import pttk.service.ItemShoesService;
import pttk.service.impl.ItemShoesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/item-shoes"})
public class ItemShoesController extends HttpServlet {

    private final ItemShoesService itemShoesService = new ItemShoesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<ItemShoes> listItemShoes = new ArrayList<>();
            String type = request.getParameter("type");
            if(type.equals("men")){
                listItemShoes = itemShoesService.getAllShoesForMan();
            }else{
                listItemShoes = itemShoesService.getAllShoesForWomen();
            }
            request.setAttribute("listItemShoes", listItemShoes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/listItemShoes.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}