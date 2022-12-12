package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.model.clothes.ItemClothes;
import pttk.service.ItemBookService;
import pttk.service.ItemClothesService;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.ItemClothesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/list-itemClothes"})
public class ListItemClothesController extends HttpServlet {
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            try {

                try {
                    List<ItemClothes> listItemClothes = itemClothesService.findAllItemClothes();
                    request.setAttribute("listItemClothes", listItemClothes);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/listItemClothes.jsp");
                    dispatcher.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    String view = "views/web/home.jsp";
                    response.sendRedirect(view);
                }
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