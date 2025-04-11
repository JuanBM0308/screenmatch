package com.juanba.screenmatch.caculates;

import com.juanba.screenmatch.models.Movie;
import com.juanba.screenmatch.models.Serie;
import com.juanba.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public void totalPlaybackTime(Title title) {
        this.totalTime += title.getDurationInMinutes();
    }

    public int getTotalTime() {
        return totalTime;
    }
}
