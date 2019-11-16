package com.iqbal.mymoviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {

    private String title;
    private String score;
    private String runtime;
    private String crew;
    private String genre;
    private String overview;
    private String date;
    private String language;
    private String photo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.score);
        dest.writeString(this.runtime);
        dest.writeString(this.crew);
        dest.writeString(this.genre);
        dest.writeString(this.overview);
        dest.writeString(this.date);
        dest.writeString(this.language);
        dest.writeString(this.photo);
    }

    public TVShow() {
    }

    protected TVShow(Parcel in) {
        this.title = in.readString();
        this.score = in.readString();
        this.runtime = in.readString();
        this.crew = in.readString();
        this.genre = in.readString();
        this.overview = in.readString();
        this.date = in.readString();
        this.language = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}