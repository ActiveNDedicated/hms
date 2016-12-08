
public class Bill {
    private double paidamount;
    private double owedamount;
    private double totalamount;
    Bill(double total,double paid){
        setTotalamount(total);
        setPaidamount(paid);
    }
    Bill ()
    {
        this.paidamount=0;
        this.owedamount=0;
        this.totalamount=0;
    }
    public double getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(double paidamount) {
        this.paidamount = paidamount;
        setOwedamount();
    }

    public double getOwedamount() {
        return owedamount;
    }

    public void setOwedamount() {
        this.owedamount = this.totalamount-this.paidamount;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }
   
}
