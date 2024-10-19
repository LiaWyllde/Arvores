package view;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		Tree<Integer> arvore = new Tree<Integer>();
		
		arvore.chamaAdiciona(200);
		arvore.chamaAdiciona(150);
		arvore.chamaAdiciona(130);
		arvore.chamaAdiciona(180);
		arvore.chamaAdiciona(310);
		arvore.chamaAdiciona(170);
		arvore.chamaAdiciona(220);
		arvore.chamaAdiciona(210);
		arvore.chamaAdiciona(320);
		arvore.chamaAdiciona(100);
		arvore.chamaAdiciona(240);
		arvore.chamaAdiciona(320);
		arvore.chamaAdiciona(90);
		arvore.chamaAdiciona(110);
		arvore.chamaAdiciona(160);
		arvore.chamaAdiciona(111);
	
//		System.out.println("- - - - - - - - - - - - - - - - ");
//		
//		System.out.println(arvore.toString());
//		
//		System.out.println("- - - - - - - - - - - - - - - - ");
		
		arvore.chamaOrdem();
		
		//System.out.println(arvore.toString()+"\n");
		
		//System.out.println("- - - - - - - - - - - - - - - - ");
		
		System.out.print("Raiz: ");
		arvore.showRaiz();
		System.out.println("\n");
		
		arvore.remove(200, arvore.getRaiz());
		
		System.out.println("\nRemovido");
		arvore.chamaOrdem();
		
		//System.out.println(arvore.toString());
	}
}
