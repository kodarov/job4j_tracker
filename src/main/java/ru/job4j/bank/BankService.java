package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Бизнес логика банковских операций. Описывает базовые операции
 * со счетами - {@link Account} и пользователями - {@link User}
 *
 * @author Salavat Kodarov
 * @version 1.0
 */
public class BankService {
    /**
     * Описывает всех пользователей и их счета.
     *
     * @since 1.0
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя {@link User} в карту users если его еще нет.
     *
     * @param user новый пользователь.
     * @since 1.0
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя {@link User} из карты users
     *
     * @param passport серия и номер паспорта
     * @since 1.0
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет по серии и номеру паспорта,
     * если пользователь существует в карте users.
     *
     * @param passport серия и номер паспорта
     * @param account  счет пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Поиск пользователя по серии и номеру паспорта, возвращает
     * null если не найден.
     *
     * @param passport серии и номеру паспорта
     * @return {@link User} или null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Поиск счета по серии и номеру паспорта и реквизиту,
     * возвращает null если не найден.
     *
     * @param passport  серия и номер паспорта
     * @param requisite реквизит счета
     * @return {@link Account} счет или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Транзакция по указанным реквизитам и паспортным данным пользователя.
     * Проверяет на существование всех указанных счетов в системе и наличие достаточного
     * баланса у отправителя, иначе возвращает false.
     *
     * @param sourcePassport       серия и номер паспорта отправителя
     * @param sourceRequisite      реквизит счета отправителя
     * @param destinationPassport  серия и номер паспорта получателя
     * @param destinationRequisite реквизит счета получателя
     * @param amount               сумма транзакции
     * @return {@code true} или {@code false} успешность операции транзакции
     * @since 1.0
     */
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

    /**
     * Получение всех счетов пользователя
     *
     * @param user пользователь у которого ищем счета
     * @return {@code List<Account>} все счета пользователя
     * @since 1.0
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}