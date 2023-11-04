package client.GUI.RecipeScreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class Footer extends HBox {

    private Button editButton;
    private Button saveButton;
    private Button deleteButton;

    Footer() {
        this.setPrefSize(500, 60);
        this.setStyle("-fx-background-color: #F0F8FF;");
        this.setSpacing(15);

        // set a default style for buttons - background color, font size, italics
        String defaultButtonStyle = "-fx-font-style: italic; -fx-background-color: #FFFFFF;  -fx-font-weight: bold; -fx-font: 11 arial;";

        editButton = new Button("Edit"); // text displayed on edit button
        editButton.setStyle(defaultButtonStyle); // styling the button

        saveButton = new Button("Save"); // text displayed on save button
        saveButton.setStyle(defaultButtonStyle); // styling the button

        deleteButton = new Button("Delete"); // text displayed on delete button
        deleteButton.setStyle(defaultButtonStyle); // styling the button
        
        this.getChildren().addAll(editButton, saveButton, deleteButton); // adding buttons to footer
        this.setAlignment(Pos.CENTER); // aligning the buttons to center
    }

    public Button getEditButton() {
        return editButton;
    }
    
    public Button getSaveButton() {
        return saveButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }
}