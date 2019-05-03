package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class welcome extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("LOGO");
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		Button signinBtn = new Button("Sign in");
		signinBtn.setPrefWidth(65);
		Button signupBtn = new Button("Sign up");
		signupBtn.setPrefWidth(65);
		hbBtn.getChildren().addAll(signinBtn, signupBtn);
		grid.add(hbBtn, 1, 4);

		// set style
		grid.setStyle("-fx-background-color:MISTYROSE;");
		scenetitle.setStyle("-fx-font-size: 32px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");
		signinBtn.setStyle(
				"-fx-text-fill: black; -fx-font-weight: bold; -fx-font-family: \"Arial Narrow\"; -fx-background-color: LEMONCHIFFON;");
		signupBtn.setStyle(
				"-fx-text-fill: black; -fx-font-weight: bold; -fx-font-family: \"Arial Narrow\"; -fx-background-color: LEMONCHIFFON;");

		// add handler
		// press ESC to clear user text field
		userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					userTextField.setText("");
				}
			}
		});
		// change button width when mouse over
		signinBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signinBtn.setPrefWidth(75);
			}
		});
		signinBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signinBtn.setPrefWidth(65);
			}
		});
		signupBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signupBtn.setPrefWidth(75);
			}
		});
		signupBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				signupBtn.setPrefWidth(65);
			}
		});
		// action when click button
		signinBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Welcome Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Welcome, "+userTextField.getText()+". Your Password is "+pwBox.getText()+".");
				alert.showAndWait();
				
				//change to next scene
			}
		});
		signupBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				signUp signup = new signUp();
				primaryStage.getScene().setRoot(signup.getRootPane());
				//change to next scene -> sign up
			}
		});

		Scene scene = new Scene(grid, 700, 500);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Hotel"); //app's name
		primaryStage.show();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}