package com.androidsdk.snaphy.snaphysdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidsdk.snaphy.snaphyandroidsdk.list.DataList;
import com.androidsdk.snaphy.snaphyandroidsdk.list.Listen;
import com.androidsdk.snaphy.snaphyandroidsdk.models.Customer;
import com.androidsdk.snaphy.snaphyandroidsdk.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecipePresenter recipePresenter = new RecipePresenter();

        /*DataList<Customer> customerDataList = new DataList<Customer>();
        customerDataList.subscribe(this, new Listen<Customer>() {
            @Override
            public void onInit(DataList<Customer> dataList) {
                super.onInit(dataList);
            }

            @Override
            public void onChange(DataList<Customer> dataList) {
                super.onChange(dataList);
            }

            @Override
            public void onClear() {
                super.onClear();
            }

        });*/
        boolean x = true;
        Presenter.getInstance();
        Presenter.getInstance().addModel("test", x);
        boolean y = Presenter.getInstance().getModel(Boolean.class, "test");




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
