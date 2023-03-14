package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois) {
		for(int i = 0; i < gaulois.getNbTrophees(); i++)
		{
			trophees[nbTrophee] = gaulois.faireUneDonnation();
			nbTrophee++;
		}
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
