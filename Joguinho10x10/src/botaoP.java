import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class botaoP {
	
	public JButton bt = new JButton("");
	int prioridade = 0;
	ArrayList<JButton> listaVisinhos = new ArrayList<JButton>();
	static Border bordaCurta = new LineBorder(Color.BLACK, 1);
	
	public botaoP(){
		
		this.bt.setFont(new Font("Arial", Font.BOLD, 15));
		this.bt.setBorder(bordaCurta);
		
	}
	
}
