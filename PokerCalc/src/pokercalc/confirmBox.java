
package pokercalc;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class confirmBox {
    
    
    //creation of confirm box
    static boolean answer;
    
    public static boolean display(String title, String message){
        
        //creation of window, title, message
        
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setTitle(title);
        window.setWidth(350);
        Label label = new Label();
        label.setText(message);
        
        
        //creation of yes/no confirm buttons
        
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
        
    }
}
//        HBox topMenu = new HBox();
//        Button buttonA = new Button("File");
//        Button buttonB = new Button("Edit");
//        Button buttonC = new Button("View");
//        topMenu.getChildren().addAll(buttonA, buttonB, buttonC);
//        
//        VBox leftMenu = new VBox();
//        Button buttonD = new Button("D");
//        Button buttonE = new Button("E");
//        Button buttonF = new Button("F");
//        leftMenu.getChildren().addAll(buttonD, buttonE, buttonF);
//        
//        BorderPane borderPane = new BorderPane();
//        borderPane.setTop(topMenu);
//        borderPane.setLeft(leftMenu);
//        
//        
//        window.setOnCloseRequest( e-> {
//            e.consume();
//            closeProgram();
//        });
//        
//        Scene scene = new Scene(borderPane, 300, 250);
//        window.setScene(scene);
//        window.show();
        
//        //button 1
//        button1.setOnAction(e -> {
//            boolean result = confirmBox.display("Title of window", "Are you sure you want to send naked pics?");
//            System.out.println(result);
//        });
//        
//        //layout 1 - children are laid out in vertical column
//        VBox layout1 = new VBox(20);
//        layout1.getChildren().addAll(label1, button1);
//        scene1 = new Scene(layout1, 300, 250);
//        
//        //button 2 
//        Button button2 = new Button("This scene sucks, go back to scene 1");
//        button2.setOnAction(e -> window.setScene(scene1));
//        
//        //layout 2
//        StackPane layout2 = new StackPane();
//        layout2.getChildren().add(button2);
//        scene2 = new Scene(layout2, 600, 300);
        