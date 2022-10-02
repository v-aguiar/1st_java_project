INSERT INTO restaurant (id, cep, complement, name)
VALUES
    (1, '12345678', 'complement 1', 'name 1'),
    (2, '87654321', 'complement 2', 'name 2');

INSERT INTO client (id, cep, complement, name)
VALUES
    (1, '12345678', 'client complement 1', 'Client 1');

INSERT INTO product (id, available, name, unitary_price, restaurant_id)
VALUES
    (1, true, 'product 1', 5.0, 1),
    (2, true, 'product 2', 6.0, 1),
    (3, true, 'product 3', 4.0, 2);

INSERT INTO cart (id, payment_option, closed, total_value, client_id)
VALUES
    (1, 0, false, 0.0, 1);
