package com.currentbp.test.LogTest;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class St1 {
    @Test
    public void t1(){
        List<String> strings = Lists.newArrayList("12.9.4-go:59","12.12.1-go:44","12.15.2-go:34","12.10.4-go:8",
                "12.15.3-go:51","13.2.2-go:137","13.6.0-go:2","12.10.5-go:144","12.21.1-go:62","13.6.1-go:2","13.6.2-go:2830");
        int count = 0;
        for (String x : strings) {
            String[] split = x.split(":");
            String appVersion = split[0];
            int c = Integer.parseInt(split[1]);
            if (new AppVersion(appVersion).compareTo(new AppVersion("12.10.5-go")) <= 0) {
                count += c;
            }
        }
        System.out.println(count);
    }
}


class AppVersion implements Comparable<AppVersion> {

    private static final int VERSION_NUMBER_SIZE = 4;

    private String[] versions;

    public AppVersion(String version) {
        this.versions = new String[VERSION_NUMBER_SIZE];

        StringTokenizer all = new StringTokenizer(version, "-");
        StringTokenizer st = new StringTokenizer(all.nextToken(), "\\.");
        int i = 0;
        while (st.hasMoreTokens()) {
            versions[i++] = st.nextToken();
        }

        for (; i < VERSION_NUMBER_SIZE; i++) {
            versions[i] = "0";
        }
    }

    @Override
    public int compareTo(AppVersion o) {
        String[] oVersion = o.versions;

        int result = 0;
        for (int i = 0; i < VERSION_NUMBER_SIZE; i++) {
            try {
                result = Integer.parseInt(versions[i]) - Integer.parseInt(oVersion[i]);
            } catch (Exception e) {
                result = versions[i].compareTo(oVersion[i]);
            }
            if (result != 0) {
                return result;
            }
        }

        return result;
    }


    @Override
    public String toString() {
        return "AppVersion{" +
                "versions=" + Arrays.toString(versions) +
                '}';
    }
}