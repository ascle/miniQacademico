-- Table: curso

-- DROP TABLE curso;

CREATE TABLE curso
(
  "codCurso" serial NOT NULL,
  "nomeCurso" character varying(20),
  CONSTRAINT curso_pkey PRIMARY KEY ("codCurso")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE curso
  OWNER TO postgres;


-- Table: disciplina

-- DROP TABLE disciplina;

CREATE TABLE disciplina
(
  "codDisciplina" character varying NOT NULL,
  "nomeDisciplina" character varying,
  "numCreditosDisc" integer,
  "preReqDisciplina_1" character varying,
  "preReqDisciplina_2" character varying,
  CONSTRAINT disciplina_pkey PRIMARY KEY ("codDisciplina"),
  CONSTRAINT "disciplina_preReqDisciplina_1_fkey" FOREIGN KEY ("preReqDisciplina_1")
      REFERENCES disciplina ("codDisciplina") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "disciplina_preReqDisciplina_2_fkey" FOREIGN KEY ("preReqDisciplina_2")
      REFERENCES disciplina ("codDisciplina") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE disciplina
  OWNER TO postgres;


-- Table: disciplina_has_curso

-- DROP TABLE disciplina_has_curso;

CREATE TABLE disciplina_has_curso
(
  "disciplina_codDisciplina" character varying,
  "curso_codCurso" integer,
  "numPeriodo" integer,
  "tipoDisciplina" character varying
)
WITH (
  OIDS=FALSE
);
ALTER TABLE disciplina_has_curso
  OWNER TO postgres;

