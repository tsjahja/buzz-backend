package com.buzz.view;

import com.buzz.model.Buzz;
import com.buzz.utils.TimeUtils;

/**
 * Created by toshikijahja on 10/18/17.
 */
public class BuzzView {

    private final Buzz buzz;
    private final boolean liked;
    private final boolean favorited;

    public BuzzView(final Buzz buzz,
                    final boolean liked,
                    final boolean favorited) {
        this.buzz = buzz;
        this.liked = liked;
        this.favorited = favorited;
    }

    public int getId() {
        return buzz.getId();
    }

    public String getText() {
        return buzz.getText();
    }

    public int getCompanyId() {
        return buzz.getCompanyId();
    }

    public String getAlias() {
        return buzz.getAlias() == null ? "" : buzz.getAlias();
    }

    public CompanyView getUserCompany() {
        return new CompanyView(buzz.getUserEmail().getCompany());
    }

    public int getUserEmailId() {
        return buzz.getUserEmail().getId();
    }

    public int getLikesCount() {
        return buzz.getLikesCount();
    }

    public int getCommentsCount() {
        return buzz.getCommentsCount();
    }

    public boolean isLiked() {
        return liked;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public TimeView getTimePassed() {
        return TimeUtils.getTimePassed(buzz.getCreated());
    }
}
