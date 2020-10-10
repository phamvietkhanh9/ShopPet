package com.example.shoppet.entity.user;

import com.example.shoppet.dto.ProductsDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "receipt_item")
public class ReceiptItem implements Serializable {

    @Id
    @GeneratedValue
    private long receiptItemId;
    @ManyToOne
    @JoinColumn(name = "receiptId")
    private Receipt receipt;
    @OneToOne
    @JoinColumn(name = "productId")
    private ProductsDto product;
    private int receiptItemQuantity;
    private double receiptItemPrice;
    private int receiptItemSale;
    private boolean receiptItemStatus;

    public long getReceiptItemId() {
        return receiptItemId;
    }

    public void setReceiptItemId(long receiptItemId) {
        this.receiptItemId = receiptItemId;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public ProductsDto getProduct() {
        return product;
    }

    public void setProduct(ProductsDto product) {
        this.product = product;
    }

    public int getReceiptItemQuantity() {
        return receiptItemQuantity;
    }

    public void setReceiptItemQuantity(int receiptItemQuantity) {
        this.receiptItemQuantity = receiptItemQuantity;
    }

    public double getReceiptItemPrice() {
        return receiptItemPrice;
    }

    public void setReceiptItemPrice(double receiptItemPrice) {
        this.receiptItemPrice = receiptItemPrice;
    }

    public int getReceiptItemSale() {
        return receiptItemSale;
    }

    public void setReceiptItemSale(int receiptItemSale) {
        this.receiptItemSale = receiptItemSale;
    }

    public boolean isReceiptItemStatus() {
        return receiptItemStatus;
    }

    public void setReceiptItemStatus(boolean receiptItemStatus) {
        this.receiptItemStatus = receiptItemStatus;
    }
}