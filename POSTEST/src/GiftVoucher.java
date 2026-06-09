// isp
class GiftVoucher implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Memotong saldo voucher sebesar: " + amount);
    }
}