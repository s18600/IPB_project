package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public static final ObservableList data =
            FXCollections.observableArrayList();
    Stage dashboardStage;
    Stage primaryStage;
    boolean isCashier;
    String name;

    @Override
    public void start(Stage ps) {
        primaryStage = ps;
        primaryStage.setTitle("Garden store app");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Email:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button logInBtn = new Button("Log in");
        Button signInBtn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(logInBtn);
        hbBtn.getChildren().add(signInBtn);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        logInBtn.setOnAction(e -> {
            String[] email = userTextField.getText().split("@");
            if (email[email.length - 1].equals("garden.com")) {
                name = email[0];
                cashierDashboard();
            } else {
                name = email[0];
                customerDashboard();
            }
        });

        signInBtn.setOnAction(event -> {
            signIn();
        });


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void cashierDashboard() {
        isCashier = true;
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  " + name);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Cashier account: " + name);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button logOut = new Button("Log out");
        Button ordersToAccept = new Button("Orders to accept");
        Button insertStationaryOrder = new Button("New stationary order");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(logOut, ordersToAccept, insertStationaryOrder);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        logOut.setOnAction(e -> {
            start(primaryStage);
        });

        insertStationaryOrder.setOnAction(event -> {
            newOrder();
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void customerDashboard() {
        isCashier = false;
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  " + name);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome " + name);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Button log_out = new Button("Log out");
        Button ordersToAccept = new Button("Check orders details");
        Button insertStationaryOrder = new Button("New order");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(log_out, ordersToAccept, insertStationaryOrder);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        log_out.setOnAction(e -> {
            start(primaryStage);
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void signIn() {
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome ");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Email:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Label pw2 = new Label("Confirme password:");
        grid.add(pw2, 0, 3);

        PasswordField pwBox2 = new PasswordField();
        grid.add(pwBox2, 1, 3);

        Button sign_in = new Button("Sign in");
        Button back = new Button("Back");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(back, sign_in);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        back.setOnAction(e -> {
            start(primaryStage);
        });

        sign_in.setOnAction(e -> {
            start(primaryStage);
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void newOrder() {
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        final ListView listView = new ListView(data);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        listView.setItems(data);

        grid.getChildren().add(listView);

        Label desc = new Label("Add positions:");
        grid.add(desc, 0, 1);

        TextField addText = new TextField();
        grid.add(addText, 0, 2);

        Button add = new Button("Add");
        grid.add(add, 0, 3);

        add.setOnAction(event -> {
            if (!addText.getText().isEmpty()) {
                data.add(addText.getText());
                addText.clear();
            }
        });

        Button submit = new Button("Submit");
        grid.add(submit, 1, 3);

        submit.setOnAction(event -> {
            if (isCashier) {
                cashierDashboard();
            }
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

}
