package com.zjk.wifiproject.activity.wifiap;
/**
 *  WifiAp����
 * @author Administrator
 *
 */
public class WifiApConst {
	 // Wifi״̬ ����
  public static final int CLOSE = 0x001;
  public static final int SEARCH = 0x002;
  public static final int CREATE = 0x003;
  public static final int NOTHING = 0x004;

  // Wifi״̬ ��ϸ
  public static final int ApSearchTimeOut = 0;// ������ʱ
  public static final int ApScanResult = 1;// ������wifi���ؽ��
  public static final int ApConnectResult = 2;// ������wifi�ȵ�
  public static final int ApCreateAPResult = 3;// �����ȵ���
  public static final int ApUserResult = 4;// �û�����������������(����)
  public static final int ApConnected = 5;// ���ӻ�Ͽ�wifi��3.5���ˢ��adapter
  public static final int ApConnectting = 6;// �����ȵ���

  // WifiAP ����
  public static final String PACKAGE_NAME = "com.zjk.wifiproject.activity";
  public static final String FIRST_OPEN_KEY = "version";
  public static final String WIFI_AP_HEADER = "ZChat_";
  public static final String WIFI_AP_PASSWORD = "wifichat123";
}
