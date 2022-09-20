package com.sahilhans0605.bygbrains.anxiety;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDaysModel {
    String dayNumber;
    List<NestedModel> nestedList= new ArrayList<>();
    boolean isExpandable;

    public ExerciseDaysModel(String dayNumber, List<NestedModel> itemList) {
        this.dayNumber = dayNumber;
        this.nestedList = itemList;
        isExpandable = false;

    }


    public String getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(String dayNumber) {
        this.dayNumber = dayNumber;
    }

    public List<NestedModel> getItemList() {
        return nestedList;
    }

    public void setItemList(List<NestedModel> itemList) {
        this.nestedList = itemList;
    }

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }
}
