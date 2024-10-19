package model;

public class Tree<T extends Comparable<T>> {
	
	private Node<T> raiz;
	
	public Tree() {
		this.raiz = null;
	}
	
	public void chamaAdiciona(T e) {
		Node<T> no = new Node<T>(e);
		adicionar(no, raiz);
	}
	
	public Node<T> getRaiz(){
		return this.raiz;
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
			if (no.getElemento().compareTo(noDois.getElemento()) >= 0) {
				//no é maior que a raiz q tenho
				if (noDois.getDireita() != null) {
					noDois = noDois.getDireita();
					adicionar(no, noDois);
				} else {
					noDois.setDireita(no);
				}
			} else {
				//não faz sentido tratar o 0 e -1 pq os dois vão pra esquerda
				if (noDois.getEsquerda() != null) {
					noDois = noDois.getEsquerda();
					adicionar(no, noDois);
				} else { 
					noDois.setEsquerda(no);
				}
			}
		}
	}
	
	public void chamaOrdem() {
		//System.out.println("\nOrdem: ");
		//ordem(raiz);
		//System.out.println("\nPosOrdem:");
		//posOrdem(raiz);
		System.out.println("\nPreOrdem: ");
		preOrdem(raiz);
	}
	
	private void ordem(Node<T> no) {
		if (no != null) {
			ordem(no.getEsquerda());
			System.out.print(no.getElemento() + " ");
			ordem(no.getDireita());
		}
	}
	
	private void preOrdem(Node<T> no) {
		if (no != null) {
			System.out.print(no.getElemento() + " ");
			preOrdem(no.getEsquerda());
			preOrdem(no.getDireita());
		}
	}
	
	private void posOrdem(Node<T> no) {
		if (no != null) {
			posOrdem(no.getEsquerda());
			posOrdem(no.getDireita());
			System.out.print(no.getElemento() + " ");
		}
	}
	
	//Encontra o menor valor na árvore
	private Node<T> min(Node<T> no) {
		Node<T> min = no;
		while (min.getEsquerda() != null) {
			min = min.getEsquerda();
		}
		return min;
	}

	public Node<T> remove(T elemento, Node<T> raiz) {
	//1 vrifica se o nó é nulo
		
		if (raiz == null) {
			return raiz;
		}
		//se não achar o elemento, volta reconstruindo a árvore
		
		if (raiz.getElemento().compareTo(elemento) > 0) {
			//se o elemento da raiz for menor, esquerda
			raiz.setEsquerda(remove(elemento, raiz.getEsquerda()));
			//esse código reconstrói a árvore, o théo jurou
			
		} else if (raiz.getElemento().compareTo(elemento) < 0) {
			//se o elemento da raiz for maior, direita
			raiz.setDireita(remove(elemento, raiz.getDireita()));
			
		} else {
			
			//aqui a gente de fato mexe com o elemento
			
			if (raiz.getEsquerda() == null && raiz.getDireita() == null) {
				return null; //(if da visão transcedental)
				//se esse nó é uma folha, o nó anterior (pai) não aponta para nada
			} else if (raiz.getEsquerda() == null) {
				return raiz.getDireita();
				
				/*
				 * se o nó não é vazio dos dois lados e não tem nada na esquerda ele 
				 * possui algo na direita, por isso o retono direto
				 */
				
			} else if (raiz.getDireita() == null) {
				return raiz.getEsquerda(); 
				
				//mesma coisa aqui, mas para o outro lado
				
			} else {
				
				var substitute = this.min(raiz.getDireita());
				
				/*
				 * essa linha de cima é exatamente a mesma que essa aqui
				 * Node<T> sub = this.min(raiz.getDireita());
				 * var identifica o tipo de retorno da atribuição e define 
				 * o tipo que ela vai ter  apartir dali
				 */
				
				raiz.setElemento(substitute.getElemento());
				
				raiz.setDireita(remove(substitute.getElemento(), raiz.getDireita()));
			}
		} 
		return raiz;
	}
	
