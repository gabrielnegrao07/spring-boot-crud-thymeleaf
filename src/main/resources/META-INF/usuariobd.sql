CREATE TABLE USUARIO (
  ID                 BIGINT       NOT NULL AUTO_INCREMENT,
  USERNAME           VARCHAR(64)  NOT NULL,
  SENHA              VARCHAR(64)  NOT NULL,
  NOME_COMPLETO      VARCHAR(100) NOT NULL,
  ATIVADO            BOOL         NOT NULL DEFAULT TRUE,       
  DATA_HORA_CADASTRO TIMESTAMP    NOT NULL,
  CONSTRAINT PK_USUARIO PRIMARY KEY (ID),
  CONSTRAINT UC_USERNAME UNIQUE (USERNAME)
);

CREATE TABLE PAPEL (
  ID   INT          NOT NULL AUTO_INCREMENT,
  NOME VARCHAR(100) NOT NULL,
  CONSTRAINT PK_PAPEL PRIMARY KEY (ID),
  CONSTRAINT UC_NOME UNIQUE (NOME)
);

CREATE TABLE USUARIO_PAPEL (
  ID_USUARIO BIGINT NOT NULL,
  ID_PAPEL   INT    NOT NULL,
  CONSTRAINT FK_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
  CONSTRAINT FK_PAPEL FOREIGN KEY (ID_PAPEL) REFERENCES PAPEL(ID)
);

INSERT INTO PAPEIS(NOME) VALUES
('ADMIN'),
('ESTAGIARIO'),
('ANALISTA'),
('GERENTE');