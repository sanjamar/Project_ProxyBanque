package com.gtm.proxybanque.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.gtm.proxybanque.metier.Compte;
import com.gtm.proxybanque.service.ConseillerService;

public class TestConseillerService {

	@Test
	public void testTransferFromCompteToCompte() {
		
		//fail("Not yet implemented");
		
		ConseillerService cs = new ConseillerService();
		
		Map<Integer,Compte> comptes = new HashMap<>();
		
		System.out.println("Enter number of account to Debit: ");
		
		Scanner sc = new Scanner(System.in);
		int compteToDebitNumber = sc.nextInt();
		
		Compte compteToDebit = comptes.get(compteToDebitNumber);

		
		/*compteToDebit.retirer(400);
		compteToDebit.retirer(1000);
		compteToDebit.retirer(200);*/
		
		//float result = compteToDebit.getSolde();
		//Assert.assertEquals("Erreur retirer", 1652680.67f, result, 0);
		
		

		System.out.println("Enter number of accout to Credit: ");
	
		int compteToCreditNumber= sc.nextInt();
		Compte compteToCredit = comptes.get(compteToCreditNumber);
		
		/*compteToCredit.verser(400);
		compteToCredit.verser(1000);
		compteToCredit.verser(200);*/
		
		//float result2 = compteToCredit.getSolde();
		//Assert.assertEquals("Erreur verser", 167028.67f, result2, 0);
		
		System.out.println("How much money do you want to transfer? ");
		float amount = sc.nextFloat();
				
		
		
		
	}

}
