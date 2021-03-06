<%-- 
    Document   : Cart
    Created on : Oct 31, 2020, 9:42:21 PM
    Author     : trinh
--%>


<%@page import="java.util.Map"%>
<%@page import="entity.Product"%>
<%@page import="java.util.TreeMap"%>
<%@page import="entity.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>

    <body>
     <jsp:include page="Menu.jsp"></jsp:include>
    <%
    Cart cart = (Cart)session.getAttribute("cart");
    if(cart == null){
    	cart = new Cart();
    	session.setAttribute("cart", cart);
    }
    TreeMap<Product,Integer> list = cart.getList();
    %>
      
        <div class="shopping-cart">
            <div class="px-4 px-lg-0">

                <div class="pb-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                <!-- Shopping cart table -->
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Số Lượng</div>
                                                </th>
                                                <th scope="col" class="border-0 bg-light">
                                                    <div class="py-2 text-uppercase">Thanh toán</div>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                       <% for(Map.Entry<Product,Integer> ds : list.entrySet()){
                                       %>
                                            
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="<%=ds.getKey().getImage() %>" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block"><%=ds.getKey().getName() %></a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong><%=ds.getKey().getPrice() %></strong></td>
                                                    <td class="align-middle">
                                                        <a href="CartControl?command=sub&maSanPham=<%=ds.getKey().getId()%>&cartID=<%=System.currentTimeMillis() %>">
                                                        <button class="btnSub">-</button></a> 
                                                        <strong><%=ds.getValue()%></strong>
                                                        <a href="CartControl?command=plus&maSanPham=<%=ds.getKey().getId()%>&cartID=<%=System.currentTimeMillis() %>"><button class="btnAdd">+</button></a>
                                                    </td>
                                                    
                                                        <td class="cart_total">
                                                        <p class="cart_total_price"><%=ds.getValue()*ds.getKey().getPrice() %>
                                                           
                                                    
                                                    </td>
                                                </tr> 
                                         
                                        <%} %>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                           
               
                                    <ul class="list-unstyled mb-4">
                                       
                                    
                                    </ul><a href="DatHang.jsp" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                                </div>
                            </div>
                        </div>
 
                    </div>
                </div>
         
      
</body>
</html>

