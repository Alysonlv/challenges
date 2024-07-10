package corp.alv.challenges.interview;

import corp.alv.challenges.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
Instructions
Your task is to implement a simplified version of a banking system. All operations that should be supported are listed below.

Solving this task consists of several levels. Subsequent levels are opened when the current level is correctly solved. You always have access to the data for the current and all previous levels.

Requirements
Your task is to implement a simplified version of a banking system. Plan your design according to the level specifications below:

Level 1: The banking system should support creating new accounts, depositing money into accounts, and transferring money between two accounts.

Expand to see level 1 details.
Level 2: The banking system should support ranking accounts based on the total value of outgoing transactions.

Level 3: The banking system should allow scheduling payments and checking the status of scheduled payments.

Level 4: The banking system should support merging two accounts while retaining both accounts' balance and transaction histories.

To move to the next level, you should pass all the tests at the current level.

Note

You will receive a list of queries to the system, and the final output should be an array of strings representing the returned values of all queries. Each query will only call one operation.

All operations will have a timestamp parameter — a stringified timestamp in milliseconds. It is guaranteed that all timestamps are unique and are in a range from 1 to 109. Operations will be given in order of strictly increasing timestamps.

Level 2
The bank wants to identify people who are not keeping money in their accounts, so implement operations to support ranking accounts based on outgoing transactions.

TOP_SPENDERS <timestamp> <n> — should return identifiers of the top n accounts with the highest amount of outgoing transactions - the total amount of money either transferred out of or paid/withdrawn (via the SCHEDULE_PAYMENT operation which will be introduced in level 3) - sorted in descending order, or in case of a tie, sorted alphabetically by accountId in ascending order. The output should be a string in the following format: "<accountId1>(<totalOutgoing1>), <accountId2>(<totalOutgoing2>), ..., <accountIdN>(<totalOutgoingN>)".
If less than n accounts exist in the system, then return all their identifiers (in the described format).
Examples
The example below shows how these operations should work (the section is scrollable to the right):

Queries	Explanations
queries = [
  ["CREATE_ACCOUNT", "1", "account3"],
  ["CREATE_ACCOUNT", "2", "account2"],
  ["CREATE_ACCOUNT", "3", "account1"],
  ["DEPOSIT", "4", "account1", "2000"],
  ["DEPOSIT", "5", "account2", "3000"],
  ["DEPOSIT", "6", "account3", "4000"],
  ["TOP_SPENDERS", "7", "3"],
  ["TRANSFER", "8", "account3", "account2", "500"],
  ["TRANSFER", "9", "account3", "account1", "1000"],
  ["TRANSFER", "10", "account1", "account2", "2500"],
  ["TOP_SPENDERS", "11", "3"]
]

returns "true"
returns "true"
returns "true"
returns "2000"
returns "3000"
returns "4000"
returns "account1(0), account2(0), account3(0)"; none of the accounts have any outgoing transactions, so they are sorted alphabetically
returns "3500"
returns "2500"
returns "500"
returns "account1(2500), account3(1500), account2(0)"

the output should be ["true", "true", "true", "2000", "3000", "4000", "account1(0), account2(0), account3(0)", "3500", "2500", "500", "account1(2500), account3(1500), account2(0)"].

Input/Output

[execution time limit] 3 seconds (java)

[memory limit] 1 GB

[input] array.array.string queries

An array of queries to the system. It is guaranteed that all the queries parameters are valid: each query calls one of the operations described in the description, all operation parameters are given in the correct format, and all conditions required for each operation are satisfied.

Guaranteed constraints:
1 ≤ queries.length ≤ 500.

[output] array.string

An array of strings representing the returned values of queries.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

 */
public class Circle_Second {
    public static final String CREATE_ACCOUNT = "CREATE_ACCOUNT";
    public static final String DEPOSIT = "DEPOSIT";
    public static final String TRANSFER = "TRANSFER";
    public static final String TOP_SPENDERS = "TOP_SPENDERS";
    public static final String MERGE = "MERGE";
    public static final String SCHEDULE_PAYMENT = "SCHEDULE_PAYMENT";
    public static final String PAYMENT_STATUS = "PAYMENT_STATUS";
    public static final String EXECUTE_PAYMENT = "EXECUTE_PAYMENT";

    Map<String, Account> accounts = new HashMap<>();
    Map<String, Double> outgoingOperations = new HashMap<>();
    Map<String, List<Payment>> scheduler = new HashMap<>();

