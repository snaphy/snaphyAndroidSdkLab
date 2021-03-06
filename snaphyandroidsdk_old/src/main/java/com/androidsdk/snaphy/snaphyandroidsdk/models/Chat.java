package com.androidsdk.snaphy.snaphyandroidsdk.models;
import android.content.ContentValues;

import com.strongloop.android.loopback.RestAdapter;

/*
Replacing with custom Snaphy callback methods
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
*/
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.ObjectCallback;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.ChatRepository;

//Now import repository of related models..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.BrandRepository;
import com.androidsdk.snaphy.snaphyandroidsdk.repository.AppUserRepository;

import java.util.HashMap;
import java.util.Map;

public class Chat extends Model {
    //For converting all model values to hashMap
    private  transient Map<String, Object> hashMap = new HashMap<>();


    public Map<String,  ? extends Object> convertMap(){
        if(that.getId() != null){
            return hashMap;
        }else{
            hashMap.put("id", that.getId());
            return hashMap;
        }
    }


    private Chat that ;

    public Chat (){
        that = this;
    }
                private String added;
                /* Adding Getter and Setter methods */
                public String getAdded(){
                    return added;
                }

                /* Adding Getter and Setter methods */
                public void setAdded(String added){
                    this.added = added;
                    //Update hashMap value..
                    hashMap.put("added", added);
                }

                private String updated;
                /* Adding Getter and Setter methods */
                public String getUpdated(){
                    return updated;
                }

                /* Adding Getter and Setter methods */
                public void setUpdated(String updated){
                    this.updated = updated;
                    //Update hashMap value..
                    hashMap.put("updated", updated);
                }

                private String message;
                /* Adding Getter and Setter methods */
                public String getMessage(){
                    return message;
                }

                /* Adding Getter and Setter methods */
                public void setMessage(String message){
                    this.message = message;
                    //Update hashMap value..
                    hashMap.put("message", message);
                }


                private String type;
                /* Adding Getter and Setter methods */
                public String getType(){
                    return type;
                }

                /* Adding Getter and Setter methods */
                public void setType(String type){
                    this.type = type;
                    //Update hashMap value..
                    hashMap.put("type", type);
                }


            
                private Map<String, Object> image;
                /* Adding Getter and Setter methods */
                public Map<String, Object> getImage(){

                    return image;

                }

                /* Adding Getter and Setter methods */
                public void setImage(Map<String, Object> image){
                    this.image = image;
                    //Update Map value..
                    hashMap.put("image", image);
                }


                private String from;
                /* Adding Getter and Setter methods */
                public String getFrom(){
                    return from;
                }

                /* Adding Getter and Setter methods */
                public void setFrom(String from){
                    this.from = from;
                    //Update hashMap value..
                    hashMap.put("from", from);
                }

                private String guid;
                /* Adding Getter and Setter methods */
                public String getGuid(){
                    return guid;
                }

                /* Adding Getter and Setter methods */
                public void setGuid(String guid){
                    this.guid = guid;
                    //Update hashMap value..
                    hashMap.put("guid", guid);
                }


            
                private String status;
                /* Adding Getter and Setter methods */
                public String getStatus(){
                    return status;
                }

                /* Adding Getter and Setter methods */
                public void setStatus(String status){
                    this.status = status;
                    //Update hashMap value..
                    hashMap.put("status", status);
                }


    //Now adding relations between related models

    //Define belongsTo relation method here..
    private transient Brand  brand ;

    public Brand getBrand(RestAdapter restAdapter) {
        //TODO: EDITED
        if(brand == null){
            if(restAdapter != null){
                //Fetch locally from db
                brand = get__brand__db(restAdapter);
            }
        }

        return brand;
    }

    public void setBrand(Brand brand) {
        //TODO: save to database..
        this.brand = brand;
    }

    public void save(final com.strongloop.android.loopback.callbacks.VoidCallback callback){
        //Save to database..
        save__db();
        //Also save to database..
        super.save(callback);
    }


    public void save__db(String id){
        ChatRepository chatRepository = (ChatRepository) getRepository();
        if(id != null){
            HashMap<String, Object> hashMap = (HashMap<String, Object>) convertMap();
            String object = chatRepository.getDbHandler().toJsonString(hashMap);

            ContentValues values = new ContentValues();
            values.put("ID", id); // Contact Name
            values.put("OBJECT", object); // Contact Phone Number*/
            chatRepository.getDbHandler().upsert__db(id, object);
        }
    }


