CREATE TABLE IF NOT EXISTS public.servicos
(
    codigo_servico INTEGER NOT NULL PRIMARY KEY,
    descricao VARCHAR(255),
    valor_claro DOUBLE PRECISION,
    valor_tecnico DOUBLE PRECISION
    );

CREATE TABLE IF NOT EXISTS public.tecnico
(
    codigo_tecnico INTEGER PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(14),
    data_admissao TIMESTAMP WITHOUT TIME ZONE
    );

CREATE TABLE IF NOT EXISTS public.servicos_executados
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    tecnico_id INTEGER NOT NULL,
    data_execucao TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    FOREIGN KEY (tecnico_id) REFERENCES public.tecnico (codigo_tecnico) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS public.servico_executado_item
(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    servico_id BIGINT NOT NULL,
    servico_executado_id BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    valor_claro DOUBLE PRECISION,
    valor_tecnico DOUBLE PRECISION,
    FOREIGN KEY (servico_id) REFERENCES public.servicos (codigo_servico),
    FOREIGN KEY (servico_executado_id) REFERENCES public.servicos_executados (id)
    );