//	public void chamaRemove(T e) {
//		Node<T> no = new Node<T>(e);
//		if (no.getElemento().compareTo(this.raiz.getElemento()) == 0) {
//			
//		} else {
//			no = verifica(no, this.raiz);
//			if (no == null) {
//				System.out.println("\nO elemento não está na lista");
//			} else {
//				System.out.println("\nO elemento " + no.getElemento().toString() + " está na lista");
//				remove(no);
//			}
//		}
//	}
//	
//	 private void remove(Node<T> no) {
//			Node<T> paiDoNo = paiDoNo(no, this.raiz);
//			System.out.println("Pai: " + paiDoNo.getElemento().toString());
//			
//			if (no.getDireita() == null && no.getEsquerda() == null) {
//				if (no.getElemento().compareTo(paiDoNo.getElemento()) >= 0) {
//					paiDoNo.setDireita(null);
//				} else {
//					paiDoNo.setEsquerda(null);
//				}
//			} else if (no.getDireita() != null && no.getEsquerda() != null) {
//				
//			} else {
//				if (no.getDireita() != null) {
//					if (no.getElemento().compareTo(paiDoNo.getElemento()) >= 0) {
//						paiDoNo.setDireita(no.getDireita());
//					} else {
//						paiDoNo.setEsquerda(no.getEsquerda());
//					}
//				} else {
//					if (no.getElemento().compareTo(paiDoNo.getElemento()) >= 0) {
//						paiDoNo.setDireita(no.getDireita());
//					} else {
//						paiDoNo.setEsquerda(no.getEsquerda());
//					}
//				}
//			}
//	}
//	 
//	private Node<T> paiDoNo(Node<T> no, Node<T> paiDoNo) {
//		if (no.getElemento().compareTo(paiDoNo.getElemento()) >= 0) {
//			if (paiDoNo.getDireita() == no) {
//				return paiDoNo;
//			} else {
//				paiDoNo = paiDoNo.getDireita();
//				return paiDoNo(no, paiDoNo);
//			}
//		} else {
//			if (paiDoNo.getEsquerda() == no) {
//				return paiDoNo;
//			} else {
//				paiDoNo = paiDoNo.getEsquerda();
//				return paiDoNo(no, paiDoNo);
//			}
//		}
//		
//	}
//
//	private Node<T> verifica(Node<T> no, Node<T> noNaPosicao) {
//		if (no.getElemento().compareTo(noNaPosicao.getElemento()) >= 0) {
//			if (noNaPosicao.getDireita() == null) {
//				return null;
//			} else {
//				if (no.getElemento().compareTo(noNaPosicao.getDireita().getElemento()) == 0) {
//					return noNaPosicao.getDireita();
//				} else {
//					noNaPosicao = noNaPosicao.getDireita();
//					return verifica(no, noNaPosicao);
//				}
//			}
//		} else {
//			if (noNaPosicao.getEsquerda() == null) {
//				return null;
//			} else {
//				if (no.getElemento().compareTo(noNaPosicao.getEsquerda().getElemento()) == 0) {
//					return noNaPosicao.getEsquerda();
//				} else {
//					noNaPosicao = noNaPosicao.getEsquerda();
//					return verifica(no, noNaPosicao);
//				}
//			}
//		}
//	}

	@Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder(" ");
		 toStringHelper(raiz, sb);
		 return sb.toString();
	 }

	 private void toStringHelper(Node<T> node, StringBuilder sb) {
		 if (node != null) {
			 sb.append(node.getElemento()).append(" ");
			 toStringHelper(node.getEsquerda(), sb);
			 toStringHelper(node.getDireita(), sb);
		 }
	 }
	 
	 public void showRaiz() {
		System.out.println(this.raiz.getElemento().toString());
	}
	 
}
