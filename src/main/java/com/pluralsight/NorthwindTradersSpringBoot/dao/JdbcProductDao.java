package com.pluralsight.NorthwindTradersSpringBoot.dao;

import com.pluralsight.NorthwindTradersSpringBoot.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//add Component annotation to register as Spring bean
@Component
public class JdbcProductDao implements ProductDao{

    //create a dataSource object
    @Autowired
    private DataSource dataSource;

    @Override
    public void add(Product product) {

    }

    @Override
    public List<Product> getAll() {

        List<Product> products = new ArrayList<>();

        String sql = """
                SELECT
                    ProductName,
                    UnitPrice,
                    productId,
                    categoryId
                FROM
                    Products
                """;
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while(rs.next()){

                Product product = new Product();

                product.setProductName(rs.getString("ProductName"));
                product.setUnitPrice(rs.getDouble("UnitPrice"));

                products.add(product);
            }
        }catch(SQLException e){

            e.printStackTrace();
        }

        return products;
    }
}
