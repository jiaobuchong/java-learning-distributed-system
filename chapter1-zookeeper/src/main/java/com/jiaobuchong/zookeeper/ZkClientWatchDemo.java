package com.jiaobuchong.zookeeper;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * 监听 watch 事件
 */
public class  ZkClientWatchDemo {

	public static void main(String[] args) {
		// 创建一个zk客户端
		ZkClient client = new ZkClient("192.168.56.101:2181");
		client.setZkSerializer(new MyZkSerializer());

		client.subscribeDataChanges("/jack/age", new IZkDataListener() {

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				System.out.println("----收到节点被删除了-------------");
			}

			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {
				System.out.println("----收到节点数据变化：" + data + "-------------");
			}
		});

		try {
			Thread.sleep(1000 * 60 * 2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
