package personnages;

import java.util.Random;

public class Druide 
{
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax)
	{
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force "+ effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	public String prendreParole() 
	{
		return "Le druide  " + nom + " : ";
	}
	
	public int preparerPotion()
	{
		Random random = new Random();
		int nb = random.nextInt(effetPotionMax);
		
		while(nb < effetPotionMin)
		{
			nb = random.nextInt(effetPotionMax);
		}
		
		if(nb >= 7)
		{
			parler("J'ai préparé une super potion de force " + nb);
		}
		else 
		{
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + nb);
		}
		return nb;
	}
	
	public void booster(Gaulois gaulois)
	{
		if(gaulois.getNom().equals("Obélix"))
		{
			parler("Non, Obélix !... Tu n'auras pas de potion magique !");
		}
		else
		{
			gaulois.boirePotion(preparerPotion());
		}
	}
	
	public static void main(String[] args) 
	{
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
	
}
