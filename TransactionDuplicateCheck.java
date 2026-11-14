package week11;


import java.util.*;

public class TransactionDuplicateCheck {

    static boolean hasDuplicate(String[] transactionIds) {
        HashSet<String> set = new HashSet<>();

        for (String id : transactionIds) {
            if (set.contains(id))
                return true;

            set.add(id);
        }

        return false;
    }

    public static void main(String[] args) {
        String[] a = {
            "TXN001", "TXN002", "TXN003",
            "TXN002", "TXN004"
        };

        String[] b = {
            "TXN001", "TXN002", "TXN003"
        };

        System.out.println(hasDuplicate(a));
        System.out.println(hasDuplicate(b));
    }
}

