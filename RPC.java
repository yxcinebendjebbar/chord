import java.io.*;
import java.net.*;
import java.math.BigInteger;

public class RPC {

    static NodeInfo findSuccessor(NodeInfo n, BigInteger id) {
        return request(n, "FIND_SUCCESSOR " + id);
    }

    static NodeInfo getPredecessor(NodeInfo n) {
        return request(n, "GET_PREDECESSOR");
    }

    static void notify(NodeInfo n, NodeInfo self) {
        request(n, "NOTIFY " + self.id + " " + self.ip + " " + self.port);
    }

    private static NodeInfo request(NodeInfo n, String msg) {
        try (Socket s = new Socket(n.ip, n.port);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            out.println(msg);
            String res = in.readLine();
            if (res == null || res.equals("NULL")) return null;

            String[] p = res.split(" ");
            return new NodeInfo(new BigInteger(p[1]), p[2], Integer.parseInt(p[3]));
        } catch (Exception e) {
            return null;
        }
    }
}
