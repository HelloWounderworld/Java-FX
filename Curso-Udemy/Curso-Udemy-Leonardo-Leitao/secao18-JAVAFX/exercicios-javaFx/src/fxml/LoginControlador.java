package fxml;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {

	@FXML // - Estou dizendo que ele pertence ao arquivo fxml
	private TextField campoEmail;
	
	@FXML
	private PasswordField campoSenha;
	
	public void entrar() {
		System.out.println("Entrar...");
		System.out.println(campoEmail);
		System.out.println(campoEmail.getText());
		System.out.println(campoSenha);
		System.out.println(campoSenha.getText());
	}
}