    String[] solution(String[][] queries) throws NumberFormatException {
        String[] result = new String[queries.length];

        for (int index = 0; index < queries.length; index++) {
            String[] query = queries[index];
            String command = query[0];

            switch (command) {
                case CREATE_ACCOUNT: {
                    result[index] = "" + createAccount(query[1], query[2]);
                    break;
                }
                case DEPOSIT: {
                    result[index] = "" + deposit(query[1], query[2], query[3]);
                    break;
                }
                case TRANSFER: {
                    result[index] = transfer(query[1], query[2], query[3], query[4]);
                    break;
                }
                case TOP_SPENDERS: {
                    result[index] = getTopNSenders(Integer.valueOf(query[2]));
                    break;
                }
                case MERGE: {
                    result[index] = mergeAccounts(query[1], query[2], query[3]);
                    break;
                }
                case SCHEDULE_PAYMENT: {
                    result[index] = schedulePayment(query[1], query[2], query[3]);
                    break;
                }
                case PAYMENT_STATUS: {
                    result[index] = getPaymentStatus(query[1], query[2], query[3]);
                    break;
                }
                case EXECUTE_PAYMENT: {
                    result[index] = executePayment(query[1], query[2], query[3]);
                    break;
                }
            }
        }

        return result;
    }

    private String executePayment(String timestamp, String accountId, String paymentId) {
        List<Payment> payments = scheduler.get(accountId);

        if (payments == null || payments.isEmpty()) {
            return "";
        }

        Account account = accounts.get(accountId);
        Payment payment = payments.stream().filter(p -> p.timestamp.equals(Long.valueOf(paymentId))).findFirst().orElseGet(() -> null);

        if (payment == null || account.balance - payment.amount < 0) {
            return "";
        }

        account.balance -= payment.amount;
        payment.executed = true;

        return accountId + "(" + formatDoubleToString(account.balance) + ")";
    }

    private String getPaymentStatus(String timestamp, String accountId, String paymentId) {
        List<Payment> payments = scheduler.get(accountId);

        if (payments == null || payments.isEmpty()) {
            return "";
        }

        boolean paymentStatus = payments.stream()
                .filter(p -> paymentId.equals(p.timestamp))
                .map(p -> p.executed)
                .findAny()
                .orElseGet(() -> false);

        return paymentStatus ? "EXECUTED" : "SCHEDULED";
    }

    private String schedulePayment(String timestamp, String accountId, String amount) {
        Account account = accounts.get(accountId);
        if (account == null) {
            return "";
        }

        Payment payment = new Payment(timestamp, account, amount);
        List<Payment> payments = scheduler.getOrDefault(accountId, new ArrayList<>());
        payments.add(payment);
        scheduler.put(accountId, payments);
        return accountId + "(" + amount + ")";
    }

    private String mergeAccounts(String timeStamp, String acc1, String acc2) {
        Account account1 = accounts.get(acc1);
        Account account2 = accounts.get(acc2);

        if (account1 == null || account2 == null
                || !account1.isActive() || !account2.isActive()) {
            return "";
        }

        Account acc = new Account(timeStamp, acc1 + acc2, account1.balance + account2.balance);
        accounts.put(acc.accountId, acc);

        account1.deactivateAccount();
        account2.deactivateAccount();

        StringBuilder sb = new StringBuilder();
        sb.append(acc.accountId).append("(").append(formatDoubleToString(acc.balance)).append(")");
        return sb.toString();
    }

    private boolean createAccount(String timestamp, String accountId) {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, new Account(timestamp, accountId));

