package com.juanba.screenmatch.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProcessor {
    private String jsonOMDb;

    public GsonProcessor(String jsonOMDb) {
        this.jsonOMDb = jsonOMDb;
    }

    public Title passJsonToObject() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        TitleOmdb titleOmdb = gson.fromJson(this.jsonOMDb, TitleOmdb.class);

        return new Title(titleOmdb);
    }
}
