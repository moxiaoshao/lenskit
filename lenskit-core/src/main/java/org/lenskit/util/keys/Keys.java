/*
 * LensKit, an open-source toolkit for recommender systems.
 * Copyright 2014-2017 LensKit contributors (see CONTRIBUTORS.md)
 * Copyright 2010-2014 Regents of the University of Minnesota
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.lenskit.util.keys;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;

/**
 * Utility class for key extractors.
 */
public final class Keys {
    private Keys() {}

    public static <T> Ordering<T> keyOrdering(final KeyExtractor<T> ex) {
        return new Ordering<T>() {
            @Override
            public int compare(T left, T right) {
                return Longs.compare(ex.getKey(left), ex.getKey(right));
            }
        };
    }

    public static KeyExtractor<KeyedObject> selfExtractor() {
        return SelfExtractor.INSTANCE;
    }

    enum SelfExtractor implements KeyExtractor<KeyedObject> {
        INSTANCE {
            @Override
            public long getKey(KeyedObject obj) {
                return obj.getKey();
            }
        }
    }
}
