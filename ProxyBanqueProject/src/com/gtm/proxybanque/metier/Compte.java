package com.gtm.proxybanque.metier;

import java.util.Date;

import com.gtm.proxybanque.service.ConseillerService;
import com.gtm.proxybanque.metier.Client;;

public class Compte {
	
    protected Client client;
    
	private int numeroCompte;
	protected float solde;
	private Date ouvertureDate;
	protected String typeCompte;
	
	public int getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public Date getOuvertureDate() {
		return ouvertureDate;
	}
	public void setOuvertureDate(Date ouvertureDate) {
		this.ouvertureDate = ouvertureDate;
	}
	
	public String getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}
	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", solde=" + solde + ", ouvertureDate=" + ouvertureDate + "]";
	}
	public Compte(int numeroCompte, float solde, Date ouvertureDate) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.ouvertureDate = ouvertureDate;
	}
	/**
	 * Method adds amount to client's account if amount is superior than zero.
	 * @param amount Amount added on account
	 */
	public void verser(float amount) {
		
		if (amount <= 0)  {
			
			System.out.println("Amount has to be superior than zero!");
		}
		else {
			
			solde = solde + amount;
			System.out.println("Customer "+ client.getPrenom() +" : " + " deposit of " + amount + " � " + " has been added on Your account!\nYour new solde is " + solde);
			
		}
	}
	/**
	 * Method withdraws amount from client's account.
	 * @param amount Amount to withdraw. 
	 * @return Returns success of operation.
	 */
	public boolean retirer(float amount) {
		
		boolean result = false;

		if (amount < 0)  {
			
			System.out.println("Invalide request!");
		}
		else {
			
			if (amount > solde) {
				System.out.println("You don't have enough money on Your account!");
				
			}
			else {
				solde = solde - amount;
				if( client != null)
					System.out.println("customer"+client.getNom() +amount + " has been taken from Your account!\nYour new solde is " + solde);
				else
					System.out.println(amount + " has been taken from Your account!\nYour new solde is " + solde);
				
				result = true;
			}
			
		}
		return result;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}	
	
	
}
