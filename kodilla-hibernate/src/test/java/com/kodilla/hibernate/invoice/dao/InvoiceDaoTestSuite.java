package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

//    @Autowired
//    private ProductDao productDao;
    @Autowired
    private InvoiceDao invoiceDao;

//    @Test
//    public void testProductDaoSave() {
//        // Given
//        Item item1 = new Item(new BigDecimal(1.0), 10);
//        Item item2 = new Item(new BigDecimal(2.0), 20);
//        Item item3 = new Item(new BigDecimal(2.0), 22);
//        Item item4 = new Item(new BigDecimal(10.0), 5);
//        Product product1 = new Product("Apple");
//        Product product2 = new Product("Orange");
//        Product product3 = new Product("Pumpkin");
//
//        item1.setProduct(product1);
//        item2.setProduct(product2);
//        item3.setProduct(product2);
//        item4.setProduct(product3);
//        product1.getItems().add(item1);
//        product2.getItems().add(item2);
//        product2.getItems().add(item3);
//        product3.getItems().add(item4);
//
//        // When
//        productDao.save(product1);
//        productDao.save(product2);
//        productDao.save(product3);
//        int productId1 = product1.getId();
//        int productId2 = product2.getId();
//        int productId3 = product3.getId();
//
//        // Then
//        Assert.assertNotEquals(0, productId1);
//        Assert.assertNotEquals(0, productId2);
//        Assert.assertNotEquals(0, productId3);
//
//        // Cleanup
//        productDao.delete(productId1);
//        productDao.delete(productId2);
//        productDao.delete(productId3);
//    }

    @Test
    public void testInvoiceDaoSave() {
        // Given
        Item item1 = new Item(new BigDecimal(1.0), 10);
        Item item2 = new Item(new BigDecimal(2.0), 20);
        Item item3 = new Item(new BigDecimal(2.0), 22);
        Item item4 = new Item(new BigDecimal(10.0), 5);
        Product product1 = new Product("Apple");
        Product product2 = new Product("Orange");
        Product product3 = new Product("Pumpkin");
        Invoice invoice = new Invoice("180108001");

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product2);
        item4.setProduct(product3);
        product1.getItems().add(item1);
        product2.getItems().add(item2);
        product2.getItems().add(item3);
        product3.getItems().add(item4);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);
        invoice.getItems().add(item4);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        Assert.assertNotEquals(0, invoiceId);

        // Cleanup
        invoiceDao.delete(invoiceId);
    }

}
