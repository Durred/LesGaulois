package personnages;

public class Gaulois 
{
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force)
	{
		super();
		this.nom = nom;
		this.force = force;
	}

	public int getNbTrophees() {
		return nbTrophees;
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
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
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
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois d�cupl�e");
	}
	
	public Trophee faireUneDonnation() {
		if(nbTrophees > 0) 
		{
			this.parler("Je donne au musee tous mes trophees : \n");
			return new Trophee(this, trophees[nbTrophees]);
		}
		else 
		{
			return null;
		}
	}
	
	public static void main(String[] args) 
	{
		Gaulois asterix = new Gaulois("Ast�rix",8);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Truc");
		asterix.boirePotion(5);
	}
}
	
