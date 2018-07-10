package com.example.alunos.myapplication.model;

import android.os.Parcelable;
import android.os.Parcel;

public class Pessoa implements Parcelable{

    private String nome;
    private String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }


    protected Pessoa(Parcel in){
        nome = in.readString();
        telefone = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);
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



