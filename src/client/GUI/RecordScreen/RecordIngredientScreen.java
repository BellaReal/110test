package client.GUI.RecordScreen;

import client.GUI.MainMenu.MainMenu;
import client.GUI.RecipeScreen.RecipeScreen;
import client.View;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RecordIngredientScreen extends BorderPane {

  private Header header;
  private Footer footer;
  private RecordIngredientPrompt recordPrompt;

  private Button createButton;

  public RecordIngredientScreen(View view, String meal) {
    header = new Header();
    recordPrompt = new RecordIngredientPrompt();
    footer = new Footer();

    // Add header to the top of the BorderPane
    this.setTop(header);
    // Add scroller to the centre of the BorderPane
    this.setCenter(recordPrompt);
    // Add footer to the bottom of the BorderPane
    this.setBottom(footer);

    createButton = footer.getCreateButton();
    createButton.setOnAction(e -> {
      String ingredients = "error";
      try {
        ingredients = Transcribe.transcribe();
        ((RecipeScreen) view.getRoot("recipe")).generateRecipe(meal, ingredients);
      } catch (Exception exception) {}
      view.setRoot("recipe");
    });
  }
}
