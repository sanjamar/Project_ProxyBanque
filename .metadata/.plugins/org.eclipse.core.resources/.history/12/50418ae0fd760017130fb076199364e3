package com.gtm.proxybanque.service;

import java.util.Date;
import java.util.Scanner;

import com.gtm.proxybanque.constants.ApplicationConstants;
import com.gtm.proxybanque.metier.Client;
import com.gtm.proxybanque.metier.Compte;
import com.gtm.proxybanque.metier.CompteCourant;
import com.gtm.proxybanque.metier.CompteEpargne;
import com.gtm.proxybanque.metier.Conseiller;

public class ConseillerService {

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
	public void readClientsInformation(Conseiller conseiller) {
		
		for(Client client: conseiller.getClients()) {
			
			System.out.println(client.toString());
			
		}
		
	}
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
	public void transferFromCompteToCompte(Compte compteToDebit, Compte compteToCredit, float amount) {
		
		if(compteToDebit.retirer(amount)) {
			compteToCredit.verser(amount);
		}
		else {
			System.out.println("Transfer canceled!");
		}
		
	}
	
	
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
	
	public void makeFinancialInvestment(Client client, Compte compte, String typeBourse, float amount) {
		
		if(isClientRich(client)) {
			if(compte.retirer(amount)) {
				
				
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
