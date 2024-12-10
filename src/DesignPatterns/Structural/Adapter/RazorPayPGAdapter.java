package DesignPatterns.Structural.Adapter;

import DesignPatterns.Structural.Adapter.ThirdParty.RazorPayPG;

public class RazorPayPGAdapter implements PaymentGatewayInterface {
    private final RazorPayPG razorPayPG;

    public RazorPayPGAdapter(RazorPayPG razorPayPG) {
        this.razorPayPG = razorPayPG;
    }

    @Override
    public void doPayment(String paymentType, double amount) {
        razorPayPG.doPayment(paymentType, amount);
    }

    @Override
    public boolean checkPaymentStatus(String paymentType, double amount) {
        return true;
    }
}
