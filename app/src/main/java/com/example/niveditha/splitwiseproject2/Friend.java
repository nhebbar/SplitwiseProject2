package com.example.niveditha.splitwiseproject2;

/**
 * Created by Niveditha on 4/20/2015.
 */
public class Friend {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private boolean member;
    private boolean treasurer;
    public boolean isTreasurer() {
        return treasurer;
    }

    public void setTreasurer(boolean treasurer) {
        this.treasurer = treasurer;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    @Override
    public String toString(){
        String selectedString = member ? "isMemeber" : "not Member";

        return name+" -> "+selectedString+ " with value "+name;
    }

}
