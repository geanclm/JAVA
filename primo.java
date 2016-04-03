// Teste de tempo e limites do numero primo
// gean carlos
// 12-12-2006
// melhoramentos e novos estudos do codigo: 21/02/2016
// apt-get install openjdk-8-jdk
// GitHub em 03/04/2016
import javax.swing.*;
class primo {
	public static void main (String args []){
			long z=0,n,i,c,resto,Tempo;
			// teste com variavel long de intervalo -9223372036854775808 a 9223372036854775807			
			n=Long.parseLong(JOptionPane.showInputDialog("Digite um numero \n ou zero para sair: "));
			Tempo=-System.currentTimeMillis(); // inicio do cronometro			
			while(n!=0){
				c=resto=0;
				for(i=2;i<n;i++){					
					resto=n-((n/i)*i); //alternativa para resto=n%i;
						if(resto==0){
							c++;
							System.out.println("------------------------------");
							System.out.println("O numero " +(n)+ " nao eh primo");
							System.out.println(n+"/"+i+" = "+(n/2));
							System.out.println("------------------------------");
							z=i;
							i=n;	// detalhe decisivo na velocidade do codigo!
						}

				}				
				if(c==0 && n!=1){
					Tempo+=System.currentTimeMillis(); // final do cronometro			
					if((Tempo/1000.0)<=60){
						JOptionPane.showMessageDialog(null,"o numero "+n+" eh primo!"+
						"\nTempo de Processamento: "+(Tempo/1000.0)+" segundo(s)\n\n");
					}
					if(((Tempo/1000.0)>60)&&((Tempo/1000.0)<=3600)){
						JOptionPane.showMessageDialog(null,"o numero "+n+" eh primo!"+					
						"\nTempo de Processamento: "+(Tempo/60000.0)+" minuto(s)\n\n");						
					}
					if((Tempo/1000.0)>3600){
						JOptionPane.showMessageDialog(null,"o numero "+n+" eh primo!"+					
						"\nTempo de Processamento: "+(Tempo/3600000.0)+" hora(s)\n\n");					
					}					
				}
				else {
					Tempo+=System.currentTimeMillis(); // final do cronometro
					if((Tempo/1000.0)<=60){											
						JOptionPane.showMessageDialog(null,"o numero "+n+" nao eh primo!"+

						"\n"+n+" / "+z+" = "+(n/2)+
		
						"\nTempo de Processamento: "+(Tempo/1000.0)+" segundos\n\n");
					}					
					if(((Tempo/1000.0)>60)&&((Tempo/1000.0)<=3600)){
						JOptionPane.showMessageDialog(null,"o numero "+n+" nao eh primo!"+								"\nTempo de Processamento: "+(Tempo/60000.0)+" minuto(s)\n\n");						
					}
					if((Tempo/1000.0)>3600){
						JOptionPane.showMessageDialog(null,"o numero "+n+" nao eh primo!"+		
						"\nTempo de Processamento: "+(Tempo/3600000.0)+" hora(s)\n\n");					
					}					
				}				
				n=Long.parseLong(JOptionPane.showInputDialog("Digite um numero \n ou zero para sair: "));
				Tempo=-System.currentTimeMillis(); // inicio do cronometro
			}
			System.exit(0);				
	}
}
