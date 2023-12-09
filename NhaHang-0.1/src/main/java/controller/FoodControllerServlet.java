package controller;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.bean.Food;
import model.bo.FoodBO;

@WebServlet("/FoodControllerServlet")
public class FoodControllerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String action = request.getParameter("action");

        if (action == null) {
            action = "list_food"; 
        }

        switch (action) {
            case "list_food":
                listFood(request, response);
                break;
            case "add_food":
                showAddForm(request, response);
                break;
            case "select_food_del":
                showDelList(request, response);
                break;
            case "select_food_upd":
                showUpdList(request, response);
                break;
            case "search_food_list":
                listSearchFood(request, response);
                break;
            case "index":
                return_index(request, response);
                break;
                
            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }


    private void listFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FoodBO foodBO = new FoodBO();
        List<Food> foodList = foodBO.getListFood();

        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list_food.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add_food.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showDelList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	FoodBO foodBO = new FoodBO();
        List<Food> foodList = foodBO.getListFood();

        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("delete_food.jsp");
        dispatcher.forward(request, response);
    }

    private void showUpdList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	FoodBO foodBO = new FoodBO();
        List<Food> foodList = foodBO.getListFood();

        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_food.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listSearchFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	FoodBO foodBO = new FoodBO();
        List<Food> foodList = foodBO.getListFood();

        request.setAttribute("foodList", foodList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("search_food.jsp");
        dispatcher.forward(request, response);
    }
    
    private void return_index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        
        String action = request.getParameter("action");

        if ("insert_food".equals(action)) {
            addFood(request, response);
        }
        if ("delete_food".equals(action)) {
        	deleteFood(request, response);
        }
        if ("process_update1".equals(action)) {
        	selectUpdateFood(request, response);
        }
        if ("process_update2".equals(action)) {
        	updateFood(request, response);
        }
        if ("find_food".equals(action)) {
        	searchFood(request, response);
        }
    }
    
    private void addFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int foodID = Integer.parseInt(request.getParameter("foodID"));
        String foodName = request.getParameter("foodName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Food food = new Food();
        food.setFoodID(foodID);
        food.setFoodName(foodName);
        food.setPrice(price);
        food.setDescription(description);

        FoodBO foodBO = new FoodBO();
        foodBO.addFood(food);

        response.sendRedirect("FoodControllerServlet?action=list_food");
    }
    
    private void deleteFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] foodIDs = request.getParameterValues("foodIDs");
        FoodBO foodBO = new FoodBO();
        
        if (foodIDs != null) {
            for (String foodID : foodIDs) {
            	foodBO.deleteFood(Integer.parseInt(foodID));
            }
        }
            response.sendRedirect("FoodControllerServlet?action=list_food");
        
    }
    
    private void selectUpdateFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int selectedFoodID = Integer.parseInt(request.getParameter("selectedFoodID"));

    	FoodBO foodBO = new FoodBO();
        Food selectedFood = foodBO.getFoodByID(selectedFoodID);

        request.setAttribute("foodToUpdate", selectedFood); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("update_form_food.jsp");
        dispatcher.forward(request, response);
    }
    
    private void searchFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String foodName = request.getParameter("foodName");
        List<Food> foodList = null;
        
        if (foodName != null && !foodName.isEmpty()) {
        	FoodBO foodBO = new FoodBO();
            foodList = foodBO.getFoodByName(foodName);
        }
        
        request.setAttribute("foodList", foodList);
        request.getRequestDispatcher("search_food.jsp").forward(request, response);

    }
    
    private void updateFood(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int foodID = Integer.parseInt(request.getParameter("foodID"));
        String foodName = request.getParameter("foodName");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        Food updatedFood = new Food();
        updatedFood.setFoodID(foodID);
        updatedFood.setFoodName(foodName);
        updatedFood.setPrice(price);
        updatedFood.setDescription(description);

        FoodBO foodBO = new FoodBO();
        boolean isUpdated = foodBO.updateFood(updatedFood);

        if (isUpdated) {
            response.sendRedirect("FoodControllerServlet?action=list_food");
        } else {

            response.sendRedirect("error.jsp");
        }
    }
    
    
}
