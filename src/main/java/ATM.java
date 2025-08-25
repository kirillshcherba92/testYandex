import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 * <p>
 * Другие валюты и номиналы должны легко добавляться разработчиками в будущем.
 * Многопоточные сценарии могут быть добавлены позже (например резервирование).
 */


public class ATM {

    private final Map<Integer, Integer> moneysMap = new HashMap<>(); // переделал бы под enumMap

    public void getMoney(Userr user, long amount) {
        final BigDecimal balance = user.getBalance();
        final BigDecimal amountBifGec = BigDecimal.valueOf(amount);
        if (balance.compareTo(amountBifGec) < 0) {
            throw new IllegalArgumentException("Требуемая сумма больше вашего баланса");
        }

        if (Long.parseLong(String.valueOf(moneysMap.values().stream().reduce(Integer::sum))) < amount) {
            throw new IllegalArgumentException("В банкомате нет такой сумммы");
        }

        if (amount % 50 != 0) {
            throw new IllegalArgumentException("Введена не корректная сумма для снятия");
        }

        if (!checkAmountForNominals(amount)) {
            throw new IllegalArgumentException("НЕ могу выдать запрашиваемую сумму");
        }


        user.setBalance(balance.subtract(amountBifGec));
    }

    public void addToMoneys(int nominal, int count) {
        moneysMap.put(nominal, moneysMap.get(nominal) + count);
    }

    public void takeNominalsMoney(int nominal, int count) {
        moneysMap.put(nominal, moneysMap.get(nominal) - count);
    }

    private boolean checkAmountForNominals(long amount) {
        AtomicBoolean result = new AtomicBoolean(false);

        moneysMap.entrySet().forEach(integerIntegerEntry -> {
            result.set(result.get() || checkNominals(integerIntegerEntry.getKey(), amount));
        });
        return result.get();
    }

    private boolean checkNominals(int nominal, long amount) {
        return moneysMap.get(nominal) >= amount / nominal;
    }

    private void sub(long amount) {
        if (checkNominals(Nominals.N5000.getNumber(), amount)) {
            final int count = (int) (amount / Nominals.N5000.getNumber());
            takeNominalsMoney(Nominals.N5000.getNumber(), count);
        }
        //TODO: реализовал бы через EnumMap и функциональный интерфейс.
    }
}
