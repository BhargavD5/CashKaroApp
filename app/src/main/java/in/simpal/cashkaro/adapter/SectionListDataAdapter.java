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
import in.simpal.cashkaro.activity.OfferCodeDetailsActivity;
import in.simpal.cashkaro.pojo.SingleOffersDataModel;
import in.simpal.cashkaro.utility.Constants;

/**
 * Created by Bhargav on 25/04/17.
 */

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleOffersDataModel> itemsList;
    private Context context;
    String headerTitle;

    public SectionListDataAdapter(Context context, ArrayList<SingleOffersDataModel> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_main, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleOffersDataModel singleItem = itemsList.get(i);
headerTitle=singleItem.getList_item_title();
       // holder.tvTitle.setText(singleItem.getList_item_title());


       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected Button OfferButton;


        public SingleItemRowHolder(View view) {
            super(view);
            OfferButton = (Button) view.findViewById(R.id.button_get_offer);
            OfferButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent1 =  new Intent(context, OfferCodeDetailsActivity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent1.putExtra(Constants.TYPE_HEADER_TITLE,headerTitle);
                    context.startActivity(intent1);
                }
            });


        }



    }

}