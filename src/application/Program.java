package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoa> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual Income: ");
			double rendaAnual = sc.nextDouble();
			
			if (c == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();
				
				list.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			}
			if (c == 'c') {
				System.out.print("Number of employees: ");
				int nFuncionarios = sc.nextInt();
				
				list.add(new PessoaJuridica(nome, rendaAnual, nFuncionarios));
			}
		}
		
		double total = 0.0;
		System.out.println();
		System.out.println("TAXES PAID:");
		for (Pessoa p : list) {
			total += p.impostoPago();
			System.out.println(p.toString());
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", total);

		sc.close();

	}

}
