package utils;

import java.util.List;

public class ProductInformation {
    List<String> productName;
    List<Integer> qty;

    public ProductInformation(List<String> productName,List<Integer> qty){
        this.productName=productName;
        this.qty=qty;
    }
}
