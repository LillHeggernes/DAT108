package no.hvl.dat108;

public class PersonSemaphore {

	private StringBuffer navn;
	private StringBuffer[] tabNavn = new StringBuffer[4];
	private int i = 0;

	public PersonSemaphore() {
		StringBuffer navn1 = new StringBuffer("Nils");
		StringBuffer navn2 = new StringBuffer("Kari");
		StringBuffer navn3 = new StringBuffer("Ole");
		StringBuffer navn4 = new StringBuffer("Anne");
		tabNavn[0] = navn1;
		tabNavn[1] = navn2;
		tabNavn[2] = navn3;
		tabNavn[3] = navn4;
	}

	public void setNavn() {
		navn = tabNavn[i];
		i++;
		i = i % 4;
	}

	public StringBuffer getNavn() {
		return navn;
	}

}
