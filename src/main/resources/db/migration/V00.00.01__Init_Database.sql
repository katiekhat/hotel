CREATE TABLE IF NOT EXISTS public.guests
(
    guest_id serial primary key,
    email character varying(255),
    first_name character varying(255),
    last_name character varying(255),
    phone_number character varying(255)
);

CREATE TABLE IF NOT EXISTS public.hotels
(
    hotel_id serial primary key,
    hotel_address character varying(255),
    hotel_description character varying(255),
    hotel_name character varying(255),
    hotel_parking boolean,
    hotel_wifi boolean
);