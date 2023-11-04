package client;

import java.util.HashMap;

import client.GUI.DeleteConfirm;
import client.GUI.EditRecipeScreen;

import client.GUI.MainMenu.MainMenu;
import client.GUI.RecordScreen.RecordIngredientScreen;
import client.GUI.RecordScreen.RecordMealScreen;
import client.GUI.RecipeScreen.RecipeScreen;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class View {
    
    HashMap<String, BorderPane> scenes;
    Scene scene;

    public View(){
        scenes = new HashMap<>();
        scenes.put("main", new MainMenu(this));
        scenes.put("recordMeal", new RecordMealScreen(this, "Record the Meal Type for the recipe:"));
        scenes.put("recordMealError", new RecordMealScreen(this, "Please repeat Meal Type:"));
        scenes.put("recipe",new RecipeScreen(this));
        scenes.put("recordBF", new RecordIngredientScreen(this, "breakfast"));
        scenes.put("recordLN", new RecordIngredientScreen(this, "lunch"));
        scenes.put("recordDR", new RecordIngredientScreen(this, "dinner"));
        scenes.put("edit",new EditRecipeScreen());
        scenes.put("delete",new DeleteConfirm());

        scene = new Scene(scenes.get("main"), 500, 600);
    }

    public BorderPane getRoot(String key){
        return scenes.get(key);
    }

    public void setRoot(String key){
        scene.setRoot(scenes.get(key));
    }
    
    public Scene getScene(){
        return scene;
    }
}