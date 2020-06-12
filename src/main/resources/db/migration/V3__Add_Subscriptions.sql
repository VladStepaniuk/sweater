CREATE TABLE user_subscriptions(
    channel_id INT NOT NULL REFERENCES usr,
    subscriber_id INT NOT NULL usr,
    PRIMARY KEY (channel_id, subscriber_id)
)