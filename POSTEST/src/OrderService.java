// srp dip

class OrderService {
    private PaymentMethod payment;
    private EmailNotifier notifier;

    public OrderService(PaymentMethod payment, EmailNotifier notifier) {
        this.payment = payment;
        this.notifier = notifier;
    }

    public void completeOrder(double amount) {
        System.out.println("Memproses pesanan pelanggan...");
        
        payment.pay(amount);
        
        notifier.sendEmail();
    }
}
