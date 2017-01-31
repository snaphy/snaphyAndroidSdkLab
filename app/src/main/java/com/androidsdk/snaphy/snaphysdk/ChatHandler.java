package com.androidsdk.snaphy.snaphysdk;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Util;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;
import com.google.gson.Gson;
import com.strongloop.android.loopback.RestAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by snaphy on 31/1/17.
 */

public class ChatHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    RestAdapter restAdapter;

    private String TAG = "snaphy";
    private String KEY_ID = "ID";
    private String KEY_OBJECT = "OBJECT";

    private String METADATA_DATABASE_NAME_KEY = "snaphy.database.name";

    // Database Name
    private static String DATABASE_NAME;

    // Contacts table name
    private static String TABLE = "CHAT";


    public ChatHandler(Context context, String tableName, RestAdapter restAdapter) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.restAdapter = restAdapter;
        TABLE = tableName;
        try{
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            DATABASE_NAME = (String) ai.metaData.get(METADATA_DATABASE_NAME_KEY);
        }
        catch (Exception e){
            Log.e(TAG, e.toString());

        }

    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE + " IF NOT EXISTS ( ID TEXT PRIMARY KEY, OBJECT TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void save__db (Chat chat) {
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<String, Object> hashMap = (HashMap<String, Object>) chat.convertMap();
        String object = toJsonString(hashMap);
        ContentValues values = new ContentValues();
        values.put("ID", chat.getId().toString()); // Contact Name
        values.put("OBJECT", object); // Contact Phone Number
        // Inserting Row
        db.insert(TABLE, null, values);
        db.close(); // Closing database connection
    }


    public String toJsonString(HashMap<String, Object> data ){
        if(data != null){
            return  new Gson().toJson(data, HashMap.class);
        }else{
            return null;
        }
    }


    public HashMap toHashMap(String jsonString){
        if(jsonString != null){
            return new Gson().fromJson(jsonString, HashMap.class);
        }else{
            return null;
        }

    }


    // Getting single cont
    public Chat get__db(String id) {
        if(id != null){
            SQLiteDatabase db = this.getReadableDatabase();

            Cursor cursor = db.query(TABLE, new String[] { "",
                            KEY_ID, KEY_OBJECT }, KEY_ID + "=?",
                    new String[] { id }, null, null, null, null);
            if (cursor != null)
                cursor.moveToFirst();

            //String model_id = cursor.getString(0);
            String object = cursor.getString(1);
            cursor.close();
            db.close(); // Closing database connection
            HashMap<String, Object> chatHashMap = toHashMap(object);
            if(chatHashMap != null){
                ChatRepository chatRepo = restAdapter.createRepository(ChatRepository.class);
                return  chatRepo.createObject(chatHashMap);
            }else{
                return null;
            }
        }else{
            return null;
        }

    }

    // Getting All Contacts
    public DataList<Chat> getAll__db() {
        DataList<Chat> chatList = new DataList<Chat>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                //String model_id = cursor.getString(0);
                String object = cursor.getString(1);
                HashMap<String, Object> chatHashMap = toHashMap(object);
                if(chatHashMap != null){
                    ChatRepository chatRepo = restAdapter.createRepository(ChatRepository.class);
                    chatList.add(chatRepo.createObject(chatHashMap));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        // return contact list
        return chatList;
    }

    // Getting contacts Count
    public int count__db() {
        String countQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count
        return cursor.getCount();
    }


    // Updating single contact
    public int update__db(Chat chat) {
        SQLiteDatabase db = this.getWritableDatabase();
        HashMap<String, Object> hashMap = (HashMap<String, Object>) chat.convertMap();
        String object = toJsonString(hashMap);
        ContentValues values = new ContentValues();
        values.put("ID", chat.getId().toString()); // Contact Name
        values.put("OBJECT", object); // Contact Phone Number

        // updating row
        return db.update(TABLE, values, KEY_ID + " = ?",
                new String[] { chat.getId().toString() });
    }


    // Deleting single contact
    public void deleteContact(Chat chat) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, KEY_ID + " = ?",
                new String[] { chat.getId().toString() });
        db.close();
    }
}
