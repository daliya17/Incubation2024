package DesignPatterns.Structural.Adapter;

import DesignPatterns.Structural.Adapter.ThirdParty.JustPayPG;
import DesignPatterns.Structural.Adapter.ThirdParty.RazorPayPG;

public class Main {
    // adapter pattern is used to make two incompatible interfaces compatible
    // in this example, we have two third party payment gateways, RazorPayPG and JustPayPG
    // we have our own PaymentGatewayInterface which has doPayment and checkPaymentStatus methods
    // we have created two adapter classes, RazorPayPGAdapter and JustPayPGAdapter
    // these adapter classes implement our PaymentGatewayInterface
    // and use the third party payment gateways to do the payment
    // this way we can use the third party payment gateways using our PaymentGatewayInterface
    // decoupling our code from the third party payment gateways
    public static void main(String[] args) {
        PaymentGatewayInterface paymentGatewayInterface1 = new RazorPayPGAdapter(new RazorPayPG());
        paymentGatewayInterface1.doPayment("Credit Card", 1000);

        // paymentgateway 2
        PaymentGatewayInterface paymentGatewayInterface2 = new JustPayPGAdapter(new JustPayPG());
        paymentGatewayInterface2.doPayment("Debit Card", 2000);
    }
}
