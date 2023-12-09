package model.bo;

import java.util.ArrayList;
import java.util.List;
import model.bean.Food;
import model.dao.FoodDAO;

public class FoodBO {
    private FoodDAO foodDAO;

    public FoodBO() {
        foodDAO = new FoodDAO();
    }

    public ArrayList<Food> getListFood() {
        return foodDAO.getListFood();
    }

    public void addFood(Food food) {
        foodDAO.addFood(food);
    }

    public boolean deleteFood(int foodID) {
        return foodDAO.deleteFood(foodID);
    }

    public Food getFoodByID(int foodID) {
        return foodDAO.getFoodByID(foodID);
    }

    public boolean updateFood(Food food) {
        return foodDAO.updateFood(food);
    }

    public List<Food> getFoodByName(String foodName) {
        return foodDAO.getFoodByName(foodName);
    }
}
	