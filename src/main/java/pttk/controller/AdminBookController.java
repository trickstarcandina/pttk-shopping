package pttk.controller;

import pttk.model.book.Author;
import pttk.model.book.Book;
import pttk.model.book.ItemBook;
import pttk.model.book.Publisher;
import pttk.service.ItemBookService;
import pttk.service.impl.ItemBookServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-book", "/admin-delete-book"})
public class AdminBookController extends HttpServlet {

    private ItemBookService itemBookService = new ItemBookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        System.out.println("pttk.controller.AdminBookController.doGet()---"+type);
        String view = "views/admin/admin-book.jsp";
        try {
            //show list product
            if (type.equals("list")) {
                view = "views/admin/book/list-book.jsp";
                int totalItem = itemBookService.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<ItemBook> itemBookList = itemBookService.findAll(maxPageItem, offset);

                request.setAttribute("itemBookList", itemBookList);
                request.setAttribute("totalPage", totalPage);
                request.setAttribute("currentPage", currentPage);
            }
            //show edit product
            else if (type.equals("edit")) {
                String id = request.getParameter("id");
                if (id != null) {
                    ItemBook itemBook = itemBookService.findById(Integer.parseInt(id));
                    request.setAttribute("itemBook", itemBook);
                }
                view = "views/admin/book/edit-book.jsp";
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
        if (serveletPath.equals("/admin-book")) {
            try {
                String view = "views/admin/book/edit-book.jsp";
                String id = request.getParameter("id");
                String title = request.getParameter("title");
                String imageUrl = request.getParameter("imageUrl");
                String price = request.getParameter("price");
                String type = request.getParameter("type");
                String quantity = request.getParameter("quantity");
                String size = request.getParameter("size");
                String publisherName = request.getParameter("publisherName");
                String publisherAddress = request.getParameter("publisherAddress");
                String authorName = request.getParameter("authorName");
                String authorBiography = request.getParameter("authorBiography");
                String authorNation = request.getParameter("authorNation");
                String description = request.getParameter("description");
                // validate input
                if (title.isEmpty() || imageUrl.isEmpty() || price.isEmpty() ||
                        type.isEmpty() || quantity.isEmpty() || size.isEmpty() || publisherName.isEmpty() ||
                        authorName.isEmpty() || description.isEmpty()) {
                    request.setAttribute("messageResponse", "Bạn cần nhập đầy đủ thông tin");
                    request.setAttribute("alert", "danger");
                } else {
                    ItemBook itemBook = new ItemBook();
                    itemBook.setImageUrl(imageUrl);
                    itemBook.setPrice(Float.parseFloat(price));
                    Book book = new Book();
                    book.setTitle(title);
                    book.setType(type);
                    book.setQuantity(Integer.parseInt(quantity));
                    book.setSize(size);
                    Publisher publisher = new Publisher();
                    publisher.setName(publisherName);
                    publisher.setAddress(publisherAddress);
                    book.setPublisher(publisher);
                    Author author = new Author();
                    author.setName(authorName);
                    author.setBiography(authorBiography);
                    author.setNation(authorNation);
                    book.setAuthor(author);
                    book.setDescription(description);
                    itemBook.setBook(book);
                    // update product if find id
                    if (!id.isEmpty() && id != null) {
                        itemBook.setId(Integer.parseInt(id));
                        itemBook = itemBookService.update(itemBook);
                        request.setAttribute("messageResponse", "Cập nhật sản phẩm thành công");
                        request.setAttribute("alert", "success");
                    }
                    //create product if not find id
                    else {
                        itemBook = itemBookService.save(itemBook);
                        request.setAttribute("messageResponse", "Thêm sản phẩm thành công");
                        request.setAttribute("alert", "success");
                        request.setAttribute("id", itemBook.getId());
                    }
                    request.setAttribute("itemBook", itemBook);
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
                itemBookService.delete(ids);
                String view = "views/admin/book/list-book.jsp";
                request.setAttribute("messageResponse", "Xoá thành công");
                request.setAttribute("alert", "success");

                int totalItem = itemBookService.getTotalItem();

                // number of item in a page
                int maxPageItem = 6;
                int totalPage = (int) Math.ceil((double) totalItem / maxPageItem);
                int currentPage = 1;

                if (request.getParameter("currentPage") != null) {
                    currentPage = Integer.parseInt(request.getParameter("currentPage"));
                }

                int offset = (currentPage - 1) * maxPageItem;

                List<ItemBook> itemBookList = itemBookService.findAll(maxPageItem, offset);

                request.setAttribute("itemBookList", itemBookList);
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
