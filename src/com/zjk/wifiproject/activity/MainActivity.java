package com.zjk.wifiproject.activity;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zjk.wifiproject.R;
import com.zjk.wifiproject.activity.wifiap.WifiApConst;
import com.zjk.wifiproject.base.BaseActivity;
import com.zjk.wifiproject.util.L;
import com.zjk.wifiproject.util.TextUtils;
import com.zjk.wifiproject.util.WifiUtils;

public class MainActivity extends BaseActivity {

    private Button            btn_creat;
    private WifiUtils         mWifiUtils;
    private CreateAPProcess   mCreateApProcess;
    private ArrayList<String> mWifiApList;     // �����������ȵ��б�

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAction();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites()
                .detectNetwork().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().penaltyLog()
                .penaltyDeath().build());
    }

    private void initView() {
        mWifiUtils = WifiUtils.getInstance(context);
        btn_creat = (Button) findViewById(R.id.btn_creat);
        btn_creat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                createWifi();
            }
        });
    }

    /**
     * ����wifi�ȵ�
     */
    protected void createWifi() {
        //���wifi״̬Ϊ������ر�wifi
        mWifiUtils.closeWifi();
        
        //����wifiap�ȵ�
        mWifiUtils.createWiFiAP(mWifiUtils.createWifiInfo(WifiApConst.WIFI_AP_HEADER + getLocalHostName(),
                WifiApConst.WIFI_AP_PASSWORD, 3, "ap"), true);
        
        if (mCreateApProcess == null) {
            mCreateApProcess = new CreateAPProcess();
        }
        mCreateApProcess.start();
        // mWifiApList.clear();
        // refreshAdapter(mWifiApList);
    }

    /** ��ʼ���ؼ����� **/
    protected void initAction() {
        L.i("zyh",
                "isWifiConnect=" + mWifiUtils.isWifiConnect() + ",WifiApState=" + mWifiUtils.getWifiApState());
        // if ((mSearchApProcess.running))
        // return;

        if (!mWifiUtils.isWifiConnect() && !mWifiUtils.getWifiApState()) {
            mWifiUtils.OpenWifi();
            // mSearchApProcess.start();
            mWifiUtils.startScan();
            // m_FrameLWTSearchAnimation.startAnimation();
            // mLlCreateAP.setVisibility(View.GONE);
            // mTvWifiApTips.setText(R.string.wifiap_text_searchap_searching);
            // mTvWifiApTips.setVisibility(View.VISIBLE);
            // mBtnCreateAp.setBackgroundResource(R.drawable.wifiap_create);
        }
        if (mWifiUtils.isWifiConnect()) {
            this.mWifiUtils.startScan();
            // this.mSearchApProcess.start();
            // this.m_FrameLWTSearchAnimation.startAnimation();
            // this.mLlCreateAP.setVisibility(View.GONE);
            // this.mTvWifiApTips.setText(R.string.wifiap_text_searchap_searching);
            // this.mTvWifiApTips.setVisibility(View.VISIBLE);
            // this.mBtnCreateAp.setBackgroundResource(R.drawable.wifiap_create);
            // this.mIvWifiApIcon.setVisibility(View.GONE);
        }

        if (mWifiUtils.getWifiApState()) {
            // m_FrameLWTSearchAnimation.stopAnimation();
            if (mWifiUtils.getApSSID().startsWith(WifiApConst.WIFI_AP_HEADER)) {
                // mTvWifiApTips.setVisibility(View.GONE);
                // mLlCreateAP.setVisibility(View.VISIBLE);
                // mPBCreatingAP.setVisibility(View.GONE);
                // mBtnCreateAp.setVisibility(View.VISIBLE);
                // mIvWifiApIcon.setVisibility(View.VISIBLE);
                // mBtnCreateAp.setBackgroundResource(R.drawable.wifiap_close);
                // mTvWifiApInfo.setText(getString(R.string.wifiap_text_connectap_succeed)
                // + getString(R.string.wifiap_text_connectap_ssid)
                // + mWifiUtils.getApSSID());
                // isClient = false;
            }
        }
    }

    /**
     * ��ȡWifi�ȵ���
     * 
     * <p>
     * BuildBRAND ϵͳ������ �� BuildMODEL �汾
     * </p>
     * 
     * @return ���� ������+�汾 (String����),���ڴ����ȵ㡣
     */
    public String getLocalHostName() {
        String str1 = Build.BRAND;
        String str2 = TextUtils.getRandomNumStr(3);
        return str1 + "_" + str2;
    }

    public String getPhoneModel() {
        String str1 = Build.BRAND;
        String str2 = Build.MODEL;
        if (-1 == str2.toUpperCase().indexOf(str1.toUpperCase()))
            str2 = str1 + "_" + str2;
        return str2;
    }

    /** handler �첽����UI **/
    public Handler handler = new Handler() {
                               public void handleMessage(Message msg) {
                                   switch (msg.what) {
                                   // ������ʱ
                                       case WifiApConst.ApSearchTimeOut:
                                       // mSearchApProcess.stop();
                                       // m_FrameLWTSearchAnimation.stopAnimation();
                                       // if (mWifiApList.isEmpty()) {
                                       // mTvWifiApTips.setVisibility(View.VISIBLE);
                                       // mTvWifiApTips.setText(R.string.wifiap_text_searchap_empty);
                                       // } else {
                                       // mTvWifiApTips.setVisibility(View.GONE);
                                       // }
                                       break;
                                       // �������
                                       case WifiApConst.ApScanResult:
                                       // int size =
                                       // mWifiUtils.mWifiManager.getScanResults().size();
                                       // if (size > 0) {
                                       // for (int i = 0; i < size; ++i) {
                                       // String apSSID =
                                       // mWifiUtils.mWifiManager.getScanResults()
                                       // .get(i).SSID;
                                       // if
                                       // (apSSID.startsWith(WifiApConst.WIFI_AP_HEADER)
                                       // && !mWifiApList.contains(apSSID)) {
                                       // mWifiApList.add(apSSID);
                                       // refreshAdapter(mWifiApList);
                                       // }
                                       // }
                                       // }
                                       break;
                                       // ���ӳɹ�
                                       case WifiApConst.ApConnectResult:
                                       // mWifiUtils.setNewWifiManagerInfo(); //
                                       // ����wifiInfo
                                       // if
                                       // (mWifiUtils.getSSID().startsWith(WifiApConst.WIFI_AP_HEADER))
                                       // {
                                       // mSearchApProcess.stop();
                                       // m_FrameLWTSearchAnimation.stopAnimation();
                                       // mTvWifiApTips.setVisibility(View.GONE);
                                       // refreshAdapter(mWifiApList);
                                       // isClient = true; // ��ʶ�ͻ���
                                       // }

                                       break;

                                       // �ȵ㴴�����
                                       case WifiApConst.ApCreateAPResult:
                                           mCreateApProcess.stop();
                                       // mPBCreatingAP.setVisibility(View.GONE);
                                       // if (((mWifiUtils.getWifiApStateInt()
                                       // == 3) ||
                                       // (mWifiUtils.getWifiApStateInt() ==
                                       // 13))
                                       // &&
                                       // (mWifiUtils.getApSSID().startsWith(WifiApConst.WIFI_AP_HEADER)))
                                       // {
                                       // mTvWifiApTips.setVisibility(View.GONE);
                                       // mLlCreateAP.setVisibility(View.VISIBLE);
                                       // mBtnCreateAp.setVisibility(View.VISIBLE);
                                       // mIvWifiApIcon.setVisibility(View.VISIBLE);
                                       // mBtnCreateAp.setBackgroundResource(R.drawable.wifiap_close);
                                       // mTvWifiApInfo.setText(getString(R.string.wifiap_text_connectap_succeed)
                                       // +
                                       // getString(R.string.wifiap_text_connectap_ssid)
                                       // + mWifiUtils.getApSSID());
                                       // isClient = false; // �ǿͻ���
                                       //
                                       // } else {
                                       // mBtnCreateAp.setVisibility(View.VISIBLE);
                                       // mBtnCreateAp.setBackgroundResource(R.drawable.wifiap_create);
                                       // mTvWifiApInfo.setText(R.string.wifiap_text_createap_fail);
                                       // }
                                       break;
                                       case WifiApConst.ApConnectting:
                                       // mSearchApProcess.stop();
                                       // m_FrameLWTSearchAnimation.stopAnimation();
                                       // mTvWifiApTips.setVisibility(View.GONE);
                                       break;
                                       case WifiApConst.ApConnected:
                                       // Log.i(TAG, "Apconnected");
                                       // refreshAdapter(mWifiApList);
                                       break;
                                       default:
                                       break;
                                   }
                               }
                           };

    /**
     * �����ȵ��߳���
     * 
     * <p>
     * �߳��������ȵ㴴���Ľ����ͨ��handler����
     * </p>
     */
    class CreateAPProcess implements Runnable {
        public boolean running   = false;
        private long   startTime = 0L;
        private Thread thread    = null;

        CreateAPProcess() {
        }

        public void run() {
            while (true) {
                if (!this.running)
                    return;
                if ((mWifiUtils.getWifiApStateInt() == 3) || (mWifiUtils.getWifiApStateInt() == 13)
                        || (System.currentTimeMillis() - this.startTime >= 30000L)) {
                    Message msg = handler.obtainMessage(WifiApConst.ApCreateAPResult);
                    handler.sendMessage(msg);
                }
                try {
                    Thread.sleep(5L);
                } catch (Exception localException) {
                }
            }
        }

        public void start() {
            try {
                thread = new Thread(this);
                running = true;
                startTime = System.currentTimeMillis();
                thread.start();
            } finally {
            }
        }

        public void stop() {
            try {
                this.running = false;
                this.thread = null;
                this.startTime = 0L;
            } finally {
            }
        }
    }
}
