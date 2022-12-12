package pttk.controller;

import pttk.model.clothes.ItemClothes;
import pttk.model.electronic.ItemElectronic;
import pttk.model.shoes.ItemShoes;
import pttk.service.ItemClothesService;
import pttk.service.ItemElectronicService;
import pttk.service.impl.ItemClothesServiceImpl;
import pttk.service.impl.ItemElectronicServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/list-itemElectronic"})
public class ItemElectronicController extends HttpServlet {
    private final ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
           try{
               List<ItemElectronic> listItemElectronic = new ArrayList<>();
               String type = request.getParameter("type");
               if(type.equals("mobile")){
                   listItemElectronic = itemElectronicService.findAllMobile();
               }else{
                   listItemElectronic = itemElectronicService.findAllComputer();
               }
               request.setAttribute("listItemElectronic", listItemElectronic);
               RequestDispatcher dispatcher = request.getRequestDispatcher("views/web/listItemElectronic.jsp");
               dispatcher.forward(request, response);
           }catch (Exception e){
               System.out.println(e);
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
