package pl.bugbreaker.opensusehowto;

import java.util.ArrayList;

public class Utils {
    public int itemLoaded = 0;
    private ArrayList<DataItem> dataSet = new ArrayList<>();

    public int getItemLoaded() {
        return itemLoaded;
    }

    public void setItemLoaded(int itemLoaded) {
        this.itemLoaded = itemLoaded;
    }

    public void setDataSet(ArrayList<DataItem> dataSet) {
        this.dataSet = dataSet;
    }

    public ArrayList<DataItem> getDataSet() {
        return dataSet;
    }

    public String getURL() {
        switch (getItemLoaded()) {
            case 1:
                return "http://susehowto.000webhostapp.com/gui/yast";
            case 2:
                return "http://susehowto.000webhostapp.com/gui/network";
            case 3:
                return "http://susehowto.000webhostapp.com/gui/users";
            case 4:
                return "http://susehowto.000webhostapp.com/gui/remote";
            case 5:
                return "http://susehowto.000webhostapp.com/gui/disks";
            case 6:
                return "http://susehowto.000webhostapp.com/gui/install";
            case 7:
                return "http://susehowto.000webhostapp.com/gui/custom";
            case 8:
                return "http://susehowto.000webhostapp.com/gui/gvim";
            case 9:
                return "http://susehowto.000webhostapp.com/cli/fs";
            case 10:
                return "http://susehowto.000webhostapp.com/cli/intro";
            case 11:
                return "http://susehowto.000webhostapp.com/cli/vim";
            case 12:
                return "http://susehowto.000webhostapp.com/cli/remote";
            case 13:
                return "http://susehowto.000webhostapp.com/cli/init";
            case 14:
                return "http://susehowto.000webhostapp.com/cli/process";
            case 15:
                return "http://susehowto.000webhostapp.com/cli/users";
            case 16:
                return "http://susehowto.000webhostapp.com/cli/software";
            case 17:
                return "http://susehowto.000webhostapp.com/cli/admin";
            case 18:
                return "http://susehowto.000webhostapp.com/cli/rescue";
            default:
                return "";
        }
    }
}
