package client.GUI.RecordScreen;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

class RecordIngredientPrompt extends VBox {

  private Label prompt;
  private Button startButton;
  private Button stopButton;
  // private AudioFormat audioFormat;
  private TargetDataLine targetDataLine;
  private Label recordingLabel;

  RecordIngredientPrompt() {
    this.setSpacing(5); // sets spacing between tasks
    this.setPrefSize(500, 560);
    this.setStyle("-fx-background-color: #F0F8FF;");

    prompt = new Label("Record the ingredients for the recipe:");

    prompt.setStyle(
      "-fx-border-width: 0; -fx-font-weight: bold; -fx-font-size: 24px"
    );
    startButton = new Button("Start");
    startButton.setFocusTraversable(false);
    stopButton = new Button("Stop");
    stopButton.setFocusTraversable(false);
    recordingLabel = new Label("Recording...");
    this.getChildren().add(prompt);
    HBox buttonBox = new HBox(8); // spacing = 8
    buttonBox.getChildren().addAll(startButton, stopButton);
    buttonBox.setAlignment(Pos.CENTER);
    this.getChildren().addAll(buttonBox, recordingLabel);
    recordingLabel.setVisible(false);
    this.setAlignment(Pos.TOP_CENTER);

    // Add the listeners to the buttons
    addListeners();
  }

  public void addListeners() {
    // Start Button
    startButton.setOnAction(e -> {
      startRecording();
    });

    // Stop Button
    stopButton.setOnAction(e -> {
      stopRecording();
    });
  }

  private void startRecording() {
    Thread t = new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            // Get the audio format
            AudioFormat audioFormat = new AudioFormat(
              44100,
              16,
              1,
              true,
              false
            );

            // the format of the TargetDataLine
            DataLine.Info dataLineInfo = new DataLine.Info(
              TargetDataLine.class,
              audioFormat
            );
            // the TargetDataLine used to capture audio data from the microphone
            targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
            targetDataLine.open(audioFormat);
            targetDataLine.start();
            recordingLabel.setVisible(true);

            // the AudioInputStream that will be used to write the audio data to a file
            AudioInputStream audioInputStream = new AudioInputStream(
              targetDataLine
            );

            // the file that will contain the audio data
            File audioFile = new File("ingredients.wav");
            audioFile.delete();

            AudioSystem.write(
              audioInputStream,
              AudioFileFormat.Type.WAVE,
              audioFile
            );
            recordingLabel.setVisible(false);
          } catch (Exception e1) {}
        }
      }
    );
    t.start();
  }

  private void stopRecording() {
    targetDataLine.stop();
    targetDataLine.close();
  }
}
