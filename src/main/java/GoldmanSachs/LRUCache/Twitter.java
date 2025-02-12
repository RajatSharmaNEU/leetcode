package GoldmanSachs.LRUCache;

import java.util.*;

public class Twitter {
    int timestamp = 0;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            next = null;
        }
    }

    private class User {
        int id;
        Set<Integer> follows;
        Tweet head;

        User(int id) {
            this.id = id;
            this.follows = new HashSet<>();
            this.head = null;
            follow(id);
        }

        public void follow(int id) {
            follows.add(id);
        }

        public void unfollow(int id) {
            follows.remove(id);
        }

        public void post(int id) {
            Tweet tweet = new Tweet(id);
            tweet.next = head;
            head = tweet;
        }
    }

    Map<Integer, User> userMap;

    public Twitter() {
        userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            User user = new User(userId);
            userMap.put(userId, user);
        }

        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        if(!userMap.containsKey(userId)) {
            return feed;
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b)->(b.time - a.time));
        for(int followerId: userMap.get(userId).follows) {
            Tweet tweet = userMap.get(followerId).head;
            if(tweet != null) {
                pq.add(tweet);
            }
        }

        int count = 0;
        while(!pq.isEmpty() && count < 10) {
            Tweet tweet = pq.poll();
            feed.add(tweet.id);
            count++;

            if(tweet.next != null) {
                pq.add(tweet.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            User user = new User(followerId);
            userMap.put(followerId, user);
        }

        if(!userMap.containsKey(followeeId)) {
            User user = new User(followeeId);
            userMap.put(followeeId, user);
        }

        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
