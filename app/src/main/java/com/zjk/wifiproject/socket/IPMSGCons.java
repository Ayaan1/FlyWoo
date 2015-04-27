package com.zjk.wifiproject.socket;

/**
 * һЩ������
 * Created by Administrator on 2015/4/27.
 */
public class IPMSGCons {

    public static final int VERSION = 0x001;		// �汾��
    public static final int PORT = 0x0979;			// �˿ںţ��ɸ�Э��Ĭ�϶˿�2425

    public static final int IPMSG_NOOPERATION		 = 0x00000000;	//�������κβ���
    public static final int IPMSG_BR_ENTRY			 = 0x00000001;	//�û�����
    public static final int IPMSG_BR_EXIT		 	 = 0x00000002;	//�û��˳�
    public static final int IPMSG_ANSENTRY			 = 0x00000003;	//ͨ������
    public static final int IPMSG_BR_ABSENCE		 = 0x00000004;	//��Ϊȱϯģʽ

    public static final int IPMSG_BR_ISGETLIST		 = 0x00000010;	//Ѱ����Ч�Ŀ��Է����û��б�ĳ�Ա
    public static final int IPMSG_OKGETLIST			 = 0x00000011;	//֪ͨ�û��б��Ѿ����
    public static final int IPMSG_GETLIST			 = 0x00000012;	//�û��б�������
    public static final int IPMSG_ANSLIST			 = 0x00000013;	//Ӧ���û��б�������

    public static final int IPMSG_SENDMSG    		 = 0x00000020;	//������Ϣ
    public static final int IPMSG_RECVMSG 			 = 0x00000021;	//ͨ���յ���Ϣ
    public static final int IPMSG_READMSG 			 = 0x00000030;	//��Ϣ��֪ͨ
    public static final int IPMSG_DELMSG 			 = 0x00000031;	//��Ϣ����֪ͨ
    public static final int IPMSG_ANSREADMSG		 = 0x00000032;	//��Ϣ��ȷ��֪ͨ

    public static final int IPMSG_GETINFO			 = 0x00000040;	//���IPMSG�汾��Ϣ
    public static final int IPMSG_SENDINFO			 = 0x00000041;	//����IPMSG�汾��Ϣ

    public static final int IPMSG_GETABSENCEINFO	 = 0x00000050;	//���ȱϯ��Ϣ
    public static final int IPMSG_SENDABSENCEINFO	 = 0x00000051;	//����ȱϯ��Ϣ

    public static final int IPMSG_UPDATE_FILEPROCESS = 0x00000060;  //�����ļ��������
    public static final int IPMSG_SEND_FILE_SUCCESS  = 0x00000061;  //�ļ����ͳɹ�
    public static final int IPMSG_GET_FILE_SUCCESS   = 0x00000062;  //�ļ����ճɹ�

    public static final int IPMSG_REQUEST_IMAGE_DATA = 0x00000063;  //ͼƬ��������
    public static final int IPMSG_CONFIRM_IMAGE_DATA = 0x00000064;  //ͼƬ����ȷ��
    public static final int IPMSG_SEND_IMAGE_SUCCESS = 0x00000065;  //ͼƬ���ͳɹ�
    public static final int IPMSG_REQUEST_VOICE_DATA = 0x00000066;  //¼����������
    public static final int IPMSG_CONFIRM_VOICE_DATA = 0x00000067;  //¼������ȷ��
    public static final int IPMSG_SEND_VOICE_SUCCESS = 0x00000068;  //¼�����ͳɹ�
    public static final int IPMSG_REQUEST_FILE_DATA  = 0x00000069;  //�ļ���������
    public static final int IPMSG_CONFIRM_FILE_DATA  = 0x00000070;  //�ļ�����ȷ��

    public static final int IPMSG_GETPUBKEY			 = 0x00000072;	//���RSA��Կ
    public static final int IPMSG_ANSPUBKEY			 = 0x00000073;	//Ӧ��RSA��Կ

    /* option for all command */
    public static final int IPMSG_ABSENCEOPT 		 = 0x00000100;	//ȱϯģʽ
    public static final int IPMSG_SERVEROPT 		 = 0x00000200;	//��������������
    public static final int IPMSG_DIALUPOPT 		 = 0x00010000;	//���͸�����
    public static final int IPMSG_FILEATTACHOPT 	 = 0x00200000;	//�����ļ�
    public static final int IPMSG_ENCRYPTOPT		 = 0x00400000;	//����


}
