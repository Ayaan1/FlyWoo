package com.zjk.wifiproject.socket;

/**
 * �൱�����������ڼ�����Ϣ�������ļ�
 * Created by Administrator on 2015/4/26.
 */
public class SocketServer {


    private MessageListenThread listenThread;

    public static void setInstance(SocketServer instance) {
        SocketServer.instance = instance;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    private boolean isRunning = false;


    //����ģʽ
    private SocketServer(){}

    private static SocketServer instance;

    public synchronized SocketServer getInstance(){
        if(instance==null){
            instance = new SocketServer();
        }
        return instance;
    }


    private void startListen(){
        setIsRunning(true);
        listenThread = new MessageListenThread();
        listenThread.start();
    }

    private void stopListen(){
        setIsRunning(false);
    }


    /**
     * ������Ϣ���߳�
     */
    class MessageListenThread extends  Thread{
        @Override
        public void run() {
            while (true){

                //�����˳�
                if(!isRunning()){
                    break;
                }


            }
        }
    }
}
