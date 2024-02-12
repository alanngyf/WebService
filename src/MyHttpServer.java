import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author alanulog
 * @create 2024-02-12 10:38 PM
 */
public class MyHttpServer {
    // port
    private int port = 8080;

    // 接收請求的方法
    public void receiving() {
        try {
            // 創建 Socket Service
            ServerSocket serverSocket = new ServerSocket(port);
            // 循環接收請求
            while (true) {
                // 獲取連接對象
                Socket socket = serverSocket.accept();
                // 獲取連接對象的輸入流
                InputStream inputStream = socket.getInputStream();
                // 創建 Request
                MyHttpRequest request = new MyHttpRequest(inputStream);
                // 解析請求
                request.parse();
                OutputStream outputStream = socket.getOutputStream();
                // 創建 Reponse
                MyHttpResponse response = new MyHttpResponse(outputStream);
                // 進行響應
                response.sendRedirect(request.getUri());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
