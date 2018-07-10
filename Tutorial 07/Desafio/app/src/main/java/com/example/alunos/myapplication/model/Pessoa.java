package com.example.alunos.myapplication.model;

import android.os.Parcelable;
import android.os.Parcel;

public class Pessoa implements Parcelable{

    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    protected Pessoa(Parcel in){
        nome = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pessoa> CREATOR =
            new Parcelable.Creator<Pessoa>(){
                @Override
                public Pessoa createFromParcel(Parcel in){
                    return new Pessoa(in);
                }

                @Override
                public Pessoa[] newArray(int size) {
                    return new Pessoa[size];
                }
            };
}



