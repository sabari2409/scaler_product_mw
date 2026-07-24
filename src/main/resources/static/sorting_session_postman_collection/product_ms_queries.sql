SELECT * FROM public.category
ORDER BY id ASC;

SELECT * FROM public.sub_category
ORDER BY id ASC;

SELECT * FROM public.product ORDER BY id ASC;

SELECT * FROM public.product ORDER BY price desc, id desc;

pg_dump -U postgres -d product_ms -f product_ms_dump.sql