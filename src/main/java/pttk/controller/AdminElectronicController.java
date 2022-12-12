package pttk.controller;

import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.ItemBook;
import pttk.model.book.Publisher;
import pttk.model.electronic.Computer;
import pttk.model.electronic.Electronic;
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
import java.util.List;

@WebServlet(urlPatterns = {"/admin-electronic", "/admin-delete-electronic"})
public class AdminElectronicController extends HttpServlet {

    private ItemElectronicService itemElectronicService = new ItemElectronicServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println("pttk.controller.AdminElectronicController.doGet()---"+type);
        String view = "views/admin/admin-electronic.jsp";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/electronic/list-electronic.jsp";
                int totalItem = itemElectronicService.getTotalItem();
                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }
                int offset = (currentPage - 1) * maxPageItem;
                List<ItemElectronic> itemElectronicList = itemElectronicService.findAllItemElectronic(maxPageItem, offset);
                request.setAttribute("itemElectronicList", itemElectronicList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            }
            //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    ItemElectronic itemElectronic = itemElectronicService.findElectronicById(Integer.parseInt(id));
                    Mobile mobile = itemElectronicService.findMobile(Integer.parseInt(id));
                    Computer computer = itemElectronicService.findComputer(Integer.parseInt(id));
                    request.setAttribute("itemElectronic", itemElectronic);
                    request.setAttribute("itemMobile", mobile);
                    request.setAttribute("itemComputer", computer);
                }
                view = "views/admin/electronic/edit-electronic.jsp";
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
        if (serveletPath.equals("/admin-electronic")) {
            try {
                String view = "views/admin/electronic/edit-electronic.jsp";
                String id = request.getParameter("id");
                String name = request.getParameter("name");
                String imageUrl = request.getParameter("imageUrl");
                String price = request.getParameter("price");
                String brand = request.getParameter("brand");
                String discount = request.getParameter("discount");
                String origin = request.getParameter("origin");

                String size = request.getParameter("size");
                String ramComputer = request.getParameter("ramComputer");
                String romComputer = request.getParameter("romComputer");
                String powerComputer = request.getParameter("powerComputer");

                String chip = request.getParameter("chip");
                String camera = request.getParameter("camera");
                String accessory = request.getParameter("accessory");
                String ramMobile = request.getParameter("ramMobile");
                String romMobile = request.getParameter("romMobile");
                String powerMobile = request.getParameter("powerMobile");
                String resolution = request.getParameter("resolution");

                String description = request.getParameter("description");

                if(ramComputer!=null) {
                    Computer computer = itemElectronicService.findComputer(Integer.parseInt(id));
                    if (name.isEmpty() || imageUrl.isEmpty() || price.isEmpty() ||
                            brand.isEmpty() || origin.isEmpty() || description.isEmpty() ||
                            size.isEmpty() || ramComputer.isEmpty() || romComputer.isEmpty() || powerComputer.isEmpty()) {
                        request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                        request.setAttribute("alert", "danger");
                    } else {
                        ItemElectronic itemElectronic = new ItemElectronic();
                        itemElectronic.setId(Integer.parseInt(id));
                        itemElectronic.setImageUrl(imageUrl);
                        itemElectronic.setPrice(Float.parseFloat(price));
                        Electronic electronic = new Electronic();
                        electronic.setId(itemElectronicService.findElectronicById(Integer.parseInt(id)).getId());
                        electronic.setName(name);
                        electronic.setBrand(brand);
                        electronic.setDiscount(Float.parseFloat(discount));
                        electronic.setOrigin(origin);
                        electronic.setPrice(Float.parseFloat(price));
                        electronic.setDescription(description);
                        itemElectronic.setElectronic(electronic);

                        computer.setSize(size);
                        computer.setRom(romComputer);
                        computer.setRam(ramComputer);
                        computer.setPower(powerComputer);
                        // update product if find id
                        if (!id.isEmpty() && id != null) {
                            itemElectronic.setId(Integer.parseInt(id));
                            itemElectronic = itemElectronicService.updateItemElectronic(itemElectronic, electronic,computer);
                            request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                            request.setAttribute("alert", "success");
                        }
//                    //create product if not find id
//                    else {
//                        itemBook = itemBookService.save(itemBook);
//                        request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
//                        request.setAttribute("alert", "success");
//                        request.setAttribute("id", itemBook.getId());
//                    }
                        request.setAttribute("itemElectronic", itemElectronic);
                        request.setAttribute("itemComputer", computer);
                    }
                }

                if(ramMobile!=null) {
                    Mobile mobile = itemElectronicService.findMobile(Integer.parseInt(id));
                    if (name.isEmpty() || imageUrl.isEmpty() || price.isEmpty() ||
                            brand.isEmpty() || origin.isEmpty() || description.isEmpty() ||
                            chip.isEmpty() || camera.isEmpty() || accessory.isEmpty() ||
                            ramMobile.isEmpty() || romMobile.isEmpty() || powerMobile.isEmpty() ||
                            resolution.isEmpty()) {
                        request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                        request.setAttribute("alert", "danger");
                    } else {
                        ItemElectronic itemElectronic = new ItemElectronic();
                        itemElectronic.setImageUrl(imageUrl);
                        itemElectronic.setPrice(Float.parseFloat(price));
                        Electronic electronic = new Electronic();
                        electronic.setId(itemElectronicService.findElectronicById(Integer.parseInt(id)).getId());
                        electronic.setName(name);
                        electronic.setBrand(brand);
                        electronic.setDiscount(Float.parseFloat(discount));
                        electronic.setOrigin(origin);
                        electronic.setPrice(Float.parseFloat(price));
                        electronic.setDescription(description);
                        itemElectronic.setElectronic(electronic);

                        mobile.setChip(chip);
                        mobile.setCamera(camera);
                        mobile.setAccessory(accessory);
                        mobile.setRom(romMobile);
                        mobile.setRam(ramMobile);
                        mobile.setPower(powerMobile);
                        mobile.setResolution(resolution);
                        // update product if find id
                        if (!id.isEmpty() && id != null) {
                            itemElectronic.setId(Integer.parseInt(id));
                            itemElectronic = itemElectronicService.updateItemElectronic1(itemElectronic, electronic, mobile);
                            request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                            request.setAttribute("alert", "success");
                        }
//                    //create product if not find id
//                    else {
//                        itemBook = itemBookService.save(itemBook);
//                        request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
//                        request.setAttribute("alert", "success");
//                        request.setAttribute("id", itemBook.getId());
//                    }
                        request.setAttribute("itemElectronic", itemElectronic);
                        request.setAttribute("itemMobile", mobile);
                    }
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        } else {
            try {
                String[] ids = request.getParameterValues("checkbox");
//                itemElectronicService.delete(ids);
                String view = "views/admin/electronic/list-electronic.jsp";
                request.setAttribute("messageResponse", "Xoá thành công");
                request.setAttribute("alert", "success");

                int totalItem = itemElectronicService.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<ItemElectronic> itemElectronicList = itemElectronicService.findAllItemElectronic(maxPageItem, offset);
                request.setAttribute("itemElectronicList", itemElectronicList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            }catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/error");
            }
        }
    }

}
