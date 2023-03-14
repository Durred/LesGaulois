package personnages;

public class Musee {
	Trophee[] trophees = new Trophee[100];
	private int nbTrophee = 0;

	public Trophee[] getTrophees() {
		return trophees;
	}

	public void setTrophees(Trophee[] trophees) {
		this.trophees = trophees;
	}

	public int getNbTrophee() {
		return nbTrophee;
	}

	public void setNbTrophee(int nbTrophee) {
		this.nbTrophee = nbTrophee;
	}


	public void donnerTrophees(Gaulois gaulois) {
		gaulois.faireUneDonnation(this);
	}
	
	public String extraireInstructionsCaml() {
		String texte = "";
		for(int i = 0; i < nbTrophee; i++)
		{
			texte += trophees[i].donnerNom() + " : " + trophees[i].getEquipement() + ";\n"  ;
		}
		
		return texte;
	}
}
