package layout;

import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class TesteStackPane extends StackPane {

	public TesteStackPane() {
		
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		Caixa c5 = new Caixa().comTexto("5");
		Caixa c6 = new Caixa().comTexto("6");
		
		getChildren().addAll(c2, c3, c4, c5, c6, c1);
		
		setOnMouseClicked( e -> {
//			System.out.println("click");
			if(e.getSceneX() > getScene().getWidth() / 2) {
//				System.out.println("direito");
				getChildren().get(0).toFront();
			} else {
//				System.out.println("esquerdo");
				getChildren().get(5).toBack();
			}
		});
		
		Thread t = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(3000);
					
					Platform.runLater(() -> {
						getChildren().get(0).toFront();
					});
					
//					getChildren().get(0).toFront(); // Esse trecho que está dando o problema do "Not on FX application thread"
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
//					System.out.println(e.getMessage());
				}
			}
		});
		
		t.setDaemon(true); // Irá parar de mostrar "Not on FX Application" no console, depois que fechar a modal
		t.start();
	}
}
