package services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public double taxaPagamento(double amount) {
		return amount * 0.02;
	}

	@Override
	public double juro(double amount, int months) {
		return amount * 0.01 * months;
	}

}