    public void save__db(){
        if(getId() == null){
            return;
        }
        String id = getId().toString();
        save__db(id);
    }

    //TODO: Add a brandId identifier as property

    public Brand get__brand__db(RestAdapter restAdapter){
        //TODO: replace brandid with gloabl
        String brandId = "BRAND ID";
        if(brandId != null){
            BrandRepository brandRepository = restAdapter.createRepository(BrandRepository.class);
            Brand brand = (Brand) brandRepository.getDbHandler().get__db(Brand.class, brandId);
            if(brand != null){
                return brand;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }


    //Adding related model automatically in case of include statement from server..
    public void setBrand(Map<String, Object> brand) {
        //First create a dummy Repo class object for customer.
        BrandRepository brandRepository = new BrandRepository();
        Brand brand1 = brandRepository.createObject(brand);
        //TODO: Save brand  to database..

        setBrand(brand1);
    }

    //Adding related model automatically in case of include statement from server..
    public void setBrand(HashMap<String, Object> brand) {
        //First create a dummy Repo class object for customer.
        BrandRepository brandRepository = new BrandRepository();
        Brand brand1 = brandRepository.createObject(brand);
        setBrand(brand1);
    }

    //Adding relation method..
    public void addRelation(Brand brand) {
        that.setBrand(brand);
    }

    //Now add instance methods to fetch the related belongsTo Model..

    //Write the method here..
    public void get__brand( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Brand> callback) {
        //Call the onBefore callback method..
        callback.onBefore();

        //Define methods here..
        final ChatRepository  chatRepo = restAdapter.createRepository(ChatRepository.class);

        chatRepo.get__brand( (String)that.getId(), refresh,  new ObjectCallback<Brand> (){



                @Override

                    public void onSuccess(Brand object) {
                        if(object != null){
                            //now add relation to this recipe.
                            addRelation(object);
                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                            //object.addRelation(that);
                            callback.onSuccess(object);
                            //Calling the finally..callback
                            callback.onFinally();
                        }else{
                            callback.onSuccess(null);
                            //Calling the finally..callback
                            callback.onFinally();
                        }

                    }


            @Override
            public void onError(Throwable t) {
                //Now calling the callback
                callback.onError(t);
                //Calling the finally..callback
                callback.onFinally();
            }

        });
    } //method def ends here.


    //Define belongsTo relation method here..
    private transient AppUser  appUser ;

    public AppUser getAppUser() {

        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    //Adding related model automatically in case of include statement from server..
    public void setAppUser(Map<String, Object> appUser) {
        //First create a dummy Repo class object for customer.
        AppUserRepository appUserRepository = new AppUserRepository();
        AppUser appUser1 = appUserRepository.createObject(appUser);
        setAppUser(appUser1);
    }

    //Adding related model automatically in case of include statement from server..
    public void setAppUser(HashMap<String, Object> appUser) {
        //First create a dummy Repo class object for customer.
        AppUserRepository appUserRepository = new AppUserRepository();
        AppUser appUser1 = appUserRepository.createObject(appUser);
        setAppUser(appUser1);
    }

    //Adding relation method..
    public void addRelation(AppUser appUser) {
        that.setAppUser(appUser);
    }

    //Now add instance methods to fetch the related belongsTo Model..
    //Write the method here..
    public void get__appUser( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<AppUser> callback) {
        //Call the onBefore callback method..
        callback.onBefore();

        //Define methods here..
        final ChatRepository  chatRepo = restAdapter.createRepository(ChatRepository.class);








        chatRepo.get__appUser( (String)that.getId(), refresh,  new ObjectCallback<AppUser> (){



                @Override

                    public void onSuccess(AppUser object) {
                        if(object != null){
                            //now add relation to this recipe.
                            addRelation(object);
                            //Also add relation to child type for two way communication..Removing two way communication for cyclic error
                            //object.addRelation(that);
                            callback.onSuccess(object);
                            //Calling the finally..callback
                            callback.onFinally();
                        }else{
                            callback.onSuccess(null);
                            //Calling the finally..callback
                            callback.onFinally();
                        }

                    }






            @Override
            public void onError(Throwable t) {
                //Now calling the callback
                callback.onError(t);
                //Calling the finally..callback
                callback.onFinally();
            }

        });
    } //method def ends here.



}
