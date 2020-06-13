
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Atm {
    ArrayList<Value> bills = new ArrayList<Value>();
    private int balance;

    public void addBillToAtm(Value value, int quantity){
        for (int counter = 0; counter < quantity; counter++) {
            bills.add(value);
        }
    }
    public void withdrawal(int withdrawalQuantity){
        updateBalance();
        if (validateWithdrawal(withdrawalQuantity)){
            transaction(withdrawalQuantity);
        }else System.out.println("not enough money:(");
    }

    private void updateBalance(){
        balance=0;
        for (int i=0;i<bills.size();i++){
            balance=balance+bills.get(i).getValue();
        }
    }

    private boolean validateWithdrawal(int withdrawalQuantity){
        boolean validate=false;
        if (withdrawalQuantity<=balance){
            validate= true;
        }return validate;
    }

    private void transaction(int withdrawalQuantity){
        ArrayList<Value> temp = new ArrayList<Value>();
        List<Value> value = Arrays.asList(Value.values());

        int rest=withdrawalQuantity;
        for (int v=0;v<value.size();v++) {
            if (rest >= value.get(v).getValue()) {
                int billValue = rest /value.get(v).getValue();
                int xBillValue = 0;

                for (int i = 0; i < bills.size(); i++) {
                    if (bills.get(i).getValue() == value.get(v).getValue())
                        xBillValue++;
                }

                for (int i = 0; i < xBillValue; i++) {
                    temp.add(value.get(v));
                    billValue--;
                    if (billValue == 0)
                        break;
                }
                rest = rest % value.get(v).getValue() + (billValue *value.get(v).getValue());
            }
        }

        if (rest>0){
            System.out.println("Could not withdraw :"+withdrawalQuantity);
        }
        //Removes withdrawn bills from atm.
        else for (int i=0;i<temp.size();i++){
            for (int j=0;j<bills.size();){
                if (temp.get(i)==bills.get(j)){
                    bills.remove(j);
                    break;
                }else j++;
            }
        }
        System.out.println("Withdrawal: "+temp);
        temp.clear();
    }
}





