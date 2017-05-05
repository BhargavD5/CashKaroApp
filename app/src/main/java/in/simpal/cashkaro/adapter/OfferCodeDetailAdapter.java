package in.simpal.cashkaro.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import in.simpal.cashkaro.R;
import in.simpal.cashkaro.activity.WebActivity;
import in.simpal.cashkaro.pojo.SingleOffersDataModel;

/**
 * Created by Bhargav on 23/04/17.
 */

public class OfferCodeDetailAdapter extends RecyclerView.Adapter<OfferCodeDetailAdapter.ViewHolder> {
    private ArrayList<SingleOffersDataModel> android_versions;
    public Context context;

    public OfferCodeDetailAdapter(Context context, ArrayList<SingleOffersDataModel> android_versions) {
        this.context = context;
        this.android_versions = android_versions;

    }

    @Override
    public OfferCodeDetailAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_cardview_main, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        Button buttonOffer;
        public ViewHolder(View view) {
            super(view);

            buttonOffer = (Button) view.findViewById(R.id.button_get_offer);
            buttonOffer.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            Intent intent = null;


                    intent =  new Intent(context, WebActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);





        }



    }

}