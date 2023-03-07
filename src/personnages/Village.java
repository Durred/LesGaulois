package personnages;

public class Village {
	
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum) 
	{
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		
		this.villageois = new Gaulois[nbVillageoisMaximum];
		
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom()
	{
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if(nbVillageois < nbVillageoisMaximum) {
			villageois[this.nbVillageois] = gaulois; 
			this.nbVillageois = this.nbVillageois + 1;
		}
	}
	
	public Gaulois trouverHabitant(int numero) {
		return villageois[numero];
	}
	
	public void afficherVillageois() {
		System.out.println(this.chef.getNom());
		for(int i = 0; i < this.nbVillageois; i++)
		{
			System.out.println(this.villageois[i].getNom());
		}
	}
	
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		
		/*Gaulois gaulois = village.trouverHabitant(30);
		 * 
		 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
			at personnages.Village.trouverHabitant(Village.java:36)
			at personnages.Village.main(Village.java:46
			
			On essaie d'accéder à une case du tableau qui n'existe pas, le dernier indice du tableau étant 29.
		 */
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		
		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		
		/*Gaulois gaulois = village.trouverHabitant(1);
		  System.out.println(gaulois);
		  
		  null
		  
		  Le seul gaulois faisant partie du tableau est Asterix, le chef étant assigné uniquement en tant que chef.
		  De ce fait, seul la case d'index 0 contient un gaulois.
		*/
		
		village.afficherVillageois();
	}
}
