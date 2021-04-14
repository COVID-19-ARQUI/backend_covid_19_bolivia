package com.example.demo.domain;

import java.util.Date;

public class Transaction {
    private Integer txId;
    private String txHost;
    private Integer txUserUd;
    private Date txDate;

    public Transaction() {
    }

    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Integer getTxUserUd() {
        return txUserUd;
    }

    public void setTxUserUd(Integer txUserUd) {
        this.txUserUd = txUserUd;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txId=" + txId +
                ", txHost='" + txHost + '\'' +
                ", txUserUd=" + txUserUd +
                ", txDate=" + txDate +
                '}';
    }
}
