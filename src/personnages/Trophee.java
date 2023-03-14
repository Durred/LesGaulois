package personnages;

public class Trophee {
	Gaulois gaulois;
	Equipement equipement;
	
	public Trophee(Gaulois gaulois, Equipement equipement) {
		super();
		this.gaulois = gaulois;
		this.equipement = equipement;
	}

	public Gaulois getGaulois() {
		return gaulois;
	}

	public Equipement getEquipement() {
		return equipement;
	}
	
	public String donnerNom() {
		return this.gaulois.getNom();
	}
}
