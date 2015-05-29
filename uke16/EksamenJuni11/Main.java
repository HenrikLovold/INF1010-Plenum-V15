import java.util.Collection;
import java.util.Iterator;

class EksamensHash<E> implements Collection<E>{
	
	private int lengde;
	
	Object[] hashTabell;

	private int antall;

	EksamensHash(int lengde) {
		this.lengde = lengde;
		hashTabell = new Object[lengde];
	}
	
	class Node {
		E objekt;
		Node neste;
		
		public Node(E objekt) {
			this.objekt = objekt;
		}

		public boolean add(E o) {
			if (neste == null) {
				neste = new Node(o);
				antall++;
				return true;
			} else {
				return neste.add(o);
			}
		}

		public boolean contains(Object o) {
			if (o.equals(objekt)) {
				return true;
			} else if (neste == null) {
				return false;
			} else {
				return neste.contains(o);
			}
		}

		public boolean remove(Object o) {
			if (neste == null) {
				return false;
			} else if (neste.objekt.equals(o)) {
				neste = neste.neste;
				antall--;
				return true;
			} else {
				return neste.remove(o);
			}
		}
		
	}

	@Override
	public boolean add(E objekt) {
		if (objekt == null) {
			throw new NullPointerException();
		} else {
			int hashVerdi = objekt.hashCode();
			hashVerdi = Math.abs(hashVerdi) % lengde;
			if (hashTabell[hashVerdi] == null) {
				hashTabell[hashVerdi] = new Node(objekt);
				antall++;
				return true;
			} return ((Node)hashTabell[hashVerdi]).add(objekt);
		}
	}
	
	public Iterator<E> minIterator() {
		return new MinIterator();
	}
	
	class MinIterator implements Iterator<E> {
		Node denne;
		int teller;
		int max;
		
		MinIterator() {
			denne = (Node)hashTabell[0];
			teller = 0;
			max = hashTabell.length - 1;
			while (denne == null && teller < max) {
				teller += 1;
				denne = (Node) hashTabell[teller];
			}
		}
		
		public boolean hasNext() {
			return denne != null;
		}
		
		public E next() {
			Node tmp = denne;
			denne = denne.neste;
			while (denne == null) {
				if (teller < max) {
					teller += 1;
					denne = (Node) hashTabell[teller];
				} else {
					break;
				}
			}
			return tmp.objekt;
		}
		
		
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		antall = 0;
		hashTabell = new Object[lengde];
		
	}

	@Override
	public boolean contains(Object objekt) {
		int hashVerdi = objekt.hashCode();
		hashVerdi = Math.abs(hashVerdi) % lengde;
		if (hashTabell[hashVerdi] == null) {
			return false;
		} else {
			return ((Node) hashTabell[hashVerdi]).contains(objekt);
		}
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return antall == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		int hashVerdi = o.hashCode();
		hashVerdi = Math.abs(hashVerdi) % lengde;
		if (hashTabell[hashVerdi] == null) {
			return false;
		} else if (((Node) hashTabell[hashVerdi]).objekt.equals(o)) {
			hashTabell[hashVerdi] = ((Node) hashTabell[hashVerdi]).neste;
			antall--;
			return true;
		} else {
			return ((Node) hashTabell[hashVerdi]).remove(o);
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return antall;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Test {
	
	public Test() {
		Vogn v1 = new Vogn("x12", 40000);
		Vogn v2 = new Vogn("z13", 40000);
		
		CharterTrikk ct1 = new CharterTrikk(v1, v2);
		
		Vogn v3 = new Vogn("t12", 60000);
		Vogn v4 = new Vogn("t23", 60000);
		Vogn v5 = new Vogn("t34", 60000);
		
		Tbanetog t1 = new Tbanetog(v3, v4, v5);
		
		EksamensHash<Transportmiddel> eh = new EksamensHash<Transportmiddel>(2);
		
		Object[] obj = {ct1, t1};
		
		leggInnIEH(obj, eh);
		
		skrivUtNoeInfo(eh);
	}
	
	EksamensHash<Transportmiddel> leggInnIEH(Object[] objektliste, EksamensHash<Transportmiddel> eh) {
		for(Object o : objektliste) {
			if(o instanceof Transportmiddel) {
				eh.add((Transportmiddel) o);
			}
		}
		
		return eh;
	}
	
	public void skrivUtNoeInfo(EksamensHash<Transportmiddel> eh) {
		for(Transportmiddel t : eh) {
			if(t instanceof VannTmdl) {
				System.out.println(t.hentTmid() + " " + t.hentVekt() + " " + t.hentMaksfart()*0.54);
			} else if(t instanceof Chartres) {
				System.out.println(t.tmid + " " + t.vekt + " " + t.maksfart + " " + ((Chartres)t).parkert());
			} else {
				System.out.println(t.tmid + " " + t.vekt + " " + t.maksfart);
			}
		}
	}
}




public class Main {
	
	public static void main(String[] args) {
		new Test();
	}
	
	
	
}


