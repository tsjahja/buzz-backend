package com.buzz.view;

import com.buzz.model.UserEmail;


/**
 * Created by toshikijahja on 10/18/17.
 */
public class UserEmailView {

    private final UserEmail userEmail;

    public UserEmailView(final UserEmail userEmail) {
        this.userEmail = userEmail;
    }

    public String getEmail() {
        return userEmail.getEmail();
    }

    public CompanyView getCompany() {
        return new CompanyView(userEmail.getCompany());
    }

}
