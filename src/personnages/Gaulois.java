package personnages;

public class Gaulois 
{
	private String nom;
	private int effetPotion = 1;
	private int force, nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force)
	{
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce() 
	{
		return force;
	}
	public void setForce(int force) 
	{
		this.force = force;
	}
	public int getEffetPotion() 
	{
		return effetPotion;
	}
	
	public void setEffetPotion(int effetPotion) 
	{
		this.effetPotion = effetPotion;
	}
	
	public String getNom()
	{
		return nom;
	}
	
//	public String prendreParole() 
//	{
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
//	public void frapper(Romain romain)
//	{
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
				this.trophees[nbTrophees] = trophees[i];
			}
	}
	
	public String toString() 
	{
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcePotion)
	{
		setEffetPotion(forcePotion);
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}
	
	public void faireUneDonnation(Musee musee) {
		if(nbTrophees > 0) 
		{
			this.parler("Je donne au musee tous mes trophees : \n");
			for(int i = 0; i < nbTrophees; i++, nbTrophees--) 
			{
				musee.trophees[musee.getNbTrophee()] = trophees[i];
				trophees[i] = null;	
				musee.setNbTrophee(musee.getNbTrophee()+1);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Truc");
		asterix.boirePotion(5);
	}
}
	
