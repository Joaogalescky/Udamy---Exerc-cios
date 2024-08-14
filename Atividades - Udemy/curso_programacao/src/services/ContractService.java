package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, int months) {

		double parcBasica = contract.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			// Calculo da data de vencimento das parcelas
			LocalDate vencParcela = contract.getDate().plusMonths(i);

			// Valor da taxa e do juros para cada mês
			double juro = onlinePaymentService.juro(parcBasica, i);

			// Valor da taxa de pagamento
			double taxa = onlinePaymentService.taxaPagamento(parcBasica + juro);
			double cota = parcBasica + juro + taxa;

			contract.getInstallments().add(new Installment(vencParcela, cota));
		}
	}
}
