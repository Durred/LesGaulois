package personnages;

import java.lang.reflect.Method;

public class Gaulois 
{
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

	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public String getNom()
	{
		return nom;
	}
	
	public String prendreParole() 
	{
		return "Le gaulois " + nom + " : ";
	}
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}
	
	public void frapper(Romain romain)
	{
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
	
	
	public String toString() 
	{
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) 
	{
		Gaulois asterix = new Gaulois("Astérix",8);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Truc");
	}
}
	
