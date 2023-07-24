/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T14
 */
public class MainController extends HttpServlet {

    private final static String ERROR = "error.jsp";
    private final static String WELCOME = "login.jsp";
    
    private final static String LOGIN = "Login";
    private final static String LOGIN_CONTROLLER = "LoginController";
    private final static String SEARCH = "Search";
    private final static String SEARCH_CONTROLLER = "SearchController";
    private final static String LOGOUT = "Logout";
    private final static String LOGOUT_CONTROLLER = "LogoutController";
    private final static String DELETE = "Delete";
    private final static String DELETE_CONTROLLER = "DeleteController";
    private final static String UPDATE = "Update";
    private final static String UPDATE_CONTROLLER = "UpdateController";
    private final static String CREATE = "Create";
    private final static String CREATE_CONTROLLER = "CreateController";
    private final static String GET_ALL = "Get all";
    private final static String GET_ALL_CONTROLLER = "GetAllController";
    private final static String ADD = "Add";
    private final static String ADD_CONTROLLER = "AddController";
    private final static String VIEW_CART = "View cart";
    private final static String VIEW_CART_PAGE = "viewCart.jsp";
    private final static String EDIT_CART = "Edit";
    private final static String EDIT_CONTROLLER = "EditController";
    private final static String REMOVE = "Remove";
    private final static String REMOVE_CONTROLLER = "RemoveController";
    private final static String SHOW_TOP = "Show";
    private final static String SHOW_TOP_CONTROLLER = "ShowTopController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        
        try{
            String action = request.getParameter("action");
            if(action == null){
                url = WELCOME;
            }else if (LOGIN.equals(action)){
                url = LOGIN_CONTROLLER;
            }else if (SEARCH.equals(action)){
                url = SEARCH_CONTROLLER;
            }else if (LOGOUT.equals(action)){
                url = LOGOUT_CONTROLLER;
            }else if (DELETE.equals(action)){
                url = DELETE_CONTROLLER;
            }else if (UPDATE.equals(action)){
                url = UPDATE_CONTROLLER;
            }else if (CREATE.equals(action)){
                url = CREATE_CONTROLLER;
            }else if (GET_ALL.equals(action)){
                url = GET_ALL_CONTROLLER;
            }else if (ADD.equals(action)){
                url = ADD_CONTROLLER;
            }else if (VIEW_CART.equals(action)){
                url = VIEW_CART_PAGE;
            }else if (EDIT_CART.equals(action)){
                url = EDIT_CONTROLLER;
            }else if (REMOVE.equals(action)){
                url = REMOVE_CONTROLLER;
            }else if (SHOW_TOP.equals(action)){
                url = SHOW_TOP_CONTROLLER;
            }
        }catch(Exception e){
            log("Error at MainController: "+ e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
