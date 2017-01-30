package com.androidsdk.snaphy.snaphysdk;

import android.util.Log;

import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Listen;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Chat;
import com.androidsdk.snaphy.snaphyandroidsdk.presenter.Presenter;

/**
 * Created by snaphy on 14/9/16.
 */
public class ChatPresenter {
    DataList<Chat> chats;
    public ChatPresenter(){

        chats = new DataList<Chat>();

        chats.subscribe(this, new Listen<Chat>() {
            @Override
            public void onInit(DataList<Chat> dataList) {
                super.onInit(dataList);
                Log.i("Snaphy", "I am getting initialized");
            }

            @Override
            public void onChange(DataList<Chat> dataList) {
                super.onChange(dataList);
                Log.i("Snaphy", "\n\nI am getting changed" + dataList.size());
            }

            @Override
            public void onClear() {
                super.onClear();
                Log.i("Snaphy", "I am getting cleared");
            }

            @Override
            public void onRemove(Chat element, int index, DataList<Chat> dataList) {
                super.onRemove(element, index, dataList);
                Log.i("Snaphy", "I am getting removed" + dataList.size());
                Chat chat = element;
            }
        });

        Presenter.getInstance().addList("Secret", chats);
        chats.add(new Chat());
        DataList<Chat> recipeContainer = Presenter.getInstance().getList(Chat.class, "Secret");
        Chat recipe = new Chat();
        recipeContainer.add(recipe);
        recipeContainer.remove(recipe);
        recipeContainer.clear();
    }

    public DataList<Chat> getChats() {
        return chats;
    }




}
