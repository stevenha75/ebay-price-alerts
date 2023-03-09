package lib;
public class item {
    private String name;
    private String link;
    private double price;
    private double limit; // If price is less than or equal to limit -> send notification

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public double getLimit(){
        return this.limit;
    }

    public String getLink(){
        return this.link;
    }

    public boolean checkPrice(){
        return price <= limit;
    }
}
