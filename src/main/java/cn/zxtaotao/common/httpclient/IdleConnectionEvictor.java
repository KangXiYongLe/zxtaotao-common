package cn.zxtaotao.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 定期关闭无效的连接，另开一个线程，用于关闭连接
 * @author zengkang
 *
 */
public class IdleConnectionEvictor extends Thread {
    private final HttpClientConnectionManager connMgr;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;

        start();
    }

    public void run() {
        try {
            while (!this.shutdown) {
                synchronized (this) {
                    wait(5000L);

                    this.connMgr.closeExpiredConnections();
                }
            }
        } catch (InterruptedException localInterruptedException) {
        }
    }

    public void shutdown() {
        this.shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
