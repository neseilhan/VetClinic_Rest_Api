PGDMP                      |         
   veterinary    16.3    16.3 '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    42046 
   veterinary    DATABASE     �   CREATE DATABASE veterinary WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE veterinary;
                postgres    false            �            1259    46431    animal    TABLE     C  CREATE TABLE public.animal (
    animal_id bigint NOT NULL,
    animal_bdate date,
    animal_breed character varying(100),
    animal_color character varying(100),
    animal_gender character varying(100),
    animal_name character varying(255),
    animal_species character varying(255),
    animal_customer_id bigint
);
    DROP TABLE public.animal;
       public         heap    postgres    false            �            1259    46430    animal_animal_id_seq    SEQUENCE     �   ALTER TABLE public.animal ALTER COLUMN animal_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.animal_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    46439    appointment    TABLE     �   CREATE TABLE public.appointment (
    appointment_id bigint NOT NULL,
    appointment_date date,
    appointment_time time(6) without time zone,
    appointment_animal_id bigint,
    appointment_doctor_id bigint
);
    DROP TABLE public.appointment;
       public         heap    postgres    false            �            1259    46438    appointment_appointment_id_seq    SEQUENCE     �   ALTER TABLE public.appointment ALTER COLUMN appointment_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.appointment_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    218            �            1259    46445    available_date    TABLE     �   CREATE TABLE public.available_date (
    available_date_id bigint NOT NULL,
    available_date date,
    date_doctor_id bigint
);
 "   DROP TABLE public.available_date;
       public         heap    postgres    false            �            1259    46444 $   available_date_available_date_id_seq    SEQUENCE     �   ALTER TABLE public.available_date ALTER COLUMN available_date_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.available_date_available_date_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    220            �            1259    46451    customer    TABLE     !  CREATE TABLE public.customer (
    customer_id bigint NOT NULL,
    customer_address character varying(255),
    customer_city character varying(255),
    customer_email character varying(255),
    customer_name character varying(50) NOT NULL,
    customer_phone character varying(255)
);
    DROP TABLE public.customer;
       public         heap    postgres    false            �            1259    46450    customer_customer_id_seq    SEQUENCE     �   ALTER TABLE public.customer ALTER COLUMN customer_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.customer_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    222            �            1259    46459    doctor    TABLE       CREATE TABLE public.doctor (
    doctor_id bigint NOT NULL,
    doctor_address character varying(255),
    doctor_city character varying(255),
    doctor_email character varying(255),
    doctor_name character varying(255) NOT NULL,
    doctor_phone character varying(255)
);
    DROP TABLE public.doctor;
       public         heap    postgres    false            �            1259    46458    doctor_doctor_id_seq    SEQUENCE     �   ALTER TABLE public.doctor ALTER COLUMN doctor_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.doctor_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    46467    vaccine    TABLE     �   CREATE TABLE public.vaccine (
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(255),
    vaccine_end_date date,
    vaccine_name character varying(255),
    vaccine_start_date date,
    animal_vaccine_id bigint
);
    DROP TABLE public.vaccine;
       public         heap    postgres    false            �            1259    46466    vaccine_vaccine_id_seq    SEQUENCE     �   ALTER TABLE public.vaccine ALTER COLUMN vaccine_id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.vaccine_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �          0    46431    animal 
   TABLE DATA           �   COPY public.animal (animal_id, animal_bdate, animal_breed, animal_color, animal_gender, animal_name, animal_species, animal_customer_id) FROM stdin;
    public          postgres    false    216   -1       �          0    46439    appointment 
   TABLE DATA           �   COPY public.appointment (appointment_id, appointment_date, appointment_time, appointment_animal_id, appointment_doctor_id) FROM stdin;
    public          postgres    false    218   �1       �          0    46445    available_date 
   TABLE DATA           [   COPY public.available_date (available_date_id, available_date, date_doctor_id) FROM stdin;
    public          postgres    false    220   '2       �          0    46451    customer 
   TABLE DATA              COPY public.customer (customer_id, customer_address, customer_city, customer_email, customer_name, customer_phone) FROM stdin;
    public          postgres    false    222   i2       �          0    46459    doctor 
   TABLE DATA           q   COPY public.doctor (doctor_id, doctor_address, doctor_city, doctor_email, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    224   �2       �          0    46467    vaccine 
   TABLE DATA           �   COPY public.vaccine (vaccine_id, vaccine_code, vaccine_end_date, vaccine_name, vaccine_start_date, animal_vaccine_id) FROM stdin;
    public          postgres    false    226   t3       �           0    0    animal_animal_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.animal_animal_id_seq', 6, true);
          public          postgres    false    215            �           0    0    appointment_appointment_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.appointment_appointment_id_seq', 9, true);
          public          postgres    false    217            �           0    0 $   available_date_available_date_id_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.available_date_available_date_id_seq', 6, true);
          public          postgres    false    219            �           0    0    customer_customer_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.customer_customer_id_seq', 6, true);
          public          postgres    false    221            �           0    0    doctor_doctor_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.doctor_doctor_id_seq', 7, true);
          public          postgres    false    223            �           0    0    vaccine_vaccine_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.vaccine_vaccine_id_seq', 6, true);
          public          postgres    false    225            4           2606    46437    animal animal_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY (animal_id);
 <   ALTER TABLE ONLY public.animal DROP CONSTRAINT animal_pkey;
       public            postgres    false    216            6           2606    46443    appointment appointment_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT appointment_pkey PRIMARY KEY (appointment_id);
 F   ALTER TABLE ONLY public.appointment DROP CONSTRAINT appointment_pkey;
       public            postgres    false    218            8           2606    46449 "   available_date available_date_pkey 
   CONSTRAINT     o   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT available_date_pkey PRIMARY KEY (available_date_id);
 L   ALTER TABLE ONLY public.available_date DROP CONSTRAINT available_date_pkey;
       public            postgres    false    220            :           2606    46457    customer customer_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (customer_id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public            postgres    false    222            <           2606    46465    doctor doctor_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT doctor_pkey PRIMARY KEY (doctor_id);
 <   ALTER TABLE ONLY public.doctor DROP CONSTRAINT doctor_pkey;
       public            postgres    false    224            >           2606    46473    vaccine vaccine_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT vaccine_pkey PRIMARY KEY (vaccine_id);
 >   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT vaccine_pkey;
       public            postgres    false    226            B           2606    46489 *   available_date fk4hug5u26sfm2hewlg9j0bwrbh    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_date
    ADD CONSTRAINT fk4hug5u26sfm2hewlg9j0bwrbh FOREIGN KEY (date_doctor_id) REFERENCES public.doctor(doctor_id);
 T   ALTER TABLE ONLY public.available_date DROP CONSTRAINT fk4hug5u26sfm2hewlg9j0bwrbh;
       public          postgres    false    4668    220    224            ?           2606    46474 !   animal fk7v0huk1yclccxra61tk2wo16    FK CONSTRAINT     �   ALTER TABLE ONLY public.animal
    ADD CONSTRAINT fk7v0huk1yclccxra61tk2wo16 FOREIGN KEY (animal_customer_id) REFERENCES public.customer(customer_id);
 K   ALTER TABLE ONLY public.animal DROP CONSTRAINT fk7v0huk1yclccxra61tk2wo16;
       public          postgres    false    4666    216    222            C           2606    46494 #   vaccine fk94u3pr7aa7f3wiy34rho393qi    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccine
    ADD CONSTRAINT fk94u3pr7aa7f3wiy34rho393qi FOREIGN KEY (animal_vaccine_id) REFERENCES public.animal(animal_id);
 M   ALTER TABLE ONLY public.vaccine DROP CONSTRAINT fk94u3pr7aa7f3wiy34rho393qi;
       public          postgres    false    4660    226    216            @           2606    46484 '   appointment fki81ox4a93tc9ka8c2fyd7p8h1    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fki81ox4a93tc9ka8c2fyd7p8h1 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctor(doctor_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fki81ox4a93tc9ka8c2fyd7p8h1;
       public          postgres    false    224    4668    218            A           2606    46479 '   appointment fksne2j50y78it7iyf8yjxhi1cl    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointment
    ADD CONSTRAINT fksne2j50y78it7iyf8yjxhi1cl FOREIGN KEY (appointment_animal_id) REFERENCES public.animal(animal_id);
 Q   ALTER TABLE ONLY public.appointment DROP CONSTRAINT fksne2j50y78it7iyf8yjxhi1cl;
       public          postgres    false    218    4660    216            �   �   x���1�@��z�\ +�M��1��Y�A&�2dC�����{���߀�L�f�4� �&Z'�����'oz)�������/�X㳈M�i���΃�g�m����{h�m�ϝl�1�e�ٖX���U~��Q�[J:��J1���*�x� ���C�      �   B   x�mɱ� ���DƼ�Y�(�d��\��M��Gc�&��r::�rq���$��&� ���      �   2   x�Mǻ E�����(F�uޙMv5�}��-L�6m�ڢ��;��}l      �      x�m�A
�0����],���p�^�Mh8ء����^CC�����@�D��h��<&��M��4��{*����]����b��K��̹�"չsI���d����� �઺|�ةa���%>:f� ��YP      �   l   x�3�̬��,��e�%%��%z����~�ũ� �g��u�K�Ss�\.c�ڣR3�!�Mp�r��L�(2ţ(j�n5ΉyťU�U���dCM����� u�VW      �   y   x�3�440�4202�5��50��.M)��
�����j�դ��%�df+$gg��5�5BV�XT�_�YtxO�����G6و�Ŕ���Y�O~qjn&V�f\f@���t�W� �7�     