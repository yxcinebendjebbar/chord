import java.math.BigInteger;

public class NodeInfo {
    public BigInteger id;
    public String ip;
    public int port;

    public NodeInfo(BigInteger id, String ip, int port) {
        this.id = id;
        this.ip = ip;
        this.port = port;
    }

    @Override
    public String toString() {
        return id + " " + ip + " " + port;
    }
}
