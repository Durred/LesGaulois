package personnages;

public class Romain 
{
	private String nom;
	private int force, nbEquipement = 0;
	private Equipement[] equipements = new Equipement[1];
	
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
	
	public String getNom() 
	{
		return nom;
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	public String prendreParole() 
	{
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) 
	{
		int forceDebut = force;
		//Pré-condition
		assert(force>=0);
		
		force -= forceCoup;
		
		//Post-condition
		assert(forceDebut<force);
		
		if(force > 0) 
		{
			parler("Aïe");
		}
		else
		{
			parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
		switch(this.nbEquipement) {
		case 2 :
		
			System.out.println("Le soldat : " + this.getNom() + " est déjà bien protégé !");
			break;
		
		case 1 :
		
			if(equipement == this.equipements[0]) 
			{
				System.out.println("Le soldat : " + this.getNom() + " possède déjà un " + equipement.getNom());
			}
		
			else
			{
				this.equipements[1] = equipement;
				System.out.println("Le soldat : " + this.getNom() + " s'équipe avec "+ equipement.getNom());
			}
			break;
		
		
		case 0 :
		
			this.equipements[0] = equipement;
			System.out.println("Le soldat : " + this.getNom() + " s'équipe avec "+ equipement.getNom());
			break;
		}
	
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
