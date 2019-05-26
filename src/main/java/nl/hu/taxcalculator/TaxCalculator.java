package nl.hu.taxcalculator;

public class TaxCalculator {

    private static final int UPPER_VALUE_BOX_ONE = 20142;
    private static final int UPPER_VALUE_BOX_TWO = 33994;
    private static final int UPPER_VALUE_BOX_THREE = 68507;

    private static final double PERCENTAGE_BOX_ONE = 0.3655;
    private static final double PERCENTAGE_BOX_TWO = 0.4085;
    private static final double PERCENTAGE_BOX_THREE = 0.4085;
    private static final double PERCENTAGE_BOX_FOUR = 0.5195;


    private boolean firstBoxDone;
    private boolean secondBoxDone;
    private boolean thirdBoxDone;

    private int totalTaxToPay;
    private int notPaidTax;

    public TaxCalculator() {
        firstBoxDone = false;
        secondBoxDone = false;
        thirdBoxDone = false;
        totalTaxToPay = 0;
        notPaidTax = 0;
    }


    public int calculateTax(int incomeBeforeTax) {
        notPaidTax = incomeBeforeTax;

        while(notPaidTax > 0) {
            calculateTaxForBox();
        }
        return totalTaxToPay;
    }

    private void calculateTaxForBox() {
        if(!firstBoxDone) {
            if(notPaidTax > UPPER_VALUE_BOX_ONE) {
                notPaidTax = notPaidTax - UPPER_VALUE_BOX_ONE;

                totalTaxToPay = totalTaxToPay + (int) (UPPER_VALUE_BOX_ONE * PERCENTAGE_BOX_ONE);
            } else {
                totalTaxToPay = totalTaxToPay + (int) (PERCENTAGE_BOX_ONE * notPaidTax);
                notPaidTax = 0;
            }
            firstBoxDone = true;
        } else if(!secondBoxDone) {
            if(notPaidTax > UPPER_VALUE_BOX_TWO) {
                notPaidTax = notPaidTax - UPPER_VALUE_BOX_TWO;
                totalTaxToPay = totalTaxToPay +  (int) (UPPER_VALUE_BOX_TWO * PERCENTAGE_BOX_TWO);
            } else {
                totalTaxToPay = totalTaxToPay + (int) (PERCENTAGE_BOX_TWO * notPaidTax);
                notPaidTax = 0;
            }
            if(!secondBoxDone) {
                secondBoxDone = true;
            }
        } if (!thirdBoxDone) {
            if(notPaidTax > UPPER_VALUE_BOX_THREE) {
                notPaidTax = notPaidTax - UPPER_VALUE_BOX_THREE;
                totalTaxToPay = totalTaxToPay + (int) (UPPER_VALUE_BOX_THREE * PERCENTAGE_BOX_THREE);
            } else {
                totalTaxToPay = totalTaxToPay + (int) (PERCENTAGE_BOX_THREE * notPaidTax);
                notPaidTax = 0;
            }
            thirdBoxDone = true;
        } else {
            totalTaxToPay = totalTaxToPay + (int) (PERCENTAGE_BOX_FOUR * notPaidTax);
            notPaidTax = 0;
        }
    }
}
