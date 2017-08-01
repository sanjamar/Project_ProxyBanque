package com.gtm.proxybanque.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.gtm.proxybanque.constants.ApplicationConstants;
import com.gtm.proxybanque.metier.Action;
import com.gtm.proxybanque.metier.Client;
import com.gtm.proxybanque.metier.Compte;
import com.gtm.proxybanque.metier.Conseiller;
import com.gtm.proxybanque.service.ClientService;
import com.gtm.proxybanque.service.ConseillerService;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConseillerService cs = new ConseillerService();
		Conseiller conseiller = new Conseiller();
		Client client1 = cs.createClient(conseiller, "Dupont", "Jacques", "2 rue des lilas", 31000, "Toulouse", "0645382989");
		Client client2 = cs.createClient(conseiller, "Dare", "Anne", "52 rue premier", 21000, "Split", "0795382945");
		/*cs.createClient(conseiller, "Ludovic", "Toni", "8 rue des lilas", 10000, "Paris", "0645978478");
		cs.createClient(conseiller, "Bodain", "Jean", " 259 rue des roses", 91000, "Paris", "0726828298");
		cs.createClient(conseiller, "Marun", "Claire", "59 rue st. Leon", 31000, "Toulouse", "0845382698");
		cs.createClient(conseiller, "Blanc", "Marie", "51 rue des lilas", 21000, "Split", "0148958298");
		cs.createClient(conseiller, "Horvat", "Ivan", "9 rue st. Marc", 61000, "Bordeaux", "0684538298");
		cs.createClient(conseiller, "Branche", "Sébastien", "2 rue des lilas", 21000, "Marseille", "0245538298");
		cs.createClient(conseiller, "Brown", "Audrey", "2 rue des lilas", 81000, "Lille", "0345389298");
		cs.createClient(conseiller, "Marc", "Olivier", "2 rue des lilas", 21000, "Split", "0554538298");
		cs.createClient(conseiller, "Singer", "Richard", "2 rue des lilas", 21000, "Split", "0764538298");*/
		
		cs.readClientsInformation(conseiller);
		
		Compte compte = cs.createCompteToClient(client1, 637, 1654280.67f, ApplicationConstants.COMPTE_COURANT);
	
		Compte compte2 = cs.createCompteToClient(client2, 643, 165428.67f, ApplicationConstants.COMPTE_COURANT);
		
		Map<Integer,Compte> comptes = new HashMap<>();
		comptes.put(compte.getNumeroCompte(), compte);
		comptes.put(compte2.getNumeroCompte(), compte2);
		
		//compte.verser(500);
		//compte.verser(800);

		ClientService clientService = new ClientService();
		clientService.readComptes(client1);
		
		//cs.transferFromCompteToCompte(compte, compte2, 165428.67f);
		
		clientService.readComptes(client2);
		boolean result = cs.isClientRich(client1);
		System.out.println(cs.isClientRich(client2));
		System.out.println(result);
		
		//cs.transferFromCompteToCompte(compte, compte2, amount);
		
		System.out.println("Enter number of account to Debit: ");
		
		Scanner sc = new Scanner(System.in);
		int compteToDebitNumber = sc.nextInt();
		
		Compte compteToDebit = comptes.get(compteToDebitNumber);
		
		
		System.out.println("Enter number of accout to Credit: ");
	
		int compteToCreditNumber= sc.nextInt();
		
		Compte compteToCredit = comptes.get(compteToCreditNumber);
		
		
		System.out.println("How much money do you want to transfer? ");
		float amount = sc.nextFloat();
	
		//compteToDebit.retirer(amount);
		//compteToCredit.verser(amount);
		
		cs.transferFromCompteToCompte(compteToDebit, compteToCredit, amount);
		//System.out.println("Your new sold is: " + compte.getSolde() + " € ");
		//System.out.println("Your new sold is: " + compte2.getSolde() + " € ");
		

		sc.close();
		//Compte compteToCredit = (compteToCreditNumber);
		
		
		Map<String, Action> actions = new HashMap<>();
		Action a1 = new Action("AF", "Airbus Paris", 35f);
		Action a2 = new Action("AP", "Airbus Tokyo", 18f);
		
		actions.put(a1.getCode(), a1);
		actions.put(a2.getCode(), a2);
		
		
		String code;
		
		char response = 'Y';
		
		Scanner scan = new Scanner(System.in);
		
		while(response == 'Y') {
			
			System.out.println("Insert code for your action");
		}
				
	}

}
