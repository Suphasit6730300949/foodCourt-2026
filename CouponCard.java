public class CouponCard {
    private double balance; // ยอดเงินที่ใช้ได้จริง
    private double deposit; // ค่ามัดจำที่เก็บไว้
    private boolean isActive;

    // Constructor: หักมัดจำทันทีที่เปิดบัตรครั้งแรก
    public CouponCard(double firstAmount, double depositAmount) {
        this.deposit = depositAmount;
        this.balance = firstAmount - depositAmount;
        this.isActive = true;
    }

    // Function: เติมเงินเพิ่ม (ไม่ต้องหักมัดจำซ้ำ)
    public void addMoney(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("✅ เติมเงินสำเร็จ: +" + amount + " บาท");
        }
    }

    // Function: ชำระค่าอาหาร
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

    // Function: คืนเงินรวมมัดจำ
    public double refund() {
        double total = balance + deposit;
        balance = 0;
        isActive = false;
        return total;
    }
}