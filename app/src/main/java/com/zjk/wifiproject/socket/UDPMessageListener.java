package com.zjk.wifiproject.socket;

import android.content.Context;

import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ������Ϣ���߳�
 * Created by Administrator on 2015/4/26.
 */
public class UDPMessageListener implements Runnable {


    private static final int POOL_SIZE = 5; //����cpu�̸߳���
    private static final int BUFFERLENGTH = 1024; //�����С

    private static String BROADCASTIP;
    /**
     * ����ģʽ
     */
    private static UDPMessageListener udpMessageListener;
    private final ExecutorService exector;
    private Context context;
    private boolean isThreadRunning;
    private DatagramSocket udpSocket;
    private byte[] sendBuffer = new byte[BUFFERLENGTH];
    private byte[] receiveBuffer = new byte[BUFFERLENGTH];
    private DatagramPacket receiveDataPacket;
    private Thread receiveUDPThread;

    private UDPMessageListener(Context context) {

        this.context = context;
        BROADCASTIP = "255.255.255.255";

        int cpuNumber = Runtime.getRuntime().availableProcessors();
        exector = Executors.newFixedThreadPool(cpuNumber * POOL_SIZE); //����CPU��Ŀ��ʼ���̳߳�

    }

    /**
     * ����UDPMessageListener��ʵ��
     *
     * @param context
     * @return
     */
    public static UDPMessageListener getInstance(Context context) {
        if (udpMessageListener == null) {
            udpMessageListener = new UDPMessageListener(context);
        }
        return udpMessageListener;
    }


    @Override
    public void run() {

        while (isThreadRunning) {

            try {
                udpSocket.receive(receiveDataPacket);
            } catch (IOException e) {
                e.printStackTrace();


                //�����쳣
                receiveDataPacket = null;
                stopUDPSocketThread();

                if (udpSocket != null) {
                    udpSocket = null;
                    udpSocket.close();
                }
                Logger.e("UDP���ݰ�����ʧ�ܣ�ֹͣ�߳�");
                break;
            }

            if (receiveDataPacket.getLength() == 0) {
                Logger.e("�޷�����UDP���ݻ��߽��յ���UDP����Ϊ��");
                continue;
            }

            String UDPListenResStr = "";
            try {
                UDPListenResStr = new String(receiveBuffer, 0, receiveDataPacket.getLength(), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Logger.e("ϵͳ��֧��GBK����");
            }


        }
    }

    /**
     * ����Socket����
     */
    public void connectUDPSocket() {

        try {
            //�󶨶˿�
            if (udpSocket == null) {
                udpSocket = new DatagramSocket(IPMSGCons.PORT);
                Logger.i("connectUDPSocket()�󶨶˿ڳɹ�");
            }

            //�������ݽ��ܰ�
            if (receiveDataPacket == null) {
                receiveDataPacket = new DatagramPacket(receiveBuffer, BUFFERLENGTH);
            }

            startUDPSocketThread();


        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private void startUDPSocketThread() {
        if (receiveUDPThread == null) {
            receiveUDPThread = new Thread(this);
            receiveUDPThread.start();
        }
        isThreadRunning = true;
        Logger.i("�����߳�");
    }

    private void stopUDPSocketThread() {
        isThreadRunning = false;
        if (receiveUDPThread != null) {
            receiveUDPThread.interrupt();
        }
        receiveUDPThread = null;
        udpMessageListener = null; //�ÿգ�������̬��������
        Logger.i("ֹͣ�߳�");
    }

}
