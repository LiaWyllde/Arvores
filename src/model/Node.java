package model;

public class Node<T extends Comparable<T>> {
	//Comparable é aplicado ao objeto porque algo precisa ser comparado
	
	private T elem;
	private Node<T> direita;
	private Node<T> esquerda;
	
	public Node(T e) {
		this.direita = this.esquerda = null;
		this.elem = e;
	}

	public T getElemento() {
		return elem;
	}

	public void setElemento(T elem) {
		this.elem = elem;
	}

	public Node<T> getDireita() {
		return direita;
	}

	public void setDireita(Node<T> direita) {
		this.direita = direita;
	}

	public Node<T> getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node<T> esquerda) {
		this.esquerda = esquerda;
	}

	@Override
	public String toString() {
		return elem.toString();
	}
}
