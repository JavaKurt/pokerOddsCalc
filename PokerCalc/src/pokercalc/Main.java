package pokercalc;

import java.util.regex.Pattern;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Kurtis
 */
public class Main extends Application {

    Stage window;
    Button button;
    ComboBox<String> comboBox;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //main javafx code in here
        window = primaryStage;
        window.setTitle("layout practice - JavaFX");

//------------- CREATION OF GRIDS FOR EACH PAGE -----------------------
        //creation of grid layout for login page
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Scene scene = new Scene(grid, 300, 200);

        //creation of grid layout for register page
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        Scene scene2 = new Scene(grid2, 300, 200);

        //creation of app main page 
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setVgap(8);
        grid3.setHgap(10);
        Scene scene3 = new Scene(grid3, 800, 600);

// ---------- LOGIN PAGE -------------------
        //Name label
        Label usernameLabel = new Label("Username: ");
        GridPane.setConstraints(usernameLabel, 0, 0);

        //username input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");
        // column, row
        GridPane.setConstraints(usernameInput, 1, 0);

        //Password label 
        Label passLabel = new Label("Password: ");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //login button
        Button loginButton = new Button("Log in  ");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> window.setScene(scene3));

        //Register button
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 3);
        registerButton.setOnAction(e -> window.setScene(scene2));

        //add everything to the grid
        grid.getChildren().addAll(usernameLabel, usernameInput, passLabel, passInput, loginButton, registerButton);

// ----------------- REGISTRATION PAGE ------------------------------------
        //Name label
        Label nameLabel = new Label("First name: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter your name");
        GridPane.setConstraints(nameInput, 1, 0);

        //Name label
        Label ageLabel = new Label("Age: ");
        GridPane.setConstraints(ageLabel, 0, 1);

        //Age
        TextField ageInput = new TextField();
        ageInput.setPromptText("Enter your age:");
        GridPane.setConstraints(ageInput, 1, 1);

        //Checkboxes
        CheckBox box1 = new CheckBox("Male");
        GridPane.setConstraints(box1, 0, 3);
        CheckBox box2 = new CheckBox("Female");
        GridPane.setConstraints(box2, 0, 4);

        //Register button
        Button confirmButton = new Button("Register");
        GridPane.setConstraints(confirmButton, 0, 5);
        confirmButton.setOnAction(e -> System.out.println("Thank you for signing up: " + nameInput + "."));

        //Back button
        Button backButton = new Button("Go back.");
        GridPane.setConstraints(backButton, 1, 5);
        backButton.setOnAction(e -> window.setScene(scene));

        grid2.getChildren().addAll(nameLabel, nameInput, ageLabel, ageInput, box1, box2, confirmButton, backButton);

// ------------- MAIN PAGE ----------------------
        //Title
        Label welcomeLabel = new Label("Welcome to KPokerHelp");
        GridPane.setConstraints(welcomeLabel, 0, 1);

        //User's choice
        Label userChoiceLabel = new Label("User's choice is...");
        GridPane.setConstraints(userChoiceLabel, 5, 2);

        //Combo box
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
        );
        comboBox.setPromptText("What is your card?");
        comboBox.setOnAction(e -> System.out.println("User has selected the card: " + comboBox.getValue()));
        GridPane.setConstraints(comboBox, 0, 2);

        //confirm button
        Button yesButton = new Button("Confirm card.");
        yesButton.setOnAction(e -> printCard());
        GridPane.setConstraints(yesButton, 0, 7);

        //Tree
        TreeItem<String> root, H, D, S, C;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //H
        H = makeBranch("H", root);
        makeBranch("A", H);
        makeBranch("2", H);
        makeBranch("3", H);
        makeBranch("4", H);
        makeBranch("5", H);
        makeBranch("6", H);
        makeBranch("7", H);
        makeBranch("8", H);
        makeBranch("9", H);
        makeBranch("10", H);
        makeBranch("J", H);
        makeBranch("Q", H);
        makeBranch("K", H);

        //D
        D = makeBranch("D", root);
        makeBranch("A", D);
        makeBranch("2", D);
        makeBranch("3", D);
        makeBranch("4", D);
        makeBranch("5", D);

        //S
        S = makeBranch("S", root);
        makeBranch("A", S);
        makeBranch("2", S);
        makeBranch("3", S);
        makeBranch("4", S);
        makeBranch("5", S);

        //C
        C = makeBranch("C", root);
        makeBranch("A", C);
        makeBranch("2", C);
        makeBranch("3", C);
        makeBranch("4", C);
        makeBranch("5", C);

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue != null) {
                System.out.println(newValue.getValue());
            }
        });

        GridPane.setConstraints(tree, 0, 5);
        //layout
        //layout.getChildren().add(tree);

        //Create branches
        grid3.getChildren().addAll(welcomeLabel, userChoiceLabel, comboBox, yesButton, tree);

// ----------------- EXTRAS ----------------------
        //Button
        button = new Button("Order Now!");
        button.setOnAction(e -> handleOptions(box1, box2));

        window.setScene(scene);
        window.show();

        //button event handlers
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
    }

    public void closeProgram() {
        Boolean answer = confirmBox.display("Title", "Are you sure you want to close the program?");
        if (answer) {
            window.close();
        }
    }

    private boolean isWord(String in) {
        return Pattern.matches("[a-zA-z]+", in);
    }

    //validation method for integers (numbers i.e. age, etc
    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error:" + message + " is not a number.");
            return false;
        }
    }

    private void handleOptions(CheckBox box1, CheckBox box2) {
        String message = "Users order:\n";
        if (box1.isSelected()) {
            message += "Bacon";
        }
        if (box2.isSelected()) {
            message += "Tuna";
        }

        System.out.println(message);
    }

    private void printCard() {
        System.out.println(comboBox.getValue());
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

}
