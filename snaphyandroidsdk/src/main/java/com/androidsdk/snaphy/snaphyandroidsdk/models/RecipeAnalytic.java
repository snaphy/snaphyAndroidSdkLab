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
import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeAnalyticRepository;

//Now import repository of related models..

    
            import com.androidsdk.snaphy.snaphyandroidsdk.repository.RecipeRepository;
            

        
    


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class RecipeAnalytic extends Model {


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

    private RecipeAnalytic that ;

    public RecipeAnalytic (){
        that = this;
    }

    
        
            
            
            
                private double totalViews;
                /* Adding Getter and Setter methods */
                public double getTotalViews(){
                    return totalViews;
                }

                /* Adding Getter and Setter methods */
                public void setTotalViews(double totalViews){
                    this.totalViews = totalViews;
                    //Update hashMap value..
                    hashMap.put("totalViews", totalViews);
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

            
            
            
            

        
    
        
            
            
                private String lastModified;
                /* Adding Getter and Setter methods */
                public String getLastModified(){
                    return lastModified;
                }

                /* Adding Getter and Setter methods */
                public void setLastModified(String lastModified){
                    this.lastModified = lastModified;
                    //Update hashMap value..
                    hashMap.put("lastModified", lastModified);
                }

            
            
            
            

        
    
        
            
            
            
                private double averageRating;
                /* Adding Getter and Setter methods */
                public double getAverageRating(){
                    return averageRating;
                }

                /* Adding Getter and Setter methods */
                public void setAverageRating(double averageRating){
                    this.averageRating = averageRating;
                    //Update hashMap value..
                    hashMap.put("averageRating", averageRating);
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

            
            
            
            

        
    
        
            
            
            
                private double totalComment;
                /* Adding Getter and Setter methods */
                public double getTotalComment(){
                    return totalComment;
                }

                /* Adding Getter and Setter methods */
                public void setTotalComment(double totalComment){
                    this.totalComment = totalComment;
                    //Update hashMap value..
                    hashMap.put("totalComment", totalComment);
                }

            
            
            

        
    
        
            
            
                private String priority;
                /* Adding Getter and Setter methods */
                public String getPriority(){
                    return priority;
                }

                /* Adding Getter and Setter methods */
                public void setPriority(String priority){
                    this.priority = priority;
                    //Update hashMap value..
                    hashMap.put("priority", priority);
                }

            
            
            
            

        
    
        
            
            
            
            
            

        
    
        
            
            
            
            
            

        
    


    



    //Now adding relations between related models
    
        
                
                    //Define belongsTo relation method here..
                    private transient Recipe  recipes ;

                    public Recipe getRecipes() {
                        return recipes;
                    }

                    public void setRecipes(Recipe recipes) {
                        this.recipes = recipes;
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipes(Map<String, Object> recipes) {
                        //First create a dummy Repo class object for customer.
                        RecipeRepository recipesRepository = new RecipeRepository();
                        Recipe recipes1 = recipesRepository.createObject(recipes);
                        setRecipes(recipes1);
                    }

                    //Adding related model automatically in case of include statement from server..
                    public void setRecipes(HashMap<String, Object> recipes) {
                        //First create a dummy Repo class object for customer.
                        RecipeRepository recipesRepository = new RecipeRepository();
                        Recipe recipes1 = recipesRepository.createObject(recipes);
                        setRecipes(recipes1);
                    }

                    //Adding relation method..
                    public void addRelation(Recipe recipes) {
                        that.setRecipes(recipes);
                    }



                
                
                







                    //Now add instance methods to fetch the related belongsTo Model..
                    

                    

                                    //Write the method here..
                                    public void get__recipes( Boolean refresh,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Call the onBefore callback method..
                                        callback.onBefore();

                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeAnalyticRepo.get__recipes( (String)that.getId(), refresh,  new ObjectCallback<Recipe> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Recipe object) {
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
                                 
                            
                        

                                    //Write the method here..
                                    public void create__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Call the onBefore callback method..
                                        callback.onBefore();

                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeAnalyticRepo.create__recipes( (String)that.getId(), data.convertMap(),  new ObjectCallback<Recipe> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Recipe object) {
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
                                 
                            
                        

                                    //Write the method here..
                                    public void update__recipes( Recipe data,  RestAdapter restAdapter, final ObjectCallback<Recipe> callback) {
                                        //Call the onBefore callback method..
                                        callback.onBefore();

                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        
                                        
                                        
                                        
                                        



                                        recipeAnalyticRepo.update__recipes( (String)that.getId(), data.convertMap(),  new ObjectCallback<Recipe> (){
                                            

                                            
                                                @Override
                                                
                                                    public void onSuccess(Recipe object) {
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
                                 
                            
                        

                                    //Write the method here..
                                    public void destroy__recipes( RestAdapter restAdapter, final VoidCallback callback) {
                                        //Call the onBefore callback method..
                                        callback.onBefore();

                                        //Define methods here..
                                        final RecipeAnalyticRepository  recipeAnalyticRepo = restAdapter.createRepository(RecipeAnalyticRepository.class);
                                        
                                        



                                        recipeAnalyticRepo.destroy__recipes( (String)that.getId(),  new VoidCallback (){
                                            
                                                @Override
                                                public void onSuccess() {
                                                    callback.onSuccess();
                                                    //Calling the finally..callback
                                                    callback.onFinally();
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
