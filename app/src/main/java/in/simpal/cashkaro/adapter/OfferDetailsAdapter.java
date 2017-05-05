package in.simpal.cashkaro.adapter;

/**
 * Created by apple on 21/10/16.
 */

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import in.simpal.cashkaro.R;
import in.simpal.cashkaro.pojo.SectionOfferModel;

//import com.squareup.picasso.Picasso;

public class OfferDetailsAdapter extends RecyclerView.Adapter<OfferDetailsAdapter.ViewHolder> {
    private ArrayList<SectionOfferModel> dataList;
    private Context mContext;


    public OfferDetailsAdapter(Context context, ArrayList<SectionOfferModel> dataList) {
        this.dataList = dataList;
        this.mContext = context;
    }

    @Override
    public OfferDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_details, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        final String sectionName = dataList.get(i).getHeaderTitle();

        ArrayList singleSectionItems = dataList.get(i).getAllItemsInSection();
        viewHolder.listItemTitle.setText(sectionName);

        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        viewHolder.recycler_view_list.setHasFixedSize(true);
        viewHolder.recycler_view_list.setLayoutManager(new GridLayoutManager(mContext,2));
        viewHolder.recycler_view_list.setAdapter(itemListDataAdapter);
        viewHolder.recycler_view_list.setNestedScrollingEnabled(false);
      }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() : 0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       TextView listItemTitle;
        Button buttonOffer;


        protected RecyclerView recycler_view_list;

        protected Button btnMore;


        public ViewHolder(View view) {
            super(view);

            listItemTitle = (TextView) view.findViewById(R.id.list_item_title);
            recycler_view_list = (RecyclerView) view.findViewById(R.id.recycler_view_list);

        }






    }

}