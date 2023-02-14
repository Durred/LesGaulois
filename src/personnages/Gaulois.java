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
	
	public void parler(String texte) 
	{
		System.out.println(prendreParole());
	}
	
	@Override
	public String toString() 
	{
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) 
	{
		//TODO créer un main permettant de tester la classe Gaulois
	}
}
	
