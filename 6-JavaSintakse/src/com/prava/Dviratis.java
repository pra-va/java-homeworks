package com.prava;


/**
 * 
 * Klasė, skirta parodyti objekto ir klasės kintamuosius.
 * Objekto kintamasis - kintamasis, sukuriamas ir panaikinamas
 * kartu su objektu. Klasės kintamasis - statinis kintamasis,
 * gyvuojantis visą programos gyvavimo laikotarpį.
 * 
 * @author pra-va
 *
 */
public class Dviratis {
	
	/**
	 * Yra du kintamieji: klasės (static) ir objekto.
	 */
	private String modelis = null;
	private static int visoPagamintaDviraciu = 0;
	private static final int PAVARU_SKAICIUS = 12;
	
	/**
	 * Konstruktorius sukuria dviračio objektą ir automatiškai
	 * padidina dviračio identifikacinį numerį.
	 */
	public Dviratis(String modelis) {
		this.modelis = modelis;
		this.visoPagamintaDviraciu++;
	}
	
	public String getModelis () {
		return this.modelis;
	}
	
	public int getPagaminta () {
		return this.visoPagamintaDviraciu;
	}
	
	public int getPavaruSkaicius () {
		return this.PAVARU_SKAICIUS;
	}
}
