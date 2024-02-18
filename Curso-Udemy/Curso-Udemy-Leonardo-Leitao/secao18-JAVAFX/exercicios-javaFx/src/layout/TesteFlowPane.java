package layout;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;

public class TesteFlowPane extends FlowPane {

	public TesteFlowPane() {
		
		Quadrado q1 = new Quadrado();
		Quadrado q2 = new Quadrado();
		Quadrado q3 = new Quadrado();
		Quadrado q4 = new Quadrado();
		Quadrado q5 = new Quadrado();
		
		setHgap(10); // espaço que vc quer eixo horizontal dos elementos
		setVgap(10); // espaçamento que vc quer no eixo vertical entre os elementos
		setPadding(new Insets(10)); // É a mesma lógica do padding que temos em css.
		
		setOrientation(Orientation.VERTICAL); // Vamos conseguir posicionar os elementos no eixo vertical
		setAlignment(Pos.CENTER_RIGHT); // O mesmo que Alignment do css
		
		getChildren().addAll(q1, q2, q3, q4, q5);
	}
}
