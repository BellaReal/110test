package main.java.client.GUI.MainMenu;

import javafx.scene.layout.*;

class RecipeList extends VBox {

  public RecipeList() {
    this.setSpacing(5); // sets spacing between tasks
    this.setPrefSize(500, 560);
    this.setStyle("-fx-background-color: #F0F8FF;");
  }

  public void updateTaskIndices() {
    int index = 1;
    for (int i = 0; i < this.getChildren().size(); i++) {
      if (this.getChildren().get(i) instanceof Recipe) {
        ((Recipe) this.getChildren().get(i)).setTaskIndex(index);
        index++;
      }
    }
  }

  public void deleteRecipe(Recipe recipe) {
    this.getChildren().removeIf(curr -> curr.equals(recipe));
    this.updateTaskIndices();
  }
}
