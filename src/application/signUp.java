package application;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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

public class signUp{
	private final GridPane rootPane;
	Stage thisStage;
	public void setStage(Stage stage) {
		thisStage = stage;
	}
	public void showStage() {
		thisStage.setTitle("Hotel");
		thisStage.show();
	}
	public signUp() {
		
		rootPane = new GridPane();
		rootPane.setAlignment(Pos.CENTER);
		rootPane.setHgap(10);
		rootPane.setVgap(10);
		rootPane.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Create your account");
		rootPane.add(scenetitle, 0, 0, 2, 1);

		Label name = new Label("Name:");
		rootPane.add(name, 0, 1);

		TextField nameTextField = new TextField();
		rootPane.add(nameTextField, 1, 1);

		Label surname = new Label("Surname:");
		rootPane.add(surname, 0, 2);

		TextField surnameTextField = new TextField();
		rootPane.add(surnameTextField, 1, 2);
		
		Label gender = new Label("Gender: ");
		rootPane.add(gender, 0, 3);
		
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Male",
			        "Female"
			    );
		ComboBox<String> genderlist = new ComboBox<>(options);
		genderlist.setValue("---");
		rootPane.add(genderlist, 1, 3);
		
		Label phone = new Label("Phone number: ");
		rootPane.add(phone, 0, 4);
		
		TextField phoneTextfield = new TextField();
		rootPane.add(phoneTextfield, 1, 4);
		
		Label email = new Label("E-mail address: ");
		rootPane.add(email, 0, 5);
		
		TextField emailTextfield = new TextField();
		rootPane.add(emailTextfield, 1, 5);
		
		Label bday = new Label("Birthday: ");
		rootPane.add(bday, 0, 6);
		
		DatePicker bdate = new DatePicker();
		rootPane.add(bdate, 1, 6);
		
		Label userName = new Label("User Name:");
		rootPane.add(userName, 0, 7);

		TextField userTextField = new TextField();
		rootPane.add(userTextField, 1, 7);

		Label pw = new Label("Password:");
		rootPane.add(pw, 0, 8);

		PasswordField pwBox = new PasswordField();
		rootPane.add(pwBox, 1, 8);
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		Button okBtn = new Button("Sign Up");
		okBtn.setPrefWidth(75);
		hbBtn.getChildren().addAll(okBtn);
		rootPane.add(hbBtn, 1, 10);

		// set style
		rootPane.setStyle("-fx-background-color:MISTYROSE;");
		scenetitle.setStyle("-fx-font-size: 32px; -fx-font-family:\"Arial Black\";-fx-fill: #555;");

		// add handler
		// press ESC to clear user text field
		nameTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					nameTextField.setText("");
				}
			}
		});
		
		surnameTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					surnameTextField.setText("");
				}
			}
		});
		
		phoneTextfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					phoneTextfield.setText("");
				}
			}
		});
		
		userTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					userTextField.setText("");
				}
			}
		});
		
		emailTextfield.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					emailTextfield.setText("");
				}
			}
		});
		
		pwBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode() == KeyCode.ESCAPE) {
					pwBox.setText("");
				}
			}
		});
		
		// change button width when mouse over
		okBtn.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				okBtn.setPrefWidth(85);
			}
		});
		okBtn.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				okBtn.setPrefWidth(75);
			}
		});
		
		// action when click button
		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText("Look, a Confirmation Dialog");
				alert.setContentText("Are you ok with this?");

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
				    // ... user chose OK -> change to sign in scene
					SignIn signIn = new SignIn();
					thisStage.getScene().setRoot(signIn.getRootPane());
					thisStage.show();
				} else {
				    // ... user chose CANCEL or closed the dialog
				}
				
				//change to next scene
			}
		});
		
	}
	public Pane getRootPane() {
		return rootPane;
	}

}



