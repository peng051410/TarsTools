/**
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.jceplugin.language.manipulator;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.AbstractElementManipulator;
import com.tencent.jceplugin.language.psi.JceFieldType;
import org.jetbrains.annotations.NotNull;

public class JceFieldTypeManipulator extends AbstractElementManipulator<JceFieldType> {
    @Override
    public JceFieldType handleContentChange(@NotNull JceFieldType psi, @NotNull TextRange range, String newContent) {
        if (psi.getIdentifier() == null) {
            return psi;
        }
        return psi.setName(newContent);
    }

    @NotNull
    @Override
    public TextRange getRangeInElement(@NotNull JceFieldType element) {
        if (element.getIdentifier() == null) {
            return new TextRange(0, 0);
        }
        return element.getIdentifier().getTextRangeInParent();
    }
}
