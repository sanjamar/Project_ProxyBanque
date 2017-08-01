package com.gtm.proxybanque.test;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import com.gtm.proxybanque.constants.ApplicationConstants;
import com.gtm.proxybanque.metier.Action;
import com.gtm.proxybanque.metier.Client;
import com.gtm.proxybanque.metier.Compte;
import com.gtm.proxybanque.metier.Conseiller;
import com.gtm.proxybanque.service.ConseillerService;

public class TestConseillerService {

	@Test
	public void testTransferFromCompteToCompteWithScanner() {
		
		//fail("Not yet implemented");
		System.out.println("----------------------------------------------------------------------------------------------\n Test transferFromCompteToCompteWithScanner: ");
		
		ConseillerService cs = new ConseillerService();
		Conseiller conseiller = new Conseiller();
		Client client1 = cs.createClient(conseiller, "Dupont", "Jacques", "2 rue des lilas", 31000, "Toulouse", "0645382989");
		Client client2 = cs.createClient(conseiller, "Dare", "Anne", "52 rue premier", 21000, "Split", "0795382945");
		Compte compte1 = cs.createCompteToClient(client1, 637, 100.00f, ApplicationConstants.COMPTE_COURANT);
		Compte compte2 = cs.createCompteToClient(client2, 643, 50.00f, ApplicationConstants.COMPTE_COURANT);
		
		Map<Integer,Compte> comptes = new HashMap<>();
		comptes.put(compte1.getNumeroCompte(), compte1);
		comptes.put(compte2.getNumeroCompte(), compte2);
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter number of account to Debit: ");
		int compteToDebitNumber = sc.nextInt();
		Compte compteToDebit = comptes.get(compteToDebitNumber);
		
		
		System.out.println("Enter number of accout to Credit: ");
		int compteToCreditNumber= sc.nextInt();
		Compte compteToCredit = comptes.get(compteToCreditNumber);
		
		
		System.out.println("How much money do you want to transfer? ");
		float amount = sc.nextFloat();
				
		sc.close();
		
		float result1 = compteToDebit.getSolde() - amount;
		float result2 = compteToCredit.getSolde() + amount;
		
		cs.transferFromCompteToCompte(compteToDebit, compteToCredit, amount);
		
		assertEquals("Error with compteToDebit ", result1, compteToDebit.getSolde(), 0);
		assertEquals("Error with compteToCredit ", result2, compteToCredit.getSolde(), 0);
		
	}
	
	@Test
	public void testTransferFromCompteToCompteCanceled() {
		
		System.out.println("----------------------------------------------------------------------------------------------\n Test transferFromCompteToCompteCanceled: ");
		ConseillerService cs = new ConseillerService();
		Conseiller conseiller = new Conseiller();
		Client client1 = cs.createClient(conseiller, "Dupont", "Jacques", "2 rue des lilas", 31000, "Toulouse", "0645382989");
		Client client2 = cs.createClient(conseiller, "Dare", "Anne", "52 rue premier", 21000, "Split", "0795382945");
		Compte compteToDebit = cs.createCompteToClient(client1, 637, 100.00f, ApplicationConstants.COMPTE_COURANT);
		Compte compteToCredit = cs.createCompteToClient(client2, 643, 50.00f, ApplicationConstants.COMPTE_COURANT);
		
		float amount = 250;
		
		float result1 = compteToDebit.getSolde();
		float result2 = compteToCredit.getSolde();
		
		cs.transferFromCompteToCompte(compteToDebit, compteToCredit, amount);
		
		assertEquals("Error with compteToDebit ", result1, compteToDebit.getSolde(), 0);
		assertEquals("Error with compteToCredit ", result2, compteToCredit.getSolde(), 0);
		
	}
	
	@Test
	public void testIsClientRich() {
		
		System.out.println("----------------------------------------------------------------------------------------------\n Test isClientRich: ");
		ConseillerService cs = new ConseillerService();
		Conseiller conseiller = new Conseiller();
		Client clientRich = cs.createClient(conseiller, "Dupont", "Jacques", "2 rue des lilas", 31000, "Toulouse", "0645382989");
		Client clientNotRich = cs.createClient(conseiller, "Dare", "Anne", "52 rue premier", 21000, "Split", "0795382945");
		cs.createCompteToClient(clientRich, 637, 1000000.00f, ApplicationConstants.COMPTE_COURANT);
		cs.createCompteToClient(clientNotRich, 643, 500.00f, ApplicationConstants.COMPTE_COURANT);
		
		boolean resultRich = cs.isClientRich(clientRich);
		
		assertEquals("Client should be rich!", true, resultRich);
		
		assertEquals("Client is not rich!", false, cs.isClientRich(clientNotRich));
		
	}
	
	@Test
	public void testMakeFinancialInvestment() {
		
		System.out.println("----------------------------------------------------------------------------------------------\n Test testMakeFinancialInvestment: ");
		
		ConseillerService cs = new ConseillerService();
		Conseiller conseiller = new Conseiller();
		Client clientRich = cs.createClient(conseiller, "Dupont", "Jacques", "2 rue des lilas", 31000, "Toulouse", "0645382989");
		Compte compte = cs.createCompteToClient(clientRich, 637, 1000000.00f, ApplicationConstants.COMPTE_COURANT);
		
		Action actionToBuy = new Action("AF", "Airbus Paris", 35f);
		Action a2 = new Action("AP", "Airbus Tokyo", 18f);
		
		int numberOfActions = 2;
		
		float result = compte.getSolde() - (actionToBuy.getPrix()*numberOfActions);
		int result2 = clientRich.getActions().size() + numberOfActions;
		
		cs.makeFinancialInvestment(clientRich, compte, actionToBuy, numberOfActions);
		
		
		assertEquals("Compte solde didn't change!", result, compte.getSolde(), 0);
		assertEquals("Action is not in the list!", result2,clientRich.getActions().size());
		
		
	}
	

}
