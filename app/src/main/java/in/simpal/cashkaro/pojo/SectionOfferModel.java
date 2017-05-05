package in.simpal.cashkaro.pojo;

import java.util.ArrayList;

/**
 * Created by Bhargav on 25/04/17.
 */

public class SectionOfferModel {


    private String headerTitle;
    private ArrayList<SingleOffersDataModel> allItemsInSection;


    public SectionOfferModel() {

    }
    public SectionOfferModel(String headerTitle, ArrayList<SingleOffersDataModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleOffersDataModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleOffersDataModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
