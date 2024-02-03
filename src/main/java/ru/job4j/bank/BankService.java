package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = getAccounts(user);
        if (user != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        for (Account account : accounts) {
            if (requisite.equals(account.getRequisite())) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null
                && destAccount != null
                && amount > 0
                && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}