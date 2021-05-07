package org.alg.advanced.graph.directed.processing;

import org.alg.fundamentals.base.Queue;
import org.alg.fundamentals.impl.queue.ArrayQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BareBonesWebCrawler {

    private static final String REGEX = "https://(\\w+\\.)*(\\w+)";
    private Queue<String> queue = new ArrayQueue<>();
    private Set<String> discovered = new HashSet<>();

    public BareBonesWebCrawler(String root) {
        queue.enqueue(root);
        discovered.add(root);
        bfs();
    }

    public static void main(String[] args) {
        new BareBonesWebCrawler("https://github.com/openjdk");
    }

    private void bfs() {
        while (!queue.isEmpty()) {
            String v = queue.dequeue();
            System.out.println(v);
            String input = readRawHtml(v);
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String w = matcher.group();
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.enqueue(w);
                }
            }
        }
    }

    private String readRawHtml(String url) {
        URL u;
        try {
            u = new URL(url);
            URLConnection conn = u.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();
            // System.out.println(buffer.toString());
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
