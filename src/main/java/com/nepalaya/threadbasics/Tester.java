package com.nepalaya.threadbasics;

public class Tester {

    public static void main(String[] args) {

        Account anitaAccount = new Account();

        System.out.println("Balance before transaction: " + anitaAccount.getBalance());

        final Transaction depositor = (account) -> {
            int amount = 1;
            for (int i = 1; i <= 10; i++) {
                account.deposit(amount);
            }
        };

        final Transaction withdrawal = (account) -> {
            int amount = 1;
            for (int i = 1; i <= 10; i++) {
                account.withDraw(amount);
            }
        };

        for (int i = 1; i <= 10000; i++) {
                new Thread(new User(anitaAccount, depositor)).start();
        }

        for (int i = 1; i <= 10000; i++) {
            new Thread(new User(anitaAccount, withdrawal)).start();
        }


        try {
            Thread.sleep(10000);
            System.out.println("Balance after transaction: " + anitaAccount.getBalance());
        }catch (Exception ex){
            System.out.println("Error");
        }
    }
}
