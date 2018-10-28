package com.buzz.dao;

import com.buzz.model.UserEmail;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

import static com.buzz.dao.BaseDao.Sort.ASC;
import static com.buzz.utils.QueryUtils.listObjectToSqlQueryInString;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 * Created by toshikijahja on 6/7/17.
 */
public class UserEmailDao extends BaseDao<UserEmail> {

    public UserEmailDao(final SessionProvider sessionProvider) {
        super(sessionProvider, UserEmail.class);
    }

    public List<UserEmail> getByUserId(final int userId) {
        return getByFieldSorted("user.id", userId, "created", ASC);
    }

    public Optional<UserEmail> getByEmail(final String email) {
        requireNonNull(email);
        return getFirst(getByField("email", email));
    }

    @SuppressWarnings("unchecked")
    public Optional<UserEmail> getByUserIdAndCompanyId(final int userId, final int companyId) {
        final List<UserEmail> userEmails = getByUserIdAndCompanyIds(userId, singletonList(companyId));
        return getFirst(userEmails);
    }

    @SuppressWarnings("unchecked")
    public List<UserEmail> getByUserIdAndCompanyIds(final int userId, final List<Integer> companyIds) {
        if (companyIds.isEmpty()) {
            return emptyList();
        }
        final Query query = getSessionProvider().getSession().createQuery(
                "FROM " + clazz.getName() + " WHERE user.id = :userId AND company.id IN " + listObjectToSqlQueryInString(companyIds));
        query.setParameter("userId", userId);
        return query.list();
    }
}
