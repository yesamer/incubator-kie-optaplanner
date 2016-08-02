/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
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
package org.optaplanner.core.impl.score.director.drools.testgen.operation;

import org.kie.api.runtime.KieSession;

public class TestGenKieSessionFireAllRules implements TestGenKieSessionOperation {

    private final int id;

    public TestGenKieSessionFireAllRules(int id) {
        this.id = id;
    }

    @Override
    public void invoke(KieSession kieSession) {
        kieSession.fireAllRules();
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append(String.format("        //%s%n", this));
        sb.append(String.format("        kieSession.fireAllRules();%n"));
    }

    @Override
    public String toString() {
        return "operation F #" + id;
    }

}
