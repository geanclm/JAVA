/* 	Determinante nxn ordem
 	18 de setembro de 2006
	by gean carlos
	segunda fase ciencia da computacao	
	11-12-2006 - alguns ajustes		*/	
// GitHub em 03/04/2016
import javax.swing.*;
public class determinante{
	public static void main(String[] a){	// programa principal  	
	  	String cabecalho,cabecalhob;  	
		int g=0,l=0,c=0,i=0,j=0,k=0,escolha=0,contalinha;
		float aux=0,det=1,x=0,A[][]=new float[10][10];
		boolean chave,somal,somac;
		while(true) { // menu de escolha
			try {
				escolha=Integer.parseInt(JOptionPane.showInputDialog(null,"1 - digitar a matriz A \n"+
				"2 - imprime a matriz A na tela \n"+"3 - determinante da matriz A \n"+	
				"4 - sair","Digite uma opcao",JOptionPane.QUESTION_MESSAGE));
						contalinha=1;
						cabecalhob="";
						cabecalho="";					
						switch(escolha){
							case 1: // digitar uma matriz A
								l=Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de linhas")); 	// quant de linha
								c=Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de colunas"));	// quant de colunas
								for(i=0;i<l;i++){
									for(j=0;j<c;j++){
										A[i][j]=Float.parseFloat(JOptionPane.showInputDialog("Digite o valor da matriz A para a linha "+(i+1)+" e coluna "+(j+1)));	// informa os valores para linha e coluna
									}
								}
								break;				
							case 2: //imprime a matriz A na tela
								System.out.println("\nMatriz A "+l+"x"+c);
								System.out.println("------------");
								for(i=0;i<c;i++){
									cabecalho=cabecalho+"\t"+(i+1);
								}
								System.out.println("li\\co"+cabecalho);					
								for(i=0;i<l;i++){
									String dados="";
									for(j=0;j<c;j++){
										dados=dados+"\t"+A[i][j];
									}
									System.out.println(contalinha+dados);
									contalinha=contalinha+1;
								}
								break;
							case 3:	// metodo da triangulacao
								chave=false;					
								det=1;					
								for(i=0;i<l;i++){ // verifica se existe alguma linha ou coluna zerada, se existir o determinante sera igual a zero
									somal=false;
									somac=false;
									for(j=0;j<c;j++){							
										if(A[i][j]!=0){	// verifica cada numero de cada linha com valor diferente de zero
											somal=true;
										}
										if(A[j][i]!=0){	// verifica cada coluna
											somac=true;
										}															
									}
									if((somac==false)||(somal==false)){
										i=l;							
										chave=true;
									}
								}					
								if(chave==true){
									System.out.println("\n\nse voce zerar uma linha \nou coluna, o determinante da matriz A "+c+"x"+c+" \nsera igual a zero. :-)"); // imprime o valor final igual a zero
								}					
									else{
										i=j=0;
										if(A[i][j]==0){ // trocando a primeira linha com A[i][j]==0							
											for(k=0;k<l;k++){							
												if(A[k][j]!=0){							
													for(g=0;g<l;g++){
														aux=A[k][g];
														A[k][g]=A[i][g];
														A[i][g]=aux;							
													}
													k=l;
													det=det*(-1);
												}																
											}								
										}
										if(l!=c){
											System.out.println("\n\na matriz nao e quadrada, \nse quiser calcular \no determinante, \npor favor, informe uma matriz quadrada nxn. :-)");
										}								
										if(l==c){						
											System.out.println("\n\nok! MATRIZ QUADRADA, \nsegue abaixo o valor do determinante:\n");							
											for(i=0;i<c;i++){ // inicia na primeira linha
												for(j=0;j<c;j++){ // percorre cada coluna da primeira linha									
													if(j<i){ // triangulo inferior principal
														if(A[i][j]!=0){ // verifica se o valor eh diferente de zero											
															x=A[i][j]/A[0+j][j]; // guarda o valor que deve ser zerado											
															for(g=0;g<c;g++){	// percorre toda a linha do numero
																A[i][g]=A[i][g]+(A[0+j][g]*x*(-1)); // zera o primeiro numero encontrado e substitui os demais da mesma linha
															}											
														}
													}
												}
											}
											for(i=0;i<l;i++){							
												for(j=0;j<c;j++){
													if(i==j){
														det=det*A[i][j];
													}								
												}
											}
											if(det==-0){
												det=det*(-1);
											}
											System.out.println("determinante de A "+l+"x"+c+": "+det); // imprime o valor final
										}
									}						
								break;					
							case 4: // sai do sistema
								System.exit(1);
								break;								
							default:
								JOptionPane.showMessageDialog(null,"Digite uma das opcoes do menu","ADVERTENCIA!", JOptionPane.QUESTION_MESSAGE);														
								break;
			  			}
			}catch (Exception e){
				JOptionPane.showMessageDialog(null,"voce deve digitar uma opcao do menu (1...4)\npor favor, faca sua escolha. :-)\n");
			}					
		}  			
	}	
}
