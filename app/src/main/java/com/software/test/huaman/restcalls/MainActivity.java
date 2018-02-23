package com.software.test.huaman.restcalls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.software.test.huaman.restcalls.data.model.BodyObj;
import com.software.test.huaman.restcalls.data.model.Post;
import com.software.test.huaman.restcalls.data.remote.APIService;
import com.software.test.huaman.restcalls.data.remote.APIUtils;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button submitBtn = (Button) findViewById(R.id.btn_submit);


        mAPIService = APIUtils.getAPIService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendPost();

            }
        });
    }

    public void showErrorMessage() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
    }

    public void sendPost() {


        Log.d(TAG, "sendPost: ");
        BodyObj bodyObj = new BodyObj();
        bodyObj.setClientAppId("");
        bodyObj.setClientDeviceId("");
        bodyObj.setClientWalletAccountId("");
        bodyObj.setConsumerEntryMode("");
        bodyObj.setEncPaymentInstrument("");
        bodyObj.setLocale("");
        bodyObj.setPanSource("");
        try {
            mAPIService.savePost("", bodyObj).enqueue(new Callback<Post>() {
                @Override
                public void onResponse(Call<Post> call, Response<Post> response) {

                    if (response.isSuccessful()) {
                        showResponse(response.body().toString());
                        Log.d(TAG, "post submitted to API." + response.body().toString());
                    }
                    try {
                        Log.d(TAG, "onResponse: raw" + response.raw().toString());
                    } catch (Exception e) {
                        Log.d(TAG, "onResponse errrr: " + e.toString());


                    }

                }

                @Override
                public void onFailure(Call<Post> call, Throwable t) {

                    showErrorMessage();
                    t.ge
                    //    Log.e(TAG, "Unable to submit post to API.");
                    Log.d(TAG, "onFailure: " +t.toString());
                }
            });
        }catch (Exception e){
            Log.d(TAG, "sendPost: "+e.toString());
        }

        Digest digest = new SHA256Digest();
        String token =  hmacToString("input", "key".getBytes(), digest);
    }



    private String hmacToString(String toEncode, byte[] key, Digest digest) {
        byte[] resBuf = hmac(toEncode, key, digest);
        return resBuf.toString()
    }

    public byte[] hmac(String toEncode, byte[] key, Digest digest) {
        HMac hmac = new HMac(digest);
        byte[] resBuf = new byte[hmac.getMacSize()];
        byte[] plainBytes = toEncode.getBytes();
        byte[] keyBytes = key;
        hmac.init(new KeyParameter(keyBytes));
        hmac.update(plainBytes, 0, plainBytes.length);
        hmac.doFinal(resBuf, 0);
        return resBuf;
    }


   /*

   Example of cancelling a request

   private Call<Post> mCall;
    public sendPost(String title, String body) {
        mCall = mAPIService.savePost(title, body, 1);
        mCall.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                if(call.isCanceled()) {
                    Log.e(TAG, "request was aborted");
                }else {
                    Log.e(TAG, "Unable to submit post to API.");
                }
                showErrorMessage();

            }
        });
    }

    public void cancelRequest() {
        mCall.cancel();
    }*/

    public void showResponse(String response) {
        Log.d(TAG, "showResponse: "+response);
    }
}
