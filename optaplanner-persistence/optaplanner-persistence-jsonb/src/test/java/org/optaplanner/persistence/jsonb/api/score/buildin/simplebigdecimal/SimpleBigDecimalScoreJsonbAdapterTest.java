/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.optaplanner.persistence.jsonb.api.score.buildin.simplebigdecimal;

import java.math.BigDecimal;

import jakarta.json.bind.annotation.JsonbTypeAdapter;

import org.junit.jupiter.api.Test;
import org.optaplanner.core.api.score.buildin.simplebigdecimal.SimpleBigDecimalScore;
import org.optaplanner.persistence.jsonb.api.score.AbstractScoreJsonbAdapterTest;

class SimpleBigDecimalScoreJsonbAdapterTest extends AbstractScoreJsonbAdapterTest {

    @Test
    void serializeAndDeserialize() {
        assertSerializeAndDeserialize(null, new TestSimpleBigDecimalScoreWrapper(null));
        SimpleBigDecimalScore score = SimpleBigDecimalScore.of(new BigDecimal("1234.4321"));
        assertSerializeAndDeserialize(score, new TestSimpleBigDecimalScoreWrapper(score));
        score = SimpleBigDecimalScore.ofUninitialized(-7, new BigDecimal("1234.4321"));
        assertSerializeAndDeserialize(score, new TestSimpleBigDecimalScoreWrapper(score));
    }

    public static class TestSimpleBigDecimalScoreWrapper extends TestScoreWrapper<SimpleBigDecimalScore> {

        @JsonbTypeAdapter(SimpleBigDecimalScoreJsonbAdapter.class)
        private SimpleBigDecimalScore score;

        // Empty constructor required by JSON-B
        @SuppressWarnings("unused")
        public TestSimpleBigDecimalScoreWrapper() {
        }

        public TestSimpleBigDecimalScoreWrapper(SimpleBigDecimalScore score) {
            this.score = score;
        }

        @Override
        public SimpleBigDecimalScore getScore() {
            return score;
        }

        @Override
        public void setScore(SimpleBigDecimalScore score) {
            this.score = score;
        }

    }
}
