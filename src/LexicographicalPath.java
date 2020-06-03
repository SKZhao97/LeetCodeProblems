import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 * https://leetcode.com/problems/lexicographical-numbers/
 * June 2nd
 */
public class LexicographicalPath {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res){
        if(!(cur > n)) {
            res.add(cur);
            for(int i = 0; i < 10; i++) {
                if(10 * cur + i > n)
                    return;
                dfs(10 * cur + i, n, res);
            }
        }
    }

    public static void main(String[] args) {
        LexicographicalPath lexicographicalPath = new LexicographicalPath();
        System.out.println(lexicographicalPath.lexicalOrder(13));
    }
}
