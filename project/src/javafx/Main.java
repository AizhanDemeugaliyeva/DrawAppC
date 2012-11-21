/* main.java
 * Aizhan Demeugaliyeva 
 */

package javafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*; 
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javax.imageio.ImageIO;
import javafx.stage.FileChooser;


public class Main extends Application {
    private String[] lines = new String[100];
    private BufferedReader reader0;
    int col = 0;

    @Override
    public void start(Stage primaryStage) {
        final StackPane root = new StackPane(); // border pane better 
        Group group = new Group();
        final TextArea text = new TextArea("Messages:");
        
        text.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 10px;");
        text.setEditable(false);
        text.addEventFilter(MouseEvent.ANY, new EventHandler<MouseEvent>() {
          @Override public void handle(MouseEvent t) { t.consume(); }
        });
        root.getChildren().add(text);
        
     //   final ImageView imageView = new ImageView(new Image("http://icons.iconarchive.com/icons/dapino/xmas-people/128/snowman-icon.png"));
        //new button for saving
        final Button saveButton = new Button("Save");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override public void handle(ActionEvent args0) {
            try {
              File output = new File("JavaFX.png"); // should be taken from the user 
              FileChooser fc = new FileChooser();
              output = fc.showSaveDialog(null);
              ImageIO.write(SwingFXUtils.fromFXImage(root.snapshot(null, null), null), "png", output);
              text.appendText("\nSaved: " + System.getProperty("user.dir") + File.separatorChar + output.getPath());
              
            } catch (IOException ex) {
              System.out.println("\nAh, the image saving failed, due to: " + ex);
             
            }
          }
        });
        // add button to close the window
        final Button close = new Button("Close");
        close.setOnAction(
                new EventHandler<ActionEvent>() {
                    public void handle( ActionEvent args1) {

                        Platform.exit();
                    }
                });
        // shows next picture 
        Button picture = new Button();
        picture.setText("Picture");
        picture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().clear();
                ImageView imageView = new ImageView(new Image("http://icons.iconarchive.com/icons/dapino/xmas-people/128/snowman-icon.png"));
                root.getChildren().add(imageView);
            }
        });
        // button for single stepping
        Button step = new Button();
         step.setText("Next");
        
        ImageFx image= new ImageFx(group, text);
        root.getChildren().add(group);
        Reader in = new InputStreamReader(System.in);
        final ParserFx parser = new ParserFx(in, image);
        step.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (parser.getAction() == 0)
                    text.appendText("\nNo more steps!");
                else
                    parser.parse();
            }
        });
       
        Region spring = new Region();
       VBox.setVgrow(spring, Priority.ALWAYS);
       primaryStage.setScene(
               new Scene(VBoxBuilder.create().spacing(2).children(
                            root,HBoxBuilder.create().spacing(5).children(
                            step, saveButton, picture, close).build(), text,
                     spring).style("-fx-padding: 10; -fx-background-color: white;").build()
                    ,800, 400 ));
       primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
