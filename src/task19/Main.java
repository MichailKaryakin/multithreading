package task19;

import javax.swing.event.TreeWillExpandListener;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    public void execute() {
        TwitterAccount twitterAccount = new TwitterAccount("Michail", 0);

        CompletableFuture<Void> future = followAccount(twitterAccount);
        CompletableFuture<Void> future1 = followAccount(twitterAccount);
        CompletableFuture<Void> future2 = followAccount(twitterAccount);
        CompletableFuture<Void> future3 = followAccount(twitterAccount);

        CompletableFuture.allOf(future, future1, future2, future3).join();

        System.out.println("Количество подписчиков: " + twitterAccount.getFollowers());
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount) {
        return CompletableFuture.runAsync(() -> {
            TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
            twitterSubscriptionSystem.addFollower(twitterAccount);
        });
    }
}
