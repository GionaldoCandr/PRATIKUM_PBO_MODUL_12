// lsp ocp

interface PaymentMethod {
    void pay(double amount);
}
interface RefundablePaymentMethod extends PaymentMethod {
    void refund(double amount);
}

class CreditCard implements RefundablePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Mengeksekusi API Bank sebesar: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund ke kartu kredit sebesar: " + amount);
    }
}



