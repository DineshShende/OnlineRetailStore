package com.store.datafixture;

import com.store.dto.AddProductRequest;
import com.store.entity.Product;

/**
 * The Class ProductDataFixture.
 *
 * @author Dinesh Shende
 * @version 1.0
 * @since 21 Mar, 2019
 */
public class ProductDataFixture {

    /** The product type A. */
    public static String productTypeA = "A";

    /** The product name shoes. */
    public static String productNameShoes = "Shoes";

    public static Long productIdShoes = 123L;

    /** The shoes price. */
    public static Float shoesPrice = 1200.0f;

    /** The product scan id shoes. */
    public static String productScanIdShoes = "SHOES123";

    public static String productTypeB = "B";

    /** The product name shoes. */
    public static String productNameCricketBat = "CricketBat";

    /** The shoes price. */
    public static Float cricketBatPrice = 2200.0f;

    /** The product scan id shoes. */
    public static String productScanIdCricketBat = "CRICKETBAT123";

    /**
     * Standard product A.
     *
     * @return the product
     */
    public static Product standardProductA() {
        Product product = new Product(productScanIdShoes, shoesPrice, productNameShoes, productTypeA);

        return product;
    }

    public static Product standardProductAWithId() {
        Product product = new Product(productIdShoes, productScanIdShoes, shoesPrice, productNameShoes, productTypeA);

        return product;
    }

    public static Product standardProductB() {
        Product product = new Product(productScanIdCricketBat, cricketBatPrice, productNameCricketBat, productTypeB);

        return product;
    }
    
    public static String addProductJson(AddProductRequest addProductRequest)
    {
    	//Created custom Json but this can be done using Gson
    	//Gson gson=new Gson();
    	String customJson="{\"billId\":"+addProductRequest.getBillId()+
    			",\"productIdWithQuantity\":[{\"productId\":"+addProductRequest.getProductIdWithQuantity().get(0).getProductId()+
    			",\"quantity\":"+addProductRequest.getProductIdWithQuantity().get(0).getQuantity()+"}]}";
    	
    	return customJson;
    }

}
