package abraham.hernandez.constantes;

public enum ValorCasilla {
	VACIO(2), CRUZ(3), CIRCULO(5);
	private int val;

	ValorCasilla(int s) {
		this.val = s;
	}

	public int getVal() {
		return val;
	}
}