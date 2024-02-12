import java.io.IOException;
import java.io.InputStream;

/**
 * @author alanulog
 * @create 2024-02-12 9:38 AM
 */
public class MyHttpRequest {

    private InputStream inputStream;
    private String uri;

    public MyHttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        try {
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String request = new String(bytes);
            parseUri(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseUri(String request) {
        int index1, index2;
        index1 = request.indexOf(' ') + 1;
        index2 = request.indexOf(' ', index1);
        uri = request.substring(index1, index2);
        System.out.println(uri);
    }

    public String getUri() {
        return this.uri;
    }
}
