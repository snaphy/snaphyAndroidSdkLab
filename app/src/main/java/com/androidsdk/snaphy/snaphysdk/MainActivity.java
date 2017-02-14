package com.androidsdk.snaphy.snaphysdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.DataListCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.ObjectCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;
import com.google.gson.Gson;
import com.strongloop.android.loopback.RestAdapter;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public RestAdapter restAdapter;
    SnaphyHelper snaphyHelper;
    MainActivity mainActivity;
    String TAG = "SNAPHY_SDK_MAINACTIVITY";
    final ChatPresenter chatPresenter = new ChatPresenter();

 /*   private Manager manager;
    {
        try {
            this.manager = new Manager(new URI(Constants.baseUrl));
        } catch (URISyntaxException e) {
            Log.e(TAG, e.toString());
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        setContentView(R.layout.activity_main);
        snaphyHelper = new SnaphyHelper(this);
        restAdapter = snaphyHelper.getLoopBackAdapter();
        //readChatData();
        subscribe();
    }

   /* *//**
     * Will create namespace if not present on the server..
     * @param where
     * @param jsonObjectObjectCallback
     *//*
    private void createNameServerIfNotExists(HashMap<String, String> where, final ObjectCallback<JSONObject> jsonObjectObjectCallback){
        try {
            //Calling through reflection..
            Method method = dataRepository.getClass().getMethod("subscribe", Map.class, ObjectCallback.class);
            method.invoke(dataRepository, where, jsonObjectObjectCallback);
        } catch (Exception e) {
            Log.e("SocketError", e.toString());
        }
    }

*/

    private void subscribe(){
        final ChatRepository chatRepository = restAdapter.createRepository(ChatRepository.class);
        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("from", "brand");
        SnaphySocket<Chat, ChatRepository> chatChatRepositorySnaphySocket = new SnaphySocket<>(mainActivity, chatRepository, hashMap);
        chatChatRepositorySnaphySocket.subscribe(new Subscribe<Chat>() {
            @Override
            public void onDataAdded(Chat data) {
                super.onDataAdded(data);
            }

            @Override
            public void onDataUpdated(Chat data) {
                super.onDataUpdated(data);
            }

            @Override
            public void onDataDeleted(Chat data) {
                super.onDataDeleted(data);
            }
        });

        //chatRepository.subscribe(hashMap);

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
