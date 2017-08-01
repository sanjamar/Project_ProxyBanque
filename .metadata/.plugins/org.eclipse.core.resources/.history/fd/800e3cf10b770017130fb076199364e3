package com.gtm.proxybanque.metier;

import java.util.Date;

public class CompteCourant extends Compte {
	
		public CompteCourant(int numeroCompte, float solde, Date ouvertureDate, float decouvert) {
		super(numeroCompte, solde, ouvertureDate);
		this.decouvert = decouvert;
		
		}
		private float decouvert;

		public float getDecouvert() {
			return decouvert;
		}

		public void setDecouvert(float decouvert) {
			this.decouvert = decouvert;
		}

		@Override
		public String toString() {
			return "CompteCourant [decouvert=" + decouvert + ", toString()=" + super.toString() + "]";
		}
		
		public boolean retirer(float amount) {
			
			boolean result = false;
			

			if (amount <0)  {
				
				System.out.println("You don't have enough money on Your account!");
			}
			else {
				
				if (amount > solde) {
					System.out.println("Invalide request!");
					
				}
				else {
					solde = solde - amount;
					if( client != null)
						System.out.println("Customer "+ client.getPrenom() +" : " + amount + " € " + " has been taken from Your account!\nYour new solde is " + solde);
					
					result = true;
				}
				
			}
			return result;
		}	


}
