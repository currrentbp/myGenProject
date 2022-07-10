package com.currentbp.sort.skipList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baopan
 * @createTime 20220710
 */
public class MySkipList {
//todo not work
    public static SkipListEntry[] header = new SkipListEntry[4];
    private static float p = 0.25f;
    private static int maxLevel = 4;//level from zero


    public void insert(long score, String value) {
        SkipListEntry currentEntry = createZeroLevel(score, value);

        SkipListEntry temp = null;
        for (SkipListEntry skipListEntry : header) {
            if (skipListEntry == null) {
                continue;
            }
            temp = findIndex(skipListEntry, score);
        }
        if (temp == null) {
            header[3] = currentEntry;
        } else {
            SkipListEntry after = temp.getAfter();
            temp.setAfter(currentEntry);
            currentEntry.setAfter(after);
            currentEntry.setBefore(temp);
            after.setBefore(currentEntry);
        }

        buildTop(currentEntry);
    }

    public void deleteByScore(long score, String value) {
    }

    public List<String> getValuesByScore(long lowScore, long topScore) {
        List<String> result = new ArrayList<>();

        return result;
    }

    private void buildTop(SkipListEntry currentEntry) {

    }

    private SkipListEntry findIndex(SkipListEntry skipListEntry, long score) {
        if (null == skipListEntry) {
            return null;
        }
        if (skipListEntry.getLevel() == 0) {
            while (true) {
                if (skipListEntry.getScore() < score && (skipListEntry.getAfter() == null || score < skipListEntry.getAfter().getScore())) {
                    return skipListEntry;
                }
            }
        }
        SkipListEntry after = skipListEntry.getAfter();
        SkipListEntry low = skipListEntry.getLow();
        return null;
    }

    private SkipListEntry createZeroLevel(long score, String value) {
        SkipListEntry skipListEntry = new SkipListEntry();
        skipListEntry.setLevel(0);
        skipListEntry.setValue(value);
        skipListEntry.setScore(score);
        return skipListEntry;
    }

}
