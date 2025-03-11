package org.example.view;

import javafx.scene.Parent;

public interface FXComponent {
  enum RenderType {
    ALL
  }

  Parent render();

  Parent render(RenderType renderType);
}
