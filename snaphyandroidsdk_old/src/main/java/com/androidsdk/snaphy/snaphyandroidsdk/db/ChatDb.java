package com.androidsdk.snaphy.snaphyandroidsdk.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;
import com.strongloop.android.loopback.RestAdapter;

import java.util.HashMap;

/**
 * Created by snaphy on 1/2/17.
 */

public class ChatDb extends DbHandler<Chat, ChatRepository> {
    public ChatDb(Context context, RestAdapter restAdapter){
        super(context, "Chat", restAdapter);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE `Chat` IF NOT EXISTS ( id TEXT PRIMARY KEY, added TEXT, updated TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Getting single cont
    public  Chat get__db(Chat chat, String id) {
        if (id != null) {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("Chat", null, "id=?", new String[]{id}, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                HashMap<String, Object> chatHashMap = new HashMap<>();
                String idData = cursor.getString(0);
                if(idData != null){
                    chatHashMap.put("id", idData);
                }


                String object = cursor.getString(1);
                cursor.close();
                db.close(); // Closing database connection
                if (object != null) {
                    HashMap<String, Object> chatHashMap = toHashMap(object);
                    if (chatHashMap != null) {
                        ChatRepository repo = restAdapter.createRepository(ChatRepository.class);
                        return (Chat)repo.createObject(chatHashMap);
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }

            } else {
                return null;
            }
        } else {
            return null;
        }

    }
}




