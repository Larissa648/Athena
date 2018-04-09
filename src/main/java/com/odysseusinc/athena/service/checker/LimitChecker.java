/*
 *
 * Copyright 2018 Observational Health Data Sciences and Informatics
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

package com.odysseusinc.athena.service.checker;

import static com.odysseusinc.athena.service.checker.CheckResult.successResult;

import com.odysseusinc.athena.api.v1.controller.dto.ConceptSearchDTO;
import java.io.IOException;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LimitChecker {

    @Value("${solr.limit.max.page.size:1000}")
    private Integer maxLimitPageSize;

    @Autowired
    private List<Checker> checkers;

    public CheckResult check(ConceptSearchDTO searchDTO) throws IOException, SolrServerException {

        for (Checker checker : checkers) {
            CheckResult result = checker.getCheckResult(searchDTO);
            if (result.isNotSuccess()) {
                return result;
            }
        }
        return successResult();
    }

    public Integer getMaxLimitPageSize() {

        return maxLimitPageSize;
    }
}