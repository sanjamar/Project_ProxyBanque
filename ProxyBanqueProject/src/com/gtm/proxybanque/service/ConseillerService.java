package com.gtm.proxybanque.service;

import java.util.Date;

import com.gtm.proxybanque.constants.ApplicationConstants;
import com.gtm.proxybanque.metier.Action;
import com.gtm.proxybanque.metier.Client;
import com.gtm.proxybanque.metier.Compte;
import com.gtm.proxybanque.metier.CompteCourant;
import com.gtm.proxybanque.metier.CompteEpargne;
import com.gtm.proxybanque.metier.Conseiller;

public class ConseillerService {

	/**
	 * Method createClient is creating and linking client to some counselor. 
	 * @param conseiller Counselor linked to created client.
	 * @param nom Client's surname
	 * @param prenom Client's first name
	 * @param adresse Client's address
	 * @param postalCode Client's postal code
	 * @param ville City where client lives
	 * @param telephone Client's telephone number
	 * @return Return created client
	 */
	public Client createClient(Conseiller conseiller, String nom, String prenom, String adresse, int postalCode, String ville, String telephone) {
		
		if(conseiller.getClients().size()<ApplicationConstants.MAX_CLIENTS) {
			Client client = new Client(nom, prenom, adresse, postalCode, ville, telephone);
			conseiller.getClients().add(client);
			return client;
		}
		else {
			System.out.println("You've reached maximal number of clients for this conseiller.");
			return null;
		}
		
	}
	
	/**
	 * Method is reading all information about conseiller's clients.
	 * @param conseiller Counselor from who to read client's information
	 */
	public void readClientsInformation(Conseiller conseiller) {
		
		for(Client client: conseiller.getClients()) {
			
			System.out.println(client.toString());
			
		}
		
	}
	/**
	 * Method creates and links account to client.
	 * @param client Client to whom to add account.
	 * @param numeroCompte Number of account added to client.
	 * @param solde Current amount of money on client's account.
	 * @param typeCompte Type of account created for client.
	 * @return Return created account.
	 */
	public Compte createCompteToClient(Client client, int numeroCompte, float solde, String typeCompte)  {
	
		Compte compte = null;
		
		if(ApplicationConstants.COMPTE_EPARGNE.equals(typeCompte)) {
			compte = new CompteEpargne(numeroCompte, solde, new Date());
			compte.setClient(client);
			client.getComptes().add(compte);
		}
		else if(ApplicationConstants.COMPTE_COURANT.equals(typeCompte)) {
			float decouvert = 0;
			compte = new CompteCourant(numeroCompte, solde, new Date(), decouvert);
			compte.setClient(client);
			client.getComptes().add(compte);
		}
		else {
			System.out.println("Type of Compte not known!");
		}
		
		return compte;
		
	}
	/**
	 * Method transfers amount from one account to another.
	 * @param compteToDebit Account to debit.
	 * @param compteToCredit Account to credit.
	 * @param amount Transfered amount in between of accounts.
	 */
	public void transferFromCompteToCompte(Compte compteToDebit, Compte compteToCredit, float amount) {
		
		if(compteToDebit.retirer(amount)) {
			compteToCredit.verser(amount);
		}
		else {
			System.out.println("Transfer canceled!");
		}
		
	}
	
	/**
	 * Method checks if client is rich or not.
	 * @param client Client to check.
	 * @return Return if client is rich or not.
	 */
	public boolean isClientRich(Client client) {
		boolean result = false;
		float resultOfAddition = 0;
		for(Compte compte: client.getComptes()) {
			//compte.getSolde();
			
			resultOfAddition += compte.getSolde();
		}
		if(resultOfAddition > ApplicationConstants.RICH_AMOUNT) {
			result = true;	
		}
		return result;
	}
	
	/**
	 * Method makes financial investment for client.
	 * @param client Client that makes financial investment.
	 * @param compte Account to debit.
	 * @param actionToBuy Action to buy.
	 * @param numberOfActions Number of actions.
	 */
	public void makeFinancialInvestment(Client client, Compte compte, Action actionToBuy, int numberOfActions) {
		
		if(isClientRich(client)) {
			float amount = (actionToBuy.getPrix()*numberOfActions);
			
			if(compte.retirer(amount)) {
				System.out.println("You have bought " + numberOfActions + " Actions.");
				
				int i = 0;
				
				while(i < numberOfActions){
					client.getActions().add(actionToBuy);
					i++;
				}
				
			}
			else {
				System.out.println("Investment was canceled!");
			}
		}
		else {
			System.out.println("Client is not rich enough!");
		}
	}
}
