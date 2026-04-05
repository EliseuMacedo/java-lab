package section13.polymorphism2.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    private Date manufactureDate;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufacturedDate) {
        this.manufactureDate = manufacturedDate;
    }

    @Override
    public final String priceTag() {
        return super.getName()
                + " (used) $ "
                + String.format("%.2f", super.getPrice())
                + " (Manufacture date: "
                + sdf.format(manufactureDate)
                + ")";
    }

}
