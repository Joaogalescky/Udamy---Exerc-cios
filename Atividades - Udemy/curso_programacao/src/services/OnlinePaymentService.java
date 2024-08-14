package services;

public interface OnlinePaymentService {

	double taxaPagamento(double amount);
	double juro(double amount, int months);
}
