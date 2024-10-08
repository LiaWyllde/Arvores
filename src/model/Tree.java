package model;

public class Tree<T extends Comparable<T>> {
	
	private Node<T> raiz;
	private int qt;
	
	public Tree() {
		this.raiz = null;
	}
	
	public void chamaAdiciona(T e) {
		Node<T> no = new Node<T>(e);
		adicionar(no, raiz);
	}

	/*
	 * Essa função recursiva é acessada a partir de chamaAdiciona() e recebe
	 * inicialmente o noDois com o valor da raiz inicial da árvore. A primeira
	 * verificação é: a está vazia? se sim, o nó será adicionado ali e pronto.
	 * Do caso contrário, as verificações tratam as seguintes possibilidades: 
	 * 
	 * 1° - se o elemento do nó for >=, ele deve seguir pela direita
	 * 2° - se o elemento do nó for menor ele segue pela esquerda
	 * 
	 * A partir desse momento, o nó deve seguir pelo lado determinado 
	 * na comparação. Aí o próximo teste é: se a posição estiver vazia, 
	 * o nó é adicionado ali. No entanto, se não for o noDois recebe 
	 * o nó que ocupa aquela posição em relação a raiz e aí a recursiva
	 * é chamada outra vez, até que apareça um espaço vazio disponível.
	 * 
	 */
	
	private void adicionar(Node<T> no, Node<T> noDois) {
		if (this.raiz == null) {
			this.raiz = no;
		} else {
			if (no.getElem().compareTo(noDois.getElem()) >= 0) {
				//no é maior que a raiz q tenho
				if (noDois.getDireita() != null) {
					noDois = noDois.getDireita();
					adicionar(no, noDois);
				} else {
					noDois.setDireita(no);
					++qt;
				}
			} else {
				//não faz sentido tratar o 0 e -1 pq os dois vão pra esquerda
				if (noDois.getEsquerda() != null) {
					noDois = noDois.getEsquerda();
					adicionar(no, noDois);
				} else {
					noDois.setEsquerda(no);
					++qt; 
				}
			}
		}
	}
	
	public void chamaOrdem() {
		System.out.println("\nOrdem: ");
		ordem(raiz);
		System.out.println("\nPosOrdem:");
		posOrdem(raiz);
		System.out.println("\nPreOrdem: ");
		preOrdem(raiz);
	}
	
	private void ordem(Node<T> no) {
		if (no != null) {
			ordem(no.getEsquerda());
			System.out.print(no.getElem() + " ");
			ordem(no.getDireita());
		}
	}
	
	private void preOrdem(Node<T> no) {
		if (no != null) {
			System.out.print(no.getElem() + " ");
			preOrdem(no.getEsquerda());
			preOrdem(no.getDireita());
		}
	}
	
	private void posOrdem(Node<T> no) {
		if (no != null) {
			posOrdem(no.getEsquerda());
			posOrdem(no.getDireita());
			System.out.print(no.getElem() + " ");
		}
	}
	
	 @Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder(" ");
		 toStringHelper(raiz, sb);
		 return sb.toString();
	 }

	 private void toStringHelper(Node<T> node, StringBuilder sb) {
		 if (node != null) {
			 sb.append(node.getElem()).append(" ");
			 toStringHelper(node.getEsquerda(), sb);
			 toStringHelper(node.getDireita(), sb);
		 }
	 }
}
