// isp

interface EmailNotifier {
    void sendEmail();
}

interface SMSNotifier {
    void sendSMS();
}

interface WhatsAppNotifier {
    void sendWhatsApp();
}

// EmailSystem hanya mengimplementasikan apa yang dia butuhkan
class EmailSystem implements EmailNotifier {
    @Override
    public void sendEmail() {
        System.out.println("Mengirim email resi...");
    }
}
