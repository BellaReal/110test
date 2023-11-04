package main.java.client.GUI.MainMenu;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;

public class Recipe extends HBox {

  private Label index;
  private Label recipeName;

  Recipe() {
    this.setPrefSize(500, 20); // sets size of task
    this.setStyle(
        "-fx-background-color: #DAE5EA; -fx-border-width: 0; -fx-font-weight: bold;"
      ); // sets background color of task

    index = new Label();
    index.setText(""); // create index label
    index.setPrefSize(40, 20); // set size of Index label
    index.setTextAlignment(TextAlignment.CENTER); // Set alignment of index label
    index.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the task
    this.getChildren().add(index); // add index label to task

    recipeName = new Label(); // create task name text field
    recipeName.setPrefSize(380, 20); // set size of text field
    recipeName.setStyle("-fx-background-color: #DAE5EA; -fx-border-width: 0;"); // set background color of texfield
    index.setTextAlignment(TextAlignment.LEFT); // set alignment of text field
    recipeName.setPadding(new Insets(10, 0, 10, 0)); // adds some padding to the text field
    this.getChildren().add(recipeName); // add textlabel to task
  }

  public void setTaskIndex(int num) {
    this.index.setText(num + ""); // num to String
    this.recipeName.setText("Task " + num);
  }

  public Label getRecipeName() {
    return this.recipeName;
  }
}
