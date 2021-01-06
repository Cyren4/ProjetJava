package Start;

/**
* Exception levé par les fonctions s'occupant de la configuration en cas d'erreur
*/
public class TropDErreurException extends Exception {
	public TropDErreurException(String s) {
		super(s);
	}
}