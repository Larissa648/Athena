CREATE TABLE VOCABULARY_CONVERSION
(	 VOCABULARY_ID_V4 BIGINT,
   VOCABULARY_ID_V5 VARCHAR(20),
   OMOP_REQ VARCHAR(1),
   CLICK_DEFAULT VARCHAR(1),
   AVAILABLE VARCHAR(25),
   URL VARCHAR(256),
   CLICK_DISABLED VARCHAR(1),
   LATEST_UPDATE DATE
);

CREATE TABLE VOCABULARY_CATEGORIES
(
   CATEGORY_ID BIGINT,
   TITLE       VARCHAR(256),
   SORT        INTEGER
);

CREATE TABLE VOCABULARY
(
   VOCABULARY_ID VARCHAR(20) NOT NULL,
   VOCABULARY_NAME VARCHAR(255) NOT NULL,
   VOCABULARY_REFERENCE VARCHAR(255),
   VOCABULARY_VERSION VARCHAR(255),
   VOCABULARY_CONCEPT_ID BIGINT NOT NULL
);

CREATE TABLE RELATIONSHIP
(
   RELATIONSHIP_ID VARCHAR(20) NOT NULL,
   RELATIONSHIP_NAME VARCHAR(255) NOT NULL,
   IS_HIERARCHICAL VARCHAR(1) NOT NULL,
   DEFINES_ANCESTRY VARCHAR(1) NOT NULL,
   REVERSE_RELATIONSHIP_ID VARCHAR(20) NOT NULL,
   RELATIONSHIP_CONCEPT_ID BIGINT NOT NULL
);

CREATE TABLE DRUG_STRENGTH
(
   DRUG_CONCEPT_ID BIGINT NOT NULL,
   INGREDIENT_CONCEPT_ID BIGINT NOT NULL,
   AMOUNT_VALUE DOUBLE PRECISION,
   AMOUNT_UNIT_CONCEPT_ID BIGINT,
   NUMERATOR_VALUE DOUBLE PRECISION,
   NUMERATOR_UNIT_CONCEPT_ID BIGINT,
   DENOMINATOR_VALUE DOUBLE PRECISION,
   DENOMINATOR_UNIT_CONCEPT_ID BIGINT,
   VALID_START_DATE DATE NOT NULL,
   VALID_END_DATE DATE NOT NULL,
   INVALID_REASON VARCHAR(1)
);
CREATE INDEX DRUG_CONCEPTID ON DRUG_STRENGTH (DRUG_CONCEPT_ID);
CREATE INDEX INGREDIENT_CONCEPTID ON DRUG_STRENGTH (INGREDIENT_CONCEPT_ID);

CREATE TABLE DOMAIN
(
   DOMAIN_ID VARCHAR(20) NOT NULL,
   DOMAIN_NAME VARCHAR(255) NOT NULL,
   DOMAIN_CONCEPT_ID BIGINT NOT NULL
);

CREATE TABLE CONCEPT_SYNONYM
(
   CONCEPT_ID BIGINT NOT NULL,
   CONCEPT_SYNONYM_NAME VARCHAR(1000) NOT NULL,
   LANGUAGE_CONCEPT_ID BIGINT NOT NULL
);

CREATE TABLE CONCEPT_RELATIONSHIP
(
   CONCEPT_ID_1 BIGINT NOT NULL,
   CONCEPT_ID_2 BIGINT NOT NULL,
   RELATIONSHIP_ID VARCHAR(20) NOT NULL,
   VALID_START_DATE DATE NOT NULL,
   VALID_END_DATE DATE NOT NULL,
   INVALID_REASON VARCHAR(1)
);
CREATE INDEX CONCEPT_RELATIONSHIP_C_1 ON CONCEPT_RELATIONSHIP (CONCEPT_ID_1);
CREATE INDEX CONCEPT_RELATIONSHIP_C_2 ON CONCEPT_RELATIONSHIP (CONCEPT_ID_2);

CREATE TABLE CONCEPT_CLASS
(
   CONCEPT_CLASS_ID VARCHAR(20) NOT NULL,
   CONCEPT_CLASS_NAME VARCHAR(255) NOT NULL,
   CONCEPT_CLASS_CONCEPT_ID DECIMAL(38) NOT NULL
);

CREATE TABLE CONCEPT_ANCESTOR
(
   ANCESTOR_CONCEPT_ID BIGINT NOT NULL,
   DESCENDANT_CONCEPT_ID BIGINT NOT NULL,
   MIN_LEVELS_OF_SEPARATION BIGINT NOT NULL,
   MAX_LEVELS_OF_SEPARATION BIGINT NOT NULL
);
CREATE INDEX ANCESTOR_CONCEPTID ON CONCEPT_ANCESTOR (ANCESTOR_CONCEPT_ID);
CREATE INDEX DESCENDANT_CONCEPTID ON CONCEPT_ANCESTOR (DESCENDANT_CONCEPT_ID);

CREATE TABLE CONCEPT
(
   CONCEPT_ID BIGINT PRIMARY KEY NOT NULL,
   CONCEPT_NAME VARCHAR(255) NOT NULL,
   DOMAIN_ID VARCHAR(20) NOT NULL,
   VOCABULARY_ID VARCHAR(20) NOT NULL,
   CONCEPT_CLASS_ID VARCHAR(20) NOT NULL,
   STANDARD_CONCEPT VARCHAR(1),
   CONCEPT_CODE VARCHAR(50) NOT NULL,
   VALID_START_DATE DATE NOT NULL,
   VALID_END_DATE DATE NOT NULL,
   INVALID_REASON VARCHAR(1)
);
CREATE INDEX CONCEPT_VOCAB ON CONCEPT (VOCABULARY_ID);