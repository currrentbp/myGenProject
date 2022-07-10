package com.currentbp.sort.skipList;

/**
 * @author
 * @createTime 20220710
 */
public class SkipListEntry {
    private SkipListEntry before;
    private SkipListEntry after;
    private SkipListEntry top;
    private SkipListEntry low;

    private long score;
    private String value;
    private int level = 0;


    public SkipListEntry getAfter() {
        return after;
    }

    public void setAfter(SkipListEntry after) {
        this.after = after;
    }


    public SkipListEntry getLow() {
        return low;
    }

    public void setLow(SkipListEntry low) {
        this.low = low;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public SkipListEntry getBefore() {
        return before;
    }

    public void setBefore(SkipListEntry before) {
        this.before = before;
    }

    public SkipListEntry getTop() {
        return top;
    }

    public void setTop(SkipListEntry top) {
        this.top = top;
    }

    @Override
    public String toString() {
        return "SkipListEntry{" +
                "before=" + before +
                ", after=" + after +
                ", top=" + top +
                ", low=" + low +
                ", score=" + score +
                ", value='" + value + '\'' +
                ", level=" + level +
                '}';
    }
}
