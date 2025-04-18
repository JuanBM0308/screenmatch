package com.juanba.screenmatch.models;

public class Serie extends Title {
    private int season;
    private int episodePerSeason;
    private int minutesPerEpisode;

    // Constructor
    public Serie(String name, int launchDate) {
        super(name, launchDate);
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minuitesPerEpisode) {
        this.minutesPerEpisode = minuitesPerEpisode;
    }

    public int getEpisodePerSeason() {
        return episodePerSeason;
    }

    public void setEpisodePerSeason(int episodePerSeason) {
        this.episodePerSeason = episodePerSeason;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public int getDurationInMinutes() {
        return season * episodePerSeason * minutesPerEpisode;
    }

    @Override
    public String toString() {
        return "Serie: " + this.getName() + " (" + this.getLaunchDate() + ")";
    }
}
