package pttk.controller;

import pttk.model.book.ItemBook;
import pttk.model.clothes.ItemClothes;
import pttk.model.electronic.ItemElectronic;
import pttk.model.shoes.ItemShoes;
import pttk.service.ItemBookService;
import pttk.service.ItemClothesService;
import pttk.service.ItemElectronicService;
import pttk.service.ItemShoesService;
import pttk.service.impl.ItemBookServiceImpl;
import pttk.service.impl.ItemClothesServiceImpl;
import pttk.service.impl.ItemElectronicServiceImpl;
import pttk.service.impl.ItemShoesServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    
    private final ItemBookService itemBookService = new ItemBookServiceImpl();
    private final ItemClothesService itemClothesService = new ItemClothesServiceImpl();
    private final ItemShoesService itemShoesService = new ItemShoesServiceImpl();
    private final ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<ItemBook> listItemBook = itemBookService.findAll();
            request.setAttribute("listItemBook", listItemBook);
            List<ItemClothes> listItemClothes = itemClothesService.findAllItemClothes();
            request.setAttribute("listItemClothes", listItemClothes);
            List<ItemShoes> listItemShoes = itemShoesService.findAllItemShoes();
            request.setAttribute("listItemShoes", listItemShoes);
            List<ItemElectronic> listItemElectronic = itemElectronicService.findAll();
            request.setAttribute("listItemElectronic", listItemElectronic);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/web/home.jsp");
            dispatcher.forward(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
