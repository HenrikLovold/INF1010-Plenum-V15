
abstract class Transportmiddel {
	protected String tmid;
	protected double vekt;
	protected double maksfart;
	
	public Transportmiddel(String tmid, int vekt, int maksfart) {
		this.tmid = tmid;
		this.vekt = vekt;
		this.maksfart = maksfart;
	}
	
	public Transportmiddel(String tmid) {
		this.tmid = tmid;
	}
	
	public boolean equals(Transportmiddel t) {
		return this.tmid == t.hentTmid();
	}

	public String hentTmid() {
		return tmid;
	}
	
	public double hentVekt() {
		return vekt;
	}
	
	public double hentMaksfart() {
		return maksfart;
	}
	
	public void settVekt(double d) {
		this.vekt = d;
	}
}

abstract class SkinneTmdl extends Transportmiddel {
	
	int antallVogner;
	
	
	public SkinneTmdl(Vogn v1, Vogn v2) {
		super(v1.hentVognId() + v2.hentVognId());
		this.antallVogner = 2;
		super.settVekt(v1.hentVekt() + v2.hentVekt());
	}

	public SkinneTmdl(Vogn v1, Vogn v2, Vogn v3) {
		super(v1.hentVognId() + v2.hentVognId() + v3.hentVognId());
		this.antallVogner = 3;
		super.settVekt(v1.hentVekt() + v2.hentVekt() + v3.hentVekt());
	}

	public SkinneTmdl(Vogn v1, Vogn v2, Vogn v3, Vogn v4, Vogn v5,
			Vogn v6) {

		super(v1.hentVognId() + v2.hentVognId() + v3.hentVognId()
				+ v4.hentVognId() + v5.hentVognId() + v6.hentVognId());
		this.antallVogner = 6;
		super.settVekt(v1.hentVekt() + v2.hentVekt() + v3.hentVekt()
				+ v4.hentVekt() + v5.hentVekt() + v6.hentVekt());
	}
	
}

abstract class VannTmdl extends Transportmiddel {
	public VannTmdl(String tmid) {
		super(tmid);
	}
}

abstract class VeiTmdl extends Transportmiddel {
	public VeiTmdl(String tmid) {
		super(tmid);
	}
	
}

class Trikk extends SkinneTmdl {
	
	public Trikk(Vogn v1, Vogn v2) {
		super(v1, v2);
	}
	
	public Trikk(Vogn v1, Vogn v2, Vogn v3) {
		super(v1, v2, v3);
	}
	
	public double maksfart() {
		double fradrag = (vekt - 8) / 1000;
		return 50 - fradrag;
	}
	
}

class Tbanetog extends SkinneTmdl {
	
	public Tbanetog(Vogn v1, Vogn v2, Vogn v3) {
		super(v1, v2, v3);
	}
	
	public Tbanetog(Vogn v1, Vogn v2, Vogn v3, Vogn v4, Vogn v5, Vogn v6) {
		super(v1, v2, v3, v4, v5, v6);
	}
	
	public double maksfart() {
		return 55;
	}
	
}

class CharterTrikk extends Trikk implements Chartres {
	
	private String parkert;

	public CharterTrikk(Vogn v1, Vogn v2) {
		super(v1, v2);
	}
	
	public CharterTrikk(Vogn v1, Vogn v2, Vogn v3) {
		super(v1, v2, v3);
	}

	public String parkert() {
		return parkert;
	}
	
}

class CharterTbane extends Tbanetog implements Chartres {
	
	private String parkert;
	
	public CharterTbane(Vogn v1, Vogn v2, Vogn v3) {
		super(v1, v2, v3);
	}

	public CharterTbane(Vogn v1, Vogn v2, Vogn v3, Vogn v4, Vogn v5, Vogn v6) {
		super(v1, v2, v3, v4, v5, v6);
	}

	public String parkert() {
		return parkert;
	}
	
}

interface Chartres {
	String parkert();
}

class Vogn {
	private String vognId;
	private double vekt;

	public Vogn(String vognId, double vekt) {
		this.vognId = vognId;
		this.vekt = vekt;
	}

	public String hentVognId() {
		return vognId;
	}

	public double hentVekt() {
		return vekt;
	}
}
