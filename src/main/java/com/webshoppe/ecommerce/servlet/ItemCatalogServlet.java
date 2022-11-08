package com.webshoppe.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webshoppe.ecommerce.entity.Book;
import com.webshoppe.ecommerce.entity.Flower;
import com.webshoppe.ecommerce.entity.Toy;
import com.webshoppe.ecommerce.jdbc.JdbcConnectionManager;
import com.webshoppe.ecommerce.repository.BookRepository;
import com.webshoppe.ecommerce.repository.FlowerRepository;
import com.webshoppe.ecommerce.repository.ToyRepository;
import com.webshoppe.ecommerce.service.BookCatalogService;
import com.webshoppe.ecommerce.service.FlowerCatalogService;
import com.webshoppe.ecommerce.service.ToyCatalogService;

public class ItemCatalogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ToyCatalogService toyCatalogService;
    private FlowerCatalogService flowerCatalogService;
    private BookCatalogService bookCatalogService;

    @Override
    public void init() throws ServletException {
        final JdbcConnectionManager jdbcConnectionManager = new JdbcConnectionManager();
        final ToyRepository toyRepository = new ToyRepository(jdbcConnectionManager);
        final FlowerRepository flowerRepository = new FlowerRepository(jdbcConnectionManager);
        final BookRepository bookRepository = new BookRepository(jdbcConnectionManager);
        toyCatalogService = new ToyCatalogService(toyRepository);
        flowerCatalogService = new FlowerCatalogService(flowerRepository);
        bookCatalogService = new BookCatalogService(bookRepository);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String itemCategory = request.getParameter("name").toString();
        final StringBuilder stringBuilder = new StringBuilder();
        
        switch (itemCategory) {
            case "toys":
                final List<Toy> toys = toyCatalogService.getToyCatalog();
                
                if (toys.isEmpty()) {
                    stringBuilder.append("<b>Toy Catalog Empty</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    toys.forEach(e -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(e.getId()).append("</td>");
                        stringBuilder.append("<td>").append(e.getName()).append("</td>");
                        stringBuilder.append("<td>").append(e.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(e.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
                
            case "flowers":
                final List<Flower> flowers = flowerCatalogService.getFlowerCatalog();
                if (flowers.isEmpty()) {
                    stringBuilder.append("<b>Cannot find flowers that met the price range.</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    flowers.forEach(f -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(f.getId()).append("</td>");
                        stringBuilder.append("<td>").append(f.getName()).append("</td>");
                        stringBuilder.append("<td>").append(f.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(f.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
                
            case "books":
                final List<Book> books = bookCatalogService.getBookCatalog();
                if (books.isEmpty()) {
                    stringBuilder.append("<b>Cannot find books that met the price range.</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    books.forEach(b -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(b.getId()).append("</td>");
                        stringBuilder.append("<td>").append(b.getName()).append("</td>");
                        stringBuilder.append("<td>").append(b.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(b.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
        }

        PrintWriter out = response.getWriter();
        out.println(stringBuilder.toString());
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        final String minimumPriceParam = request.getParameter("minimum-price");
        final BigDecimal minimumPrice = new BigDecimal(minimumPriceParam);

        final String maximumPriceParam = request.getParameter("maximum-price");
        final BigDecimal maximumPrice = new BigDecimal(maximumPriceParam);

        final StringBuilder stringBuilder = new StringBuilder();
        final String itemCategory = request.getParameter("itemCategory");
        switch (itemCategory) {
            case "toys":
                final List<Toy> toys = toyCatalogService.getToyCatalog(minimumPrice, maximumPrice);
                if (toys.isEmpty()) {
                    stringBuilder.append("<b>Cannot find toys that met the price range.</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    toys.forEach(e -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(e.getId()).append("</td>");
                        stringBuilder.append("<td>").append(e.getName()).append("</td>");
                        stringBuilder.append("<td>").append(e.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(e.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
            case "flowers":
                final List<Flower> flowers = flowerCatalogService.getFlowerCatalog(minimumPrice, maximumPrice);
                if (flowers.isEmpty()) {
                    stringBuilder.append("<b>Cannot find flowers that met the price range.</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    flowers.forEach(f -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(f.getId()).append("</td>");
                        stringBuilder.append("<td>").append(f.getName()).append("</td>");
                        stringBuilder.append("<td>").append(f.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(f.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
            case "books":
                final List<Book> books = bookCatalogService.getBookCatalog(minimumPrice, maximumPrice);
                if (books.isEmpty()) {
                    stringBuilder.append("<b>Cannot find books that met the price range.</b>");
                } else {
                    stringBuilder.append("<table class='table'>");
                    stringBuilder.append("<thead>");
                    stringBuilder.append("<th scope='col'>ID</th>");
                    stringBuilder.append("<th scope='col'>Name</th>");
                    stringBuilder.append("<th scope='col'>Description</th>");
                    stringBuilder.append("<th scope='col'>Price</th>");
                    stringBuilder.append("</thead>");
                    books.forEach(b -> {
                        stringBuilder.append("<tr scope='row'>");
                        stringBuilder.append("<td>").append(b.getId()).append("</td>");
                        stringBuilder.append("<td>").append(b.getName()).append("</td>");
                        stringBuilder.append("<td>").append(b.getDescription()).append("</td>");
                        stringBuilder.append("<td>").append(b.getPrice()).append("</td>");
                        stringBuilder.append("</tr>");
                    });
                    stringBuilder.append("</table>");
                }
                break;
        }

        PrintWriter out = response.getWriter();
        out.println(stringBuilder.toString());
        out.flush();
        out.close();
    }

}