            return true;
        }
        return false;
    }

    private String deposit(String timestamp, String accountId, String amount) throws NumberFormatException {
        Account account = accounts.get(accountId);

        if (account == null) {
            return "";
        }

        account.balance += Double.valueOf(amount);

        // Deposit op = new Deposit(account, timestamp, amount);
        // operations.put(accountId, op);
        return formatAmount("" + account.balance);
    }

    private String transfer(String timestamp, String sourceAccountId, String targetAccountId, String amount) {
        Account sourceAccount = accounts.get(sourceAccountId);
        Account targetAccount = accounts.get(targetAccountId);
        if (sourceAccount == null || targetAccount == null || sourceAccountId.equals(targetAccountId)) {
            return "";
        }

        double amountToTransfer = Double.valueOf(amount);

        if (sourceAccount.balance < amountToTransfer) {
            return "";
        }

        sourceAccount.balance -= amountToTransfer;
        targetAccount.balance += amountToTransfer;

        Transfer t = new Transfer(timestamp, sourceAccount, targetAccount, amount);
        outgoingOperations.put(sourceAccountId, outgoingOperations.getOrDefault(sourceAccountId, 0.0) + amountToTransfer);

        return formatAmount("" + sourceAccount.balance);
    }

    private String getTopNSenders(int n) {
        StringBuilder sb = new StringBuilder();
        Map<Double, List<String>> map = new TreeMap<>(Collections.reverseOrder());

        if (outgoingOperations.size() == 0) {
            Set<String> accWithoutOutgoing = new TreeSet<>();

            List<String> accs = new ArrayList<>(accounts.keySet());
            Collections.sort(accs);
            int i = 0;
            while (i < n) {
                sb.append(accs.get(i)).append("(0), ");
                i++;
            }

            return sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).toString();
        }

        for (Map.Entry<String, Double> entry : outgoingOperations.entrySet()) {
            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), new ArrayList());
            }

            map.get(entry.getValue()).add(entry.getKey());
        }

        for (List<String> accounts : map.values()) {
            Collections.sort(accounts);
        }

        int count = 0;
        for (Map.Entry<Double, List<String>> entry : map.entrySet()) {

            for (String id : entry.getValue()) {
                sb.append(id).append("(").append(formatAmount("" + entry.getKey())).append(")").append(", ");
                count++;
            }

            if (count == n) {
                break;
            }
        }


        Set<String> accWithoutOutgoing = new TreeSet<>();
        for (String a : accounts.keySet()) {
            if (!outgoingOperations.containsKey(a)) {
                accWithoutOutgoing.add(a);
            }
        }

        for (String notPre : accWithoutOutgoing) {
            sb.append(notPre).append("(0)").append(", ");
            count++;
            if (count == n) {
                break;
            }
        }

        return sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).toString();
    }

    private String formatAmount(String amount) {
        if (amount.charAt(amount.length() - 1) == '0' && amount.charAt(amount.length() - 2) == '.') {
            return amount.substring(0, amount.length() - 2);
        }
        return amount;
    }

    public String formatDoubleToString(double value) {
        return String.format("%.0f", value);
    }

    class Account {
        long timestamp;
        String accountId;
        double balance;
        private boolean active;

        public Account(String timestamp, String accountId) {
            this.timestamp = Integer.valueOf(timestamp);
            this.accountId = accountId;
            this.balance = 0.0;
            this.active = true;
        }

        public Account(String timestamp, String accountId, double balance) {
            this.timestamp = Integer.valueOf(timestamp);
            this.accountId = accountId;
            this.balance = balance;
            this.active = true;
        }

        public void deactivateAccount() {
            this.active = false;
        }

        public boolean isActive() {
            return this.active;
        }
    }

    abstract class Operation {
        Account account;
        Long timestamp;
        double amount;
        boolean executed;
    }

    class Deposit extends Operation {

        public Deposit(Account account, String timestamp, String amount) throws NumberFormatException {
            this.account = account;
            this.timestamp = Long.valueOf(timestamp);
            this.amount = Double.valueOf(amount);
            this.executed = true;
        }
    }

    class Transfer extends Operation {
        Account targetAccount;

        public Transfer(String timestamp, Account sourceAccount, Account targetAccount, String amount) throws NumberFormatException {
            this.timestamp = Long.valueOf(timestamp);
            this.account = sourceAccount;
            this.targetAccount = targetAccount;
            this.amount = Double.valueOf(amount);
            this.executed = true;
        }
    }

    class Payment extends Operation {
        public Payment(String timestamp, Account account, String amount) {
            this.account = account;
            this.timestamp = Long.valueOf(timestamp);
            this.amount = Double.valueOf(amount);
            this.executed = false;
        }
    }

    public static void main(String[] args) {
        String[][] queries = {
                {"CREATE_ACCOUNT", "1", "account3"},
                {"CREATE_ACCOUNT", "2", "account2"},
                {"CREATE_ACCOUNT", "3", "account1"},
                {"CREATE_ACCOUNT", "12", "account4"},
                {"CREATE_ACCOUNT", "13", "account5"},
                {"CREATE_ACCOUNT", "14", "account6"},

                {"DEPOSIT", "4", "account1", "2000"},
                {"DEPOSIT", "5", "account2", "3000"},
                {"DEPOSIT", "6", "account3", "4000"},
                {"DEPOSIT", "15", "account4", "4000"},
                {"DEPOSIT", "16", "account4", "2100"},
                {"DEPOSIT", "17", "account5", "200"},

                {"TOP_SPENDERS", "7", "3"},

                {"TRANSFER", "8", "account3", "account2", "500"},
                {"TRANSFER", "9", "account3", "account1", "1000"},
                {"TRANSFER", "10", "account1", "account2", "2500"},

                {"TOP_SPENDERS", "11", "3"},
                {"TRANSFER", "18", "account4", "account2", "500"},
                {"TRANSFER", "19", "account4", "account1", "500"},
                {"TRANSFER", "20", "account4", "account1", "100"},
                {"TRANSFER", "21", "account4", "account5", "500"},
                {"TRANSFER", "22", "account4", "account5", "500"},
                {"TRANSFER", "23", "account4", "account6", "500"},

                {"TOP_SPENDERS", "24", "3"},
                {"MERGE", "25", "account1", "account2"},
                {"SCHEDULE_PAYMENT", "26", "account4", "10000"},
                {"PAYMENT_STATUS", "27", "account4", "26"},
                {"EXECUTE_PAYMENT", "28", "account4", "26"},
                {"PAYMENT_STATUS", "29", "account4", "26"},

                {"DEPOSIT", "30", "account4", "8000"},
                {"EXECUTE_PAYMENT", "31", "account4", "26"},
                {"PAYMENT_STATUS", "32", "account4", "26"}
        };

        Circle_Second c = new Circle_Second();
        String[] result = c.solution(queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(queries[i]) + " ==> " + result[i]);
        }
    }
}
