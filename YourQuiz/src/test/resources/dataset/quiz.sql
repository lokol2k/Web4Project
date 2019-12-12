INSERT INTO public.quiz(
            id, created,quiz_header, description, start_date, end_date, is_active, usuario_id,category_id)
    VALUES (3, NOW(),'Pronomes', 'Quiz dos pronomes', '2019-11-21', '2019-11-23', true, 1001,100),
    (4, NOW(),'Pronomes', 'Quiz de pop', '2019-11-21', '2019-11-23', true, 1001,103),
    (5, NOW(),'Pronomes', 'Quiz de japones', '2019-11-21', '2019-11-23', true, 1001,101),
    (6, NOW(),'Pronomes', 'Quiz de lul', '2019-11-21', '2019-11-23', true, 1001,103),
    (7, NOW(),'Pronomes', 'Quiz de lolzito', '2019-11-21', '2019-11-23', true, 1001,102)
    ;