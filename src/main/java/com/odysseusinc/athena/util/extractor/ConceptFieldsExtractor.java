/*
 *
 * Copyright 2018 Odysseus Data Services, inc.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Company: Odysseus Data Services, Inc.
 * Product Owner/Architecture: Gregory Klebanov
 * Authors: Pavel Grafkin, Vitaly Koulakov, Maria Pozhidaeva
 * Created: April 4, 2018
 *
 */

package com.odysseusinc.athena.util.extractor;

import static com.odysseusinc.athena.util.FieldValueUtil.getString;

import com.odysseusinc.athena.api.v1.controller.dto.ConceptDTO;

public class ConceptFieldsExtractor extends FieldsExtractor<ConceptDTO> {

    public String[] fields(ConceptDTO concept) {

        return new String[]{getString(concept.getId()),
                getString(concept.getCode()),
                getString(concept.getName()),
                getString(concept.getClassName()),
                getString(concept.getDomain()),
                getString(concept.getVocabulary()),
                getString(concept.getInvalidReason()),
                getString(concept.getStandardConcept())};
    }
}
