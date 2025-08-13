package com.IntroductionToSpringBoot.weak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

//    @Autowired
   final private DB db;

    public DBService(DB db){       // this is constructor dependencies
        this.db=db;
    }


    public String getData(){
        return db.getData();
    }
}
