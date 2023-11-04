package main.java.client.GUI.RecordScreen;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.java.client.GUI.MainMenu.MainMenu;
import main.java.client.GUI.RecipeScreen.RecipeScreen;
import main.java.client.View;

public class RecordMealScreen extends BorderPane {

  private Header header;
  private Footer footer;
  private RecordMealPrompt recordPrompt;

  private Button createButton;

  public RecordMealScreen(View view, String str) {
    header = new Header();
    recordPrompt = new RecordMealPrompt(str);
    footer = new Footer();

    // Add header to the top of the BorderPane
    this.setTop(header);
    // Add scroller to the centre of the BorderPane
    this.setCenter(recordPrompt);
    // Add footer to the bottom of the BorderPane
    this.setBottom(footer);

    createButton = footer.getCreateButton();
    createButton.setOnAction(e -> {
      String mealType = "error";
      try {
        mealType = Transcribe.transcribe();
        String type = Transcribe.checkMealType(mealType);
        if (type == null) {
          view.setRoot("recordMealError");
        } else if (type.equals("breakfast")) {
          view.setRoot("recordBF");
        } else if (type.equals("lunch")) {
          view.setRoot("recordLN");
        } else if (type.equals("dinner")) {
          view.setRoot("recordDR");
        } else {
          view.setRoot("recordMealError");
        }
      } catch (Exception exception) {}
      //view.setRoot("recordMealError");
    });
  }
}
