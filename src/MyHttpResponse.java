import java.io.*;

/**
 * @author alanulog
 * @create 2024-02-12 10:29 AM
 */
public class MyHttpResponse {

    private OutputStream outputStream;

    public MyHttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void sendRedirect(String uri){
        /**
         *  判斷目標資源是否存在，
         *  - 若不存在，返回404
         *   若存在，將目標資源通過輸出流響應給客戶端
         */
        System.out.println(System.getProperty("user.dir") + "/WebContent" + uri);

        File file = new File(System.getProperty("user.dir") + "/WebContent" + uri);
        if (file.exists()) {
            try {
                // 返回目標資源數據
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                fileInputStream.read(bytes);
                String result = new String(bytes);
                String response = getResponseMessage("200", result);
                this.outputStream.write(response.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                // return 404
                String error = getResponseMessage("404", "404, " + uri + " File Not Found!");
                System.out.println(error);
                this.outputStream.write(error.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getResponseMessage(String code, String message) {
        return "HTTP/1.1 " + code + "\r\n"
                + "Content-type: text/html\r\n"
                + "Content-length: " + message.length()
                + "\r\n"
                + "\r\n"
                + message;
    }

}
