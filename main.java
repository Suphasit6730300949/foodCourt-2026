import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double DEPOSIT_FEE = 50.0;
        CouponCard myCard = null;

        System.out.println("=== ระบบศูนย์อาหาร ห้าง A ===");

        while (true) {
            System.out.println("\n--- เมนู ---");
            System.out.println("1. เปิดบัตรใหม่ (มัดจำ " + DEPOSIT_FEE + ")");
            System.out.println("2. เติมเงินเพิ่ม");
            System.out.println("3. ซื้ออาหาร");
            System.out.println("4. คืนบัตรและรับเงินคืน");
            System.out.println("5. ดูยอดเงินคงเหลือ");
            System.out.println("6. ออกจากระบบ");
            System.out.print("เลือกรายการ: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (myCard != null) {
                    System.out.println("❌ คุณมีบัตรอยู่แล้ว");
                } else {
                    System.out.print("ใส่ยอดเงินเปิดบัตร: ");
                    double money = sc.nextDouble();
                    if (money > DEPOSIT_FEE) {
                        myCard = new CouponCard(money, DEPOSIT_FEE);
                        System.out.println("✅ เปิดบัตรแล้ว ยอดเงินใช้ได้: " + myCard.getBalance());
                    } else {
                        System.out.println("❌ เงินไม่พอค่ามัดจำ");
                    }
                }
            } else if (choice == 2) {
                if (myCard == null) {
                    System.out.println("❌ กรุณาเปิดบัตรก่อน");
                } else {
                    System.out.print("ระบุจำนวนเงินที่ต้องการเติม: ");
                    double amount = sc.nextDouble();
                    myCard.addMoney(amount);
                    System.out.println("💰 ยอดเงินปัจจุบัน: " + myCard.getBalance());
                }
            } else if (choice == 3) {
                if (myCard == null) {
                    System.out.println("❌ กรุณาใช้บัตรซื้ออาหาร");
                } else {
                    System.out.print("ราคาสินค้า: ");
                    double price = sc.nextDouble();
                    if (myCard.pay(price)) {
                        System.out.println("✅ จ่ายสำเร็จ คงเหลือ: " + myCard.getBalance());
                    } else {
                        System.out.println("❌ เงินไม่พอ! กรุณาเติมเงิน");
                    }
                }
            } else if (choice == 4) {
                if (myCard != null) {
                    System.out.println("💵 รับเงินคืนทั้งสิ้น: " + myCard.refund() + " บาท");
                    myCard = null; // ทำลายบัตรทิ้งหลังจากคืนเงิน
                } else {
                    System.out.println("❌ ไม่มีบัตรให้คืน");
                }
            } else if (choice == 5) {
                if (myCard != null) {
                    System.out.println("💰 ยอดเงินคงเหลือ: " + myCard.getBalance());
                } else {
                    System.out.println("❌ กรุณาเปิดบัตรก่อน");
                }
            } else if (choice == 6) {
                break;
            }
        }
        System.out.println("ขอบคุณที่ใช้บริการ");
        sc.close();
    }
}