package com.nbu.secretsanta.secretsanta.config;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
@NoArgsConstructor
public class ListWrapper {
    private LinkedList<Hobby> theList ;

    public LinkedList<Hobby> getTheList(){
        return theList;
    }
    public void setTheList(LinkedList<Hobby> li){
        theList = li;
    }


}
