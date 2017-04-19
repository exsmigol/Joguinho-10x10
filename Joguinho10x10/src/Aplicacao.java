import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class Aplicacao{
	
	static ArrayList<botaoP> listaBotaoP = new ArrayList<botaoP>();
	static JFrame tela = new JFrame("Joguinho 10x10. Jogo iniciado.");
	static int jogada = 0;
	static int ultimoJogado;
	static JButton btNovo = new JButton("Novo");
	static Border bordaCurta = new LineBorder(Color.BLACK, 1);
	static Border bordaLonga = new LineBorder(Color.BLACK, 3);
	
	public static void main(String[] args) {
				
		tela.setBounds(100, 100, 770, 850);
		tela.setLayout( null );
		
		alimentaListaBotaoP();
		defineVizinhos();
		
		btNovo.setBounds(30, 730, 130, 60);
		btNovo.setEnabled(false);
		ALbotao novo = new ALbotao(-1);
		btNovo.addActionListener(novo);
		tela.getContentPane().add(btNovo);
		
		tela.setVisible(true);
		
	}
	
	public static void novoJogo(){
		
		jogada = 0;
		btNovo.setEnabled(false);
		tela.setTitle("Joguinho 10x10. Jogo iniciado.");
		
		for (int i = 0; i<100; i++){
			
			Aplicacao.listaBotaoP.get(i).bt.setText("");
			Aplicacao.listaBotaoP.get(i).bt.setEnabled(true);
			Aplicacao.listaBotaoP.get(ultimoJogado).bt.setBorder(bordaCurta);
						
		}
		
	}
	
	public static void aplicaJogada(int numBotao){
		
		boolean continua = false;
		
		if (jogada == 0){
			
			for (int i = 0; i < 100; i++){
				
				listaBotaoP.get(i).bt.setEnabled(false);
				
			}
			
			for (int i = 0; i < listaBotaoP.get(numBotao).listaVisinhos.size(); i++){
				
				listaBotaoP.get(numBotao).listaVisinhos.get(i).setEnabled(true);
				
			}
			
			listaBotaoP.get(numBotao).bt.setText(Integer.toString(jogada+1));
			ultimoJogado = numBotao;
			listaBotaoP.get(ultimoJogado).bt.setBorder(bordaLonga);
			jogada++;
			continua = true;
			btNovo.setEnabled(true);
			
		}else{
			
			for (int i = 0; i < 100; i++){
				
				listaBotaoP.get(i).bt.setEnabled(false);
				
			}
			
			for (int i = 0; i < listaBotaoP.get(numBotao).listaVisinhos.size(); i++){
				
				if ( listaBotaoP.get(numBotao).listaVisinhos.get(i).getText() == "" ){
					
					listaBotaoP.get(numBotao).listaVisinhos.get(i).setEnabled(true);
					continua = true;
					
				}
				
			}
			
			listaBotaoP.get(numBotao).bt.setText(Integer.toString(jogada+1));
			listaBotaoP.get(ultimoJogado).bt.setBorder(bordaCurta);
			ultimoJogado = numBotao;
			listaBotaoP.get(ultimoJogado).bt.setBorder(bordaLonga);
			jogada++;
			
		}
		
		tela.setTitle("Joguinho 10x10. Jogadas: "+jogada+".");
		
		if (continua == false){
			
			if (jogada == 100){
				
				JOptionPane.showMessageDialog(null,"Parabéns! Você venceu!");
				
			}else{
				
				JOptionPane.showMessageDialog(null,"Você perdeu!");
				
			}
			
		}			
		
	}
	
	private static void defineVizinhos() {
		
		for (int botao = 0; botao<100; botao++){
			
			//horizontal
			
			if ( (botao%10) != 7 && (botao%10 != 8) && (botao%10 != 9) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao+3).bt);
			if ( (botao%10) != 0 && (botao%10 != 1) && (botao%10 != 2) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao-3).bt);
			if (botao > 29) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao-30).bt);
			if (botao < 70) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao+30).bt);
			
			//diagonal
			
			if ( (botao%10) != 0 && (botao%10 != 1) && (botao > 21) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao-22).bt);
			if ( (botao%10) != 0 && (botao%10 != 1) && (botao < 80) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao+18).bt);
			if ( (botao%10) != 9 && (botao%10 != 8) && (botao > 19) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao-18).bt);
			if ( (botao%10) != 9 && (botao%10 != 8) && (botao < 78) ) listaBotaoP.get(botao).listaVisinhos.add(listaBotaoP.get(botao+22).bt);
			
		}
				
	}

	public static void alimentaListaBotaoP(){
		
		int botaoX = 30,botaoY = 30;
		
		for (int numBotao = 0; numBotao<100; numBotao++){
			
			botaoP bt = new botaoP();
			ALbotao cliqueBotao = new ALbotao(numBotao);
			bt.bt.addActionListener(cliqueBotao);
			bt.bt.setBounds(botaoX, botaoY, 60, 60);
			listaBotaoP.add(bt);
			tela.getContentPane().add(bt.bt);
			
			botaoX = botaoX + 70;
			
			if (botaoX > 660){
				
				botaoX = 30;
				botaoY = botaoY + 70;
				
			}
			
		}
		
	}

}
