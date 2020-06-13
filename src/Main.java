public class Main {
    public static void main(String[] args) {

        Atm atm=new Atm();

        atm.addBillToAtm(Value.ONETHOUSAND,2);
        atm.addBillToAtm(Value.FIVEHUNDRED,3);
        atm.addBillToAtm(Value.ONEHUNDRED,5);

        atm.withdrawal(1500);
        atm.withdrawal(700);
        atm.withdrawal(400);
        atm.withdrawal(1100);
        atm.withdrawal(1000);
        atm.withdrawal(700);
        atm.withdrawal(300);

    }
}
