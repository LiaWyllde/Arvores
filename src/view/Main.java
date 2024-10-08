package view;

import model.*;

public class Main {

	public static void main(String[] args) {
		
		Tree<Integer> arvore = new Tree<Integer>();
		
		arvore.chamaAdiciona(20);
		arvore.chamaAdiciona(15);
		arvore.chamaAdiciona(13);
		arvore.chamaAdiciona(18);
		arvore.chamaAdiciona(31);
		arvore.chamaAdiciona(17);
		arvore.chamaAdiciona(22);
		arvore.chamaAdiciona(21);
		arvore.chamaAdiciona(30); 
		arvore.chamaAdiciona(1);
	
		System.out.println("- - - - - - - - - - - - - - - - ");
		
		System.out.println(arvore.toString());
		
		System.out.println("- - - - - - - - - - - - - - - - ");
		
		arvore.chamaOrdem();
		
		
	}
}
