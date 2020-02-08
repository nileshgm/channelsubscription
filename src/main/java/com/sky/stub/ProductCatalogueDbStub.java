package com.sky.stub;

import com.sky.model.Product;
import com.sky.model.ProductCatalogue;

import java.util.*;

public class ProductCatalogueDbStub {

    public static Map<String, List<ProductCatalogue>> createAndReturnProductCatalogue(){
        Map<String, List<ProductCatalogue>> productCatalogueByLocations = new HashMap<>();
        List<Product> newsProductsForAll = new ArrayList<>();
        newsProductsForAll.add(new Product("1","Sky News"));
        newsProductsForAll.add(new Product("2", "Sky Sports News"));
        ProductCatalogue newsForAll = new ProductCatalogue("News",newsProductsForAll);

        List<Product> sportsProductsForLondon = new ArrayList<>();
        sportsProductsForLondon.add(new Product("1","Arsenal TV"));
        sportsProductsForLondon.add(new Product("2", "Chelsea TV"));
        ProductCatalogue sportsForLondon = new ProductCatalogue("Sports",sportsProductsForLondon);
        List<ProductCatalogue> productCataloguesForLondon = Arrays.asList(sportsForLondon, newsForAll);
        productCatalogueByLocations.put("LONDON", productCataloguesForLondon);


        List<Product> sportsProductsForLiverpool = new ArrayList<>();
        sportsProductsForLiverpool.add(new Product("1", "Liverpool TV"));
        ProductCatalogue sportsForLiverpool = new ProductCatalogue("Sports",sportsProductsForLiverpool);
        List<ProductCatalogue> productCataloguesForLiverpool = Arrays.asList(sportsForLiverpool,newsForAll);
        productCatalogueByLocations.put("LIVERPOOL",productCataloguesForLiverpool);

        return productCatalogueByLocations;

    }
}
