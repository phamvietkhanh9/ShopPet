package com.example.shoppet.entity.user;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

@Entity(name = "receipt")
public class Receipt implements Serializable {

    @Id
    @GeneratedValue
    private long receiptId;
    private String receiptName;
    private String receiptMail;
    private String receiptAddress;
    private Timestamp receiptDate;
    private boolean receiptStatus;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiptItemId")
    private List<ReceiptItem> listReceiptItem;

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptMail() {
        return receiptMail;
    }

    public void setReceiptMail(String receiptMail) {
        this.receiptMail = receiptMail;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public Timestamp getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Timestamp receiptDate) {
        this.receiptDate = receiptDate;
    }

    public boolean isReceiptStatus() {
        return receiptStatus;
    }

    public void setReceiptStatus(boolean receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    public List<ReceiptItem> getListReceiptItem() {
        return listReceiptItem;
    }

    public void setListReceiptItem(List<ReceiptItem> listReceiptItem) {
        this.listReceiptItem = listReceiptItem;
    }
}