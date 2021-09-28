package com.nepalaya.threadbasics;

public class User implements Runnable {

    private Account account;
    private Transaction transaction;

    public User(Account account, Transaction transaction) {
        this.account = account;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        transaction.process(account);
    }
}


