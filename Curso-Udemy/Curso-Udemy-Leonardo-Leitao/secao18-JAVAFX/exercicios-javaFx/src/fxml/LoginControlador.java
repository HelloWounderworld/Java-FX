package fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {

	@FXML // - Estou dizendo que ele pertence ao arquivo fxml
	private TextField campoEmail;
	
	@FXML
	private PasswordField campoSenha;
	
	public void entrar() {
		boolean emailValido = campoEmail.getText().equals("student@mathcoder.com.jp");
		boolean senhaValida = campoSenha.getText().equals("zfc++");
//		System.out.println("Entrar...");
//		System.out.println(campoEmail);
//		System.out.println(campoEmail.getText());
//		System.out.println(campoSenha);
//		System.out.println(campoSenha.getText());
		
		if(emailValido && senhaValida) {
//			System.out.println("Sucesso");
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.title("Login FXML")
				.text("Login efetuado com sucesso!")
				.showInformation();
		} else {
//			System.out.println("Falhou");
			Notifications.create()
				.position(Pos.TOP_RIGHT)
				.title("Login FXML")
				.text("Usuario ou senha inválido!")
				.showError();
		}
	}
}
