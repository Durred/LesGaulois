package personnages;

public class Romain 
{
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];
	
	public Romain(String nom, int force)
	{	
		if(force <= 0)
		{
			System.out.println("Force négative");
			assert(false);
		}
		
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getNbEquipement() {
		return nbEquipement;
	}

	public void setNbEquipement(int nbEquipement) {
		this.nbEquipement = nbEquipement;
	}

	public Equipement[] getEquipements() {
		return equipements;
	}

	public void setEquipements(Equipement[] equipements) {
		this.equipements = equipements;
	}
	
	public String getNom() 
	{
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	public String prendreParole() 
	{
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) 
//	{
//		int forceDebut = force;
//		//Pré-condition
//		assert(force>=0);
//		
//		force -= forceCoup;
//		
//		//Post-condition
//		assert(forceDebut<force);
//		
//		if(force > 0) 
//		{
//			parler("Aïe");
//		}
//		else
//		{
//			parler("J'abandonne...");
//		}
//	}
	
	public void sEquiper(Equipement equipement) {
		String texte = "Le soldat : ";
		switch(this.nbEquipement) {
		case 2 :
		
			System.out.println( texte + this.getNom() + " est déjà bien protégé !");
			break;
		
		case 1 :
		
			if(equipement == this.equipements[0]) 
			{
				System.out.println(texte + this.getNom() + " possède déjà un " + equipement.getNom());
			}
		
			else
			{
				this.equipements[1] = equipement;
				System.out.println(texte + this.getNom() + " s'équipe avec "+ equipement.getNom());
				nbEquipement++;
			}
			break;
		
		
		default :
		
			this.equipements[0] = equipement;
			System.out.println(texte + this.getNom() + " s'équipe avec "+ equipement.getNom());
			nbEquipement++;
			break;
		}
	
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		 if (force > 0) {
			 parler("Aïe");
		 } 
		 else {
			 equipementEjecte = ejecterEquipement();
			 parler("J'abandonne...");
		 }
		 
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) {
			 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			 for (int i = 0; i < nbEquipement; i++) {
				 if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					 resistanceEquipement += 8;
				 } 
				 else {
					 System.out.println("Equipement casque");
					 resistanceEquipement += 5;
				 }

			 	}
			 texte += resistanceEquipement + "!";
			}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup < 0)
		{
			return 0;
		}
		else
		{
			return forceCoup;
		}
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] =
				equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			} 
		}
		return equipementEjecte;
	}

	public static void main(String[] args) 
	{
		Romain romain = new Romain("Romain", 1);
		Romain minus = new Romain("Minus", 6);
		romain.prendreParole();
		romain.parler("Truc");
		romain.recevoirCoup(4);
		
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
	}
}
