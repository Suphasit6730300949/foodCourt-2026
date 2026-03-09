public class CouponCard {
    private double balance;
    private double deposit;
    private boolean isActive;

    public CouponCard(double firstAmount, double depositAmount) {
        this.deposit = depositAmount;
        this.balance = firstAmount - depositAmount;
        this.isActive = true;
    }

    public void addMoney(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("✅ เติมเงินสำเร็จ: +" + amount + " บาท");
        }
    }

    public boolean pay(double price) {
        if (price <= balance) {
            balance -= price;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public double refund() {
        double total = balance + deposit;
        balance = 0;
        isActive = false;
        return total;
    }
}