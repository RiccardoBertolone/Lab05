package it.polito.tdp.anagrammi.model;

import java.util.*;

public class Model {
	
	List<String> soluzioni ; // elenco delle soluzioni
	Map<Character, Integer> lettere ; // elenco delle lettere utilizzabili
	
	public List<String> calcolaPermutazioni(String s) {
		soluzioni = new ArrayList<String>() ;
		lettere = new TreeMap<Character, Integer>() ;
		for (int i = 0; i<s.length(); i++) {
			lettere.put(s.charAt(i), punteggio(s.charAt(i), s)) ;
		}
		recursive("", s.length()) ;
		return soluzioni ;
	}

	private Integer punteggio(char charAt, String s) {
		int count = 0 ;
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(i)==charAt)
				count++ ;
		}
		return count ;
	}

	private void recursive(String parziale, int lunghezza) {
		if (parziale.length()==lunghezza) {
			soluzioni.add(parziale) ;
			System.out.println(parziale) ;
			return ;
		}
		for (Character c : lettere.keySet()) {
			parziale+=c.toString();
			if (isCorretta(parziale))
				recursive(parziale, lunghezza) ;
			StringBuilder sb = new StringBuilder(parziale) ;
			parziale=sb.deleteCharAt(parziale.length()-1).toString() ;
		}
	}

	public boolean isCorretta(String parziale) {
		boolean flag = true ;
		for (Character c : lettere.keySet())
			if (punteggio(c, parziale) > lettere.get(c))
				flag = false ;
		return flag;
	}

}
