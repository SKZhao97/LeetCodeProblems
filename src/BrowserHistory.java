import java.util.ArrayList;
import java.util.List;

/**
 * 1472. Design Browser History
 * https://leetcode.com/problems/design-browser-history/
 * June 6th
 */
public class BrowserHistory {
    List<String> history;
    String current;
    int curIndex;
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        current = homepage;
        history.add(homepage);
        curIndex = 0;
    }

    public void visit(String url) {
        curIndex++;
        current = url;
        int k = history.size();
        for (int i = curIndex; i < history.size(); ) {
            history.remove(i);
        }
        history.add(url);
    }

    public String back(int steps) {
        if (curIndex > steps) {
            curIndex = curIndex - steps;
        } else {
            curIndex = 0;
        }
        current = history.get(curIndex);
        return current;
    }

    public String forward(int steps) {
        if (history.size() - curIndex - 1 > steps) {
            curIndex = curIndex + steps;
        } else {
            curIndex = history.size() - 1;
        }
        current = history.get(curIndex);
        return current;
    }

    public static void main(String[] args) {
//        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
//        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
//        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
//        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
//        System.out.println(browserHistory.history);
//        System.out.println(browserHistory.back(1));                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
//
//        System.out.println(browserHistory.back(1));                 // You are in "facebook.com", move back to "google.com" return "google.com"
//        System.out.println(browserHistory.forward(1));              // You are in "google.com", move forward to "facebook.com" return "facebook.com"
//        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
//        System.out.println(browserHistory.history);
//        System.out.println(browserHistory.forward(2));                // You are in "linkedin.com", you cannot move forward any steps.
//        System.out.println(browserHistory.back(2));                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
//        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com
        BrowserHistory browserHistory = new BrowserHistory("jr");
        browserHistory.visit("uiza.com");
        System.out.println(browserHistory.history);
        System.out.println(browserHistory.forward(3));
        System.out.println(browserHistory.forward(3));
        browserHistory.visit("fve");
        browserHistory.visit("hy");
        System.out.println(browserHistory.back(3));
        System.out.println(browserHistory.curIndex);
        System.out.println(browserHistory.history);
        browserHistory.visit("cccs");
        System.out.println(browserHistory.history);
        browserHistory.visit("bivs");
        System.out.println(browserHistory.forward(6));
        System.out.println(browserHistory.back(1));

    }



//    ["BrowserHistory","visit","forward","forward","visit","visit","back","visit","visit","forward","back","visit","visit","visit","forward","forward","visit","visit","back","visit","forward","visit","visit","visit","back"]
//            [["jrbilt.com"],["uiza.com"],[3],[3],["fveyl.com"],["hyhqfqf.com"],[3],["cccs.com"],["bivz.com"],[6],[1],["cmbw.com"],["iywwwfn.com"],["sktbhdx.com"],[8],[10],["bskj.com"],["thw.com"],[6],["hgesj.com"],[6],["ctb.com"],["fllnc.com"],["fs.com"],[7]]

}
