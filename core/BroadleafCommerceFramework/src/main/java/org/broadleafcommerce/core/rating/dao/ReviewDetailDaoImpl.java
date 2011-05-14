/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.core.rating.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.broadleafcommerce.config.EntityConfiguration;
import org.broadleafcommerce.core.rating.domain.ReviewDetail;
import org.broadleafcommerce.core.rating.domain.ReviewFeedback;
import org.springframework.stereotype.Repository;

@Repository("blReviewDetailDao")
public class ReviewDetailDaoImpl implements ReviewDetailDao {

    @PersistenceContext(unitName = "blPU")
    protected EntityManager em;

    @Resource
    protected EntityConfiguration entityConfiguration;

    protected String queryCacheableKey = "org.hibernate.cacheable";

    public ReviewDetail readReviewDetailById(Long reviewId) {
        return em.find(ReviewDetail.class, reviewId);
    }

    public ReviewDetail saveReviewDetail(ReviewDetail reviewDetail) {
        return em.merge(reviewDetail);
    }

	public ReviewDetail create() {
		return (ReviewDetail) entityConfiguration.createEntityInstance(ReviewDetail.class.getName());
	}

	public ReviewFeedback createFeedback() {
		return (ReviewFeedback) entityConfiguration.createEntityInstance(ReviewFeedback.class.getName());
	}
}
