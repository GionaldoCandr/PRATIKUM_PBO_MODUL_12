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

class EmailSystem implements EmailNotifier {
    @Override
    public void sendEmail() {
        System.out.println("Mengirim email resi...");
    }
}
