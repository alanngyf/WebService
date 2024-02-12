/**
 * @author alanulog
 * @create 2024-02-12 9:26 AM
 *
 * 思路
 * - 啓動socket服務後，循環接收瀏覽器請求
 * - 接收到請求之後，將流中的數據取出
 * - 判斷目標資源是否存在，
 *   - 若不存在，返回404
 *   - 若存在，將目標資源通過輸出流響應給客戶端
 *
 * class
 *   - Server: 開啓socket服務
 *   - Request: 封裝請求，處理請求的相關業務
 *   - Response: 封裝響應，處理響應的相關業務
 *   - Test: 測試類
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Server startup successfully");
        MyHttpServer server = new MyHttpServer();
        server.receiving();

    }
}
