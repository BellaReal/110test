package main.java.client;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import main.java.client.GUI.DeleteConfirm;
import main.java.client.GUI.EditRecipeScreen;
import main.java.client.GUI.MainMenu.MainMenu;
import main.java.client.GUI.RecipeScreen.RecipeScreen;
import main.java.client.GUI.RecordScreen.RecordIngredientScreen;
import main.java.client.GUI.RecordScreen.RecordMealScreen;

public class View {

  HashMap<String, BorderPane> scenes;
  Scene scene;

  public View() {
    scenes = new HashMap<>();
    scenes.put("main", new MainMenu(this));
    scenes.put(
      "recordMeal",
      new RecordMealScreen(this, "Record the Meal Type for the recipe:")
    );
    scenes.put(
      "recordMealError",
      new RecordMealScreen(this, "Please repeat Meal Type:")
    );
    scenes.put("recipe", new RecipeScreen(this));
    scenes.put("recordBF", new RecordIngredientScreen(this, "breakfast"));
    scenes.put("recordLN", new RecordIngredientScreen(this, "lunch"));
    scenes.put("recordDR", new RecordIngredientScreen(this, "dinner"));
    scenes.put("edit", new EditRecipeScreen());
    scenes.put("delete", new DeleteConfirm());

    scene = new Scene(scenes.get("main"), 500, 600);
  }

  public BorderPane getRoot(String key) {
    return scenes.get(key);
  }

  public void setRoot(String key) {
    scene.setRoot(scenes.get(key));
  }

  public Scene getScene() {
    return scene;
  }
}
