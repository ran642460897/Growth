package com.example.growth.modules.smack;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.growth.R;
import com.example.growth.modules.main.BaseActivity;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;

import java.io.IOException;

/**
 * Creator:ran
 * Date:2016-02-19 12:55
 * Note:
 */
public class SmackActivity extends BaseActivity {
    private EditText account;
    private EditText psd;
    private Button login;
    private Button logout;
    private TextView state;

    private AbstractXMPPConnection connection;
    private Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smack);
        initView();
    }
    private void initView(){
        account=(EditText)findViewById(R.id.smack_account);
        psd=(EditText)findViewById(R.id.smack_psd);
        state=(TextView)findViewById(R.id.smack_state);
        login=(Button)findViewById(R.id.smack_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String s1 = account.getText().toString().trim();
                        String s2 = psd.getText().toString().trim();
                        if (!TextUtils.isEmpty(s1)&&!TextUtils.isEmpty(s2)) {
                            con(s1,s2);
                        }
                        else{
                            Looper.prepare();
                            alter("帐号或密码不能为空！");
                            Looper.loop();
                        }
                    }
                });
                thread.start();
            }
        });
        logout=(Button)findViewById(R.id.smack_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
    private void con(String account,String psd){
        XMPPTCPConnectionConfiguration.Builder configBuilder=XMPPTCPConnectionConfiguration.builder();
        configBuilder.setUsernameAndPassword("test", "test");
        configBuilder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        configBuilder.setResource("SmackAndroidTestClient");
        configBuilder.setServiceName("192.168.1.100");

        configBuilder.setDebuggerEnabled(true);
        SASLAuthentication.unBlacklistSASLMechanism("PLAIN");
        SASLAuthentication.blacklistSASLMechanism("DIGEST-MD5");
        connection=new XMPPTCPConnection(configBuilder.build());
        connection.addConnectionListener(new XMPPConnectionListener());

        try {
            Log.d("xmpp", "it will connect!");
            connection.connect();
            Log.d("xmpp", "it has connected!");
            Log.d("xmpp", "it will login!");
            connection.login();
            Log.d("xmpp", "it has logged in!");
            register(account,psd);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    state.setText("已登录");
                    login.setEnabled(false);
                    state.setText("创建成功");
                }
            });
        } catch (SmackException e) {
            e.printStackTrace();
            Log.d("xmpp", "SmackException!");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("xmpp", "IOException!");
        } catch (XMPPException e) {
            e.printStackTrace();
            Log.d("xmpp", "XMPPException!");
        }
    }
    private void register(String account,String psd){
        AccountManager manager=AccountManager.getInstance(connection);
        manager.sensitiveOperationOverInsecureConnection(true);
        try {
            manager.createAccount(account,psd);
        } catch (SmackException.NoResponseException e) {
            e.printStackTrace();
        } catch (XMPPException.XMPPErrorException e) {
            e.printStackTrace();
        } catch (SmackException.NotConnectedException e) {
            e.printStackTrace();
        }
    }

//    private void logout(){
//        if(connection!=null) {
//            try {
//                AccountManager manager=AccountManager.getInstance(connection);
//                manager.deleteAccount();
//            } catch (SmackException.NoResponseException e) {
//                e.printStackTrace();
//            } catch (XMPPException.XMPPErrorException e) {
//                e.printStackTrace();
//            } catch (SmackException.NotConnectedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    class XMPPConnectionListener implements ConnectionListener {
        @Override
        public void connected(XMPPConnection connection) {
            Log.d("xmpp", "connected!");
        }

        @Override
        public void authenticated(XMPPConnection connection, boolean resumed) {
            Log.d("xmpp", "authenticated!");
        }

        @Override
        public void connectionClosed() {
            Log.d("xmpp", "connectionClosed!");
        }

        @Override
        public void connectionClosedOnError(Exception e) {
            Log.d("xmpp", "connectionClosedOnError!");
        }

        @Override
        public void reconnectionSuccessful() {
            Log.d("xmpp", "reconnectionSuccessful!");
        }

        @Override
        public void reconnectingIn(int seconds) {
            Log.d("xmpp", "reconnectingIn!");
        }

        @Override
        public void reconnectionFailed(Exception e) {
            Log.d("xmpp", "reconnectionFailed!");
        }
    }

}
