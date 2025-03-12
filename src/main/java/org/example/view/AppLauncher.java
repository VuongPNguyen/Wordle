package org.example.view;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.controller.Controller;
import org.example.controller.ControllerImpl;
import org.example.model.Wordle;
import org.example.model.WordleImpl;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    Wordle wordle = new WordleImpl("test");
    Controller controller = new ControllerImpl(wordle);

  }
}
