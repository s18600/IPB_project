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
    public static final ObservableList orders =
            FXCollections.observableArrayList();
    public static final ObservableList acceptedOrders =
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
                if (email[0].contains(".gardener")) {
                    name = email[0];
                    gardenerDashboard();
                } else {
                    name = email[0];
                    cashierDashboard();
                }
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
        Button insertStationaryOrder = new Button("New stationary order");
        Button registerNewCustomer = new Button("Register new Customer");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(logOut, insertStationaryOrder, registerNewCustomer);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        logOut.setOnAction(e -> {
            isCashier = false;
            start(primaryStage);
        });

        insertStationaryOrder.setOnAction(event -> {
            newOrder();
        });

        registerNewCustomer.setOnAction(event -> {
            signIn();
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void gardenerDashboard() {
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
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(logOut, ordersToAccept);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        logOut.setOnAction(e -> {
            isCashier = false;
            start(primaryStage);
        });

        ordersToAccept.setOnAction(event -> {
            orders();
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
        Button checkOrdersDetails = new Button("Check orders details");
        Button newOrder = new Button("New order");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().addAll(log_out, checkOrdersDetails, newOrder);
        grid.add(hbBtn, 1, 4);


        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        log_out.setOnAction(e -> {
            start(primaryStage);
        });

        checkOrdersDetails.setOnAction(event -> {
            customerOrders();
        });

        newOrder.setOnAction(event -> {
            newOrder();
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
            if (isCashier) {
                cashierDashboard();
            } else {
                start(primaryStage);
            }
        });

        sign_in.setOnAction(e -> {
            if (isCashier) {
                cashierDashboard();
            } else {
                start(primaryStage);
            }
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

        Button back = new Button("Back");
        grid.add(back, 1, 4);

        back.setOnAction(e -> {
            data.clear();
            if (isCashier) {
                cashierDashboard();
            } else {
                customerDashboard();
            }
        });

        submit.setOnAction(event -> {
            if (isCashier) {
                data.add("\nStationary order: " + name);
            } else {
                data.add("\nCustomer name: " + name);
            }
            orders.add(listView.getItems().toString());
            data.clear();
            if (isCashier) {
                cashierDashboard();
            } else {
                customerDashboard();
            }
        });


        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void orders() {
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        final ListView listView = new ListView(orders);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        listView.setItems(orders);

        grid.getChildren().add(listView);

        Button accept = new Button("accept first order from the list");
        grid.add(accept, 0, 1);

        Button decline = new Button("decline first order from the list");
        grid.add(decline, 0, 2);

        accept.setOnAction(e -> {
            if (orders.size() > 0) {
                acceptedOrders.add(orders.get(0));
                orders.remove(0);
            }
        });

        decline.setOnAction(e -> {
            if (orders.size() > 0) {
                orders.remove(0);
            }
        });


        Button back = new Button("Back");
        grid.add(back, 1, 4);

        back.setOnAction(e -> {
            data.clear();
            gardenerDashboard();
        });

        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

    private void customerOrders() {
        dashboardStage = new Stage();
        dashboardStage.initOwner(primaryStage);
        dashboardStage.setTitle("Cashier id:  ");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        final ListView listView = new ListView(orders);
        listView.setPrefSize(200, 250);
        listView.setEditable(true);

        ObservableList cOrders = FXCollections.observableArrayList();

        acceptedOrders.forEach((order) -> {
            String[] o = order.toString().split(":");
            String[] o1 = o[o.length - 1].trim().split("]");
            if (o1[0].equals(name)) {
                cOrders.add(order);
            }
        });

        listView.setItems(cOrders);

        grid.getChildren().add(listView);


        Button back = new Button("Back");
        grid.add(back, 1, 4);
        grid.add(new Label("Accepted"), 1, 0);

        back.setOnAction(e -> {
            cOrders.clear();
            if (isCashier) {
                cashierDashboard();
            } else {
                customerDashboard();
            }
        });

        Scene scene = new Scene(grid, 600, 480);
        primaryStage.setScene(scene);
    }

}
