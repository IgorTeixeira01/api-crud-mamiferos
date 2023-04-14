ALTER TABLE mamiferos
ADD CONSTRAINT fk_mamiferos_tipos_mamiferos FOREIGN KEY (id_tipo) REFERENCES tipos_mamiferos (id_tipo),
ADD CONSTRAINT fk_mamiferos_alimentacao FOREIGN KEY (id_alimentacao) REFERENCES alimentacao (id_alimentacao);
