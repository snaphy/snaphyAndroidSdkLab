package com.androidsdk.snaphy.snaphysdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.DataListCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.ObjectCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Listen;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Util;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Model;
import com.androidsdk.snaphy.snaphyandroidsdk.presenter.Presenter;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Manager;
import com.google.gson.Gson;
import com.strongloop.android.loopback.RestAdapter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public RestAdapter restAdapter;
    SnaphyHelper snaphyHelper;
    MainActivity mainActivity;
    String TAG = "SNAPHY_SDK_MAINACTIVITY";
    final ChatPresenter chatPresenter = new ChatPresenter();;

    private Manager manager;
    {
        try {
            this.manager = new Manager(new URI(Constants.baseUrl));
        } catch (URISyntaxException e) {
            Log.e(TAG, e.toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        setContentView(R.layout.activity_main);
        snaphyHelper = new SnaphyHelper(this);
        restAdapter = snaphyHelper.getLoopBackAdapter();
        readChatData();
        subscribe();
    }



    private void subscribe(){
        ChatRepository chatRepository = restAdapter.createRepository(ChatRepository.class);
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("from", "brand");
        SnaphySocket<Chat, ChatRepository> snaphySocket = new SnaphySocket<>(mainActivity, chatRepository, hashMap);
        snaphySocket.onDataAdded(new OnData<Chat>() {
            @Override
            public void onData(Chat data) {
                Log.e(TAG, data+"");
                Log.e(TAG, "New Data has been added in route");
            }
        });

        snaphySocket.subscribe(new Subscribe<Chat>() {
            @Override
            public void onDataAdded(Chat data) {
                Log.e(TAG, data+"");
                Log.e(TAG, "New Data has been added in route");
            }

            @Override
            public void onDataUpdated(Chat data) {
                Log.e(TAG, data+"");
                Log.e(TAG, "New Data has been updated in route");
            }

            @Override
            public void onDataDeleted(Chat data) {
                Log.e(TAG, data+"");
                Log.e(TAG, "Data has been deleted in route");
            }
        });
    }


    private void readChatData(){
        ChatRepository chatRepository = restAdapter.createRepository(ChatRepository.class);
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("include", "brand");

        final ChatPresenter chatPresenter = new ChatPresenter();

        chatRepository.find(filter, new DataListCallback<Chat>() {
            @Override
            public void onBefore() {
                super.onBefore();
            }

            @Override
            public void onSuccess(DataList<Chat> objects) {
                super.onSuccess(objects);
                Log.i(TAG, "Chat data fetched");


                chatPresenter.getChats().addAll(objects);
                Chat chat = objects.get(0);
                String json = new Gson().toJson(chat.convertMap(), HashMap.class);
                HashMap<String, Object> newData = new Gson().fromJson(json, HashMap.class);
                Log.i(TAG, newData.toString());
            }

            @Override
            public void onError(Throwable t) {
                Log.e(TAG, t.toString());
                super.onError(t);
            }

            @Override
            public void onFinally() {
                super.onFinally();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
