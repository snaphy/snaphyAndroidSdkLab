package com.androidsdk.snaphy.snaphyandroidsdk.models;







import org.json.JSONObject;
import org.json.JSONArray;

import java.util.List;
import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.remoting.adapters.Adapter;

/*
Replacing with custom Snaphy callback methods
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;
*/
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.ObjectCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.DataListCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.callbacks.VoidCallback;
import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;

//Import self repository..
import com.androidsdk.snaphy.snaphyandroidsdk.repository.HotDealRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.CategoryRepository;
            

        
    

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.BrandRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class HotDeal extends Model {


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

    private HotDeal that ;

    public HotDeal (){
        that = this;
    }

    
        
            

            
                private String title;
                /* Adding Getter and Setter methods */
                public String getTitle(){
                    return title;
                }

                /* Adding Getter and Setter methods */
                public void setTitle(String title){
                    this.title = title;
                    //Update hashMap value..
                    hashMap.put("title", title);
                }

            
            
            
            

            

        
    
        
            

            
                private String description;
                /* Adding Getter and Setter methods */
                public String getDescription(){
                    return description;
                }

                /* Adding Getter and Setter methods */
                public void setDescription(String description){
                    this.description = description;
                    //Update hashMap value..
                    hashMap.put("description", description);
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

            
            

            

        
    
        
            

            
                private String url;
                /* Adding Getter and Setter methods */
                public String getUrl(){
                    return url;
                }

                /* Adding Getter and Setter methods */
                public void setUrl(String url){
                    this.url = url;
                    //Update hashMap value..
                    hashMap.put("url", url);
                }

            
            
            
            

            

        
    
        
            

            
            
                private double price;
                /* Adding Getter and Setter methods */
                public double getPrice(){
                    return price;
                }

                /* Adding Getter and Setter methods */
                public void setPrice(double price){
                    this.price = price;
                    //Update hashMap value..
                    hashMap.put("price", price);
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

            
            
            
            

            

        
    
        
            

            
                private String expiryDate;
                /* Adding Getter and Setter methods */
                public String getExpiryDate(){
                    return expiryDate;
                }

                /* Adding Getter and Setter methods */
                public void setExpiryDate(String expiryDate){
                    this.expiryDate = expiryDate;
                    //Update hashMap value..
                    hashMap.put("expiryDate", expiryDate);
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

            
            
            
            

            

        
    
        
            

            
            
            
            

            

        
    
        
            

            
            
            
            

            

        
    
        
            

            
            
            
            

            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private transient Category  category ;

                    public Category getCategory() {
                        return category;
                    }

                    public void setCategory(Category category) {
                        this.category = category;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCategory(Map<String, Object> category) {
                        //First create a dummy Repo class object for customer.
                        CategoryRepository categoryRepository = new CategoryRepository();
                        Category category1 = categoryRepository.createObject(category);
                        setCategory(category1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setCategory(HashMap<String, Object> category) {
                        //First create a dummy Repo class object for customer.
                        CategoryRepository categoryRepository = new CategoryRepository();
                        Category category1 = categoryRepository.createObject(category);
                        setCategory(category1);
                    }

                    //Adding relation method..
                    public void addRelation(Category category) {
                        that.setCategory(category);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__category( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Category> callback) {
                                        //Call the onBefore callback method..
                                        callback.onBefore();

                                        //Define methods here..
                                        final HotDealRepository  hotDealRepo = restAdapter.createRepository(HotDealRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        hotDealRepo.get__category( (String)that.getId(), refresh,  new ObjectCallback<Category> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Category object) {
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
                    private transient Brand  brand ;

                    public Brand getBrand() {
                        return brand;
                    }

                    public void setBrand(Brand brand) {
                        this.brand = brand;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setBrand(Map<String, Object> brand) {
                        //First create a dummy Repo class object for customer.
                        BrandRepository brandRepository = new BrandRepository();
                        Brand brand1 = brandRepository.createObject(brand);
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
                                        final HotDealRepository  hotDealRepo = restAdapter.createRepository(HotDealRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        hotDealRepo.get__brand( (String)that.getId(), refresh,  new ObjectCallback<Brand> (){
                                            

                                            
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
                                 
                            
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                    

                

                 
                 
             
          
      

}
