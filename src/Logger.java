import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 * https://leetcode.com/problems/logger-rate-limiter/
 * June 20th
 */
class Logger {

    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }
        int time = map.get(message);
        if (time <= timestamp - 10) {
            map.put(message, timestamp);
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2,"bar"));
        System.out.println(logger.shouldPrintMessage(3,"foo"));
        System.out.println(logger.shouldPrintMessage(8,"bar"));
        System.out.println(logger.shouldPrintMessage(10,"foo"));
        System.out.println(logger.shouldPrintMessage(11,"foo"));
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */