INSERT INTO users (nome, cpf, senha, role) VALUES
                                               ('Administrador', '11111111111', '$2a$10$jw7E8l5JMCvzT0BIcK.7dO80M0ktNAZOtbH2dV7jM/DrNfNGu3PJO', 'ADMIN'),
                                               ('Maria Silva',    '22222222222', '$2a$10$iwJK3QUHim9v1auV.hzpTe.y9IIr5vAsNXBBcWIXu4.EoyIFgvyla', 'USER'),
                                               ('João Souza',     '33333333333', '$2a$10$iwJK3QUHim9v1auV.hzpTe.y9IIr5vAsNXBBcWIXu4.EoyIFgvyla', 'USER');

INSERT INTO produto (nome, preco, ativo) VALUES
                                             ('Notebook Dell Inspiron 15', 3899.90, true),
                                             ('Teclado Mecânico Redragon', 289.90, true),
                                             ('Mouse Gamer Logitech G203', 149.90, true),
                                             ('Monitor LG 27" Full HD', 999.00, true),
                                             ('Headset HyperX Cloud Stinger', 349.90, true),
                                             ('SSD Kingston 480GB', 269.90, true),
                                             ('Webcam Logitech C920', 459.90, false),
                                             ('Cadeira Gamer ThunderX3', 1299.00, true),
                                             ('Impressora HP DeskJet Ink Advantage', 599.90, true),
                                             ('Roteador TP-Link Archer C6', 279.90, false);