import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALbotao implements ActionListener {
	
	int numBotao;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (numBotao == -1){
			
			Aplicacao.novoJogo();
			
		}else{
			
			Aplicacao.aplicaJogada(this.numBotao);
			
		}
		
	}

	public void setNumBotao(int numBotao) {
		this.numBotao = numBotao;
	}
	
	ALbotao(int numBotao){
		
		this.numBotao = numBotao;
		
	}	

}
