import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 * June 28th
 */
public class Codec {

    private static final String BASE_URL = "https://tinyurl.com/";
    private final int N = 62;
    private final int len = 7;

    char[] chars = new char[N];
    int[] cnts = new int[7];
    Map<String, String> cache = new HashMap<>();

    public Codec() {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            chars[i++] = c;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            chars[i++] = c;
        }
        for (char c = '0'; c <= '9'; c++) {
            chars[i++] = c;
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (cache.containsKey(longUrl)) {
            return cache.get(longUrl);
        }
        StringBuilder sb = new StringBuilder();
        int inc = 1;
        for (int i = len - 1; i >= 0; i--) {
            cnts[i] += inc;
            inc = cnts[i] / N;
            cnts[i] = cnts[i] % N;
            sb.insert(0, chars[cnts[i]]);
        }
        sb.insert(0, BASE_URL);
        cache.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return cache.getOrDefault(shortUrl, shortUrl);
    }
    public static void main(String[] args) {
        String url= "https://leetcode.com/problems/design-tinyurl";
        Codec codec = new Codec();
        codec.decode(codec.encode(url));
    }
}
