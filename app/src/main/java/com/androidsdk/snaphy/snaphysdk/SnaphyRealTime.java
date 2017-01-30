package com.androidsdk.snaphy.snaphysdk;

import android.util.Log;

import com.androidsdk.snaphy.snaphyandroidsdk.list.Util;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Manager;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by snaphy on 30/1/17.
 */

public class SnaphyRealTime {
    private ChatRepository chatRepository;
    private HashMap<String, String> where;
    private Socket socket;
    private String room = "";
    private String namespace = "";
    private String TAG = "Snaphy";
    private MainActivity mainActivity;
    private Manager manager;
    {
        try {
            this.manager = new Manager(new URI(Constants.baseUrl));
        } catch (URISyntaxException e) {
            Log.e("Snaphy", e.toString());
        }
    }

    public SnaphyRealTime(MainActivity mainActivity, ChatRepository chatRepository, HashMap<String, String> where){
        this.mainActivity = mainActivity;
        this.chatRepository = chatRepository;
        this.where = where;
        //Get the room and namespace.
        getDetails();
        Socket socket = manager.socket(namespace);
        socket.connect();
        joinRoom(socket, room);

    }

    private void joinRoom(Socket socket, String room){
        socket.emit("create", room);
    }


    private void getDetails(){
        namespace = "/Chat";
        room = "/";
        // Iterating over keys only
        for (String key : where.keySet()) {
            System.out.println("Key = " + key);
            namespace =  namespace + "/" + key;
            room = room + where.get(key) + "/";
        }
    }


    //Implementing the interface for events..
    public interface Listeners<T> {
        //On Initialization of the Constructors..
        public void onDataAdded(T data);
        // When any Change appears in the list..
        public void onDataUpdated(T data);
        public void onDataDeleted(T data);


    }



    /**
     * Subscriber fires when a new data is to be added.
     * @param onDataReceived
     * @return {SnaphyRealTime} Return self to maintain chaining.
     */
    public SnaphyRealTime onDataAdded(final OnData<Chat> onDataReceived){
        Emitter.Listener onDataAdded = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "NEW DATA ADDED" + data.toString());
                        onDataReceived.onData(chat);
                    }
                });
            }
        };


        //On Data added
        socket.on("POST", onDataAdded);
        return this;
    }


    public void leave(){
        //socket.emit('leave', this.room);
        socket.emit("leave", room);
    }



    /**
     * Subscriber fires when a new data is to be Updated.
     * @param onDataReceived
     * @return {SnaphyRealTime} Return self to maintain chaining.
     */
    public SnaphyRealTime onDataUpdated(final OnData<Chat> onDataReceived){
        Emitter.Listener onDataUpdated = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "DATA UPDATED" + data.toString());
                        onDataReceived.onData(chat);
                    }
                });
            }
        };


        //On Data added
        socket.on("PUT", onDataUpdated);
        return this;
    }



    /**
     * Subscriber fires when a new data is deleted.
     * @param onDataReceived
     * @return {SnaphyRealTime} Return self to maintain chaining.
     */
    public SnaphyRealTime onDataDeleted(final OnData<Chat> onDataReceived){
        Emitter.Listener onDataDeleted = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "DATA Deleted" + data.toString());
                        onDataReceived.onData(chat);
                    }
                });
            }
        };

        //On Data added
        socket.on("PUT", onDataDeleted);
        return this;
    }

    /**
     * Listen for real time data change for onNewData added, deleted and updated..
     * @param onDataReceived
     */
    public void subscribe(final Subscribe<Chat> onDataReceived) {
        Emitter.Listener onDataAdded = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "NEW DATA ADDED" + data.toString());
                        onDataReceived.onDataAdded(chat);
                    }
                });
            }
        };

        //On Data added
        socket.on("POST", onDataAdded);

        /*On Data Updated*/
        Emitter.Listener onDataUpdated = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "DATA UPDATED" + data.toString());
                        onDataReceived.onDataUpdated(chat);
                    }
                });
            }
        };
        //On Data added
        socket.on("PUT", onDataUpdated);


        /*On Data DELETED*/
        Emitter.Listener onDataDeleted = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject data = (JSONObject) args[0];
                        Map<String, Object> ChatData = Util.fromJson(data);
                        Chat chat = chatRepository.createObject(ChatData);
                        Log.i(TAG, "DATA DELETED" + data.toString());
                        onDataReceived.onDataDeleted(chat);
                    }
                });
            }
        };
        //On Data added
        socket.on("DELETE", onDataDeleted);
    }
}
