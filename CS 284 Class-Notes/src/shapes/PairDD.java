package shapes;

public class PairDD {
	// data fields
	private double fst;
	private double snd;
	
	public PairDD(double fst, double snd) {
		super();
		this.fst = fst;
		this.snd = snd;
	}

	public double getFst() {
		return fst;
	}

	public void setFst(double fst) {
		this.fst = fst;
	}

	public double getSnd() {
		return snd;
	}

	public void setSnd(double snd) {
		this.snd = snd;
	}
	
	public String toString() {
		return "<"+fst+","+snd+">";
	}
}
