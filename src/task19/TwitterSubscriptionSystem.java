package task19;

public class TwitterSubscriptionSystem {
    public void addFollower(TwitterAccount account) {
        synchronized (account) {
            account.setFollowers(account.getFollowers() + 1);
        }
    }
}
