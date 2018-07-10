package com.example.alunos.recyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Livro implements Parcelable {

    private String titulo;
    private String autor;
    private String descricao;

    public Livro(String t, String a, String d){
        this.titulo = t;
        this.autor = a;
        this.descricao = d;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    protected Livro(Parcel in){
        titulo = in.readString();
        autor = in.readString();
        descricao = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(autor);
        dest.writeString(descricao);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Livro> CREATOR =
            new Parcelable.Creator<Livro>(){
                @Override
                public Livro createFromParcel(Parcel in){
                    return new Livro(in);
                }

                @Override
                public Livro[] newArray(int size) {
                    return new Livro[size];
                }
            };
}

