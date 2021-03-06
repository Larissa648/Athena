package com.odysseusinc.athena.service.impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryBoosts {

    private NotExactTermBoosts notExactTerm;
    private SingleNotExactTermBoosts singleNotExactTermBoosts;
    private FewTermsBoosts fewTermsBoosts;
    private ExactTermBoosts exactTerm;
    private SingleExactTermBoosts singleExactTermBoosts;
    private AsteriskTermBoosts asteriskTermBoosts;
    private SingleAsteriskTermBoosts singleAsteriskTermBoosts;
    private PhraseBoosts phrase;
    private AdditionalBoosts additionalBoosts;

    public static QueryBoosts buildDefault() {

        return new QueryBoosts(
                new NotExactTermBoosts(), new SingleNotExactTermBoosts(), new FewTermsBoosts(),
                new ExactTermBoosts(), new SingleExactTermBoosts(),
                new AsteriskTermBoosts(), new SingleAsteriskTermBoosts(),
                new PhraseBoosts(), new AdditionalBoosts());
    }

    @Data
    public static class NotExactTermBoosts {

        private Integer conceptCodeText = 1000;
        private Integer conceptNameText = 1000;
        private Integer conceptSynonymNameText = 50;
        private Integer conceptCodeTextFuzzy = 50;
        private Integer conceptNameTextFuzzy = 50;
        private Integer conceptSynonymNameFuzzy = 15;
        private Integer querySymbols = 10;
        private Integer querySymbolsFuzzy = 1;
    }

    @Data
    public static class SingleNotExactTermBoosts {
        private Integer conceptCodeText = 500;
        private Integer conceptCodeTextFuzzy = 50;
    }

    @Data
    public static class  FewTermsBoosts {
        private Integer query = 20000;
    }

    @Data
    public static class ExactTermBoosts {
        private Integer conceptId = 100000;
        private Integer conceptCode = 80000;
        private Integer conceptName = 60000;
        private Integer conceptSynonymName = 7000;
        private Integer conceptCodeCi = 10000;
        private Integer conceptNameCi = 1000;
        private Integer conceptSynonymNameCi = 300;
        private Integer querySymbols = 10;
    }

    @Data
    public static class SingleExactTermBoosts {
        private Integer conceptCode = 80000;
        private Integer conceptCodeCi = 10000;
    }

    @Data
    public static class AsteriskTermBoosts {
        private Integer conceptCode = 80000;
        private Integer conceptName = 60000;
        private Integer conceptSynonymName = 7000;
        private Integer conceptCodeCi = 30000;
        private Integer conceptNameCi = 25000;
        private Integer conceptSynonymNameCi = 2000;
        private Integer conceptCodeText = 10000;
        private Integer conceptNameText = 8000;
        private Integer conceptSynonymNameText = 500;

    }

    @Data
    public static class SingleAsteriskTermBoosts {
        private Integer conceptCode = 80000;
        private Integer conceptCodeCi = 30000;
        private Integer conceptCodeText = 10000;
    }

    @Data
    public static class PhraseBoosts {
        private Integer conceptId = 100000;
        private Integer conceptCode = 80000;
        private Integer conceptName = 60000;
        private Integer conceptSynonymName = 7000;
        private Integer conceptCodeCi = 10000;
        private Integer conceptNameCi = 1000;
        private Integer conceptSynonymNameCi = 300;
        private Integer conceptClassIdCi = 100;
        private Integer domainIdCi = 100;
        private Integer vocabularyIdCi = 100;
    }

    @Data
    public static class AdditionalBoosts {
        private Integer standardConcept = 25000;
        private Integer classificationConcept = 5000;
        private Integer valid = 2500;
    }

}
