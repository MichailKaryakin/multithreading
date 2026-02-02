package task19;

public class TwitterAccount {
    private String username;
    private Integer followers;

    public TwitterAccount(String username, Integer followers) {
        this.username = username;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }
}
