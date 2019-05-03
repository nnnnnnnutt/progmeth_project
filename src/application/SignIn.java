package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignIn {
	private GridPane rootPane;
	Stage thisStage;
	public void setStage(Stage stage) {
		thisStage = stage;
	}
	public SignIn() {
		rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("LOGO");
		rootPane.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		rootPane.add(userName, 0, 1);

		TextField userTextField = new TextField();
		rootPane.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		rootPane.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		rootPane.add(pwBox, 1, 2);

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		Button signinBtn = new Button("Sign in");
		signinBtn.setPrefWidth(65);
		Button signupBtn = new Button("Sign up");
		signupBtn.setPrefWidth(65);
		hbBtn.getChildren().addAll(signinBtn, signupBtn);
		rootPane.add(hbBtn, 1, 4);

		// set style
		rootPane.setStyle("-fx-background-color:MISTYROSE;");
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
				thisStage.getScene().setRoot(signup.getRootPane());
				//change to next scene -> sign up
			}
		});
		
		Scene scene = new Scene(rootPane, 700, 500);

		thisStage.setScene(scene);
		thisStage.setTitle("Hotel"); //app's name
		thisStage.show();
	}
	public Pane getRootPane() {
		return rootPane;
	}

}
