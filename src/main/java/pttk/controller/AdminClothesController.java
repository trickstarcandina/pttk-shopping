/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pttk.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import pttk.model.clothes.Clothes;
import pttk.model.clothes.ItemClothes;
import pttk.model.clothes.Origin;
import pttk.model.clothes.Trademark;
import pttk.service.ItemClothesService;
import pttk.service.impl.ItemClothesServiceImpl;

@WebServlet(urlPatterns = {"/admin-clothes", "/admin-delete-clothes"})
public class AdminClothesController extends HttpServlet {

    private ItemClothesService itemClothesService = new ItemClothesServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String view = "";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/clothes/list-clothes.jsp";
                int totalItem = itemClothesService.getTotalItem();
                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }
                int offset = (currentPage - 1) * maxPageItem;
                List<ItemClothes> itemClothesList = itemClothesService.findAll(maxPageItem, offset);
                request.setAttribute("itemClothesList", itemClothesList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            } //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    ItemClothes itemClothes = itemClothesService.findById(Integer.parseInt(id));
                    request.setAttribute("itemClothes", itemClothes);
                    System.out.println("pttk.controller.AdminClothesController.doGet()------" + itemClothes.getClothes().getBarcode());
                }
                view = "views/admin/clothes/edit-clothes.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String serveletPath = request.getServletPath();
        if (serveletPath.equals("/admin-clothes")) {
            try {
                String view = "views/admin/clothes/edit-clothes.jsp";
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String imageUrl = request.getParameter("imageUrl");
                String priceItemClothes = request.getParameter("priceItemClothes");
                String priceClothes = request.getParameter("priceClothes");
                String barCode = request.getParameter("barcode");
                String type = request.getParameter("type");
                String yearOfManufacture = request.getParameter("yearOfManufacture");
                String size = request.getParameter("size");
                String color = request.getParameter("color");
                String material = request.getParameter("material");
                String description = request.getParameter("description");
                String nationOrigin = request.getParameter("nationOrigin");
                String addressOrigin = request.getParameter("addressOrigin");
                String nameTradeMark = request.getParameter("nameTradeMark");
                String addressTradeMark = request.getParameter("addressTradeMark");
                // validate input
                if (name.isEmpty() || imageUrl.isEmpty() || priceItemClothes.isEmpty() || priceClothes.isEmpty() || barCode.isEmpty() || size.isEmpty() || color.isEmpty() || description.isEmpty()) {
                    request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                    request.setAttribute("alert", "danger");
                } else {
                    ItemClothes itemClothes = new ItemClothes();
                    itemClothes.setImageUrl(imageUrl);
                    itemClothes.setPrice(Float.parseFloat(priceItemClothes));
                    Clothes clothes = new Clothes();
                    clothes.setBarcode(barCode);
                    clothes.setName(name);
                    clothes.setColor(color);
                    clothes.setDescription(description);
                    clothes.setMaterial(material);
                    clothes.setSize(size);
                    clothes.setPrice(Float.parseFloat(priceClothes));
                    clothes.setYearOfManufacture(Integer.parseInt(yearOfManufacture));
                    clothes.setType(type);
                    Origin origin = new Origin(nationOrigin, addressOrigin);
                    Trademark tradeMark = new Trademark(nameTradeMark, addressTradeMark);
                    clothes.setTrademark(tradeMark);
                    clothes.setOrigin(origin);
                   itemClothes.setClothes(clothes);
                    // update product if find id
                    if (!id.isEmpty() && id != null) {
                        itemClothes.setId(Integer.parseInt(id));
                        itemClothes = itemClothesService.update(itemClothes);
                        request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công!");
                        request.setAttribute("alert", "success");
                    } //create product if not find id
                    else {
                         itemClothes = itemClothesService.save(itemClothes);
                         request.setAttribute("messageResponse", "Thêm sản phẩm thành công !");
                         request.setAttribute("alert", "success");
                         request.setAttribute("id", itemClothes.getId());
                    }
                    request.setAttribute("itemClothes", itemClothes);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        } else { // delete item
            try {
                String[] ids = request.getParameterValues("checkbox");
                itemClothesService.delete(ids);
                String view = "views/admin/clothes/list-clothes.jsp";
                request.setAttribute("messageResponse", "Xoá thành công");
                request.setAttribute("alert", "success");
                int totalItem = itemClothesService.getTotalItem();
                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;
                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }
                int offset = (currentPage - 1) * maxPageItem;
                List<ItemClothes> itemClothesList = itemClothesService.findAll(maxPageItem, offset);

                request.setAttribute("itemClothesList", itemClothesList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        }
    }

}
