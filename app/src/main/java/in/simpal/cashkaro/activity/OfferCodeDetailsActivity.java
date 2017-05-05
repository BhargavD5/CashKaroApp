package in.simpal.cashkaro.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import in.simpal.cashkaro.R;
import in.simpal.cashkaro.adapter.OfferCodeDetailAdapter;
import in.simpal.cashkaro.pojo.SingleOffersDataModel;
import in.simpal.cashkaro.utility.Constants;

import static in.simpal.cashkaro.utility.Constants.list_category;

/**
 * Created by Bhargav on 23/04/17.
 */

public class OfferCodeDetailsActivity extends AppCompatActivity {

TextView tv_title_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_code_details_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Amazon");

        String title=getIntent().getStringExtra(Constants.TYPE_HEADER_TITLE);
        tv_title_header= (TextView) findViewById(R.id.textview_header);
        if(tv_title_header!=null) {
            tv_title_header.setText(title);
        }else{
            tv_title_header.setVisibility(View.INVISIBLE);
        }
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList androidVersions = prepareDummyData();
        OfferCodeDetailAdapter adapter = new OfferCodeDetailAdapter(getApplicationContext(),androidVersions);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList prepareDummyData(){

        ArrayList offerlist = new ArrayList<>();
        for(int i = 0; i< list_category.length; i++){
            SingleOffersDataModel singleOffersDataModel = new SingleOffersDataModel();
            offerlist.add(singleOffersDataModel);
        }
        return offerlist;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
