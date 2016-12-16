/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAF
 */
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class CreditCard {
    private String cardNumber;
    private String cardHolder;
    private Date expiryDate;
    Calendar calendar = Calendar.getInstance();
    
    
    public CreditCard(){
        
    }
    public CreditCard(String cardNumber, String cardHolder, int month, int year){
        setCardNumber(cardNumber);
        setCardHolder(cardHolder);
        setExpiryDate(month, year);
    }
    
  public boolean validateCard (String cardNumber)
  {
    int sum = 0;
    boolean alternate = false;
    for (int i = cardNumber.length() - 1; i >= 0; i--)
    {
      int n = Integer.parseInt(cardNumber.substring(i, i + 1));
      if (alternate)
      {
        n *= 2;
        if (n > 9)
        {
          n = (n % 10) + 1;
        }
      }
      sum += n;
      alternate = !alternate;
    }
    return (sum % 10 == 0);
  }

    /**
     * @return the cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }
   
    /**
     * @param cardNumber the cardNumber to set
     */
    public void setCardNumber(String cardNumber) {
        if (validateCard(cardNumber)) {
            this.cardNumber = cardNumber;
        }
        else 
            JOptionPane.showMessageDialog(null, "Your credit card number is not valid. Please enter again", "Alert", JOptionPane.ERROR_MESSAGE); 
    }

    /**
     * @return the cardHolder
     */
    public String getCardHolder() {
        return cardHolder;
    }

    /**
     * @param cardHolder the cardHolder to set
     */
    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    /**
     * @return the expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param month
     * @param year
     */
    public void setExpiryDate(int month, int year) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0); 
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        this.expiryDate = calendar.getTime();
    }

}
