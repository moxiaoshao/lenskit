/*
 * LensKit, an open source recommender systems toolkit.
 * Copyright 2010-2014 LensKit Contributors.  See CONTRIBUTORS.md.
 * Work on LensKit has been funded by the National Science Foundation under
 * grants IIS 05-34939, 08-08692, 08-12148, and 10-17697.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package org.lenskit.data.entities;

/**
 * Class for quickly building common entity types.  This class automatically assigns entity IDs and makes it quick
 * and easy to build entities.
 */
public class EntityFactory {
    private long entityId = 0;

    public EntityFactory() {

    }

    public Entity rating(long uid, long iid, double rating) {
        return Entities.newBuilder(CommonTypes.RATING, ++entityId)
                       .setAttribute(CommonAttributes.USER_ID, uid)
                       .setAttribute(CommonAttributes.ITEM_ID, iid)
                       .setAttribute(CommonAttributes.RATING, rating)
                       .build();
    }

    public Entity rating(long uid, long iid, double rating, long timestamp) {
        return Entities.newBuilder(CommonTypes.RATING, ++entityId)
                       .setAttribute(CommonAttributes.USER_ID, uid)
                       .setAttribute(CommonAttributes.ITEM_ID, iid)
                       .setAttribute(CommonAttributes.RATING, rating)
                       .setAttribute(CommonAttributes.TIMESTAMP, timestamp)
                       .build();
    }
}