package com.juanba.screenmatch.models;

public class Serie extends Title {
    private int season;
    private int episodePerSeason;
    private int minuitesPerEpisode;

    // Constructor
    public Serie(String name, int launchDate) {
        super(name, launchDate);
    }

    public int getMinuitesPerEpisode() {
        return minuitesPerEpisode;
    }

    public void setMinuitesPerEpisode(int minuitesPerEpisode) {
        this.minuitesPerEpisode = minuitesPerEpisode;
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
        return season * episodePerSeason * minuitesPerEpisode;
    }
}
