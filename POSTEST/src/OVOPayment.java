// isp
public class OVOPayment implements RefundablePaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Mengeksekusi API OVO sebesar: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund ke saldo OVO sebesar: " + amount);
    }
}
